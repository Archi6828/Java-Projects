import java.awt.Color;
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


public class GUI implements ActionListener
{
	JFrame frame = new JFrame( "JAC's Pet Store" );
	JPanel panel = new JPanel();
	PetAdoption p;
	
	//Instructions
	JLabel welcomeLabel = new JLabel( "Welcome to JAC's Pet Store!" );
	JLabel instructionsLabel = new JLabel("Would you like to: ");
	JLabel questionLabel = new JLabel();
	
	//Text Fields for adding a new animal
	JTextField animalNameTxt = new JTextField( 20 );
	JTextField animalAgeTxt = new JTextField( 20 );
	JTextField animalSpeciesTxt = new JTextField( 20 );
	JTextField animalColorTxt = new JTextField( 20 );
	JTextField animalSizeTxt = new JTextField( 20 );
	
	JTextField location = new JTextField( 20 );
	
	//Text Fields for adopting an animal
	JTextField PrintChioceTxt = new JTextField( 20 );
	
	//Navigation buttons
	JButton newCustomerBtn = new JButton( "New Customer" );
	JButton adoptBtn = new JButton( "Adopt an Animal" );
	JButton putUpBtn = new JButton( "Put an Animal Up for Adoption" );
	JButton yesBtn = new JButton( "Yes" );
	JButton noBtn = new JButton( "No" );
	JButton exitBtn = new JButton( "Exit" );
	JButton homeBtn = new JButton( "Return Home" );
	JButton submitBtn = new JButton( "Submit" );
	JButton nextBtn = new JButton( "Next" );
	
	//Buttons for printing info
	JButton printAllBtn = new JButton( "All" );
	JButton printSpeciesBtn = new JButton( "Species" );
	JButton printAgeBtn = new JButton( "Age" );
	JButton printSizeBtn = new JButton( "Size" );
	JButton printColorBtn = new JButton( "Color" );
	
	//Adopt
	JButton AdoptBtn = new JButton( "Choose" );
	
	//location buttons
	ImageIcon imageMap;
	JButton IrvineBtn = new JButton( "Irvine" );
	JButton ParisBtn = new JButton( "Paris" );
	JButton TokyoBtn = new JButton( "Tokyo" );
	JButton BeijingBtn = new JButton( "Beijing" );
	
