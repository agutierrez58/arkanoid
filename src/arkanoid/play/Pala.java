package arkanoid.play;

import arkanoid.play.estructures.RectangleType;
import processing.core.PApplet;

public class Pala implements RectangleType{
	
	
	public static float x; // float pel tema del Processing
	public static float y;
	public float xpalaSpeed;
	// https://processing.org/tutorials/eclipse/
	PApplet canvas; // The parent, The world!
	
	private float dimWidth = 75;
	private float dimHeight = 25;
	
   public Pala(PApplet canvas, float xpala, float ypala, float xpalaSpeed) {
	   	// Pala
		this.x = xpala;
		this.y = ypala;
		this.xpalaSpeed= 14;
		
		// Per pintar-se!
		this.canvas = canvas;
    }
   
   public void mouDreta(){
	   this.x = x + xpalaSpeed;
   }
   
   public void mouEsquerra(){
	   this.x = x - xpalaSpeed;
   }
   
   public double getXPos(){
	   return this.x;
   }
   
   public double getYPos(){
	   return this.y;
   }
   
   void draw() {
		// Depen de xpala
		canvas.fill(200,0,0);
		canvas.rect((float) x, (float) y, this.dimWidth,this.dimHeight);
		
	}
   
    // Al ser tipus Rectangle .. important

	public float getWidth() {
		return this.dimWidth;
	}
	
	public float getHeight() {
		return this.dimHeight;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
   
}
