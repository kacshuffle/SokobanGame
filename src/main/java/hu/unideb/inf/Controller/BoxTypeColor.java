package hu.unideb.inf.Controller;

import java.util.HashMap;
import java.util.Map;

import hu.unideb.inf.View.BoxTypes;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class BoxTypeColor {
	public static Map<BoxTypes, ImagePattern> boxMap = new HashMap<BoxTypes,ImagePattern>();
	
	public BoxTypeColor(){
		initColors();
	}
	
	Image boxI = new Image(getClass().getResourceAsStream("dobozka.png"));
	Image frameI = new Image(getClass().getResourceAsStream("keret.png"));
	Image floorI = new Image(getClass().getResourceAsStream("floor.png"));
	Image playerI = new Image(getClass().getResourceAsStream("player.png"));
	Image placeI = new Image(getClass().getResourceAsStream("point.png"));
	Image finishedI = new Image(getClass().getResourceAsStream("finished.png"));
	
	ImagePattern box = new ImagePattern(boxI, 0, 0, 1, 1, true);
	ImagePattern frame = new ImagePattern(frameI, 0, 0, 1, 1, true);
	ImagePattern floor = new ImagePattern(floorI, 0, 0, 1, 1, true);
	ImagePattern player = new ImagePattern(playerI, 0, 0, 1, 1, true);
	ImagePattern place = new ImagePattern(placeI, 0, 0, 1, 1, true);
	ImagePattern finished = new ImagePattern(finishedI, 0, 0, 1, 1, true);
	
	private void initColors(){
		boxMap.put(BoxTypes.ALAPTERULET, floor);
		boxMap.put(BoxTypes.JATEKOS, player);
		boxMap.put(BoxTypes.CELTERULET, place);
		boxMap.put(BoxTypes.DOBOZ, box);
		boxMap.put(BoxTypes.KERET, frame);
		boxMap.put(BoxTypes.KESZCEL, finished);
	}

}
