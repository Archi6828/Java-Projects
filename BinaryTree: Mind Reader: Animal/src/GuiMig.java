import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
//how to use MigLayout- https://www.youtube.com/watch?v=Yl-OMkI82UM 
//Jar file download for Mig- http://www.java2s.com/Code/JarDownload/miglayout/miglayout-4.0.jar.zip


public class GuiMig implements ActionListener
{
	JFrame frame = new JFrame( "Tree Game" );
	
	JPanel panel = new JPanel();
	JPanel instructionsPanel = new JPanel();
	JPanel questionsPanel = new JPanel();
	JPanel endPanel = new JPanel();
	JPanel addPanel = new JPanel();
	
	//Instructions
	JLabel instructionsLabel1 = new JLabel( "Welcome to the Game" );
	JLabel instructionsLabel2 = new JLabel("To play, answer the questiosn by clicking the Yes and No buttons.");
	JLabel instructionsLabel3 = new JLabel("Can the computer guess your animal?");
	JLabel instructionsLabel4 = new JLabel("Follow the screen to help me become smarter if I get it wrong.");
	JLabel instructionsLabel5 = new JLabel("Click start to begin.");
	
	JLabel questionsLabel;
	JLabel animalLabel = new JLabel( "Please enter an animal" );
	JLabel newQuestionLabel = new JLabel( "Please enter a question" );
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
	
	
	public GuiMig() throws IOException
	{
//		addPanel.setLayout( new MigLayout() );
//		
//		addPanel.add( instructionsLabel );
//		//pushx = grow cell horizontally
//		//growx = grows animalTxt
//		addPanel.add( animalTxt, "wrap, pushx, growx" );
//		addPanel.add( newQuestionLabel );
//		addPanel.add( newQuestionTxt, "wrap, pushx, growx" );
//		addPanel.add( playAgainBtn, "skip, split2" );
//		addPanel.add( exitBtn );
		
		String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
		String [] questions = content.split( "\n" );
		
		//create questions tree
		tree = new Tree( questions );
		current = tree.getRoot();
		
		instructionsLabel1.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 24 ) );
		
		//Set up buttons
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
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		
		
		
		//Testing buttons
		panel.add( noBtn, "wrap" );
		panel.add( submitBtn, "wrap" );
		panel.add( playAgainBtn, "wrap" );
		panel.add( exitBtn, "wrap" );
		
		frame.add( panel );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
     
        if( word.equals( "Start" ) )
        {
            frame.getContentPane().removeAll();
            
            questionsPanel.setLayout( new MigLayout() );
            questionsPanel.add( instructionsLabel1, "wrap" );
            questionsPanel.add( yesBtn );
            
            frame.add( questionsPanel );
	    		frame.pack();
	    		frame.setVisible( true );
        	
        }
        
        else if( word.equals( "Yes" ) )
        {
	        	if( !current.isLeaf() )
	    		{
				current = increment( word, current );
	    		}
	    		
	    	
	        	if( current != null && current.isLeaf() )
			{
	        		//GIVE OPTION TO TRY AGAIN
			}
        }
        
        else if( word.equals( "No" ) )
        {
        		if( !current.isLeaf() )
        		{
    				current = increment( word, current );
        		}
        		
        	
	        	if( current != null && current.isLeaf() )
			{
				frame.getContentPane().removeAll();
            
	        		addPanel.setLayout( new MigLayout() );
	        		addPanel.add( animalLabel );
	        		addPanel.add( animalTxt, "wrap" );
	        		addPanel.add( newQuestionLabel );
	        		addPanel.add( newQuestionTxt, "wrap" );
	            	addPanel.add( submitBtn );
	            
	            	frame.add( addPanel );
		    		frame.pack();
		    		frame.setVisible( true );
		    		
			}
        }
        
        
        
        else if( word.equals( "Exit" ) )
        {
        		panel.removeAll();
        		panel.add( new JLabel( "Hello" ) );
        		
        		panel.revalidate();
        		panel.repaint();
        		
        		//System.exit( 0 );
        }
        
        else if( word.equals( "Play Again" ) )
        {
        		current = tree.getRoot();
        		//set up panel
        		
        		
        		
        		
        }
        
        
        
        
        else if( word.equals( "Submit" ) )
        {
        		String animalStr = animalTxt.getText();
        		String questionStr = newQuestionTxt.getText();
        		
        		tree.insertNode(current, questionStr, animalStr );

        		//reset text fields
        		animalTxt.setText( "" );
	        newQuestionTxt.setText( "" );
	         
	        //GIVE OPTION TO TRY AGAIN
	        
	        frame.getContentPane().removeAll();
            endPanel.setLayout( new MigLayout() );
            tryAgainLabel.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 24 ) );
            
            endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( "               " ) );
            endPanel.add( tryAgainLabel );
            endPanel.add( new JLabel( "                        " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
            endPanel.add( playAgainBtn, "skip, split2" );
            endPanel.add( exitBtn );
            endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        endPanel.add( new JLabel( " " ), "wrap" );
	        
	        
            frame.add( endPanel );
	    		frame.pack();
	    		frame.setVisible( true );

        }
    }
	
	
	
        
