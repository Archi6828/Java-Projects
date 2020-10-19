

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.*;

public class NumberCrush 
{
	private JFrame frame, frame2;
	private JPanel mainPanel, buttonPanel, MAINpanel, timerPanel, titlePanel, buttonsPanel, resultPanel;
	private JLabel timerLabel, titleLabel, resultLabel, scoreLabel;
	private JButton button, button1, button2, button3, button4, button5;
	private int time, score;
	private Timer t;
        private JButton[][] grid;
	private ArrayList<JButton>buttontemp = new ArrayList<JButton>();
	
	public NumberCrush() throws IOException
	{
            
            
            
    	//Set up frame
    	frame = new JFrame();
    	frame.setSize(800,900);
    	frame.setTitle("Number Crush");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	
   	time = 0;
        
    	
    	//set up all panels
    	MAINpanel = new JPanel();
    	MAINpanel.setLayout(new GridLayout(4,2));
    	mainPanel = new JPanel();
    	mainPanel.setLayout(new GridLayout(1,2));
        
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
        
    	setUpTimer();
    	button = new JButton("PLAY");
    	button.setSize(150, 150);
    	setUpButton();
        //CREATE GRID
       
  	
    	//TITLE
    	titleLabel = new JLabel("Number Crush");
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
    	
    	
     	
     	//mainPanel.add(pos5, BorderLayout.NORTH);
        
        //set up mainPanel and initialize first randomized order
      	setUpmainPanel();
       
        
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
        
        
    	public String getRandomNumbers()
    	{
            int random = (int)(Math.random()*4 +1);
            return "" + random;
    	}
    	
    	public void setUpmainPanel()
    	{
            
       
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
                	
            	}
		else if( time == 60 )
		{
                    mainPanel.removeAll();
                    mainPanel = new JPanel();
                    scoreLabel = new JLabel ("Congratulations! Your final Score is " + score + "!");
                    mainPanel.add(scoreLabel);
                    frame2.add(mainPanel);
                    
                    mainPanel.repaint();
                    mainPanel.revalidate();  

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
                    //take out frame1
                    frame.setVisible(false);
                    
                    //create new frame and panel
                    frame2 = new JFrame();
                    

                    //set size
                    
                    frame2.setLayout(new GridLayout(5,5));
                    frame2.setSize(800,800);//set layout of frame
                     t.start();
                    grid=new JButton[4][4]; //allocate the size of grid
                    for(int y=0; y<4; y++)
                    { 
                        for(int x=0; x<4; x++)
                        {
                            grid[x][y]=new JButton(getRandomNumbers()); 
                            buttontemp.add(grid[x][y]);
                            frame2.add(grid[x][y]); //adds button to grid
                        }
                    }
                    frame2.add(timerPanel, BorderLayout.SOUTH);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    frame2.pack(); 
                    frame2.setVisible(true);
                    
                    //setUpSwitchButton();
                   
                    //button.setText("Pause");
                    
                   
             	}
            	else
            	{
               	t.stop();
                	button.setText("PLAY");                    
            	}
                 String a = "";
                String b = "";
                int count = 0;
                JButton temp = buttontemp.get(0);
                JButton temp2 = new JButton();
                 System.out.println(count + " " + temp.getText());
                while(buttontemp.contains((JButton)event.getSource()))
                {
                   // if((buttontemp.get(i).isSelected() && count % 2 != 0) || (buttontemp.get(i).isSelected() && count == 0))
                   if(count == 0 )
                    { 
                       // temp = buttontemp.get(i);
                        temp = (JButton)event.getSource();
                        System.out.println("temp: " + count + " " + temp.getText());
                        temp.setBackground(Color.red);
                        a = temp.getText();
                        count++;
                    }
                
                    else if(temp.equals((JButton)event.getSource()) && temp.getBackground() == Color.red)
                    {
                        count--;
                        a = "";
                    }
                    if(temp.getBackground() == Color.red && !temp.equals((JButton)event.getSource()) && count % 2 != 0)
                    {
                        temp2 = (JButton)event.getSource();
                         temp2.setBackground(Color.red);
                         b = temp.getText();
                         count++;
                    }
                   // else if(buttontemp.get(i).isSelected() && temp2.equals((JButton)event.getSource()) && temp2.getBackground() == Color.red)
                    else if(temp2.equals((JButton)event.getSource()) && temp2.getBackground() == Color.red)
                   {
                        count--;
                        b = "";
                     }
                     if(count % 2 == 0 && temp.getBackground() == Color.red && temp2.getBackground() == Color.red && !a.isEmpty() && !b.isEmpty())
                     {
                         temp.setText(b);
                         temp2.setText(a);
                         return;
                     }
                }
                
                    /*
                    if((button1.isSelected() || button2.isSelected() || button3.isSelected()|| button4.isSelected()) && count % 2 != 0)
                    {
                        temp = (JButton)event.getSource();
                        temp.setBackground(Color.red);
                        a = temp.getText();
                        count++;
                    }
                    else if((button1.isSelected() || button2.isSelected() || button3.isSelected()|| button4.isSelected()) && temp.equals((JButton)event.getSource()) && temp.getBackground() == Color.red)
                    {
                        count--;
                        a = "";
                    }
                     if(temp.getBackground() == Color.red && !temp.equals((JButton)event.getSource()) && count % 2 != 0)
                     {
                         temp2 = (JButton)event.getSource();
                         temp2.setBackground(Color.red);
                         b = temp.getText();
                         count++;
                     }
                      else if((button1.isSelected() || button2.isSelected() || button3.isSelected()|| button4.isSelected()) && temp2.equals((JButton)event.getSource()) && temp2.getBackground() == Color.red)
                     {
                        count--;
                        b = "";
                     }
                     if(count % 2 == 0 && temp.getBackground() == Color.red && temp2.getBackground() == Color.red && !a.isEmpty() && !b.isEmpty())
                     {
                         temp.setText(b);
                         temp2.setText(a);
                     }
                }
              */
                
            	MAINpanel.repaint();
            	MAINpanel.revalidate();
        	}
    	}
    	ActionListener listener = new ButtonListener();
    	button.addActionListener(listener);
        for(int i = 0; i < buttontemp.size(); i++)
        {
            buttontemp.get(i).addActionListener(listener);
        }
	}
//setup switch button

    /**
     *
     */
  	public void setUpSwitchButton()
	{
            
	}
}
          





