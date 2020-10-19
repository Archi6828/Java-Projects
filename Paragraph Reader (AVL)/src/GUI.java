import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.Set;
import java.awt.Image;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
//how to use MigLayout- https://www.youtube.com/watch?v=Yl-OMkI82UM 
//Jar file download for Mig- http://www.java2s.com/Code/JarDownload/miglayout/miglayout-4.0.jar.zip


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;


public class GUI extends JFrame implements ActionListener
{
    JTextField newQuestion;
    JTextField newAnimal;
    
    static JFrame instructionFrame = new JFrame( "Paragraph Reader" );
    static JFrame gameFrame = new JFrame( "Paragraph Reader" );
    static JFrame endFrame = new JFrame( "Paragraph Reader" );
    
    JButton yesButton;
    JButton noButton;
    JButton tryAgainButton;
    JButton exitButton;
    JButton startButton;
    JButton submitButton;
    
    JLabel instructionsLabel;
    JLabel questionsLabel;
    JLabel tryAgainLabel;
    JTextField newQuestionTxt;
	
    
    JPanel instructionsPanel;
    JPanel gamePanel;
    JPanel treePanel;
    JPanel endPanel;
    
    AVLTree tree = new AVLTree();
    
    
    public GUI() throws IOException
    {
    		super( "Delivery Service" );  //NOT SURE
    		instructionFrame.setSize( 1000, 1000 );
    		instructionFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    		gameFrame.setSize( 1000, 1000 );
//        //Set up tree
//        	String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
//		//String [] questions = content.split( "\n" );
//		t = new Tree( questions );
    		
         //Set up tree
    		//AVLTree tree = new AVLTree();
    		int count = 0;
    		Scanner s = new Scanner( new File("src/text"));
    		while(s.hasNext()) {
    			String word = s.next();
    			if( word.length() >= 5 ) {
    				tree.root = tree.insert(tree.root, word);
    				count++;
    			}
    		} 
    		
		instructionsPanel = new JPanel();
		instructionsPanel.setBackground( Color.LIGHT_GRAY );
		instructionsPanel.setLayout(new GridLayout(2,1));
		
		gamePanel = new JPanel();
		gamePanel.setBackground( Color.LIGHT_GRAY );
		gamePanel.setLayout(new GridLayout(6,2));
		
		treePanel = new JPanel();
		treePanel.setBackground( Color.LIGHT_GRAY );
		treePanel.setLayout(new GridLayout(4,1));
		
		endPanel = new JPanel();
		endPanel.setBackground( Color.LIGHT_GRAY );
		endPanel.setLayout(new GridLayout(4,4));
		
		newQuestionTxt = new JTextField( 20 );
		
		instructionsLabel = new JLabel( "Welcome to Paragraph Reader!", SwingConstants.CENTER);
		instructionsLabel.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
		instructionsPanel.add(instructionsLabel, BorderLayout.CENTER );
		//instructionFrame.add( instructionsLabel );
	
		startButton = new JButton( "Start" );
		startButton.addActionListener( this );
		startButton.setSize(20,20);
		instructionsPanel.add( startButton );
		
		yesButton = new JButton( "Yes" );
		yesButton.addActionListener( this );
		//gameFrame.add( yesButton );
		
		noButton = new JButton( "No" );
		noButton.addActionListener( this );
		//gameFrame.add( noButton );
		
		exitButton = new JButton( "Exit" );
		exitButton.addActionListener( this );
		//gameFrame.add( exitButton );
		
		tryAgainButton = new JButton( "Try Again" );
		tryAgainButton.addActionListener( this );
		//endFrame.add( tryAgainButton );
        
		submitButton = new JButton( "Submit" );
		submitButton.setSize(20,20);
		submitButton.addActionListener( this );
		
		instructionFrame.add( instructionsPanel );
		instructionFrame.setVisible( true );
		
    }
    
    
    
    public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
        
