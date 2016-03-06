import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;

public class StrainerPanel extends JPanel{
	
	public static final int PANEL_SIZE = 729;
	public static int maxSteps;
	
	public StrainerPanel(int givenSteps){
		maxSteps = givenSteps;
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		Graphics p2d = page;
		
		int width = PANEL_SIZE / 3;
		int height = PANEL_SIZE / 3;
		int x = PANEL_SIZE / 3;
		int y = PANEL_SIZE / 3;
		//System.out.println(maxSteps);
		draw(maxSteps, page, x, y, width, height);
	}
	
	public void draw(int limit, Graphics page, int x, int y, int width, int height){
		//System.out.println(limit);
		Graphics p2d = page;
		p2d.setColor(Color.white);
		if (limit <= 0) {
			return;
		}
		if (limit == 1) {
			p2d.fillRect(x, y, width, height);
		}
		else {
			p2d.fillRect(x, y, width, height);
			width /= 3;height /= 3;
   
			// separating into 3x3 grid
   
			int x1 = x - 2 * width;
			int y1 = y - 2 * height;
			int x2 = x + width;
			int y2 = y + height;
			int x3 = x + 4 * width;
			int y3 = y + 4 * height;
			draw(limit - 1, page, x1, y1, width, height);
			draw(limit - 1, page, x2, y1, width, height);
			draw(limit - 1, page, x3, y1, width, height);
			draw(limit - 1, page, x1, y2, width, height);
			draw(limit - 1, page, x1, y3, width, height);
			draw(limit - 1, page, x2, y3, width, height);
			draw(limit - 1, page, x2, y2, width, height);
			draw(limit - 1, page, x3, y3, width, height);
			draw(limit - 1, page, x3, y2, width, height);
		}
	}
}