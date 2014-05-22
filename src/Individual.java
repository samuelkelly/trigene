import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Individual {
	
	public static final int NUMBER_OF_TRIANGLES = 30;
	
	private Triangle[] triangles;
	private double fitness;
	
	/** Returns a new random individual. */
	public Individual() {
		triangles = new Triangle[NUMBER_OF_TRIANGLES];
		// randomly generate a bunch of triangles
		for (int i = 0; i < NUMBER_OF_TRIANGLES; i++)
			triangles[i] = new Triangle();
	}
	
	/** Returns a copy of the current Individual. */
	public Individual(Individual that) {
		this.triangles = new Triangle[NUMBER_OF_TRIANGLES];
		for (int i = 0; i < NUMBER_OF_TRIANGLES; i++)
			triangles[i] = new Triangle(that.triangles[i]);
	}
	
	/**
	 * Randomly mutates the current Individual.
	 */
	public void mutate() {
		// mutate a randomly chosen triangle 
		triangles[(int) (Math.random() * NUMBER_OF_TRIANGLES)].mutate();		
	}
	
	/**
	 * Returns a new Individual which is a random
	 * mutation of the current Individual.
	 */
	public Individual spawn()
	{
		Individual child = new Individual(this);
		child.mutate();
		return child;
	}
	
	/**
	 * returns a buffered image of the individual
	 */
	public BufferedImage getBufferedImage()
	{
		BufferedImage temp = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
		Graphics g = temp.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 255, 255);
		
		for(Triangle t: triangles)
		{
			g.setColor(new Color((float)(t.r / 255.0), (float)(t.g / 255.0), (float)(t.b / 255.0), (float)(t.alpha / 255.0)));
			g.fillPolygon(new int[] {t.x1, t.x2, t.x3}, new int[] {t.y1, t.y2, t.y3}, 3);
		}
		
		return temp;
	}

}
