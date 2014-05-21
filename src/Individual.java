
public class Individual {
	
	public static final int NUMBER_OF_TRIANGLES = 10;
	
	private Triangle[] triangles;
	
	/** Returns a new random individual. */
	public Individual() {
		triangles = new Triangle[NUMBER_OF_TRIANGLES];
		// randomly generate a bunch of triangles
		for (int i = 0; i < NUMBER_OF_TRIANGLES; i++)
			triangles[i] = new Triangle();
	}
	
	/**
	 * Returns a new Individual which is a random
	 * mutation of the current Individual.
	 */
	public void mutate() {
		// mutate a randomly chosen triangle 
		triangles[(int) (Math.random() * NUMBER_OF_TRIANGLES)].mutate();		
	}
}
