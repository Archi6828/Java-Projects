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
    
    static JFrame instructionFrame = new JFrame( "Mind Reader: Animal" );
    static JFrame gameFrame = new JFrame( "Mind Reader: Animal" );
    static JFrame endFrame = new JFrame( "Mind Reader: Animal" );
    
    JButton yesButton;
    JButton noButton;
    JButton tryAgainButton;
    JButton exitButton;
    JButton startButton;
    
    JLabel instructionsLabel;
    JLabel questionsLabel;
    
    JPanel instructionsPanel;
    Tree t;
    
    
    public GUI() throws IOException
    {
    		super( "Delivery Service" );  //NOT SURE
    		instructionFrame.setSize( 800, 800 );
    		instructionFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        //Set up tree
        	String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
		String [] questions = content.split( "\n" );
		t = new Tree( questions );
       
        
		instructionsPanel = new JPanel();
		instructionsPanel.setBackground( Color.LIGHT_GRAY );
		instructionsPanel.setLayout(new GridLayout(2,1));
		
		instructionsLabel = new JLabel( "Welcome to Mind Reader, Animal Version." + "\n" + "To play, please answer the questions with the \"yes\" \"no\" buttons." + "\n" + "If we get it wrong, please follow the screen to help us improve." + "\n" + "Click Start to begin.");
		instructionsLabel.setFont(new Font( Font.SANS_SERIF, Font.BOLD, 14 ) );
		instructionsPanel.add(instructionsLabel, BorderLayout.NORTH );
		//instructionFrame.add( instructionsLabel );
		
		startButton = new JButton( "Start" );
		startButton.addActionListener( this );
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
        
		
		instructionFrame.add( instructionsPanel );
		instructionFrame.setVisible( true );
		
    }
    
    
    
    public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
        
        //takes user to "window" of inputting packages
        if( word.equals( "Start" ) )
        {
            setVisible( false );
            instructionFrame.setVisible( false );
            gameFrame.setSize( 600, 600 );
            gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            gameFrame.setLayout( new FlowLayout() );
            gameFrame.setVisible( true );
        }
    }
//        
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
//        }
//        
//    }
//    
//    
//    
//    
//    
//    
    
    
    
    
    
    
    
    
    
    
    
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

