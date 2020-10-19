//WITH CHARACTER COLORS
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

public class Memory
{
	private JFrame frame;
	private JPanel mainPanel, image1Panel, image2Panel, image3Panel, image4Panel, image5Panel, buttonPanel, MAINpanel, timerPanel, titlePanel, buttonsPanel, resultPanel;
	private JLabel timerLabel, image1Label, image2Label, image3Label, image4Label, image5Label, imageLabel, titleLabel, resultLabel;
	private JButton button, button1, button2, button3, button4, button5;
	private int time;
	private ImageIcon image1, image2, image3, image4, image5, image;
	private Timer t;
	private ArrayList<JPanel> positions = new ArrayList<JPanel>();
	private ArrayList<JPanel>temp = new ArrayList<JPanel>();
	private ArrayList<JButton>buttontemp = new ArrayList<JButton>();
        private ArrayList<JPanel>randomized1Order = new ArrayList<JPanel>();
        private ArrayList<JPanel>randomized2Order = new ArrayList<JPanel>();
    	
	
	public Memory()
	{
            
            
            
    	//Set up frame
    	frame = new JFrame();
    	frame.setSize(1000,900);
    	frame.setTitle("Timer Example");
    	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   	time = 0;
    	
    	//set up all panels
    	MAINpanel = new JPanel();
    	MAINpanel.setLayout(new GridLayout(4,2));
    	mainPanel = new JPanel();
    	mainPanel.setLayout(new GridLayout(1,2));
    	image1Panel = new JPanel();
    	image1Panel.setLayout(new GridLayout());
    	image2Panel = new JPanel();
    	image2Panel.setLayout(new GridLayout());
   	image3Panel = new JPanel();
    	image3Panel.setLayout(new GridLayout());
    	image4Panel = new JPanel();
    	image4Panel.setLayout(new GridLayout());
    	image5Panel = new JPanel();
    	image5Panel.setLayout(new GridLayout());
    	buttonPanel = new JPanel();
    	buttonPanel.setLayout(new GridLayout());
    	timerPanel = new JPanel();
    	timerPanel.setLayout(new GridLayout());
    	titlePanel = new JPanel();
    	titlePanel.setLayout(new GridLayout());
    	titlePanel.setBackground(Color.DARK_GRAY);
    	timerPanel.setBackground(Color.DARK_GRAY);
    	buttonPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBackground(Color.DARK_GRAY);
     	buttonsPanel = new JPanel();
    	buttonsPanel.setLayout(new GridLayout());
    	resultPanel = new JPanel();
    	resultPanel.setLayout(new GridLayout());
        
        //identify character
       // colorChoices(());
        
    	// set up colors
  	//image 1
    	image1 = createImageIcon("dark red.png", "dark red");
    	Image scale = image1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
    	image1 = new ImageIcon(scale);
    	image1Label = new JLabel("", image1, JLabel.CENTER);
   	
    	//image 2
   	image2 = createImageIcon("dark green.jpg", "dark green");
    	Image scale1 = image2.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
    	image2 = new ImageIcon(scale1);
    	image2Label = new JLabel("", image2, JLabel.CENTER);
    	//image 3
    	image3 = createImageIcon("dark purple.jpg", "dark purple");
  	Image scale2 = image3.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
    	image3 = new ImageIcon(scale2);
    	image3Label = new JLabel("", image3, JLabel.CENTER);
     	
    	//image 4
   	image4 = createImageIcon("drak blue.jpg", "dark blue");
    	Image scale3 = image4.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
    	image4 = new ImageIcon(scale3);
    	image4Label = new JLabel("", image4, JLabel.CENTER);
    	//image 5
    	image5 = createImageIcon("silver.jpg", "silver");
    	Image scale4 = image5.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
    	image5 = new ImageIcon(scale4);
    	image5Label = new JLabel("", image5, JLabel.CENTER);
    	
    	setUpTimer();
    	button = new JButton("PLAY");
    	button.setSize(150, 150);
    	setUpButton();
    	//switch buttons
  	button1 = new JButton("PICK");
  	button2 = new JButton("PICK");
  	button3 = new JButton("PICK");
  	button4 = new JButton("PICK");
  	button5 = new JButton("PICK");
	
       	buttonsPanel.add(button1, BorderLayout.CENTER );
        buttonsPanel.add(button2, BorderLayout.CENTER);
        buttonsPanel.add(button3, BorderLayout.CENTER);
        buttonsPanel.add(button4, BorderLayout.CENTER );
        buttonsPanel.add(button5, BorderLayout.CENTER);
                	
  	for(int i = 0; i < 5; i++)
  	{
       	buttontemp.add((JButton) buttonsPanel.getComponent(i));
  	}
  	
    	//TITLE
    	titleLabel = new JLabel("MEMORY GAME");
    	titleLabel.setBounds(250,250,250,250);
    	titleLabel.setForeground(Color.CYAN);
    	titleLabel.setFont(new Font("Sans_serif",  Font.HANGING_BASELINE, 100));
    	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	titlePanel.add(titleLabel, BorderLayout.CENTER);
  	MAINpanel.add(titlePanel, SwingConstants.CENTER);
   	
  	//TIMER
   	timerLabel = new JLabel("Timer: " + time);
    	timerLabel.setBounds(250,250,250,250);
   	timerLabel.setForeground(Color.LIGHT_GRAY);
    	timerLabel.setFont(new Font("Sans_serif",  Font.HANGING_BASELINE, 50));
    	timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	timerPanel.add(timerLabel, BorderLayout.CENTER);
    	MAINpanel.add(timerPanel, BorderLayout.CENTER);
    	
    	//adding images to panles and main panel
    	image1Panel.add(image1Label, BorderLayout.CENTER);
    	image2Panel.add(image2Label, BorderLayout.CENTER);
    	image3Panel.add(image3Label, BorderLayout.CENTER);
    	image4Panel.add(image4Label, BorderLayout.CENTER);
    	image5Panel.add(image5Label, BorderLayout.CENTER);
    	
    	//imagepanel, timerpanel, and buttonpanel to main panel
   	JPanel pos1 = image1Panel;
    	positions.add(pos1);
	//	mainPanel.add(pos1, BorderLayout.EAST);
     	JPanel pos2 = image2Panel;
     	positions.add(pos2);
	//	mainPanel.add(pos2, BorderLayout.WEST);
     	JPanel pos3 = image3Panel;
     	positions.add(pos3);
     	//mainPanel.add(pos3, BorderLayout.CENTER);
     	JPanel pos4 = image4Panel;
     	positions.add(pos4);
     	//mainPanel.add(pos4, BorderLayout.SOUTH);
      	JPanel pos5 = image5Panel;
     	positions.add(pos5);
     	
     	//mainPanel.add(pos5, BorderLayout.NORTH);
        
        //set up mainPanel and initialize first randomized order
      	setUpmainPanel();
       	randomized1Order = setUprandomOrderList();
        
   	MAINpanel.add(mainPanel, BorderLayout.CENTER);
   	buttonPanel.setBounds(50, 100, 70, 20);
    	buttonPanel.add(button, BorderLayout.CENTER);
    	MAINpanel.add(buttonPanel, BorderLayout.SOUTH);
    	MAINpanel.setForeground(Color.yellow);
    	MAINpanel.setOpaque(true);
    
    	//frame.setForeground(Color.MAGENTA);
    	frame.add(MAINpanel);
    	frame.setBackground(new Color(53, 56, 64));
    	frame.setVisible(true);
	}
        
