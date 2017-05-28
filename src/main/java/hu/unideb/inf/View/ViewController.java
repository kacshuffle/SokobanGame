package hu.unideb.inf.View;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sun.prism.paint.Color;

import hu.unideb.inf.Controller.BoxTypeColor;
import hu.unideb.inf.Controller.Direction;
import hu.unideb.inf.Controller.PlayGround;
import hu.unideb.inf.DAO.PlayerImp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ViewController extends Application
{

	private static Pane app = new Pane();
	private static PlayGround playGround = new PlayGround();
	private static BoxTypeColor boxTypeColor = new BoxTypeColor();
	
	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	
    public static void main( String[] args )
    {
        launch(args);
    }
    
    private Pane initGround(){
    	app.setPrefSize(WIDTH, HEIGHT);
    	for (int i = 0 ; i < 10; i++){
    		for (int j = 0; j < 10; j++){
    	
    			playGround.boxes[i][j].setTranslateX(i*50);
    			playGround.boxes[i][j].setTranslateY(j*50);
    			app.getChildren().addAll(playGround.boxes[i][j]);
    		}
    	}
    	updatePlayGround();
    	
    	return app;
    }
    
    private void updatePlayGround(){
    	for (int i = 0 ; i < 10; i++){
    		for (int j = 0; j < 10; j++){
    			playGround.boxes[i][j].setFill(BoxTypeColor.boxMap.get(playGround.boxes[i][j].getType()));
    		}
    	}
    	
    	if( playGround.Winner()){
    		app.getChildren().addAll(setEndingScreen());
			setEndingScreen();
			playGround.nyertes = 1;
			System.out.println("Nyertél most nem fogsz tudni mozogni.");
		} 
    }
    
    public VBox setRightBlock(){
    	VBox jobb = new VBox(10);
    	jobb.setSpacing(10);
        jobb.setPrefWidth(200);
        jobb.setPrefHeight(500);

        jobb.setLayoutX(WIDTH-200);
        Button gomb = new Button("Játék újrakezdése");
        gomb.setPrefWidth(150);
        gomb.setPadding(new Insets(10, 10, 10, 10));
        gomb.setTranslateX((jobb.getPrefWidth()-gomb.getPrefWidth())/2);
        gomb.setTranslateY(50);
        jobb.setStyle("-fx-background-color: #c2c2d6;");
        jobb.getChildren().add(gomb);
        
        Text manualTitle = new Text("Irányítás:");
        manualTitle.setTranslateX(50);
        manualTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        manualTitle.setTranslateY(100);
        jobb.getChildren().add(manualTitle);
        
        GridPane moveHolder = new GridPane();
        moveHolder.setAlignment(Pos.CENTER);
        moveHolder.setHgap(10);
        moveHolder.setVgap(10);
        moveHolder.setPrefWidth(200);
        moveHolder.setPrefHeight(400);
        
        Text moveUp = new Text("↑ - Felfele lépés");
        moveUp.setTextAlignment(TextAlignment.CENTER);
        moveUp.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        moveHolder.add(moveUp, 0, 0, 2, 1);
        
        Text moveDown = new Text("↓ - Lefele lépés");
        moveDown.setTextAlignment(TextAlignment.CENTER);
        moveDown.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        moveHolder.add(moveDown, 0, 1, 2, 1);
        
        Text moveLeft = new Text("← - Balra lépés");
        moveLeft.setTextAlignment(TextAlignment.CENTER);
        moveLeft.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        moveHolder.add(moveLeft, 0, 2, 2, 1);
        
        Text moveRight = new Text("→ - Jobbra lépés");
        moveRight.setTextAlignment(TextAlignment.CENTER);
        moveRight.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        moveHolder.add(moveRight, 0, 3, 2, 1);
        
        jobb.getChildren().add(moveHolder);
        
        gomb.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	playGround.lepes = 0;
            	playGround.celban = 0;
            	playGround.resetPlayGround();
                updatePlayGround();
                playGround.getDatum();                 
            }
        });
        
        return jobb;
    }
    
    public GridPane setWelcomeScreen(){
    	GridPane welcomeGrid = new GridPane();
    	
    	welcomeGrid.setAlignment(Pos.CENTER);
    	welcomeGrid.setHgap(10);
    	welcomeGrid.setVgap(10);
    	welcomeGrid.setPrefWidth(300);
    	welcomeGrid.setPrefHeight(150);
    	welcomeGrid.setLayoutX((WIDTH-200)/2 - welcomeGrid.getPrefWidth()/2);
    	welcomeGrid.setLayoutY(HEIGHT/2 - welcomeGrid.getPrefHeight()/2);
    	welcomeGrid.setPadding(new Insets(25, 25, 25, 25));
    	welcomeGrid.setStyle("-fx-background-color: #C0C0C0;");
        
        Text welcomeScreenTitle = new Text("Üdvözöllek, \n kérlek írd be a beceneved.");
        welcomeScreenTitle.setTextAlignment(TextAlignment.CENTER);
        welcomeScreenTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        welcomeGrid.add(welcomeScreenTitle, 0, 0, 2, 1);

        Label nickName = new Label("Becenév:");
        welcomeGrid.add(nickName, 0, 1);

        TextField nickNameTextField = new TextField();
        welcomeGrid.add(nickNameTextField, 1, 1);
        
        Button startButton = new Button("Játék kezdése");
        HBox btnHolder = new HBox(10);
        btnHolder.setAlignment(Pos.BOTTOM_RIGHT);
        btnHolder.getChildren().add(startButton);
        welcomeGrid.add(btnHolder, 1, 4);        
        
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                playGround.jatekosneve = nickNameTextField.getText();
                playGround.kezdes = 1;
                welcomeGrid.setVisible(false);
            }
        });
        
       
		return welcomeGrid;
    }
    
    public GridPane setEndingScreen(){
    	GridPane endGrid = new GridPane();
    	endGrid.setAlignment(Pos.CENTER);
    	endGrid.setHgap(10);
    	endGrid.setVgap(10);
    	endGrid.setPrefWidth(300);
    	endGrid.setPrefHeight(150);
    	endGrid.setLayoutX((WIDTH-200)/2 - endGrid.getPrefWidth()/2);
    	endGrid.setLayoutY(HEIGHT/2 - endGrid.getPrefHeight()/2);
    	endGrid.setPadding(new Insets(25, 25, 25, 25));
    	endGrid.setStyle("-fx-background-color: #C0C0C0;");
        
        Text scenetitle = new Text("Gratulálok, nyertél!\n\n Lépéseid száma: " + playGround.lepes);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        endGrid.add(scenetitle, 0, 0, 2, 1);

        Button btn = new Button("Hozzáadás a toplistához");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        hbBtn.getChildren().add(btn);
        endGrid.add(hbBtn, 1, 4);        
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	PlayerImp.AddToHighScore(playGround.celban,playGround.lepes,playGround.datum, playGround.jatekosneve);
            	endGrid.setVisible(false);
            }
        });
       
		return endGrid;
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(initGround());
		scene.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.UP){
					if(playGround.nyertes != 1 && playGround.kezdes == 1){
					playGround.Move(Direction.UP);
					updatePlayGround();
					}
				}
			
				if (event.getCode() == KeyCode.DOWN){
					if(playGround.nyertes != 1 && playGround.kezdes == 1){
					playGround.Move(Direction.DOWN);
					updatePlayGround();
					}
				}
				
				if (event.getCode() == KeyCode.LEFT){
					if(playGround.nyertes != 1 && playGround.kezdes == 1){
					playGround.Move(Direction.LEFT);
					updatePlayGround();
					}
				}
				
				if (event.getCode() == KeyCode.RIGHT){
					if(playGround.nyertes != 1 && playGround.kezdes == 1){
					playGround.Move(Direction.RIGHT);
					updatePlayGround();
					}
				}
		});
		
        app.getChildren().add(setRightBlock());
        app.getChildren().addAll(setWelcomeScreen());
        
		primaryStage.setScene(scene);
		primaryStage.show();
		
		playGround.getDatum();
		
	}

}