/*

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener
{
    JTextField nameField;
    JTextField addressField;
    JTextField weightField;
    JTextField deliverNumField;
    
    JLabel resultLabel;
    
    DeliveryService company;
    
    //new frames so I can change "window" ish 
    static JFrame PackageFrame = new JFrame( "Delivery Service" );
    static JFrame DeliveryFrame = new JFrame( "Delivery Service" );
    static JFrame endFrame = new JFrame( "Delivery Service" );
    
    public static void main( String [] args )
    {
        GUI test = new GUI();
        test.setVisible( true );
    }
    
    //general first page setup
    public GUI()
    {
        super( "Delivery Service" );
        setSize( 600, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout( new FlowLayout() );
        
        company = new DeliveryService();
        
        JLabel title = new JLabel( "Welcome to the Delivery Service" );
        title.setFont(new Font( Font.SANS_SERIF, Font.BOLD, 24 ) );
        add(title);
        
        JButton startButton = new JButton( "Start" );
        startButton.addActionListener( this );
        add( startButton );
    }

    
    
    public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
        
        //takes user to "window" of inputting packages
        if( word.equals( "Start" ) || word.equals( "Add More" ) )
        {
            setVisible( false );
            DeliveryFrame.setVisible( false );
            PackageFrame.setSize( 600, 600 );
            PackageFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            PackageFrame.setLayout( new FlowLayout() );
            PackageFrame.setVisible( true );
            packageInput();
        }
        
        //supposedly adds packages to delivery services
        else if( word.equals( "Enter" ) )
        {
            String name = nameField.getText();
            String address = addressField.getText();
            double weight = 0;
            try
            {
                weight = Double.parseDouble( weightField.getText() );
            }
            catch( Exception p )
            {
                weight = 0;
            }
            
            //add package to company
            Package p = new Package( name, address, weight );
            company.addPackage( p );
            
            //reset text fields
            nameField.setText( "" );
            addressField.setText( "" );
            weightField.setText( "" );
            
            //"printing" package that was just submitted
            String result = "You just inputed package:";
            result += "\n" + "\t" + name;
            result += "\n" + "\t" + address;
            result += "\n" + "\t" + weight;
            
            resultLabel.setText( result );
        }
        
        //takes user to "window" of delivering packages
        else if( word.equals( "Process Packages" ) )
        {
            PackageFrame.setVisible( false );
            DeliveryFrame.setSize( 600, 600 );
            DeliveryFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            DeliveryFrame.setLayout( new FlowLayout() );
            DeliveryFrame.setVisible( true );
            packageDeliver();
        }
        
        //not really used rn
        else if( word.equals( "Exit" ) )
        {
            System.exit( 0 );
        }
        
        //submiting call to deliver a set number of packages
        else if( word.equals( "Submit" ) )
        {
            int num = 0;
            try
            {
                num = Integer.parseInt( deliverNumField.getText() );
            }
            catch( Exception p )
            {
                num = 0;
            }
            
            
            resultLabel.setText( company.deliverNum( num ) );
        }
        
        //call to deliver all packages
        else if( word.equals( "Deliver All" ) )
        {
            //resultLabel.setText( company.deliverAll() );
            PackageFrame.setVisible( false );
            DeliveryFrame.setVisible( false );
            endFrame.setSize( 600, 600 );
            endFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            endFrame.setLayout( new FlowLayout() );
            endFrame.setVisible( true );
            
            
            
        }
        
    }
    
    
    
    public void packageInput()
    {
        
        JLabel name = new JLabel( "Name: " );
        PackageFrame.add( name );
        nameField = new JTextField( "name", 42 );
        PackageFrame.add( nameField );
        
        JLabel address = new JLabel( "Address (House #/Street/Zip Code/City/State/Country): " );
        PackageFrame.add( address );
        addressField = new JTextField( "address", 15 );
        PackageFrame.add( addressField );
        
        JLabel weight = new JLabel( "Weight: " );
        PackageFrame.add( weight );
        weightField = new JTextField( "weight", 40 );
        PackageFrame.add( weightField );
        
        //button for entering each package's info
        JButton enterButton = new JButton( "Enter" );
        enterButton.addActionListener( this );
        PackageFrame.add( enterButton );
        
        //instruction label
        JLabel complete = new JLabel( "If you are done entering packages, please click \"Process Packages\" " );
        PackageFrame.add( complete );
        
        //Button for finished entering packages
        JButton doneButton = new JButton( "Process Packages" );
        doneButton.addActionListener(this);
        PackageFrame.add( doneButton );
        
        resultLabel = new JLabel( "" );
        PackageFrame.add( resultLabel );
        
    }
    
    
    
    
    
    public void packageDeliver()
    {
        JLabel questionLabel = new JLabel( "Enter number of packages you wish to deliver: " );
        DeliveryFrame.add( questionLabel );
        
        deliverNumField = new JTextField( "num", 10 );
        DeliveryFrame.add( deliverNumField );
        
        JButton submitButton = new JButton( "Submit" );
        submitButton.addActionListener(this);
        DeliveryFrame.add( submitButton );
        
        JButton submitAllButton = new JButton( "Deliver All" );
        submitAllButton.addActionListener(this);
        DeliveryFrame.add( submitAllButton );
        
        JLabel addMoreLabel = new JLabel( "Click Here to add more packages" );
        DeliveryFrame.add( addMoreLabel );
        
        JButton addMore = new JButton( "Add More" );
        addMore.addActionListener(this);
        DeliveryFrame.add( addMore );
        
        resultLabel = new JLabel( "" );
        DeliveryFrame.add( resultLabel );
        
        
        
    }
    
    
    
    
    
    
    
}












/*
//EXAMPLE

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI2 extends JFrame implements ActionListener
{
    JTextField nameField;
    JLabel resultLabel;
    
    public static void main( String [] args )
    {
        GUI2 test = new GUI2();
        test.setVisible( true );
    }
    
    
    public GUI2()
    {
        super( "Delivery Service" );
        setSize( 400, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout( new FlowLayout() );
        
        JLabel name = new JLabel( "Name: " );
        add( name );
        
        nameField = new JTextField( "name", 10 );
        add( nameField );
        
        JButton exitButton = new JButton( "Exit" );
        exitButton.addActionListener( this );
        add( exitButton );
        JButton clearButton = new JButton( "Clear" );
        clearButton.addActionListener(this);
        add( clearButton );
        JButton nameButton = new JButton( "Get Name" );
        nameButton.addActionListener( this );
        add( nameButton );
        
        resultLabel = new JLabel( "" );
        add( resultLabel );
    }

    
    
    public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
        if( word.equals( "Exit" ) )
        {
            System.exit( 0 );
        }
        
        else if( word.equals( "Clear" ) )
        {
            nameField.setText( "" );
            resultLabel.setText( "" );
        }
        
        else if( word.equals( "Get Name" ) )
        {
            String name = nameField.getText();
            nameField.setText( "" );
            resultLabel.setText( "Enter name was " + name );
        }
        
        
        
    }
    
    
}

*/

