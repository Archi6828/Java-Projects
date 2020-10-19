import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
//how to use MigLayout- https://www.youtube.com/watch?v=Yl-OMkI82UM 
//Jar file download for Mig- http://www.java2s.com/Code/JarDownload/miglayout/miglayout-4.0.jar.zip


public class GuiM2 implements ActionListener
{
	JFrame frame = new JFrame( "Tree Game" );
	
	JPanel panel = new JPanel();
	
	//Instructions
	JLabel instructionsLabel1 = new JLabel( "Welcome to the Game" );
	JLabel instructionsLabel2 = new JLabel("To play, answer the questions by clicking the Yes and No buttons.");
	JLabel instructionsLabel3 = new JLabel("Can the computer guess your animal?");
	JLabel instructionsLabel4 = new JLabel("Follow the screen to help me become smarter if I get it wrong.");
	JLabel instructionsLabel5 = new JLabel("Click start to begin.");
	
	JLabel questionsLabel = new JLabel();
	JLabel animalLabel = new JLabel( "Please enter your animal" );
	JLabel newQuestionLabel = new JLabel( "Please enter a question to differentiate the animal." );
	JLabel newQuestionLabel2 = new JLabel( "(Yes for your animal, No for the original animal)" );
	JLabel tryAgainLabel = new JLabel( "Would you like to play again?" );
	
	JTextField animalTxt = new JTextField( 20 );
	JTextField newQuestionTxt = new JTextField( 20 );
	
	JButton startBtn = new JButton( "Start" );
	JButton yesBtn = new JButton( "Yes" );
	JButton noBtn = new JButton( "No" );
	JButton exitBtn = new JButton( "Exit" );
	JButton playAgainBtn = new JButton( "Play Again" );
	JButton submitBtn = new JButton( "Submit" );
	
	Tree tree;
	Node current;
	Node previous;
	
	
	public GuiM2() throws IOException
	{
		String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
		String [] questions = content.split( "\n" );
		
		//create questions tree
		tree = new Tree( questions );
		current = tree.getRoot();
		previous = tree.getRoot();
		
		instructionsLabel1.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 24 ) );
		instructionsLabel1.setForeground( Color.WHITE );
		
		instructionsLabel2.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		instructionsLabel2.setForeground( Color.WHITE );
		
		instructionsLabel3.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		instructionsLabel3.setForeground( Color.WHITE );
		
		instructionsLabel4.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		instructionsLabel4.setForeground( Color.WHITE );
		
		instructionsLabel5.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		instructionsLabel5.setForeground( Color.WHITE );
		
		questionsLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
//		questionsLabel.setForeground( Color.WHITE );
//		
		animalLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
//		animalLabel.setForeground( Color.WHITE );
//		
		newQuestionLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
//		newQuestionLabel.setForeground( Color.WHITE );
//		
		newQuestionLabel2.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
//		newQuestionLabel2.setForeground( Color.WHITE );
//		
		tryAgainLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
//		tryAgainLabel.setForeground( Color.WHITE );
		
		panel.setBackground( Color.BLACK );
		
		//Set up buttons designs
		startBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		yesBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		noBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		exitBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		playAgainBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		submitBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		
		
		startBtn.setPreferredSize( new Dimension( 100, 40 ) );
		yesBtn.setPreferredSize( new Dimension( 100, 40 ) );
		noBtn.setPreferredSize( new Dimension( 100, 40 ) );
		exitBtn.setPreferredSize( new Dimension( 100, 40 ) );
		playAgainBtn.setPreferredSize( new Dimension( 100, 40 ) );
		submitBtn.setPreferredSize( new Dimension( 100, 40 ) );
		
		
		
		
		
		//Set up button listeners
		startBtn.addActionListener( this );
		yesBtn.addActionListener( this );
		noBtn.addActionListener( this );
		exitBtn.addActionListener( this );
		playAgainBtn.addActionListener( this );
		submitBtn.addActionListener( this );
		
		
		panel.setLayout( new MigLayout() );
		panel.add( instructionsLabel1, "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( instructionsLabel2, "wrap" );
		panel.add( instructionsLabel3, "wrap" );
		panel.add( instructionsLabel4, "wrap" );
		panel.add( instructionsLabel5, "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( startBtn, "skip, split2" );
		panel.add( exitBtn );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		
		
		frame.add( panel );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
     
        if( word.equals( "Start" ) || word.equals( "Play Again") )
        {
        		panel.setBackground( Color.PINK);
        		
        		current = tree.getRoot();
        		
        		panel.removeAll();
        		questionsLabel.setText( current.getQuestion() );
            
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( questionsLabel, "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( yesBtn );
        		panel.add( noBtn );
            
            	panel.revalidate();
            	panel.repaint();
        }
        
        else if( word.equals( "Yes" ) )
        {
        		previous = current;
        		current = increment( word, current );
	        
        		if( current != null )
	    		{
				questionsLabel.setText( current.getQuestion() );
				
				panel.revalidate();
				panel.repaint();
	    		}
        		
	        	if( current == null )
			{
	        		setUpEndScreen();
			}
        }
        
        else if( word.equals( "No" ) )
        {
        		previous = current;
        		current = increment( word, current );
        		
        		if( current != null )
        		{
    				questionsLabel.setText( current.getQuestion() );
    				
    				panel.revalidate();
    				panel.repaint();
        		}
        		
        	
	        	if( current == null )
			{
	        		panel.removeAll();
	        		
				panel.add( animalLabel );
				panel.add( animalTxt, "wrap" );
				panel.add( newQuestionLabel );
				panel.add( newQuestionTxt, "wrap" );
				panel.add( newQuestionLabel2, "wrap" );
				panel.add( submitBtn, "wrap" );
	            
				panel.revalidate();
				panel.repaint();
			}
        }
        
        else if( word.equals( "Exit" ) )
        {
        		System.exit( 0 );
        }
        
        else if( word.equals( "Submit" ) )
        {
        		String animalStr = animalTxt.getText();
        		String questionStr = newQuestionTxt.getText();
        		
        		tree.insertNode( previous, questionStr, animalStr );

        		//reset text fields
        		animalTxt.setText( "" );
	        newQuestionTxt.setText( "" );
	        
	        //End screen
	        setUpEndScreen();
        }
    }
	
	
	public void setUpEndScreen()
	{
		panel.removeAll();
		
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( tryAgainLabel );
		panel.add( playAgainBtn, "skip, split2" );
		panel.add( exitBtn );
		
		panel.revalidate();
		panel.repaint();
	}
	
	private static Node increment( String s, Node n )
	{
		if( s.equals( "Yes" ) )
			return n.getYesNode();
		return n.getNoNode();
	}
	
	
	public static void main( String [] args )
	{
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run() {
				try {
					new GuiM2();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
}
