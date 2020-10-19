//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class FractalGasketGraphics extends Canvas implements Runnable {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public FractalGasketGraphics() {
		setBackground(Color.WHITE);
	}
	
	public void paint(Graphics window) {
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL", Font.BOLD, 24));
		window.drawString("Sierpinski's Gasket", 25, 50);
		
		gasket(window, (WIDTH - 10) / 2, 20, WIDTH - 40, HEIGHT - 20, 40, HEIGHT - 20);
	}
	
	public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3) {
		
            if( Math.sqrt((Math.pow(x2-x1, 2)) + (Math.pow(y2-y1, 2))) > 2)
            {
                Polygon p = new Polygon();
                p.addPoint(x1, y1);
                p.addPoint(x2, y2);
                p.addPoint(x3, y3);
                // base case goes here
                // make a random color here
                int x = (int)(Math.random()*3+1);
                Color c = null;
                if( x == 1 )
                        c = Color.blue;
                if( x == 2 )
                        c = Color.green;
                if( x == 3 )
                        c = Color.red;
                //draw lines to make a triangle or use fillPolygon
                window.setColor(c);
                window.drawLine(x1, y1, x2, y2);     
                window.drawLine(x2, y2, x3, y3);
                window.drawLine(x3, y3, x1, y1);
                // make some recursive calls
                gasket(window, (x1 + x2)/2, (y1+y2)/2, x2, y2 , (x3+x2)/2, (y2+y3)/2);
                gasket(window, x1, y1, (x2+x1)/2, (y2+y1)/2, (x3+x1)/2, (y3+y1)/2);
                gasket(window, (x1 + x3)/2, (y1+y3)/2, (x2+x3)/2, (y2+y3)/2, x3, y3);
            }
	}
	
	public void run() {
		try {
			Thread.currentThread();
			Thread.sleep(3);
		} catch (Exception e) {
		}
	}
}