    	public JPanel getRandomImages()
    	{
        	int random;
        	JPanel posRandom = temp.get(0);
        	
                    	random = (int)(Math.random() * temp.size());
                    	posRandom = temp.get(random);
                    	temp.remove(random);
                    	
        	return posRandom;
    	}
    	
    	public void setUpmainPanel()
    	{
       	//add images from positions to temp
      	for(int i = 0; i < positions.size(); i++)
      	{
          	temp.add(positions.get(i));
      	}
          	for(int i = 0; i < 5; i++)
          	{
               	mainPanel.add(getRandomImages(), BorderLayout.CENTER);
          	}
    	}
        
        public ArrayList<JPanel> setUprandomOrderList()
        {
           ArrayList<JPanel>randomizedOrder = new ArrayList<JPanel>();
           
            for(int i = 0; i < 5; i++)
          {
            randomizedOrder.add((JPanel) mainPanel.getComponent(i));
          }
            return randomizedOrder;
        }
        
        
	// Setting up timer before scrambleing colors
	public void setUpTimer()
	{
    	class TimerListener implements ActionListener
    	{
        	public void actionPerformed(ActionEvent event)
       	{
            	time++;
          	timerPanel.remove(timerLabel);
          	
            	timerLabel = new JLabel("Timer: " + time, JLabel.CENTER);
           	
             	timerLabel.setBounds(250,250,250,250);
             	timerLabel.setForeground(Color.LIGHT_GRAY);
             	timerLabel.setFont(new Font("Sans_serif",  Font.HANGING_BASELINE, 50));
             	timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
             	timerPanel.add(timerLabel, BorderLayout.CENTER);
             	MAINpanel.add(timerPanel, BorderLayout.NORTH);
            	if(time == 1)
            	{
                	setUpmainPanel();
                        randomized2Order = setUprandomOrderList();
                        
                        //DELETE later: check to c if randomlists r diff
                        if(randomized1Order.equals(randomized2Order))
                            System.out.println("SAME");
                        else
                            System.out.println("DIFFERENT");
            	}
             	MAINpanel.repaint();
            	MAINpanel.revalidate();
        	}
    	}
    	ActionListener listener = new TimerListener();
    	final int DELAY = 1000;
    	t = new Timer(DELAY, listener);
	}
	
