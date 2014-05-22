import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GeneticGui extends JPanel {

	BufferedImage imageToBecome;
	BufferedImage bestImage;
	CompareImages comparer;
	Individual population[];
	
	public GeneticGui()
	{
		bestImage = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
		
		population = new Individual[50];
		for(int i = 0; i < population.length; i++)
		{
			population[i] = new Individual();
		}
		comparer = new CompareImages();
		
		try {
			File file = new File("testImage.png");
			imageToBecome  = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
	}
	
	private void evolve() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++)
		{
			nextGeneration();
			System.out.println("" + i);
			repaint();
		}
	}

	private void nextGeneration() {
		Individual bestFive[] = new Individual[5];
		TreeSet<Individual> sortedPop = new TreeSet<Individual>(new Comparator<Individual>(){
			@Override
			public int compare(Individual arg0, Individual arg1) {
				return (int) (comparer.compareImages(imageToBecome, arg0.getBufferedImage()) - comparer.compareImages(imageToBecome, arg1.getBufferedImage()));
			}
		});
		
		for(int i = 0; i < population.length; i++)
		{
			sortedPop.add(population[i]);
		}
		
		for(int i = 0; i < bestFive.length; i++)
		{
			bestFive[i] = sortedPop.pollLast();
		}
		
		bestImage = bestFive[0].getBufferedImage();
		
		int n = 0; // TODO: maybe add bounds check
		for(int i = 0; i < bestFive.length; i++)
		{
			population[n++] = bestFive[i];
			for(int j = 0; j < 4; j++)
			{
				population[n++] = bestFive[i].spawn();
			}
		}
	}

	
	public void paintComponent(Graphics g)
	{
		g.clearRect(0, 0, 1000, 600);
		
		g.drawImage(imageToBecome, 10, 10, 480, 480, null);
		
		g.drawImage(bestImage, 510, 10, 480, 480, null);
		
		g.drawString("" + new CompareImages().compareImages(imageToBecome, bestImage), 500, 550);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(1000, 600);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(1000, 600);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(1000, 600);
	}
	
	public static void main(String[] args) {
		final GeneticGui myGui = new GeneticGui();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle("Genetic Algorithm Prototype: Triangle Drawer");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.add(myGui);
				frame.pack();
			}
		});
		
		myGui.evolve();
	}


}
