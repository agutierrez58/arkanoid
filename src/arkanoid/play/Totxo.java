package arkanoid.play;

import arkanoid.play.estructures.ObjecteFisic;
import arkanoid.play.estructures.RectangleType;
import processing.core.PApplet;

public class Totxo implements RectangleType, ObjecteFisic{

	public float x;
	public float y;
	public float width;
	public float height;

	private PApplet canvas;
	
	public Totxo(PApplet canvas, float x, float y) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.width = 50;
		this.height = 25;
		
	}
	
	public float getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	public float getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

	public float getX() {
		// Posicio X objecte (canto esquerra left-up)
		return this.x;
	}

	public float getY() {
		// Posicio Y objecte (canto esquerra left-up)
		return this.y;
	}



	public void draw() {
		canvas.fill(120);
		//rect(this.x*scl, this.y*scl/2, 50, 25);
		canvas.rect(this.x, this.y, this.width, this.height);
	}

	public boolean isDynamic() {
		return false; // no es mou
	}

}
