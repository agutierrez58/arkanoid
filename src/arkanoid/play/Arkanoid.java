package arkanoid.play;

import java.util.LinkedList;

import arkanoid.play.estructures.CircleType;
import arkanoid.play.estructures.RectangleType;
import processing.core.PApplet;

public class Arkanoid extends PApplet {
	// Bouncing Ball
	float x= 100;
	float y = 100;
	float xspeed = 1;
	float yspeed = (float) 3.3;
	
	// Pala
	Pala pala;
	Pilota pilota;
	LinkedList<Totxo> totxos;
	
	public static void main(String[] args) {
		// Exemple
		PApplet.main("arkanoid.play.Arkanoid");

		
		// Primer totxos dibuixar (estatics)
		// pilota que rebota en direccions
		// moviment de raqueta ...
		
		// joc de rebots ....

	}
	
	
	
	@Override
	public void settings() {
		// TODO Auto-generated method stub
		size(500,500);
		
		// Li passem el canvas
		pala = new Pala((PApplet)this, (float) (width/2.0), height - 50, (float)12.0);
		// I la pilota
		pilota = new Pilota ((PApplet) this, x,y);
		
		// I els totxos
		totxos = new LinkedList<Totxo>();
		// Posar objectes estatics :  totxos, ... (cada vegada cal pintar-los!)
		Totxo t = null;
		int scl=75;
		for(int i=0; i < width; i++) {
			for (int j=0; j< height/scl/2; j++) {
				t = new Totxo((PApplet)this, i*scl, j*scl/2);
				totxos.add(t);
			}
			//ellipse(random(0,width), random(0,height), random(100), random(100));				
		}
			
	}
	
	
	@Override
	public void setup() {
		
		// En principi no fa falta doncs cada vegada repintem de negre (sinó la pilota)
		background(0);
			
	}
	
	@Override
	public void keyPressed() {
		if (key == CODED){
			if (keyCode == RIGHT && pala.x < width){
				
				pala.mouDreta();
				
			} else if (keyCode == LEFT && pala.x > 0){
				
				pala.mouEsquerra();
			}
		}
	}
	
	@Override
	public void draw() {
		// Repintem cada vegada (sinó pilota es veu multiplicada ("arrastrada" ...)
		background(0);
		
		// Pintar els totxos
		Totxo i_remove = null;
		for (Totxo p : this.totxos){
			p.draw();
			if (intersects((CircleType)pilota, (RectangleType)p)){
				pilota.yspeed = -1*pilota.yspeed;
				i_remove = p;
			}
		}
		if (i_remove != null) totxos.remove(i_remove);
		
		
		// El que es pot fer, es testejar si la pilota esta mes amunt o mes avall que 1/3 de height !? (per no testejar-ho cada vegada !?)
		
		
		// Pilota que rebota
		if (intersects((CircleType)pilota, (RectangleType)pala)){
			pilota.yspeed = -1*pilota.yspeed;
			//System.out.println("Pilota ha de rebotar!!");
		}
		pilota.mou(); // Es necessari!? Ho hauria de fer la pilota mateix no!? (per si un cas.. com que es fara un test si pica ..)
		pilota.draw();
		
		// Moure rectangle a sota ... (fer update ... es mou sol! -usuari)
		pala.draw();
		
		//noLoop();	
	}

