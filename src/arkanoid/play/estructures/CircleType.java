package arkanoid.play.estructures;

public interface CircleType {
	
	/*
	 * Per ara no s'utilitza en el fons, doncs es tracta com un quadrat ...
	 * Mes endevant ... intersect2
	 * 
	 * */
	
	/* Sobretot pel tema de les colisions - figura envolvent  */

	//public static float x = 0; // Pos x   -no funciona (matxaca el valor de l'objecte ...)
	//public static float y = 0; // Pos y
	//public static float r = 0; // El Radi
	
	public float getX();
	public float getY();
	public float getRadius();

}