        //takes user to "window" of inputting packages
        //set up gamePanel and gameFrame
        if( word.equals( "Start" ) )
        {
            setVisible( false );
            instructionFrame.setVisible( false );
            gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            
             askWord();	    			
            gameFrame.setVisible( true );
        }
        
        else if( word.equals( "Yes" ) )
        {
        		treePanel.removeAll();
        		gamePanel.removeAll();
	        askWord();
	        treePanel.revalidate();
     		treePanel.repaint();
	        gamePanel.revalidate();
     		gamePanel.repaint();
        }
       
        else if( word.equals( "No" ) )
        {
        		treePanel.removeAll();
        		gamePanel.removeAll();
        		JLabel thx = new JLabel( "Thanks for using Paragraph Reader!");
        		thx.setFont(new Font( Font.SERIF, Font.BOLD, 35 ) );
			gamePanel.add( thx,SwingConstants.CENTER);
			
			treePanel.revalidate();
     		treePanel.repaint();
			gamePanel.revalidate();
			gamePanel.repaint();
        }
 
        else if( word.equals( "Submit" ) )
        {
        		gamePanel.removeAll();
        		gamePanel.setLayout(new GridLayout(7,1));
        		
        		Node temp = tree.Contains(newQuestionTxt.getText());
			if( temp != null ) {
				JLabel w = new JLabel("The definition of the word \"" + temp.key + "\" is:");
				gamePanel.add(w,  SwingConstants.CENTER);
				w.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
				
				String [] d = temp.getDef().split("\n");
		    	 	final JList list = new JList(d);
		    	 	JScrollPane scrollPane = new JScrollPane(list);
		    	 	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		    	 	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    	 	gamePanel.add(scrollPane, BorderLayout.CENTER);

//	    			gamePanel.add( new JLabel( " " ), "wrap" );
	    			
	    			JLabel q = new JLabel("Would you like to look up another word? (y or n)");
	    			gamePanel.add(q,  SwingConstants.CENTER);
	        		q.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
	        		
	        		gamePanel.add( new JLabel( " " ), "wrap" );
	    			gamePanel.add( yesButton);
	    			gamePanel.add( new JLabel( " " ), "wrap" );
	    			gamePanel.add( noButton);
			}
			else
			{
    				JLabel i = new JLabel("Invalid input. Please type in a valid word.");
				gamePanel.add(i,  SwingConstants.CENTER);
				i.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
				treePanel.removeAll();
	        		gamePanel.removeAll();
		        askWord();
		        treePanel.revalidate();
	     		treePanel.repaint();
		        gamePanel.revalidate();
		        gamePanel.repaint();
			}
	        newQuestionTxt.setText( "" );

     		gamePanel.revalidate();
     		gamePanel.repaint();

        }
    }

    public void askWord() {
    		gamePanel.setLayout(new GridLayout(2,1));
    		
    		//treePanel
    		JLabel p = new JLabel("Please enter a word that you would like to define: ");
    		treePanel.add(p,  SwingConstants.CENTER);
    		p.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
		treePanel.add( newQuestionTxt, "wrap" );
		treePanel.add( submitButton, "wrap" );
		JLabel avl = new JLabel("AVL Tree with moderately difficult words: ");
		treePanel.add(avl,  SwingConstants.CENTER);
		avl.setFont(new Font( Font.SERIF, Font.BOLD, 25 ) );
		gamePanel.add(treePanel, BorderLayout.CENTER);
			
    	 	String [] words = BTreePrinter.printNode(tree.root).split("\n");
    	 	
    	 	final JList list = new JList(words);
    	 	JScrollPane scrollPane = new JScrollPane(list);

    	 	scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    	 	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	 	scrollPane.setPreferredSize(getMaximumSize());
    	 	gamePanel.add(scrollPane, BorderLayout.CENTER);

	    	gameFrame.add( gamePanel);
    }
    
    public static void main( String [] args )
    {
        try 
        {
			GUI test = new GUI();
		}
        
        catch (IOException e) 
        {

		}
    }
}

