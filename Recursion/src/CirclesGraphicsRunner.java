//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import javax.swing.JFrame;

public class CirclesGraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public CirclesGraphicsRunner() {
		super("Graphics Runner");
		setSize(WIDTH, HEIGHT);
		
		getContentPane().add(new CirclesGraphics());
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		CirclesGraphicsRunner run = new CirclesGraphicsRunner();
	}
}