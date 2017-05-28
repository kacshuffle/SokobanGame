package hu.unideb.inf.View;

import javafx.scene.shape.Rectangle;

public class Box extends Rectangle{
	BoxTypes type;
	int x; 
	int y;
	
	public Box() {
		
	}
	
	public Box(BoxTypes boxTypes){
		super();
		this.type = boxTypes;
		
		super.setWidth(50);
		super.setHeight(50);
	}

	public BoxTypes getType() {
		return type;
	}

	public void setType(BoxTypes type) {
		this.type = type;
	}
	
	
	
}