//        //supposedly adds packages to delivery services
//        else if( word.equals( "Enter" ) )
//        {
//            String name = nameField.getText();
//            String address = addressField.getText();
//            double weight = 0;
//            try
//            {
//                weight = Double.parseDouble( weightField.getText() );
//            }
//            catch( Exception p )
//            {
//                weight = 0;
//            }
//            
//            //add package to company
//            Package p = new Package( name, address, weight );
//            company.addPackage( p );
//            
//            //reset text fields
//            nameField.setText( "" );
//            addressField.setText( "" );
//            weightField.setText( "" );
//            
//            //"printing" package that was just submitted
//            String result = "You just inputed package:";
//            result += "\n" + "\t" + name;
//            result += "\n" + "\t" + address;
//            result += "\n" + "\t" + weight;
//            
//            resultLabel.setText( result );
//        }
//        
//        //takes user to "window" of delivering packages
//        else if( word.equals( "Process Packages" ) )
//        {
//            PackageFrame.setVisible( false );
//            DeliveryFrame.setSize( 600, 600 );
//            DeliveryFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//            DeliveryFrame.setLayout( new FlowLayout() );
//            DeliveryFrame.setVisible( true );
//            packageDeliver();
//        }
//        
//        //not really used rn
//        else if( word.equals( "Exit" ) )
//        {
//            System.exit( 0 );
//        }
//        
//        //submiting call to deliver a set number of packages
//        else if( word.equals( "Submit" ) )
//        {
//            int num = 0;
//            try
//            {
//                num = Integer.parseInt( deliverNumField.getText() );
//            }
//            catch( Exception p )
//            {
//                num = 0;
//            }
//            
//            
//            resultLabel.setText( company.deliverNum( num ) );
//        }
//        
//        //call to deliver all packages
//        else if( word.equals( "Deliver All" ) )
//        {
//            //resultLabel.setText( company.deliverAll() );
//            PackageFrame.setVisible( false );
//            DeliveryFrame.setVisible( false );
//            endFrame.setSize( 600, 600 );
//            endFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//            endFrame.setLayout( new FlowLayout() );
//            endFrame.setVisible( true );
//            
//            
//            
	private static Node increment( String s, Node n )
	{	
		String temp = s.toLowerCase();
		if( temp.equals( "Yes" ) )
			return n.getYesNode();
		return n.getNoNode();
	}
	
	
	
	
//	private static void game( Node currentN, Tree tree )
//	{
//		Scanner s = new Scanner( System.in );
//		
//		while( !current.isLeaf() )
//		{
//			System.out.print( current.getQuestion() + ": " );
//			current = increment( s.next(), current );
//		}
//		
//		if( current != null && current.isLeaf() )
//		{
//			System.out.print( current.getQuestion() + ": " );
//			String input = s.next().toLowerCase();
//			
//			if( input.equals( "n" ) )
//			{
//				System.out.print( "What animal were you thinking of?: " );
//				String animal = "Is it a " + s.next().toLowerCase() + "?";
//				s.nextLine();
//				
//				System.out.print( "Please enter a question to differentiate the two animals: " );
//				String Qadd = s.nextLine();
//				t.insertNode(current, Qadd, animal);
//			}
//		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main( String [] args )
	{
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run() 
			{
				try 
				{
					new GuiMig();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
		});
	}
	
}