	private String locationStr;
	private boolean adoption;
	
	
	public GUI() throws IOException
	{
		//Set up pet adoption catalogue
		p = new PetAdoption();
		createTree( p, "Irvine" );
		createTree( p, "Paris" );
		createTree( p, "Tokyo" );
		createTree( p, "Beijing" );
		
		locationStr = "";
		adoption = true;
		
		//map image
		imageMap = createImageIcon( "map.jpg", "map" );
		
		//scale
        Image scale = imageMap.getImage().getScaledInstance( 500, 350, 0 );
        imageMap = new ImageIcon( scale );
		
		//Set up the font for the labels
		welcomeLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 25 ) );
		welcomeLabel.setForeground( Color.WHITE );
		instructionsLabel.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 18 ) );
		instructionsLabel.setForeground( Color.WHITE );
		
		//Set up the background color for the panel
		panel.setBackground( Color.PINK );
		
		//Set up buttons designs
		newCustomerBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 20 ) );
		adoptBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		putUpBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		yesBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		noBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		exitBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		homeBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		submitBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		nextBtn.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 18 ) );
		
		newCustomerBtn.setPreferredSize( new Dimension( 120, 60 ) );
		adoptBtn.setPreferredSize( new Dimension( 100, 40 ) );
		putUpBtn.setPreferredSize( new Dimension( 100, 40 ) );
		yesBtn.setPreferredSize( new Dimension( 100, 40 ) );
		noBtn.setPreferredSize( new Dimension( 100, 40 ) );
		exitBtn.setPreferredSize( new Dimension( 100, 40 ) );
		homeBtn.setPreferredSize( new Dimension( 100, 40 ) );
		submitBtn.setPreferredSize( new Dimension( 100, 40 ) );
		nextBtn.setPreferredSize( new Dimension( 100, 40 ) );
		
		//Set up button listeners
		newCustomerBtn.addActionListener( this );
		adoptBtn.addActionListener( this );
		putUpBtn.addActionListener( this );
		yesBtn.addActionListener( this );
		noBtn.addActionListener( this );
		exitBtn.addActionListener( this );
		homeBtn.addActionListener( this );
		submitBtn.addActionListener( this );
		nextBtn.addActionListener( this );
		//buttons for printing 
		printAllBtn.addActionListener( this );
		printSpeciesBtn.addActionListener( this );
		printColorBtn.addActionListener( this );
		printSizeBtn.addActionListener( this );
		printAgeBtn.addActionListener( this );
		AdoptBtn.addActionListener( this );
		
		//buttons for location
		IrvineBtn.addActionListener( this );
		ParisBtn.addActionListener( this );
		TokyoBtn.addActionListener( this );
		BeijingBtn.addActionListener( this );
		
		//Set up Home Screen
		panel.setLayout( new MigLayout() );
		panel.add( welcomeLabel, "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( newCustomerBtn, "skip, split2" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( exitBtn, "skip, split2" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		
		//Set up frame
		frame.add( panel );
		frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
	
	
	public void actionPerformed(ActionEvent e) 
    {
		String word = e.getActionCommand();
	     
        if( word.equals( "New Customer" ) || word.equals( "Return Home") )
        {
        		panel.removeAll();
        		
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( adoptBtn, "split2" );
        		panel.add( putUpBtn, "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( new JLabel( " " ), "wrap" );
        		panel.add( exitBtn, "skip, split2, wrap" );
        		panel.add( homeBtn, "split2, skip, wrap" );
            
            	panel.revalidate();
            	panel.repaint();
        }

        if( word.equals( "Adopt an Animal" ) )
        {
        		setUpLocationScreen();
        		adoption = true;
        }
        
        if( word.equals( "Put an Animal Up for Adoption" ) )
        {
	        	setUpLocationScreen();
	    		adoption = false;
        }

        //location button
 	   if( word.equals( "Irvine" ) || word.equals( "Paris") || word.equals( "Tokyo" ) || word.equals( "Beijing") )
     {
 		  locationStr = word;
 		  if( adoption )
				word = "Adopt";
			else
				word = "Put Up";
 			
     }
 	   
        
        //for getting string of location input
//        if( word.equals( "Next" ) )
//        {
//    			//locationStr = location.getText();
//    			//locationStr = 
//    			if( adoption )
//    				word = "Adopt";
//    			else
//    				word = "Put Up";
//        }
        
        if( word.equals( "Put Up" ) )
        {
	        	panel.removeAll();
	    		
			panel.add( new JLabel( "Please enter your animal's information: " ), "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( "Name: " ), "wrap" );
			panel.add( animalNameTxt, "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( "Species: " ), "wrap" );
			panel.add( animalSpeciesTxt, "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( "Age (years): " ), "wrap" );
			panel.add( animalAgeTxt, "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( "Color: " ), "wrap" );
			panel.add( animalColorTxt, "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( "Size (small-1, medium-2, large-3): " ), "wrap" );
			panel.add( animalSizeTxt, "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( new JLabel( " " ), "wrap" );
			panel.add( submitBtn, "wrap" );
			panel.add( exitBtn, "wrap" );
	        
			panel.revalidate();
			panel.repaint();
        }

        if( word.equals( "Adopt" ) )
        {
         	panel.removeAll();
         	
	        	panel.add( new JLabel( "How would you like to search by? Species, Age, Size, Color, All" ), "wrap" );
	    		panel.add( new JLabel( " " ), "wrap" );
	    		
	    		panel.add( printSpeciesBtn, "wrap" );
	    		panel.add( printAgeBtn , "wrap" );
	    		panel.add( printSizeBtn, "wrap" );
	    		panel.add( printColorBtn , "wrap" );
	    		panel.add( printAllBtn, "wrap" );
	    		
	    		panel.revalidate();
			panel.repaint();
        }
       
        if(word.equals("All")) {
 		   panel.removeAll();
 	    	
 			//panel.add( new JLabel( " " ), "wrap" );
			for( Animal a : p.get(locationStr) )
			{
				panel.add( new JLabel( "Name: " + a.getName() + "           " + "Species: " + a.getSpecies() + "           " + "Age: " + a.getAge() + "           " +  "Size: " + a.getSize() + "           " + "Color: " + a.getColor()), "wrap" );
			}
			panel.add( new JLabel( " " ), "wrap" );
 			panel.add( new JLabel( "Please enter the name of the animal you wish to adopt: " ), "wrap" );
 			panel.add( PrintChioceTxt, "wrap" );
 			panel.add( new JLabel( " " ), "wrap" );
 			
 			panel.add( AdoptBtn, "wrap" );
			panel.add( exitBtn, "wrap" );
			
 			panel.revalidate();
 			panel.repaint();
 		}
        
	    	   if(word.equals("Species")) {
	    		   panel.removeAll();
	    	    		
				for( Animal a : p.get(locationStr) )
				{
					panel.add( new JLabel( "Species: " + a.getSpecies() + "           " + "Name: " + a.getName()), "wrap" );
				}
				panel.add( new JLabel( " " ), "wrap" );
				panel.add( new JLabel( "Please enter the name of the animal you wish to adopt: " ), "wrap" );
	 			panel.add( PrintChioceTxt, "wrap" );
	 			panel.add( new JLabel( " " ), "wrap" );
	 			
	    			panel.add(AdoptBtn, "wrap" );
	    			panel.add( exitBtn, "wrap" );
	    			
	    			panel.revalidate();
	    			panel.repaint();
	    		}
	    		
	    	   if(word.equals("Age")) {
	    		   panel.removeAll();
	    		   
				for( Animal a : p.get(locationStr) )
				{
					panel.add( new JLabel( "Age: " + a.getAge() + "           " + "Species: " + a.getSpecies() + "           " + "Name: " + a.getName()), "wrap" );
				}
				panel.add( new JLabel( " " ), "wrap" );
				panel.add( new JLabel( "Please enter the name of the animal you wish to adopt: " ), "wrap" );
	 			panel.add( PrintChioceTxt, "wrap" );
	 			panel.add( new JLabel( " " ), "wrap" );
	 			
	    			panel.add( AdoptBtn, "wrap" );
	    			panel.add( exitBtn, "wrap" );
	    			
	    			panel.revalidate();
	    			panel.repaint();
	    		}
	    	   
	    	   if(word.equals("Size")) {
	    		   panel.removeAll();
	    		   
				for( Animal a : p.get(locationStr) )
				{
					panel.add( new JLabel( "Size: " + a.getSize() + "           " + "Species: " + a.getSpecies() + "           " + "Name: " + a.getName()), "wrap" );
				}
				panel.add( new JLabel( " " ), "wrap" );
				panel.add( new JLabel( "Please enter the name of the animal you wish to adopt: " ), "wrap" );
	 			panel.add( PrintChioceTxt, "wrap" );
	 			panel.add( new JLabel( " " ), "wrap" );
	 			
	    			panel.add( AdoptBtn, "wrap" );
	    			panel.add( exitBtn, "wrap" );
	    			
	    			panel.revalidate();
	    			panel.repaint();
	    		}
	    	   
	    	   if(word.equals("Color")) {
	    		   panel.removeAll();
	    	    	
				for( Animal a : p.get(locationStr) )
				{
					panel.add( new JLabel( "Color: " + a.getColor() + "           " + "Species: " + a.getSpecies() + "           " + "Name: " + a.getName()), "wrap" );
				}
				panel.add( new JLabel( " " ), "wrap" );
				panel.add( new JLabel( "Please enter the name of the animal you wish to adopt: " ), "wrap" );
	 			panel.add( PrintChioceTxt, "wrap" );
	 			panel.add( new JLabel( " " ), "wrap" );
	 			
	    			panel.add( AdoptBtn, "wrap" );
	    			panel.add( exitBtn, "wrap" );
	    			
	    			panel.revalidate();
	    			panel.repaint();
	    		}
	    	   
	    	   if(word.equals("Choose")){
	    		   String  name = PrintChioceTxt.getText();
	    		   panel.removeAll();
	    		   
	    		   for( Animal a : p.get(locationStr) )
	    		   {
		    		   if(a.getName().equals(name)) {
		    			   panel.removeAll();
		    			   System.out.println("chosen: " + name);
		    			   p.remove(locationStr, name, a.getSpecies());
		    			   panel.add( new JLabel( "Congratulations! You have adopted "+ name + "!" ), "wrap" );
		    			   panel.add( new JLabel( " " ), "wrap" );
		    			   
		    			   panel.add( homeBtn, "wrap" );
		    			   panel.revalidate();
			    		   panel.repaint();
		    		   }
		    		   else {
		    			   panel.removeAll();
		    			   panel.add( new JLabel( "That is an invalid name. Please input another name: " ), "wrap" );
		    			   panel.add( PrintChioceTxt, "wrap" );
		    			   panel.add( new JLabel( " " ), "wrap" );
		    			   
		    			   panel.add(AdoptBtn, "wrap" );
		    			   panel.add( homeBtn, "wrap" );
		    			   panel.revalidate();
			    		   panel.repaint();
		    		   }
	    		   }
	    		   panel.add( exitBtn, "wrap" );
	    			
	    			panel.revalidate();
	    			panel.repaint();
	    			   
    			}
	    		/*

	    		System.out.println( "Please enter the name of the animal you wish to adopt: " );
	    		String name = input.nextLine();
	    		
	    		while( !p.contains( location, name ) )
	    		{
	    			System.out.println( "That is an invalid name. Please input another name: " );
	    			name = input.nextLine();
	    		}
	    		
	    		System.out.println( "Please enter the species of the animal you wish to adopt: " );
	    		String species = input.nextLine();
	    		
	    		while( !p.contains( location, name, species ) )
	    		{
	    			System.out.println( p.printSpecies(location ) );
	    			System.out.println( "That is an invalid species. Please input another species: " );
	    			species = input.nextLine();
	    		}
	    		
	    		p.remove(location, name, species );
	    		
	    		System.out.println( "Congratulations! You have adopted " + name + "!" );
	    		
	    		panel.add( new JLabel( " " ), "wrap" );
//	    		panel.add( new JLabel( " " ), "wrap" );
//	    		panel.add( new JLabel( " " ), "wrap" );
//	    		panel.add( new JLabel( " " ), "wrap" );
	    		//panel.add( submitBtn, "wrap" );
			panel.add( exitBtn, "wrap" );
			
	    		panel.revalidate();
			panel.repaint();
        }
        */
	    	
	    	
	    	   
	    	   
        if( word.equals( "Exit" ) )
        {
        		System.exit( 0 );
        }
        
        if( word.equals( "Submit" ) )
        {
        		String nameStr = animalNameTxt.getText();
        		String speciesStr = animalSpeciesTxt.getText();
        		int  ageInt= Integer.parseInt( animalAgeTxt.getText() );
        		int sizeInt = Integer.parseInt( animalSizeTxt.getText() );
        		String colorStr = animalColorTxt.getText();
        		
        		Animal a = new Animal( nameStr, speciesStr, colorStr, sizeInt, ageInt );
        		
        		String temp = nameStr + "-" + speciesStr + "-" + colorStr + "-" + sizeInt + "-" + ageInt;
        		
        		p.add( locationStr, a );
        		try {
					writeToTextFile( locationStr, temp);
			} 
        		catch (IOException e1) {
			}
        		
        		//reset text fields
        		animalNameTxt.setText( "" );
        		animalSpeciesTxt.setText( "" );
        		animalAgeTxt.setText( "" );
        		animalSizeTxt.setText( "" );
        		animalColorTxt.setText( "" );
        		
	        //End screen
	        setUpEndScreen();
        }
    
    }
	
	//creates image icon
    public ImageIcon createImageIcon(String path, String description)
    {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	public void setUpEndScreen()
	{
		panel.removeAll();
		
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( newCustomerBtn, "wrap" );
		panel.add( exitBtn, "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		
		panel.revalidate();
		panel.repaint();
	}
	
	
	public void setUpLocationScreen()
	{
		panel.removeAll();
		questionLabel.setText( "Please select enter your location: " );
		
        
		panel.add( new JLabel(imageMap), "wrap" );
		
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( IrvineBtn , "wrap" );
		panel.add( ParisBtn, "wrap" );
		panel.add( TokyoBtn, "wrap" );
		panel.add( BeijingBtn, "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		//panel.add( questionLabel, "wrap" );
		//panel.add( location );
		panel.add( new JLabel( " " ), "wrap" );
		panel.add( new JLabel( " " ), "wrap" );
		//panel.add( nextBtn );
		panel.add( exitBtn );
		panel.add( homeBtn );
		
		panel.revalidate();
    		panel.repaint();
	}
	
	//Method that allows us to write to a file
	public static void writeToTextFile(String fileName, String content) throws IOException 
	{   
		//Files.write(Paths.get("src/" + fileName), content.getBytes(), StandardOpenOption.APPEND);
		Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.APPEND);
    }
	
		
	//Method that is used to create the Tree when we first start the program
	public static void createTree( PetAdoption p, String file ) throws FileNotFoundException
	{
		//Scanner s = new Scanner( new File( "src/" + file ) );
		Scanner s = new Scanner( new File(file ) );
		
		while( s.hasNext() )
		{
			String temp = s.nextLine();
			if( temp.length() > 0 )
			{
				String [] aComponents = temp.split( "-" );
				String size = aComponents[3].toLowerCase();
				
				int sizeNum = 1;
				if( size.equals( "medium" ) )
					sizeNum = 2;
				else if( size.equals( "large" ) )
					sizeNum = 3;
				
				Animal a = new Animal( aComponents[0], aComponents[1], aComponents[2], sizeNum, Integer.parseInt( aComponents[4] ) );
				
				p.add( file, a );
			}
		}
	}
	
	
	public static void main( String [] args )
	{
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run() {
				try {
					new GUI();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
}
























/*
public class GUI implements ActionListener
{
	JFrame frame = new JFrame( "JAC's Pet Store" );
	
	JPanel panel = new JPanel();
	
	//Instructions
	JLabel welcomeLabel = new JLabel( "Welcome to the Jac's Pet Store!" );
	JLabel instructionsLabel = new JLabel("Would you like to: ");
	
	JLabel questionsLabel = new JLabel();
//	JLabel animalLabel = new JLabel( "Please enter your animal" );
//	JLabel newQuestionLabel = new JLabel( "Please enter a question to differentiate the animal." );
//	JLabel newQuestionLabel2 = new JLabel( "(Yes for your animal, No for the original animal)" );
	JLabel tryAgainLabel = new JLabel( "Would you like to repeat?" );
	
	JTextField animalName = new JTextField( 20 );
	JTextField animalAge = new JTextField( 20 );
	JTextField animalSpecies = new JTextField( 20 );
	JTextField animalColor = new JTextField( 20 );
	JTextField animalSize = new JTextField( 20 );
	
	JButton startBtn = new JButton( "Start" );
	JButton yesBtn = new JButton( "Yes" );
	JButton noBtn = new JButton( "No" );
	JButton exitBtn = new JButton( "Exit" );
	JButton playAgainBtn = new JButton( "Play Again" );
	JButton submitBtn = new JButton( "Submit" );
	
	public GUI() throws IOException
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
	
	public static void writeToTextFile(String fileName, String content) throws IOException 
	{   
		Files.write(Paths.get("src/" + fileName), content.getBytes(), StandardOpenOption.APPEND);
    }
	
	public static void createTree( PetAdoption p, String file ) throws FileNotFoundException
	{
		Scanner s = new Scanner( new File( "src/" + file ) );
		
		while( s.hasNext() )
		{
			String temp = s.nextLine();
			if( temp.length() > 0 )
			{
				String [] aComponents = temp.split( "-" );
				String size = aComponents[3].toLowerCase();
				
				int sizeNum = 1;
				if( size.equals( "medium" ) )
					sizeNum = 2;
				else if( size.equals( "large" ) )
					sizeNum = 3;
				
				Animal a = new Animal( aComponents[0], aComponents[1], aComponents[2], sizeNum, Integer.parseInt( aComponents[4] ) );
				
				p.add( file, a );
			}
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main( String [] args )
	{
		SwingUtilities.invokeLater( new Runnable() 
		{
			@Override
			public void run() {
				try {
					new GUI();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
}
 */

