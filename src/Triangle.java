import static java.lang.Math.min;
import static java.lang.Math.max;

public class Triangle {
	/** The vertices of the triangle. */
	public short x1, y1, x2, y2, x3, y3;
	
	/** The transparency value of the triangle. */
	public short alpha;
	
	/** The red, green, and blue values of the triangle. */
	public short r, g, b;
	
	public Triangle(short x1, short y1,
			        short x2, short y2,
			        short x3, short y3,
			        short alpha, short r, short g, short b) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.alpha = alpha;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/** Returns a random triangle. */
	public Triangle() {
		this((short) (Math.random() * 256),
		 	 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256),
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256), 
			 (short) (Math.random() * 256));
	}
	
	/** Mutate a random field of the triangle. */
	public void mutate() {
		// select a field at random and add a random
		// number between -50 and +50 to it
		int fieldNumber = (int) Math.random() * 10;
		short c = (short) (Math.random() * 100 - 50); // random increment
		switch (fieldNumber) {
		case 0: x1 = (short) min(max(0, x1 + c), 255); break;
 		case 1: y1 = (short) min(max(0, y1 + c), 255); break;
		case 2: x2 = (short) min(max(0, x2 + c), 255); break;
		case 3: y2 = (short) min(max(0, y2 + c), 255); break;
		case 4: x3 = (short) min(max(0, x3 + c), 255); break;
		case 5: y3 = (short) min(max(0, y3 + c), 255); break;
		case 6: alpha = (short) min(max(0, alpha + c), 255); break;
		case 7: r = (short) min(max(0, r + c), 255); break;
		case 8: g = (short) min(max(0, g + c), 255); break;
		case 9: b = (short) min(max(0, b + c), 255); break;
		}
	}
}
