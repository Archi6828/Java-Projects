//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import javax.swing.JFrame;

public class FractalGasketGraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public FractalGasketGraphicsRunner() {
		super("Fractal Runner");
		
		setSize(WIDTH + 40, HEIGHT + 40);
		
		getContentPane().add(new FractalGasketGraphics());
		// getContentPane().add(new Carpet());
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		FractalGasketGraphicsRunner run = new FractalGasketGraphicsRunner();
	}
}