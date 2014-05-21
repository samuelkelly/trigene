import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GeneticGui extends JPanel {

	BufferedImage imageToBecome;
	
	public GeneticGui()
	{
		try {
			File file = new File("testImage.png");
			imageToBecome  = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(imageToBecome, 10, 10, 480, 480, null);
		
		g.setColor(Color.black);
		g.fillRect(510, 10, 480, 480);		
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(1000, 500);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(1000, 500);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(1000, 500);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Genetic Algorithm Prototype: Triangle Drawer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.add(new GeneticGui());
				frame.pack();
			}
		});
	}

}
