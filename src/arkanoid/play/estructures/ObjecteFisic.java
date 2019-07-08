package arkanoid.play.estructures;

public interface ObjecteFisic {
	
	// Un objecte fisic per defecte no es mou per la pantalla (te posicio x,y)
	// public static float x = 0; // Pos x
	// public static float y = 0; // Pos y
	 
	 //public void checkCollision(); // Toca els xspeed i yspeed dels objectes 

	 public void draw();
	 
	 public boolean isDynamic(); // Si es que si, te xspeed i yspeed (es mou)
	//public static boolean isDynamic = true;  // Els atributs no s'hereden! (cal objecte abstracte) -el contracte es signatura
		// Els objectes fisics dinamics es mouen per la pantalla
		//public float xspeed = 0;
		//public float yspeed = 0;
}
