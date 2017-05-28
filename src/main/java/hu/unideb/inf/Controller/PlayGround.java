package hu.unideb.inf.Controller;

import java.time.LocalDateTime;

import hu.unideb.inf.DAO.PlayerImp;
import hu.unideb.inf.View.Box;
import hu.unideb.inf.View.BoxTypes;
import hu.unideb.inf.View.ViewController;

public class PlayGround {
	
	public int lepes = 0;
	public int celban = 0;
	public String jatekosneve;
	public int nyertes = 0;
	public int kezdes = 0;
	
	public LocalDateTime datum = LocalDateTime.now();
		
	private static final int SIZE = 10;
	
	public Box[][] boxes = new Box[SIZE][SIZE];
	
	public Box[][] getBoxes() {
		return boxes;
	}

	public void setBoxes(Box[][] boxes) {
		this.boxes = boxes;
	}
		
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void resetPlayGround(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				boxes[i][j].setType(BoxTypes.ALAPTERULET);
			}
		}
		initPlayGround();
		
	}
	
	public PlayGround() {
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				boxes[i][j] = new Box(BoxTypes.ALAPTERULET);
			}
		}
		
		initPlayGround();
	}
	
	public void initPlayGround(){
		
		for (int i = 0; i < SIZE; i++) {
			boxes[i][0].setType(BoxTypes.KERET);
			boxes[0][i].setType(BoxTypes.KERET);
			boxes[SIZE-1][i].setType(BoxTypes.KERET);
			boxes[i][SIZE-1].setType(BoxTypes.KERET);
		}
				
		boxes[1][1].setType(BoxTypes.JATEKOS);
		
		boxes[7][2].setType(BoxTypes.DOBOZ);
		boxes[3][3].setType(BoxTypes.DOBOZ);
		boxes[5][6].setType(BoxTypes.DOBOZ);
		
		boxes[8][5].setType(BoxTypes.CELTERULET);
		boxes[2][7].setType(BoxTypes.CELTERULET);
		boxes[5][3].setType(BoxTypes.CELTERULET);
	}
	
	public boolean Winner(){	
		if(celban == 3){
			return true;
		} else {
			return false;
		}
	}
	
	public void Move(Direction dir){
		int x = 0;
		int y = 0;
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(boxes[i][j].getType() == BoxTypes.JATEKOS){
					x = i;
					y = j;
				}
			}
		}
			
		
		if(dir == Direction.UP){
			BoxTypes type = boxes[x][y-1].getType();
			if(boxes[x][y-1].getType() != BoxTypes.KERET){
				if(boxes[x][y-1].getType() == BoxTypes.DOBOZ && boxes[x][y-2].getType() == BoxTypes.CELTERULET){
					boxes[x][y-2].setType(BoxTypes.KESZCEL);
					celban++;
					
					boxes[x][y-1].setType(boxes[x][y].getType());
					boxes[x][y].setType(BoxTypes.ALAPTERULET);
				}else if(boxes[x][y-1].getType() == BoxTypes.KESZCEL || boxes[x][y-1].getType() == BoxTypes.CELTERULET){

				}else if(boxes[x][y-1].getType() == BoxTypes.DOBOZ && boxes[x][y-2].getType() == BoxTypes.KESZCEL){

				}else if (boxes[x][y-1].getType() == BoxTypes.DOBOZ && boxes[x][y-2].getType() == BoxTypes.KERET){

				}else if (boxes[x][y-1].getType() == BoxTypes.DOBOZ && boxes[x][y-2].getType() == BoxTypes.DOBOZ){

				} else{
					if (boxes[x][y-1].getType() == BoxTypes.DOBOZ && boxes[x][y-2].getType() != BoxTypes.KERET){
						boxes[x][y-2].setType(boxes[x][y-1].getType());
						boxes[x][y-1].setType(boxes[x][y].getType());
						boxes[x][y].setType(BoxTypes.ALAPTERULET);
					} else {
						boxes[x][y-1].setType(boxes[x][y].getType());
						boxes[x][y].setType(type);
					}
				}
				lepes++;
			}
		}
		
		if(dir == Direction.DOWN){
			BoxTypes type = boxes[x][y+1].getType();
			if(boxes[x][y+1].getType() != BoxTypes.KERET){
				if(boxes[x][y+1].getType() == BoxTypes.DOBOZ && boxes[x][y+2].getType() == BoxTypes.CELTERULET){
					boxes[x][y+2].setType(BoxTypes.KESZCEL);
					celban++;
					
					boxes[x][y+1].setType(boxes[x][y].getType());
					boxes[x][y].setType(BoxTypes.ALAPTERULET);
				}else if(boxes[x][y+1].getType() == BoxTypes.KESZCEL || boxes[x][y+1].getType() == BoxTypes.CELTERULET){

				}else if(boxes[x][y+1].getType() == BoxTypes.DOBOZ && boxes[x][y+2].getType() == BoxTypes.KESZCEL){

				}else if(boxes[x][y+1].getType() == BoxTypes.DOBOZ && boxes[x][y+2].getType() == BoxTypes.KERET){

				}else if (boxes[x][y+1].getType() == BoxTypes.DOBOZ && boxes[x][y+2].getType() == BoxTypes.DOBOZ){

				} else{
					if (boxes[x][y+1].getType() == BoxTypes.DOBOZ && boxes[x][y+2].getType() != BoxTypes.KERET){
						boxes[x][y+2].setType(boxes[x][y+1].getType());
						boxes[x][y+1].setType(boxes[x][y].getType());
						boxes[x][y].setType(BoxTypes.ALAPTERULET);
					} else {
						boxes[x][y+1].setType(boxes[x][y].getType());
						boxes[x][y].setType(type);
					}
				}
				lepes++;

			}
		}
		
		if(dir == Direction.LEFT){
			BoxTypes type = boxes[x-1][y].getType();
			if(boxes[x-1][y].getType() != BoxTypes.KERET){
				if(boxes[x-1][y].getType() == BoxTypes.DOBOZ && boxes[x-2][y].getType() == BoxTypes.CELTERULET){
					boxes[x-2][y].setType(BoxTypes.KESZCEL);
					celban++;
					
					boxes[x-1][y].setType(boxes[x][y].getType());
					boxes[x][y].setType(BoxTypes.ALAPTERULET);
				}else if(boxes[x-1][y].getType() == BoxTypes.KESZCEL || boxes[x-1][y].getType() == BoxTypes.CELTERULET){

				}else if(boxes[x-1][y].getType() == BoxTypes.DOBOZ && boxes[x-2][y].getType() == BoxTypes.KESZCEL){

				}else if(boxes[x-1][y].getType() == BoxTypes.DOBOZ && boxes[x-2][y].getType() == BoxTypes.KERET){

				}else if (boxes[x-1][y].getType() == BoxTypes.DOBOZ && boxes[x-2][y].getType() == BoxTypes.DOBOZ){

				} else {
					if (boxes[x-1][y].getType() == BoxTypes.DOBOZ && boxes[x-2][y].getType() != BoxTypes.KERET){
						boxes[x-2][y].setType(boxes[x-1][y].getType());
						boxes[x-1][y].setType(boxes[x][y].getType());
						boxes[x][y].setType(BoxTypes.ALAPTERULET);
					} else {
						boxes[x-1][y].setType(boxes[x][y].getType());
						boxes[x][y].setType(type);
					}
				}
				lepes++;
				
			}
		}
		
		if(dir == Direction.RIGHT){
			BoxTypes type = boxes[x+1][y].getType();
			if(boxes[x+1][y].getType() != BoxTypes.KERET){
				if(boxes[x+1][y].getType() == BoxTypes.DOBOZ && boxes[x+2][y].getType() == BoxTypes.CELTERULET){
					boxes[x+2][y].setType(BoxTypes.KESZCEL);
					celban++;
					
					boxes[x+1][y].setType(boxes[x][y].getType());
					boxes[x][y].setType(BoxTypes.ALAPTERULET);
				}else if(boxes[x+1][y].getType() == BoxTypes.KESZCEL || boxes[x+1][y].getType() == BoxTypes.CELTERULET){

				}else if(boxes[x+1][y].getType() == BoxTypes.DOBOZ && boxes[x+2][y].getType() == BoxTypes.KESZCEL){

				}else if(boxes[x+1][y].getType() == BoxTypes.DOBOZ && boxes[x+2][y].getType() == BoxTypes.KERET){

				}else if (boxes[x+1][y].getType() == BoxTypes.DOBOZ && boxes[x+2][y].getType() == BoxTypes.DOBOZ){

				} else {
					if (boxes[x+1][y].getType() == BoxTypes.DOBOZ && boxes[x+2][y].getType() != BoxTypes.KERET){
						boxes[x+2][y].setType(boxes[x+1][y].getType());
						boxes[x+1][y].setType(boxes[x][y].getType());
						boxes[x][y].setType(BoxTypes.ALAPTERULET);
					} else {
						boxes[x+1][y].setType(boxes[x][y].getType());
						boxes[x][y].setType(type);
					}
				}
				lepes++;

			}
		}
		
	}
}