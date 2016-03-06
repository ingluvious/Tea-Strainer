import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class StrainerFrame extends JFrame{
	
	public static final int PANEL_SIZE = 729;
	public static Graphics g;
	
	public static void main(String args[]){
		
		int maxSteps = 0;
		String fileName = "";
		
		maxSteps = Integer.parseInt(args[0]);
		fileName = args[1] + ".png";
		
		StrainerFrame frame = new StrainerFrame();
		frame.setSize(PANEL_SIZE, PANEL_SIZE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new StrainerPanel(maxSteps));
		frame.setVisible(true);
		
		try{
			BufferedImage image = new BufferedImage(PANEL_SIZE, PANEL_SIZE, BufferedImage.TYPE_INT_RGB);
			g = image.getGraphics();
			frame.paint(g);
			frame.pack();
			ImageIO.write(image,"png", new File(fileName));
		}
		catch(Exception e){
			System.out.println("Invalid something... WHAT DID YOU INPUT.?!");
			
		}
	}
}