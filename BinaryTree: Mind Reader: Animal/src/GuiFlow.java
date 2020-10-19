import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;

public class GuiFlow extends JFrame implements ActionListener
{
    JTextField animal;
    JTextField newQuestion;
    
    JLabel instructionsLabel;
    JPanel instructionsPanel;
    
    JButton startButton;
    JButton yesButton;
    JButton noButton;
    
    Tree tree;
    
    static JFrame gameFrame = new JFrame( "Tree" );
    
    public static void main( String [] args ) throws IOException
    {
        GuiFlow test = new GuiFlow();
        test.setVisible( true );
    }
    
    
    public GuiFlow() throws IOException
    {
        super( "Tree" ); //sets title
        setSize( 600, 600 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //setLayout( new FlowLayout() );
        
        
        String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
        String [] questions = content.split( "\n" );
        
        tree = new Tree( questions);
        
        instructionsPanel = new JPanel();
        instructionsPanel.setLayout( new FlowLayout(-2, 10, 10 ) ); //( # pixels from side of window, # of pixels btwn each other/horizontal gap, # of pixels up and down/vertical gap)
        
        instructionsLabel = new JLabel( "Welcome to the Tree" );
        instructionsLabel.setFont(new Font( Font.SANS_SERIF, Font.BOLD, 12 ) );
        instructionsPanel.add(instructionsLabel);
        
        startButton = new JButton( "Start" );
        startButton.addActionListener( this );
        instructionsPanel.add( startButton );
        
        yesButton = new JButton( "Yes" );
        yesButton.addActionListener( this );
        instructionsPanel.add( yesButton );
        
        add( instructionsPanel );
        
    }

    
    
    public void actionPerformed(ActionEvent e) 
    {
        String word = e.getActionCommand();
        
        if( word.equals( "Start" ) )
        {
            setVisible( false );
            gameFrame.setSize( 600, 600 );
            gameFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            gameFrame.setLayout( new FlowLayout() );
            gameFrame.setVisible( true );
        }
        
//        else if( word.equals( "Enter" ) )
//        {
//            String name = nameField.getText();
//            String address = addressField.getText();
//            double weight = Double.parseDouble( addressField.getText() ); 
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
//            
//            String result = "You just inputed package:";
//            result += "\n" + "\t" + name;
//            result += "\n" + "\t" + address;
//            result += "\n" + "\t" + weight;
//            
//            resultLabel.setText( result );
//        }
//        
//        else if( word.equals( "Done" ) )
//        {
//            packageDeliver();
//        }
//        
//        else if( word.equals( "Exit" ) )
//        {
//            System.exit( 0 );
//        }
//        
//        else if( word.equals( "Submit" ) )
//        {
//            int num = Integer.parseInt( deliverNumField.getText() );
//            company.deliverNum( num );
//        }
//        
//        else if( word.equals( "Deliver All" ) )
//        {
//            company.deliverAll();
//        }
        
    }
    
//    
//    
//    public void packageInput()
//    {
//        JLabel name = new JLabel( "Name: " );
//        PackageFrame.add( name );
//        nameField = new JTextField( "name", 20 );
//        PackageFrame.add( nameField );
//        
//        JLabel address = new JLabel( "Address: " );
//        PackageFrame.add( address );
//        addressField = new JTextField( "address", 20 );
//        PackageFrame.add( addressField );
//        
//        JLabel weight = new JLabel( "Weight: " );
//        PackageFrame.add( weight );
//        weightField = new JTextField( "weight", 20 );
//        PackageFrame.add( weightField );
//        
//        
//        //button for entering each package's info
//        JButton enterButton = new JButton( "Enter" );
//        enterButton.addActionListener( this );
//        PackageFrame.add( enterButton );
//        
//        //instruction label
//        JLabel complete = new JLabel( "If you are done entering packages, please click \"Done\" " );
//        PackageFrame.add( complete );
//        
//        //Button for finished entering packages
//        JButton doneButton = new JButton( "Done" );
//        doneButton.addActionListener(this);
//        PackageFrame.add( doneButton );
//        
//        resultLabel = new JLabel( "" );
//        PackageFrame.add( resultLabel );
//        
//        
//    }
    
    
    
   
    
}
//
//
//
//
//
//
//
//
//
//
//
//
///*
////EXAMPLE
//
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//public class GUI2 extends JFrame implements ActionListener
//{
//    JTextField nameField;
//    JLabel resultLabel;
//    
//    public static void main( String [] args )
//    {
//        GUI2 test = new GUI2();
//        test.setVisible( true );
//    }
//    
//    
//    public GUI2()
//    {
//        super( "Delivery Service" );
//        setSize( 400, 400 );
//        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       // setLayout( new FlowLayout() );
       
//        JLabel name = new JLabel( "Name: " );
//        add( name );
//        
//        nameField = new JTextField( "name", 10 );
//        add( nameField );
//        
//        JButton exitButton = new JButton( "Exit" );
//        exitButton.addActionListener( this );
//        add( exitButton );
//        JButton clearButton = new JButton( "Clear" );
//        clearButton.addActionListener(this);
//        add( clearButton );
//        JButton nameButton = new JButton( "Get Name" );
//        nameButton.addActionListener( this );
//        add( nameButton );
//        
//        resultLabel = new JLabel( "" );
//        add( resultLabel );
//    }
//
//    
//    
//    public void actionPerformed(ActionEvent e) 
//    {
//        String word = e.getActionCommand();
//        if( word.equals( "Exit" ) )
//        {
//            System.exit( 0 );
//        }
//        
//        else if( word.equals( "Clear" ) )
//        {
//            nameField.setText( "" );
//            resultLabel.setText( "" );
//        }
//        
//        else if( word.equals( "Get Name" ) )
//        {
//            String name = nameField.getText();
//            nameField.setText( "" );
//            resultLabel.setText( "Enter name was " + name );
//        }
//        
//        
//        
//    }
//    
//    
//}
//
//*/