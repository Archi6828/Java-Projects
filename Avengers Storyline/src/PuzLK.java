import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
 
/*
Rules I changed:
Instead a traditional puzzle game, 
the player will see a question at the bottom, and the player needs to click the corresponding panel in order to get scores/coins/whatever.
 
Since the puzzle has 6 pieces, there will be 6 random questions provided (according to the x value).
 
I put System.out.println now as results, and u can change it :D
 
x = 1   should get "worked1" if successfully click on panel 1   otherwise get "failed"
x = 2   should get "worked2" if successfully click on panel 2   otherwise get "failed"
x = 3   should get "worked3" if successfully click on panel 3   otherwise get "failed"
and so on...
 
 
*/
 
 
 
public class PuzLK extends JFrame implements ActionListener
{
    
    private JPanel mainPanel, centerPanel, GreenGoblinPanel, topPanel, bottomPanel, Piece1Panel, Piece2Panel, Piece3Panel, Piece4Panel, Piece5Panel, Piece6Panel, timerPanel;
    private JFrame frame;
    private ImageIcon pic1, Piece1, Piece2, Piece3, Piece4, Piece5, Piece6; 
    private JLabel LokiLabel, Piece1Label, Piece2Label, Piece3Label, Piece4Label, Piece5Label, Piece6Label, timerLabel;
    private ArrayList <JButton> newArr = new ArrayList <JButton>();
    private ArrayList <JButton> temp = new ArrayList <JButton>();
    
    private int time;
    private Timer t;
    
    
    private JButton button, pic1Button, pic2Button, pic3Button, pic4Button, pic5Button, pic6Button, timerButton;
    
    //the random x value, has 6 possibe values. If x = 1, the player needs to click on Panel 1. 
    private int x;
    
