public class CaptainAmerica extends Character
{
    private boolean isEndGame;
    private boolean isPuzzleGame;
    private boolean isMemGame;
    public String miniGameText;
    public String endMiniGameText;
    
    public CaptainAmerica( int charChoice, int questNum )
    {
        super(charChoice, questNum);
    }
    
    public String getQuestion( int quest )
    {
        if(quest==2)
            return "You’ve been working on strategy for attacking Hydra outposts all day. What do you do next?";
        else if(quest==3)
            return "What do you do with your newfound evidence of Red Skull’s location?";
        else if(quest==4)
            return "You and Peggy formulate a plan to go after Red Skull, but Colonel Phillips doesn’t approve. What do you do?";
        else if(quest==5 || quest==13)
            return "The following day, the Colonel sends you and the Howling Commandos to break into a Hydra base. What do you do?";
        else if(quest==8)
            return "The coordinates take you to an island with a heavily guarded Hydra compound. What do you do?";
        else if(quest==9 || quest==17)
            return "The soldiers take you to Red Skull. What do you do?";
        else if(quest==10 || quest==18)
            return "Peggy and the Howling Commandos storm the compound! The battle is won and Red Skull has been defeated. What do you do?";
        else if(quest==12)
            return "Colonel Phillips orders you to stay on the military base and focus on the original battle strategy, as planned. What do you do?";
        else if(quest==14 || quest==15 || quest==6 || quest==7)
            return "You find the Tesseract, the source of Hydra’s power, but no Red Skull. What do you do?";
        else if(quest==16)
            return "The coordinates take you to an island with a heavily guarded Hydra compound. What do you do?";
        else
            return "You’ve defeated Red Skull but you hear reinforcements coming down the hall to take you out. What do you do?";
    }
    
    public String getOption1( int quest )
    {
        if(quest==2)
            return "Go to the bar and spend time with Bucky and the other Howling Commandos.";
        else if(quest==3)
            return "Take it to Agent Peggy Carter.";
        else if(quest==4)
            return "Follow the Colonel’s orders and stay on the military base.";
        else if(quest==5 || quest==13)
            return "Use explosives to blow a hole in the wall.";
        else if(quest==6 || quest==14)
            return "Take the Tesseract and immediately fight your way back out of the base.";
        else if(quest==7 || quest==15)
            return "Take the Tesseract and immediately sneak back out of the base.";
        else if(quest==8 || quest==16)
            return "Try to sneak in.";
        else if(quest==9 || quest==17)
            return "Call for backup and wait to strike.";
        else if(quest==10 || quest==18)
            return "Search for the Tesseract, the source of Hydra’s power.";
        else if(quest==12)
            return "Follow the Colonel’s orders and stay on the base.";
        else
            return "Leave immediately.";
    }
    
    public String getOption2( int quest )
    {
        if(quest==2)
            return "Go back to the barracks and go to sleep.";
        else if(quest==3)
            return "Take it to Colonel Phillips.";
        else if(quest==4 || quest==12)
            return "Convince Howard Stark to fly you to the coordinates.";
        else if(quest==5 || quest==13)
            return "Try to sneak in.";
        else if(quest==6 || quest==7 || quest==14 || quest==15)
            return "Take the Tesseract and continue searching the base.";
        else if(quest==8 || quest==16)
            return "Try to fight your way in.";
        else if(quest==9)
            return "Attack the Hydra soldiers immediately, then go for Red Skull..";
        else if(quest==10 || quest==18)
            return "Leave before Hydra reinforcements show up to take you out.";
        else if(quest==11)
            return "Search the room for the Tesseract, the source of Hydra’s power, before you leave.";
        else if(quest==17)
            return "Attack the Hydra soldiers immediately, then go for Red Skull.";
        else //if(quest==19)
            return "Search the room for the Tesseract, the source of Hydra’s power, before you leave.";
    }
    
    public boolean isMiniGameMem()
    {
        return isMemGame;
    }
    public boolean isMiniGamePuz()
    {
        return isPuzzleGame;
    }
    
