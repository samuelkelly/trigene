import java.awt.Color;
import java.awt.image.BufferedImage;

public class CompareImages {

	public double compareImages(BufferedImage imageA, BufferedImage imageB) {
		int height = imageA.getHeight();
		int width = imageA.getWidth();

		// the fitness value
		double fitness = 0;

		// for all the pixels
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// for image a
				int imageARgb = imageA.getRGB(i, j);
				Color colorA = new Color(imageARgb);
				double aRed = colorA.getRed();
				double aGreen = colorA.getGreen();
				double aBlue = colorA.getBlue();

				// for image b
				int imageBRgb = imageB.getRGB(i, j);
				Color colorB = new Color(imageBRgb);
				double bRed = colorB.getRed();
				double bGreen = colorB.getGreen();
				double bBlue = colorB.getBlue();

				fitness += Math.sqrt(Math.pow(aRed - bRed, 2)
						+ Math.pow(aGreen - bGreen, 2)
						+ Math.pow(aBlue - bBlue, 2));
			}
		}
		return fitness;
	}

}
