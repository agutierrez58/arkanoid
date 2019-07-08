package arkanoid.play;

import arkanoid.play.estructures.CircleType;
import arkanoid.play.estructures.ObjecteFisic;
import arkanoid.play.estructures.RectangleType;
import processing.core.PApplet;

public class Pilota implements ObjecteFisic, CircleType{
	public float x;
	public float y;
	public float r;
	public float xspeed;
	public float yspeed;
	PApplet canvas; // The parent, The world!

	public Pilota(PApplet canvas,float x, float y) {
		this.x = x;
		this.y = y;
		this.r = 8;
		this.xspeed = (float) 1.2;
		this.yspeed = (float) 3.3;
		
		this.canvas = canvas;
	}

	public void mou() {
		// Moviment de la pilota
		x = x + xspeed;
		y = y + yspeed;
		
		
		// Check for bouncing   --> Qui ho fara?
		if (x > this.canvas.width || x < 0) {
			xspeed = xspeed*-1;
		}
		if (y > this.canvas.height || y < 0) {
			yspeed = yspeed*-1;
		}
	}
	
	public void draw(){
		this.canvas.stroke(0);
		this.canvas.fill(20,80,150);
		this.canvas.ellipse(x,y,this.r*2,this.r*2);
	}


	public float getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	public float getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	public float getRadius() {
		// TODO Auto-generated method stub
		return this.r;
	}

	public boolean isDynamic() {
		return true; // es mou -te xspeed i yspeed
	}


}