public class SpiderMan extends Character
{
            
    private boolean isEndGame;
    private boolean isPuzzleGame;
    private boolean isMemGame;
    private String miniGameText, endMiniGameText;
    
    public SpiderMan( int charChoice, int questNum )
    {
        super(charChoice, questNum);
    }
    
    public String getQuestion( int quest )
    {
        if(quest==2)
            return "At school, you hear rumors of something strange occurring in Central Park. What do you do?";
        else if(quest==3)
            return "Tony Stark texts you to tell you to stay at school and claims he’ll handle the situation. What do you do?";
        else if(quest==4)
            return "Where do you go to investigate the rumors?";
        else if(quest==5)
            return "Knowing that the Green Goblin is attacking Central Park, what do you do?";
        else if(quest==6)
            return "You hear screams down the hall. Now the school is being attacked by the Green Goblin! What do you do?";
        else if(quest==8)
            return "On your way to Central Park, you remember that you skipped breakfast. What do you do?";
        else if(quest==9)
            return "You find the Green Goblin terrorizing citizens in the Park. What do you do?";
        else if(quest==12)
            return "While you’re stopping for a snack, your Spidey Sense starts tingling. What do you do?";
        else if(quest==14)
            return "One of the Green Goblin’s bombs destroyed the snack cart! What do you do?";
        else
            return "Now that the Green Goblin is trapped in webbing, what do you do?";
    }
    
    public String getOption1( int quest )
    {
        if(quest==2)
            return "Go to class, as usual.";
        else if(quest==3)
            return "Text back and ask what’s going on.";
        else if(quest==4)
            return "The Library";
        else if(quest==5)
            return "Stay at school, let the adult heroes handle it. You have a chem test!";
        else if(quest==6)
            return "Mutter angrily about the adult heroes and run to change into your supersuit.";
        else if(quest==8)
            return "Continue on your way and ignore how hungry you are.";
        else if(quest==9)
            return "Get his attention by yelling clever quips at him.";
        else if(quest==7 || quest==10 || quest==11 || quest==13 || quest==15 || quest==16)
            return "Stay and wait for S.H.I.E.L.D. to arrive to pick him up.";
        else if(quest==12)
            return "Spin around immediately.";
        else //if(quest==14)
            return "Shout back an apology as you swing away to fight the Green Goblin.";
    }
    
    public String getOption2( int quest )
    {
        if(quest==2)
            return "Ditch class to investigate the rumors.";
        else if(quest==3)
            return "Mute your phone and go to class.";
        else if(quest==4)
            return "The Computer Lab";
        else if(quest==5)
            return "Leave school and head to Central Park.";
        else if(quest==6)
            return "Pause to take pictures that you can sell to \"The Daily Bugle.\"";
        else if(quest==7)
            return "Leave school and go out for celebratory pancakes.";
        else if(quest==8)
            return "Stop at a snack cart to pick up some food. Can't fight on an empty stomach...";
        else if(quest==9)
            return "Sneak up on him to web him up from behind and detain him.";
        else if(quest==10 || quest==11)
            return "Leave Central Park and go out for celebratory pancakes.";
        else if(quest==12)
            return "Finish paying for your food.";
        else if(quest==13 || quest==15 || quest==16)
            return "Leave Central Park and return to school.";
        else //if(quest==14)
            return "Take out your wallet and give the owner some cash before fighting.";
    }
    
    public int getNextQuestNum( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==2)
                return 3;
            else if(quest==3)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 5;
            }
            else if(quest==4)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 5;
            }
            else if(quest==5)
            {
                isPuzzleGame = false;
                return 6;
            }
            else if(quest==6)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==7)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==8)
                return 9;
            else if(quest==9)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
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
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 13;
            }
            else if(quest==13)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==14)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 15;
            }
            else if(quest==15)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==16)
            {
                isEndGame = true;
                return quest;
            }
        }
        else //if(choice2)
        {
            if(quest==2)
                return 4;
            else if(quest==3)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 5;
            }
            else if(quest==4)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 5;
            }
            else if(quest==5)
            {
                isPuzzleGame = false;
                return 8;
            }
            else if(quest==6)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==7)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==8)
                return 12;
            else if(quest==9)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
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
                return 14;
            else if(quest==13)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==14)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 16;
            }
            else if(quest==15)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==16)
            {
                isEndGame = true;
                return quest;
            }
        }
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
            return "S.H.I.E.L.D. picks up the Green Goblin and you return to class. Fury looks pleased.";
        }
        else //if ( choice2 )
        {
            if(quest==7 || quest==10 || quest==11)
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "You enjoy your pancakes before returning to school and passing your chem test.";
                else
                    return "DEADPOOL shows up and crashes your pancake party! Good luck with that...";
            }
            else
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "You return to school and pass your chem test.";
                else
                    return "You arrive at school and see on the news that the Goblin escaped! Better luck next time...";
            }
        }
    }
    
    public String getMiniGameScreenText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==3)
                return "Mr. Stark sends you a picture, but you recently broke your phone so the message glitches. Put the image back together to discover what’s happening in Central Park!";
            else if(quest==4)
                return "You’re scrolling through social media to find a report of the situation, but your phone freezes and the image is scattered! Put it back together to discover what's going on!";
            else if(quest==6 || quest==9 || quest==14)
                return "Put the colors back in order to defend yourself against the Green Goblin and yell insults at him!";
            else
                return "The Green Goblin spotted you! Put the colors back in order to dodge the Pumpkin Bombs he’s throwing your way and fight back!";         
        }
        else
        {
            if(quest==3)
                return "From across the classroom, you hear people whispering about the situation in Central Park. You catch a quick glimpse of an image on someone’s phone screen a few seats in front of you. Put it back together to discover what’s happening in Central Park!";
            else if(quest==4)
                return "You’re trying to watch a live feed of the situation in Central Park, but the image is scattered because of the poor-quality campus Wi-Fi! Put the image back together to figure out what’s going on!";
            else if(quest==6 || quest==14)
                return "Put the colors back in order to defend yourself against the Green Goblin and yell insults at him!";
            else
                return "Put the colors back in order to sneak up on the Green Goblin without being seen!"; 
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
            if(quest==3 || quest==4)
                return "The Green Goblin is attacking!";
            else
                return "You defeat the Green Goblin!";     
        }
        else
        {
            if(quest==3 || quest==4)
                return "The Green Goblin is attacking!";
            else
                return "You defeat the Green Goblin!";
        }
    }
    
    /*
    public void randomEvent( boolean checkRandom )
    {
        
    }
    */
}