	/*
	 * Then to check if square B intersects with square A evaluate this:

		(aX < (bX + bLen) && (aX + aLen) > bX)
		&& (aY < (bY - bLen) && (aY - aLen) > bY)
		
		In other words, there are four possible scenarios and you check if either of square B's corners 
		are within the X-range of square A and that either of square B's corners are within the Y-range of square A.
		
		(Y)
		 ^
		 |             1:                        2:
		 |       +--------+                   +--------+
		 |       |        |                   |        |
		 |       |   A +--|-----+       +-----+--+ A   |
		 |       |     |  |     |       |     |  |     |
		 |       +-----+--+ B   |       |   B +--+-----+
		 |             |        |       |        |
		 |             +--------+       +--------+
		 |
		 |             3:                        4:
		 |       +--------+                   +--------+
		 |       |        |                   |        |
		 |       |   B +--|-----+       +-----+--+ B   |
		 |       |     |  |     |       |     |  |     |
		 |       +-----+--+ A   |       |   A +--+-----+
		 |             |        |       |        |
		 |             +--------+       +--------+
		 |
		 +-------------------------------------------------> (X)
	 * */
	/**
	 * Check if two rectangles collide
	 * x_1, y_1, width_1, and height_1 define the boundaries of the first rectangle
	 * x_2, y_2, width_2, and height_2 define the boundaries of the second rectangle
	 */
	boolean rectangle_collision(float x_1, float y_1, float width_1, float height_1, float x_2, float y_2, float width_2, float height_2)
	{
	  return !(x_1 > x_2+width_2 || x_1+width_1 < x_2 || y_1 > y_2+height_2 || y_1+height_1 < y_2);
	}
	
	public boolean intersects(CircleType circle, RectangleType rect){
		
		// Un cercle es pot aproximar a un quadrat
		// https://stackoverflow.com/questions/18172930/check-whether-if-two-squares-are-intersecting-with-each-other
		
		/*
		 * First of all put it in to your mind that in computers the coordinates system is upside down. 
		 * x-axis is same as in mathematics but y-axis increases downwards and decrease on going upward.. 
		 * if rectangle are drawn from center. if x1 coordinates is greater than x2 plus its its half of widht. 
		 * then it means going half they will touch each other. and in the same manner going downward + half of its height. 
		 * it will collide..
		 * */
		
		// Transformem el cercle amb un rectangle
		float x1 = circle.getX() - circle.getRadius();
	    float y1 = circle.getY() - circle.getRadius();
	    float width1 = circle.getRadius()*2;
	    float height1 = width1;
		
		return rectangle_collision(x1, y1, width1, height1, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}
	
	public boolean intersects2(CircleType circle, RectangleType rect)
	{
		// Per ara no s'utilitza .... mes endevant ..
		// Manera mes fina ... per ara no la faig servir ... mirar abans com va ...
		// https://stackoverflow.com/questions/401847/circle-rectangle-collision-detection-intersection
		
		/*
		 * The first pair of lines calculate the absolute values of the x and y difference between the center of the circle and the center of the rectangle. This collapses the four quadrants down into one, so that the calculations do not have to be done four times. The image shows the area in which the center of the circle must now lie. Note that only the single quadrant is shown. The rectangle is the grey area, and the red border outlines the critical area which is exactly one radius away from the edges of the rectangle. The center of the circle has to be within this red border for the intersection to occur.
		 * */
	    float circleDistance_x = abs(circle.getX() - rect.getX());
	    float circleDistance_y = abs(circle.getY() - rect.getY());

	    /*The second pair of lines eliminate the easy cases where the circle is far enough away from the rectangle (in either direction) that no intersection is possible. This corresponds to the green area in the image.
	     * */
	    if (circleDistance_x > (rect.getWidth()/2 + circle.getRadius())) { return false; }
	    if (circleDistance_y > (rect.getHeight()/2 + circle.getRadius())) { return false; }

	    /*The third pair of lines handle the easy cases where the circle is close enough to the rectangle (in either direction) that an intersection is guaranteed. This corresponds to the orange and grey sections in the image. Note that this step must be done after step 2 for the logic to make sense
	     * */
	    if (circleDistance_x <= (rect.getWidth()/2)) { return true; } 
	    if (circleDistance_y <= (rect.getHeight()/2)) { return true; }

	    /*The remaining lines calculate the difficult case where the circle may intersect the corner of the rectangle. To solve, compute the distance from the center of the circle and the corner, and then verify that the distance is not more than the radius of the circle. This calculation returns false for all circles whose center is within the red shaded area and returns true for all circles whose center is within the white shaded area.
	     * */
	    float cornerDistance_sq = (float) (Math.pow((circleDistance_x - rect.getWidth()/2), 2) +
	                              Math.pow((circleDistance_y - rect.getHeight()/2), 2));

	    return (cornerDistance_sq <= (circle.getRadius()*circle.getRadius())); // Cercle al quadrat
	}
	

}
