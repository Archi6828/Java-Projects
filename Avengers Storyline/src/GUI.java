//Marvel RPG GUI

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI
{
    //RPG variables
    private int characterChoice;
    private boolean randomEventOccured;
    private int questionNumber;
    private Character player;
    private JButton option1, option2, miniGameExit, miniGameEnter, playAgain;
    boolean pick1, pick2;
    
    //GUI construction components
    private JFrame frame;
    private JPanel imagePanelBW, imagePanelSM, imagePanelCA, buttonPanelBW, buttonPanelSM, buttonPanelCA;
    private JPanel mainPanel, titlePanel, characterChoicePanel;
    private JLabel imageLabelBW, imageLabelSM, imageLabelCA, imageLabelSY;
    private JButton buttonBW, buttonSM, buttonCA;
    private ImageIcon imageBW, imageSM, imageCA, symbol;
    private JLabel charChoice;
    
    //Menu bar
    private JMenuBar menuBar;
    private JMenu help;
    private JMenuItem about, howToPlay;
    
    //constructor - creates title page/Question 1 (choose your character)
    public GUI()
    {
        randomEventOccured = false;
        questionNumber = 1;
        
        //frame
        frame = new JFrame();
        frame.setSize( 1000, 900 );
        frame.setTitle("Marvel RPG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        
        //create panels
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        titlePanel = new JPanel();
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setLayout( new GridLayout(2,1) );
        
        //create image icons
        imageBW = createImageIcon( "blackwidow.jpg", "BlackWidow" );
        imageCA = createImageIcon( "captainamerica.jpg", "Cap" );
        imageSM = createImageIcon( "spiderman.jpg", "SpiderMan" );
        symbol = createImageIcon( "symbol.png", "Symbol" );
        //scale
        Image scaleBW = imageBW.getImage().getScaledInstance( 225, 325, 0 );
        imageBW = new ImageIcon( scaleBW );
        Image scaleCA = imageCA.getImage().getScaledInstance( 300, 270, 0 );
        imageCA = new ImageIcon( scaleCA );
        Image scaleSM = imageSM.getImage().getScaledInstance( 270, 320, 0 );
        imageSM = new ImageIcon( scaleSM );
        Image scaleSY = symbol.getImage().getScaledInstance( 150, 150, 0 );
        symbol = new ImageIcon( scaleSY );
        
        //creat image labels
        imageLabelBW = new JLabel("", imageBW, JLabel.CENTER);
        imageLabelCA = new JLabel("", imageCA, JLabel.CENTER);
        imageLabelSM = new JLabel("", imageSM, JLabel.CENTER);
        imageLabelSY = new JLabel("", symbol, JLabel.CENTER);
        
        titlePanel.add(imageLabelSY, BorderLayout.CENTER);
        
        //title on top
        charChoice = new JLabel("Who do you choose?");
        charChoice.setBounds(250,250,250,250);
        charChoice.setForeground(Color.WHITE);
        charChoice.setFont(new Font("Sans_serif", Font.HANGING_BASELINE, 80));
        charChoice.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(charChoice);
        
        
        //Black Widow button
        buttonPanelBW = new JPanel();
        buttonBW = new JButton( "Black Widow" );
        //Cap button
        buttonPanelCA = new JPanel();
        buttonCA = new JButton( "Captain America" );
        //Spidey button
        buttonPanelSM = new JPanel();
        buttonSM = new JButton( "Spider-Man" );
        //set up
        setUpBWButton();
        setUpCAButton();
        setUpSMButton();
        //Add buttons to button panels
        buttonPanelBW.add(buttonBW);
        buttonPanelBW.setBackground(Color.BLACK);
        buttonPanelCA.add(buttonCA);
        buttonPanelCA.setBackground(Color.BLACK);
        buttonPanelSM.add(buttonSM);
        buttonPanelSM.setBackground(Color.BLACK);
        
        
        //construct BW
        imagePanelBW = new JPanel();
        imagePanelBW.add(imageLabelBW);
        imagePanelBW.setBackground(Color.BLACK);
        //construct CA
        imagePanelCA = new JPanel();
        imagePanelCA.add(imageLabelCA);
        imagePanelCA.setBackground(Color.BLACK);
        //construct SM
        imagePanelSM = new JPanel();
        imagePanelSM.add(imageLabelSM);
        imagePanelSM.setBackground(Color.BLACK);
        
        //characterChoicePanel
        characterChoicePanel = new JPanel();
        characterChoicePanel.setLayout( new GridLayout(2,3) );
        characterChoicePanel.add(imagePanelBW);
        characterChoicePanel.add(imagePanelCA);
        characterChoicePanel.add(imagePanelSM);
        characterChoicePanel.add(buttonPanelBW);
        characterChoicePanel.add(buttonPanelCA);
        characterChoicePanel.add(buttonPanelSM);
        characterChoicePanel.setBackground(Color.BLACK);
              
        
        //add title and character choices to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(characterChoicePanel, BorderLayout.CENTER);
        
        setUpMenuBar();
        
        //add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    //sets up the menu bar
    public void setUpMenuBar()
    {
        menuBar = new JMenuBar();
        help = new JMenu( "Help" );
        about = new JMenuItem( "About" );
        setUpAbout();
        howToPlay = new JMenuItem( "How To Play" );
        setUpHowTo();
        help.add(about);
        help.add(howToPlay);
        menuBar.add(help);
        frame.setJMenuBar(menuBar);
    }
    
    //sets up the about section of the menu bar
    public void setUpAbout()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                JFrame aboutFrame = new JFrame();
                aboutFrame.setSize( 500, 200 );
                aboutFrame.setTitle("About - Marvel RPG");
                aboutFrame.setBackground(Color.BLACK);
                
                JPanel aboutPanel = new JPanel();
                aboutPanel.setBackground(Color.BLACK);
                
                JLabel aboutLabel1 = new JLabel("This game was created by Jen Siino, Annie Pang, and");
                aboutLabel1.setForeground(Color.WHITE);
                aboutLabel1.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                aboutPanel.add(aboutLabel1);
                
                JLabel aboutLabel2 = new JLabel("Archita Bathole from Period 1 AP ComputerScience.");
                aboutLabel2.setForeground(Color.WHITE);
                aboutLabel2.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                aboutPanel.add(aboutLabel2);
                
                JLabel aboutLabel3 = new JLabel("The characters featured in this game are owned by Marvel Comics.");
                aboutLabel3.setForeground(Color.WHITE);
                aboutLabel3.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                aboutPanel.add(aboutLabel3);
                
                JLabel aboutLabel4 = new JLabel("Jen wrote the RPG, Archita wrote the memory game,");
                aboutLabel4.setForeground(Color.WHITE);
                aboutLabel4.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                aboutPanel.add(aboutLabel4);
                
                JLabel aboutLabel5 = new JLabel("and  Annie wrote the picture puzzle.");
                aboutLabel5.setForeground(Color.WHITE);
                aboutLabel5.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                aboutPanel.add(aboutLabel5);
                
                aboutFrame.add(aboutPanel);
                aboutFrame.setVisible(true);
            }
        }
        ActionListener listener = new AddButtonListener();
        about.addActionListener(listener);
    }
    
    //sets up the how to play section of the menu bar
    public void setUpHowTo()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                JFrame howFrame = new JFrame();
                howFrame.setSize( 500, 200 );
                howFrame.setTitle("How To Play - Marvel RPG");
                howFrame.setBackground(Color.BLACK);
                
                JPanel howPanel = new JPanel();
                howPanel.setBackground(Color.BLACK);
                
                JLabel aboutLabel1 = new JLabel("Choose your own adventure!");
                aboutLabel1.setForeground(Color.WHITE);
                aboutLabel1.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                howPanel.add(aboutLabel1);
                
                JLabel aboutLabel2 = new JLabel("Pick what choices you want your character to make");
                aboutLabel2.setForeground(Color.WHITE);
                aboutLabel2.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                howPanel.add(aboutLabel2);
                
                JLabel aboutLabel3 = new JLabel("and watch the story unfold. The goal of the game");
                aboutLabel3.setForeground(Color.WHITE);
                aboutLabel3.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                howPanel.add(aboutLabel3);
                
                JLabel aboutLabel4 = new JLabel("is to defeat the villain. If you successfully defeat");
                aboutLabel4.setForeground(Color.WHITE);
                aboutLabel4.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                howPanel.add(aboutLabel4);
                
                JLabel aboutLabel5 = new JLabel("the villain, you win! Otherwise, try again!");
                aboutLabel5.setForeground(Color.WHITE);
                aboutLabel5.setFont(new Font("Sans_serif", Font.PLAIN, 14));
                howPanel.add(aboutLabel5);
                
                howFrame.add(howPanel);
                howFrame.setVisible(true);
            }
        }
        ActionListener listener = new AddButtonListener();
        howToPlay.addActionListener(listener);
    }
    
    //sets up character choice buttons
    private void setUpBWButton()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                characterChoice = 1;
                questionNumber = 2;
                player = new BlackWidow( 1, 2 );
                setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        buttonBW.addActionListener(listener);
    }
    private void setUpCAButton()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                characterChoice = 2;
                questionNumber = 2;
                randomEventOccured = true;
                player = new CaptainAmerica( 2, 2 );
                setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        buttonCA.addActionListener(listener);
    }
    private void setUpSMButton()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                characterChoice = 3;
                questionNumber = 2;
                player = new SpiderMan( 3, 2 );
                setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        buttonSM.addActionListener(listener);
    }
    
    //creates the question screen
    public void setUpQuestionScreen()
    {
        frame.remove(mainPanel);
        mainPanel.removeAll();
        mainPanel.setLayout( new GridLayout(3,1) );

            //set up buttons
        option1 = new JButton( player.getOption1( questionNumber ) );
        option2 = new JButton( player.getOption2( questionNumber ) );
        setUpQuestButton1();
        setUpQuestButton2();
        JPanel optionButtons = new JPanel();
        optionButtons.setBackground(Color.BLACK);
        optionButtons.setLayout( new GridLayout(1,2) );
        optionButtons.add(option1);
        optionButtons.add(option2);

        JPanel qPanel = new JPanel();      
        qPanel.setBackground(Color.BLACK);
        JLabel question = new JLabel( player.getQuestion( questionNumber ) );
        question.setBounds(250,250,250,250);
        question.setForeground(Color.WHITE);
        question.setFont(new Font("Sans_serif", Font.BOLD, 20));
        if(characterChoice != 1)
                question.setFont(new Font("Sans_serif", Font.BOLD, 16));
        question.setHorizontalAlignment(SwingConstants.CENTER);       
        qPanel.add(question, BorderLayout.CENTER);

        mainPanel.add(imageLabelSY, BorderLayout.CENTER);
        mainPanel.add(qPanel, BorderLayout.NORTH);
        mainPanel.add(optionButtons);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    //creates the answer choice buttons
    private void setUpQuestButton1()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                pick1 = true;
                pick2 = false;
                int currentQ = questionNumber;
                questionNumber = player.getNextQuestNum( pick1, pick2, currentQ );
                
                if(player.isFinalScreen())
                    displayGameOver();
                else if(player.isMiniGameMem())
                {
                    setUpMiniGameMem();
                }
                else if(player.isMiniGamePuz())
                {    
                    setUpMiniGamePuz();
                }
                else
                    setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        option1.addActionListener(listener);
    }
    private void setUpQuestButton2()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                pick2 = true;
                pick1 = false;
                int currentQ = questionNumber;
                questionNumber = player.getNextQuestNum( pick1, pick2, currentQ );
                
                if(player.isFinalScreen())
                    displayGameOver();
                else if(player.isMiniGameMem())
                {
                    setUpMiniGameMem();
                }
                else if(player.isMiniGamePuz())
                {    
                    setUpMiniGamePuz();
                }
                else
                    setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        option2.addActionListener(listener);
    }
    
    //set up mini-game pages
    public void setUpMiniGameMem()
    {
        String miniGameText = player.returnMiniGameText();
                
        frame.remove(mainPanel);
        mainPanel.removeAll();
        
        JLabel miniGameLabel = new JLabel( miniGameText );
        miniGameLabel.setBounds(250,250,250,250);
        miniGameLabel.setForeground(Color.WHITE);
        miniGameLabel.setFont(new Font("Sans_serif", Font.BOLD, 12));
        miniGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        miniGameEnter = new JButton("Play Game");
        setUpPlayGameButton();
                
        mainPanel.add(imageLabelSY, BorderLayout.CENTER);
        mainPanel.add(miniGameLabel, BorderLayout.CENTER);
        
        mainPanel.add(miniGameEnter);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void setUpMiniGamePuz()
    {
        String miniGameText = player.returnMiniGameText();
                
        frame.remove(mainPanel);
        mainPanel.removeAll();
        
        JLabel miniGameLabel = new JLabel( miniGameText );
        miniGameLabel.setBounds(250,250,250,250);
        miniGameLabel.setForeground(Color.WHITE);
        miniGameLabel.setFont(new Font("Sans_serif", Font.BOLD, 12));
        miniGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        miniGameEnter = new JButton("Play Game");
        setUpPlayGameButton();
                
        mainPanel.add(imageLabelSY, BorderLayout.CENTER);
        mainPanel.add(miniGameLabel, BorderLayout.CENTER);
        
        mainPanel.add(miniGameEnter);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    //set up post-mini-game screen that tells you to return to the story
    public void returnToStoryScreen()
    {
        String endMiniGameText = player.returnEndMiniGameText();
                
        frame.remove(mainPanel);
        mainPanel.removeAll();
        
        JLabel endMiniGameLabel = new JLabel( endMiniGameText );
        endMiniGameLabel.setBounds(250,250,250,250);
        endMiniGameLabel.setForeground(Color.WHITE);
        endMiniGameLabel.setFont(new Font("Sans_serif", Font.BOLD, 12));
        endMiniGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        miniGameExit = new JButton("Return to Story");
        setUpMiniGameExitButton();
                        
        mainPanel.add(imageLabelSY, BorderLayout.CENTER);
        mainPanel.add(endMiniGameLabel, BorderLayout.CENTER);
        
        mainPanel.add(miniGameExit);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    //sets up play mini-game button to open mini-game
    public void setUpPlayGameButton()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                Memory newMem;
                
                //sets up picture mini-game if necessary
                if(player.isMiniGamePuz())
                {
                    PuzRS redSkull;
                    PuzGG greenGob;
                    PuzLK loki;
                    if(characterChoice==1) //-> BW
                    {
                        loki = new PuzLK();
                    }
                    else if(characterChoice==2) //-> CA
                    {
                        redSkull = new PuzRS();
                    }
                    else //if(characterChoice==3) -> SM
                    {
                        greenGob = new PuzGG();
                    }
                }
                //sets up memory mini-game if necessary
                if(player.isMiniGameMem())
                  newMem = new Memory();
                //sets up return to story screen after
                returnToStoryScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        miniGameEnter.addActionListener(listener);
    }
    //sets up post-mini-game screen return to story button
    public void setUpMiniGameExitButton()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                setUpQuestionScreen();
            }
        }
        ActionListener listener = new AddButtonListener();
        miniGameExit.addActionListener(listener);
    }
    
    //ending screen
    public void displayGameOver()
    {
        String gameOverText = player.getFinalScreenText(pick1, pick2, questionNumber);
        
        frame.remove(mainPanel);
        mainPanel.removeAll();
        mainPanel.setLayout( new GridLayout(3,1) );
        
        JLabel endText = new JLabel( gameOverText );
        endText.setBounds(250,250,250,250);
        endText.setForeground(Color.WHITE);
        endText.setFont(new Font("Sans_serif", Font.BOLD, 17));
        endText.setHorizontalAlignment(SwingConstants.CENTER);
        
        playAgain = new JButton( "Play Again" );
        setUpPlayAgain();
        
        mainPanel.add(imageLabelSY, BorderLayout.CENTER);
        mainPanel.add(endText, BorderLayout.CENTER);
        mainPanel.add(endText);
        mainPanel.add(playAgain);
        
        frame.add(mainPanel);
        frame.setVisible(true);
        
        //if adding a picture, remember to change the grid layout
    }
    //creates play again button
    public void setUpPlayAgain()
    {
        class AddButtonListener implements ActionListener
        {
            public void actionPerformed( ActionEvent event )
            {
                frame.dispose();
                GUI newGame = new GUI();
            }
        }
        ActionListener listener = new AddButtonListener();
        playAgain.addActionListener(listener);
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
    
}