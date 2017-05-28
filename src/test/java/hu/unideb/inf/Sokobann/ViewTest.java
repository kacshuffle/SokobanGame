package hu.unideb.inf.Sokobann;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.Controller.PlayGround;
import hu.unideb.inf.View.Box;
import hu.unideb.inf.View.BoxTypes;
import hu.unideb.inf.View.ViewController;
import javafx.scene.layout.Pane;

public class ViewTest {

	private ViewController viewcontroller;
	private PlayGround playground;

	@Before
	public void initView(){
		viewcontroller = new ViewController();
	}
	
	@Before
	public void initPlayGround(){
		playground = new PlayGround();
	}
	
	@Test
	public void initGroundTest(){
		Box[][] temp = playground.getBoxes();
		for (int i = 0; i < 10; i++) {
			assertEquals("10 sor van-e", temp[i].length, 10);
		}
	}	
	
	
}