    public boolean isFinalScreen()
    {
        return isEndGame;
    }
    
    public String getFinalScreenText( boolean choice1, boolean choice2, int quest )
    {
        if( choice1 )
        {
            if( quest==6 || quest==7 || quest==14 || quest==15 )
                return "You and your team get out safely with the Tesseract.";
            else if(quest==10 || quest==18)
                return "You don’t find the Tesseract but you take some Hydra tech and classified documents on your way out of the compound.";
            else //if(quest==11 || quest==19)
                return "You and your team get out safely.";
        }
        else //if ( choice2 )
        {
            if(quest==6 || quest==14)
                return "You manage to get out with some Hydra tech and plans, but lost the Tesseract in the fight.";
            else if(quest==7 || quest==15)
                return "You and your team get out safely with Hydra tech, the Tesseract, and some of their classified documents.";
            else if(quest==10 || quest==18)
                return "You and your team get out safely.";
            else //if(quest==11 || quest==19)
                return "You don’t find the Tesseract but you take some Hydra tech and classified documents on your way out of the compound.";
        }
    }
        
    public int getNextQuestNum( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==2)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 3;
            }
            else if(quest==3)
            {
                isPuzzleGame = false;
                return 4;
            }
            else if(quest==4)
                return 5;
            else if(quest==5)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 6;
            }
            else if(quest==6)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==7)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==8)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 9;
            }
            else if(quest==9)
            {
                isMemGame = false;
                return 10;
            }
            else if(quest==10)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==11)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==12)
                return 13;
            else if(quest==13)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 14;
            }
            else if(quest==14)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==15)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==16)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 17;
            }
            else if(quest==17)
            {
                isMemGame = false;
                return 18;
            }
            else if(quest==18)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==19)
            {
                isEndGame = true;
                return quest;
            }
        }
        else //if(choice2)
        {
            if(quest==2)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 3;
            }
            else if(quest==3)
            {
                isPuzzleGame = false;
                return 12;
            }
            else if(quest==4)
                return 8;
            else if(quest==5)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==6)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==7)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==8)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 9;
            }
            else if(quest==9)
            {
                isMemGame = false;
                return 11;
            }
            else if(quest==10)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==11)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==12)
                return 16;
            else if(quest==13)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 15;
            }
            else if(quest==14)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==15)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==16)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 17;
            }
            else if(quest==17)
            {
                isMemGame = false;
                return 19;
            }
            else if(quest==18)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==19)
            {
                isEndGame = true;
                return quest;
            }
        }
    }
    
    
    public String getMiniGameScreenText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==2)
                return "Someone in the bar slips you a note. Put the image back together to analyze the clue!";
            else if(quest==8 || quest==16)
                return "You get captured by Hydra soldiers! Put the colors back in order to memorize the route they take you through the compound!";
            else
                return "Hydra soldiers are attacking! Put the colors back in order to find your way through the castle in the chaos!";         
        }
        else
        {
            if(quest==2)
                return "You find a ripped up photo lying on the floor. Put the image back together to analyze the clue!";
            else if(quest==5 || quest==13)
                return "Put the colors back in order to sneak around the castle and avoid Hydra soldiers.";
            else
                return "You get captured by Hydra soldiers! Put the colors back in order to memorize the route they take you through the compound!"; 
        }
    }
    
    public String returnMiniGameText()
    {
        return miniGameText;
    }
    
    public String returnEndMiniGameText()
    {
        return endMiniGameText;
    }
    
    public String getEndMiniGameText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==2)
                return "The back of the note has coordinates written on it.";
            else if(quest==8 || quest==16)
                return "You successfully memorized the layout.";
            else
                return "You end up in a lab for manufacturing weapons.";         
        }
        else
        {
            if(quest==2)
                return "The back of the photo has coordinates written on it.";
            else if(quest==5 || quest==13)
                return "You end up in a lab for manufacturing weapons.";
            else
                return "You successfully memorized the layout."; 
        }
    }
    
    
    /*
    public void randomEvent( boolean checkRandom )
    {
        return;
    }
    */
    
}