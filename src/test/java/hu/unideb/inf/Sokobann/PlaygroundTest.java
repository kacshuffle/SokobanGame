package hu.unideb.inf.Sokobann;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.Controller.PlayGround;
import hu.unideb.inf.View.BoxTypes;

public class PlaygroundTest {
	
	private PlayGround playground;
	
	@Before
	public void initGround() {
		playground = new PlayGround();
	}
	
	/*@Test
	public void playGroundTest() {
		for (int i = 1; i < playground.getBoxes().length -1; i++) {
			for (int j = 1; j < playground.getBoxes()[i].length -1; j++) {
				//assertEquals("Nem minden Box alapterulet", BoxTypes.ALAPTERULET, playground.boxes[i][j].getType());
				assertNotEquals(BoxTypes.ALAPTERULET, playground.boxes[i][j].getType());
				
			}
		}
	}*/
		
	@Test
	public void GroundTest(){
		for (int i = 0; i < playground.getBoxes().length; i++){
			for (int j = 0; j < playground.getBoxes().length; j++){
				assertEquals("Box keret-e", BoxTypes.KERET, playground.boxes[i][0].getType());
				assertEquals("Box keret-e", BoxTypes.KERET, playground.boxes[0][i].getType());
				assertEquals("Box keret-e", BoxTypes.KERET, playground.boxes[playground.getBoxes().length-1][i].getType());
				assertEquals("Box keret-e", BoxTypes.KERET, playground.boxes[i][playground.getBoxes().length-1].getType());
			}
				assertEquals("A box Játékos", BoxTypes.JATEKOS, playground.boxes[1][1].getType());
				
				assertEquals("A box Doboz", BoxTypes.DOBOZ, playground.boxes[4][2].getType());
				assertEquals("A box Doboz", BoxTypes.DOBOZ, playground.boxes[4][3].getType());
				assertEquals("A box Doboz", BoxTypes.DOBOZ, playground.boxes[4][4].getType());
				
				assertEquals("A box Cél terület", BoxTypes.CELTERULET, playground.boxes[playground.getBoxes().length-2][6].getType());
				assertEquals("A box Cél terület", BoxTypes.CELTERULET, playground.boxes[playground.getBoxes().length-2][7].getType());
				assertEquals("A box Cél terület", BoxTypes.CELTERULET, playground.boxes[playground.getBoxes().length-2][8].getType());

			
		}
	}
	
	@Test
	public void WinnerTest(){
		if(playground.celban == 3){
			assertTrue(playground.celban == 3);
		} else {
			assertTrue(playground.celban == 0);
		}
	}
}