	// click on colors to put in order
	public void setUpButton()
	{
   	class ButtonListener implements ActionListener
   	{
        	public void actionPerformed(ActionEvent event)
        	{
            	if(button.getText().equals("PLAY"))
            	{
                	
               	MAINpanel.remove(buttonPanel);
               	MAINpanel.add(buttonsPanel, BorderLayout.CENTER);
               	setUpSwitchButton();
               
                	
                	t.start();
                	button.setText("Pause");
             	}
            	else
            	{
               	t.stop();
                	button.setText("PLAY");
            	}
            	MAINpanel.repaint();
            	MAINpanel.revalidate();
        	}
    	}
    	ActionListener listener = new ButtonListener();
    	button.addActionListener(listener);
	}
//setup switch button
  	public void setUpSwitchButton()
	{
            ArrayList<Integer>temporder = new ArrayList<Integer>();
            ArrayList<JPanel>sorted = new ArrayList<JPanel>();
           
    	class ButtonListener implements ActionListener
   	{
            int count = 0, one =0;
            JButton firstButton;
            
                // first Button
        	public void actionPerformed(ActionEvent event)
        	{  
        	firstButton = (JButton)event.getSource();
               
               	if(firstButton.getText().equals("PICK"))
                {
                    count++;
                   firstButton.setText("CHOSEN");
                   one = buttontemp.indexOf(firstButton);
                   System.out.println(buttontemp.indexOf(firstButton) + " " + count + " " + one);
                }
                else
                {
                    firstButton.setText("PICK");
                    count--;
                }
                //add the order picked into temporder arraylist
                temporder.add(buttontemp.indexOf(firstButton));
                System.out.println(temporder);
                
                if(count >= 5)
                {
                    MAINpanel.remove(buttonsPanel);
                    MAINpanel.remove(timerPanel);
                    MAINpanel.setLayout(new GridLayout(3,4));
                    t.stop();
                    isCorrect();
                }
                
                MAINpanel.repaint();
            	MAINpanel.revalidate();
                }
                
                public ArrayList<JPanel> chosenOrder()
                {
                    //add the JPanels in chosen order into sorted 
                for(int i = 0; i < 5; i++)
                {
                    sorted.add(randomized2Order.get(temporder.get(i)));
                }
                
                return sorted;
                }
               
        	public void isCorrect()
                {   
                //check if order is correct
                boolean flag;
                if(chosenOrder().equals(randomized1Order))
                    flag = true;
                else 
                    flag = false;
                System.out.println(flag);
                
                if(flag == true)
                {
                    resultLabel = new JLabel("YOU GOT IT!");
                }
                else
                {
                     resultLabel = new JLabel("YOU LOSE!");
                }
                
                //set up of result panel
                resultLabel.setBounds(250,250,250,250);
                    resultLabel.setForeground(Color.CYAN);
                    resultLabel.setFont(new Font("Sans_serif",  Font.HANGING_BASELINE, 100));
                    resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    resultPanel.add(resultLabel, BorderLayout.CENTER);
                    resultPanel.setBackground(Color.DARK_GRAY);
                    MAINpanel.add(resultPanel, SwingConstants.CENTER);
                    
                }
             	
    	}
    	ActionListener listener = new ButtonListener();
    	button1.addActionListener(listener);
     	button2.addActionListener(listener);
      	button3.addActionListener(listener);
       	button4.addActionListener(listener);
        	button5.addActionListener(listener);
	}	
          
//COLORS BASED ON CHARECTERS
 /*
   public void colorChoices()
   {
    //Spider-Man
    if(charChoice == 3)
    {
        image1 = createImageIcon("dark green.jpg", "dark green");
        image2 = createImageIcon("light green.jpg", "light green");
        image3 = createImageIcon("dark purple.jpg", "dark purple");
        image4 = createImageIcon("light purple.png", "light purple");
        image5 = createImageIcon("bronze.png", "bronze");
    }
    if(charChoice == 2)
    {
        image1 = createImageIcon("silver.jpg", "silver");
        image2 = createImageIcon("light red.jpg", "light red");
        image3 = createImageIcon("red.jpg", "red");
        image4 = createImageIcon("black.jpg", "black");
        image5 = createImageIcon("dark red.png", "dark red");
    }
    if(charChoice == 1)
    {
        image1 = createImageIcon("dark green.jpg", "dark green");
        image2 = createImageIcon("light green.jpg", "light green");
        image3 = createImageIcon("black.jpg", "black");
        image4 = createImageIcon("light blue.jpg", "light blue");
        image5 = createImageIcon("gold.jpg", "gold");
    }
   }*/
    	
public ImageIcon createImageIcon(String path,  String description) {
    	java.net.URL imgURL = getClass().getResource(path);
   	if (imgURL != null) {  	
       	return new ImageIcon(imgURL, description);
    	}
   	else {
        	System.err.println("Couldn't find file: " + path);
        	return null;	
    	}
}
}