    //record times of rounds
    private int y;
    
    
    public PuzLK()
    {
        x = randomNumber();//(int) (Math.random() * 6 + 1);
        
        frame = new JFrame();
        frame.setSize(1000,900);
        //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Puzzle Game");
        
        //set up panels
        mainPanel = new JPanel();
        centerPanel = new JPanel();
        GreenGoblinPanel = new JPanel ();
        topPanel = new JPanel ();
        bottomPanel = new JPanel ();
        
        mainPanel.setLayout( new GridLayout(4,4));
        
        
        
        /*
                    if(x == 1)
                    button = new JButton("CLICK to start the game! CLICK the Panel with the most light!");
                    if(x == 2)
                    button = new JButton("CLICK to start the game! CLICK the Panel with the two red lights!");
                    if(x == 3)
                    button = new JButton("CLICK to start the game! CLICK the Panel with his left arm!");
                    if(x == 4)
                    button = new JButton("CLICK to start the game! CLICK on the right wing!");
                    if(x == 5)
                    button = new JButton("CLICK to start the game! CLICK the Panel with the engine!");
                    if(x == 6)
                    button = new JButton("CLICK to start the game! CLICK the Panel with his left leg!");
        */
        
        //All the random questions 
        randomQuestions();
       
        
        setUpButton();
        
        
        //set up timer
        time = 0;
        setUpTimer();
        timerLabel = new JLabel ("Timer: " + time, JLabel.CENTER);
     
        //initialize all the panels        
        Piece1Panel = new JPanel();
        Piece1Panel.setLayout(new GridLayout());
        Piece2Panel = new JPanel();
        Piece2Panel.setLayout(new GridLayout());
        Piece3Panel = new JPanel();
        Piece3Panel.setLayout(new GridLayout());
        Piece4Panel = new JPanel();
        Piece4Panel.setLayout(new GridLayout());
        Piece5Panel = new JPanel();
        Piece5Panel.setLayout(new GridLayout());
        Piece6Panel = new JPanel();
        Piece6Panel.setLayout(new GridLayout());
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
 
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
       
 
        
        //set up images
        pic1 = createImageIcon( "Loki.jpg", "Loki");
        Image GreenGoblinPic = pic1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        pic1 = new ImageIcon ( GreenGoblinPic);
        LokiLabel = new JLabel ( "", pic1, JLabel.CENTER);
        
        
        
        Piece1 = createImageIcon( "LokiPiece1.jpg", "piece1");
        Image GreenGoblinPiece1 = Piece1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece1 = new ImageIcon ( GreenGoblinPiece1);
        Piece1Label = new JLabel ( "", Piece1, JLabel.CENTER);
        
        Piece2 = createImageIcon( "LokiPiece2.jpg", "piece2");
        Image GreenGoblinPiece2 = Piece2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece2 = new ImageIcon ( GreenGoblinPiece2);
        Piece2Label = new JLabel ( "", Piece2, JLabel.CENTER);
        
        
       Piece3 = createImageIcon( "LokiPiece3.jpg", "piece3");
        Image GreenGoblinPiece3 = Piece3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece3 = new ImageIcon ( GreenGoblinPiece3);
        Piece3Label = new JLabel ( "", Piece3, JLabel.CENTER);
        
        
        Piece4 = createImageIcon( "LokiPiece4.jpg", "piece4");
        Image GreenGoblinPiece4 = Piece4.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece4 = new ImageIcon ( GreenGoblinPiece4);
        Piece4Label = new JLabel ( "", Piece4, JLabel.CENTER);
        
        Piece5 = createImageIcon( "LokiPiece5.jpg", "piece5");
        Image GreenGoblinPiece5 = Piece5.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece5 = new ImageIcon ( GreenGoblinPiece5);
        Piece5Label = new JLabel ( "", Piece5, JLabel.CENTER);
        
        
        Piece6 = createImageIcon( "LokiPiece6.jpg", "piece6");
        Image GreenGoblinPiece6 = Piece6.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Piece6 = new ImageIcon ( GreenGoblinPiece6);
        Piece6Label = new JLabel ( "", Piece6, JLabel.CENTER);
        
        
        //All the pictures are buttons 
            pic1Button = new JButton (Piece1);
            pic2Button = new JButton (Piece2);
            pic3Button = new JButton (Piece3);
            pic4Button = new JButton (Piece4);
            pic5Button = new JButton (Piece5);
            pic6Button = new JButton (Piece6);
        
        
//adding all the labels to the panels        
         GreenGoblinPanel.add(LokiLabel);
         Piece1Panel.add(Piece1Label);
         Piece2Panel.add(Piece2Label);
         Piece3Panel.add(Piece3Label);
         Piece4Panel.add(Piece4Label);
         Piece5Panel.add(Piece5Label);
         Piece6Panel.add(Piece6Label);
        
///adding all the panels to the buttons         
         pic1Button.add(Piece1Panel);
         pic2Button.add(Piece2Panel);
         pic3Button.add(Piece3Panel);
         pic4Button.add(Piece4Panel);
         pic5Button.add(Piece5Panel);
         pic6Button.add(Piece6Panel);
 
//this game has two image panels, and each panel has 3 images
    //top 3 images
         topPanel.add(pic1Button);
         topPanel.add(pic2Button);
         topPanel.add(pic3Button);
    //bottom 3 images
         bottomPanel.add(pic4Button);
         bottomPanel.add(pic5Button);
         bottomPanel.add(pic6Button);
         
 
//adding all the (6) buttons to newArr         
        JButton pos1 = pic1Button;
    	newArr.add(pos1);
	
     	JButton pos2 = pic2Button;
     	newArr.add(pos2);
	
     	JButton pos3 = pic3Button;
     	newArr.add(pos3);
     	
     	JButton pos4 = pic4Button;
     	newArr.add(pos4);
     	
      	JButton pos5 = pic5Button;
      	newArr.add(pos5);
        
        JButton pos6 = pic6Button;
      	newArr.add(pos6);
        
 
//adding all the things to mainPanel
          mainPanel.add(GreenGoblinPanel, BorderLayout.CENTER);
          mainPanel.add(topPanel, BorderLayout.NORTH);
          mainPanel.add(bottomPanel, BorderLayout.SOUTH);
          mainPanel.add(button, BorderLayout.SOUTH);
          
 
         frame.add(mainPanel);
         
         
              
         frame.setVisible(true);
 
    }
    
    public int randomNumber()
    {
        return (int)(Math.random() * 6 + 1);
    }
    
    public void randomQuestions()
    {
        if(x == 1)
                    button = new JButton("CLICK to start the game! Find where the star is!");
                    if(x == 2)
                    button = new JButton("CLICK to start the game! Locate Loki's face!");
                    if(x == 3)
                    button = new JButton("CLICK to start the game! Find the two horns!");
                    if(x == 4)
                    button = new JButton("CLICK to start the game! Locate where the green ribbon is!");
                    if(x == 5)
                    button = new JButton("CLICK to start the game! Click his hand!");
                    if(x == 6)
                    button = new JButton("CLICK to start the game! Find the pure black piece!");
    }
 
    //randomize all the images    
        public JButton getRandomImages()
    	{
      
        	
        	JButton posRandom = temp.get(0);
        	
                    	int random = (int)(Math.random() * temp.size());
                        
                    	posRandom = temp.get(random);
                        
                        temp.remove(random);
                    	
        	return posRandom;
    	}
    	
        
        
        
    	public void setUpmainPanel()
    	{
       	
            
      	for(int i = 0; i < newArr.size(); i++)
      	{
          	temp.add(newArr.get(i));
      	}
           	for(int i = 0; i < 3; i++)
          	{
               	topPanel.add(getRandomImages(), BorderLayout.CENTER);
         	}
                
                for(int i = 0; i < 3; i++)
          	{
               	bottomPanel.add(getRandomImages(), BorderLayout.CENTER);
         	}
            
                
         	
    	}
    
        
        
        //have this so players can click on the 6 buttons
        public void picToButtons()
        {
                  
            pic1Button.addActionListener(this);
            pic2Button.addActionListener(this);
            pic3Button.addActionListener(this);
            pic4Button.addActionListener(this);
            pic5Button.addActionListener(this);
            pic6Button.addActionListener(this);
        }
        
 
    
    
          
 
//printing all the results                
    public void actionPerformed(ActionEvent e) 
{
    //u can delete this line. I put this line to know which x value I get, so I know which result should be printed :D
    System.out.println(x);
    
    frame.dispose();
    
    /*
        
    //put score/coines/whatever here     
    
    //e.getSource is to determine "if the mouse is clicked here ..."
    if (x == 1)
    {
    
            if(e.getSource()== pic1Button )
            
            //change this!
                System.out.println("worked1"); 
            
            
            else
                //change this!
                System.out.println("failed");
           
    }
    
    
    if (x == 2)
    {
            if(e.getSource()== pic2Button )
            //change this!
                System.out.println("worked2"); 
            
            
            else
                //change this!
                System.out.println("failed");
    }
    
    if (x == 3)
    {
            if(e.getSource()== pic3Button )
            {//change this!
                System.out.println("worked3"); 
            }
            
            else//change this!
                System.out.println("failed");
    }
    
    
    if (x == 4)
    {
            if(e.getSource()== pic4Button )
            {//change this!
                System.out.println("worked4"); 
            }
            
            else//change this!
                System.out.println("failed");
    }
    
    if (x == 5)
    {
            if(e.getSource()== pic5Button )
            {//change this!
                System.out.println("worked5"); 
            }
            
            else//change this!
                System.out.println("failed");
    }
    
    
    if (x == 6)
    {
            if(e.getSource()== pic6Button )
            {//change this!
                System.out.println("worked6"); 
            }
            
            else//change this!
                System.out.println("failed");
    }
                 
        */        
     
}
      
 
          
    
    //set up a button to start the game
    public void setUpButton()
    {
        
        class ButtonListener implements ActionListener
        {
            
            public void actionPerformed ( ActionEvent  e)
            {
                
                if ( button.getText().contains("t"))
                {
                    t.start();
                   
                    //button.setText("Remember where the pieces are!");
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    
 
                    
                    
                }
                
            
                mainPanel.repaint();
                mainPanel.revalidate();
            
            }            
            
                    
 
                
            
        }
        
        ActionListener listener = new ButtonListener();
        button.addActionListener(listener);
    }
    
    //set up a timer
    
    public void setUpTimer()
    {
        class TimerListener implements ActionListener
        {
            public void actionPerformed (ActionEvent event)
            {
                mainPanel.remove(button);
                time++;
                mainPanel.remove( timerLabel);
                timerLabel = new JLabel ( "Timer: " + time, JLabel.SOUTH_EAST);
                
                mainPanel.add(timerLabel, BorderLayout.SOUTH);
                
                if ( time==5 ){
                
                    
                   setUpmainPanel();
                   picToButtons();
                   
                   
                }
                
                  
                
                mainPanel.revalidate();
                mainPanel.repaint();
                
            
                
        }
            }
            
        
        ActionListener listener = new TimerListener();
        final int DELAY = 1000; 
        t = new Timer ( DELAY, listener);
       
    }
    
    
    
    
 
 
    
            public ImageIcon createImageIcon(String path, String description) 
    {         
        java.net.URL imgURL = getClass().getResource(path);         
        if (imgURL != null) 
        {             
            return new ImageIcon(imgURL, description);         
        } else 
        {             
            System.err.println("Couldn't find file: " + path);             
            return null;         
        }     
    }
 
 
 
 
}