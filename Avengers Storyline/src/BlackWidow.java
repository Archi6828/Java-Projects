public class BlackWidow extends Character
{
    private boolean isEndGame;
    private boolean isPuzzleGame;
    private boolean isMemGame;
    private String miniGameText, endMiniGameText;
    
    public BlackWidow( int charChoice, int questNum )
    {
        super(charChoice, questNum);
    }
    
    public String getQuestion( int quest )
    {
        if( quest == 2 )
            return "Director Fury called you in on your one day off of the month. Do you:";
        else if( quest == 3 )
            return "You find out the villain you are fighting could either be at the theater or the beach. Where do you go?";
        else if( quest == 4 )
            return "Director Fury sends you an angry message about disobeying his orders. What do you do?";
        else if( quest == 5 )
            return "You show up at the theater but can’t find any evidence of villainous activity. What do you do?";
        else if( quest == 6 )
            return "You remember Hawkeye told you he needed new sunglasses. Do you:";
        else if( quest == 7 )
            return "Knowing who your target is, do you call in backup?";
        else if( quest == 8 )
            return "You see Loki. Iron-Man wants to attack, but Captain America wants to plan first. Who do you side with?";
        else if( quest == 9 )
            return "As you attacked, Loki disappeared! Maybe it was a trick the whole time… What do you do now?";
        else if( quest == 10 )
            return "You see someone from a distance who is obviously Loki, disguised as a civilian! What do you do?";
        else if( quest == 11 )
            return "You found Loki! What do you do?";
        else if( quest == 12 )
            return "Now that you’re in position, how do you attack your target?";
        else if( quest == 13 )
            return "Who do you bring with you to look for Loki?";
        else if( quest == 14 )
            return "You see someone from a distance who is obviously Loki, disguised as a civilian! What do you do?";
        else if( quest == 15 )
            return "You see someone from a distance who is obviously Loki, disguised as a civilian! What do you do?";
        else if( quest == 16 )
            return "You see Loki in the distance. What do you do?";
        else if( quest == 17 )
            return "Now that you’re in position, how do you attack your target?";
        else if( quest == 18 )
            return "You see someone from a distance who is obviously Loki, disguised as a civilian! What do you do?";
        else if( quest == 19 )
            return "Loki disappeared! Maybe it was a trick the whole time… What do you do now?";
        else if( quest == 20 )
            return "You see someone from a distance who is obviously Loki, disguised as a civilian! What do you do?";
        else if( quest == 21 )
            return "After hearing your explanation, the officers want to help you catch Loki! What do you do?";
        else if ( quest == 22 )
            return "The person you’re talking to is obviously Loki, disguised as a civilian! What do you do?";
        else
            return "The person you see from a distance is obviously Loki, disguised as a civilian! What do you do?";
        
        
    }
    
    public String getOption1( int quest )
    {
        if(quest==2)
            return "Ignore the call and go to the beach with Hawkeye. Fury wouldn’t mind…";
        else if(quest==3)
            return "Theater";
        else if(quest==4)
            return "Reply and apologize, then read the mission debrief.";
        else if(quest==5)
            return "Continue searching. He’s probably just waiting for the right moment to strike...";
        else if(quest==6)
            return "Stop at a kiosk to buy him a new pair.";
        else if(quest==7)
            return "Yes, call the rest of the Avengers.";
        else if(quest==8)
            return "Iron-Man";
        else if(quest==9)
            return "Contact Director Fury and update him on the current situation.";
        else if(quest==10)
            return "Alert Captain America and wait for the right time to strike.";
        else if(quest==11)
            return "Alert Captain America and wait for the right time to strike.";
        else if(quest==12)
            return "Use your tasers to temporarily paralyze him.";
        else if(quest==13)
            return "Hawkeye";
        else if(quest==15)
            return "Wait for the right time to strike and use the Hulk as a distraction.";
        else if(quest==16)
            return "Stop and plan a sneak attack before approaching him.";
        else if(quest==17)
            return "Use your tasers to temporarily paralyze him.";
        else if(quest==19)
            return "Contact Director Fury and update him on the current situation.";
        else if(quest==21)
            return "Work with the police to ask civilians if they’ve seen him.";
        else
            return "Wait for the right time to strike.";
    }
    
    public String getOption2( int quest )
    {
        if(quest==2)
            return "Go to S.H.I.E.L.D. HQ to get intel for your mission.";
        else if(quest==3)
            return "Beach";
        else if(quest==4)
            return "Turn off your communication device.";
        else if(quest==5)
            return "Leave and go to the beach.";
        else if(quest==6)
            return "Continue on your mission. Hawkeye can get sunglasses on his own time.";
        else if(quest==7)
            return "No, you can handle this on your own.";
        else if(quest==8)
            return "Captain America";
        else if(quest==9)
            return "Ask the Scarlet Witch to use her powers to locate Loki in the crowd.";
        else if(quest==12 || quest==17)
            return "Use a knockout dart to put him to sleep.";
        else if(quest==13)
            return "The Hulk";
        else if(quest==15)
            return "Strike immediately. Point the Hulk in the right direction and let him SMASH.";
        else if(quest==16)
            return "Charge at him with guns blazing.";
        else if(quest==19)
            return "Talk to the police who are now approaching you after pulled your guns on Loki.";
        else if(quest==21)
            return "Work with the police to ask civilians if they’ve seen him.";
        else //if(quest==23)
            return "Strike immediately. Use the high-tech handcuffs Fury gave you to detain him.";
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
            if(quest==11)
                return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            else if(quest==14)
                return "You and Hawkeye out-tricked the trickster! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            else if(quest==15)
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "Loki got away! Director Fury will not be happy... Better luck next time!";
                else
                    return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            }
            else
                return "You out-tricked the trickster! Thor will take his brother back to Asgard as a prisoner."; 
        }
        else //if ( choice2 )
        {
            if(quest==11)
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "Loki got away! Director Fury will not be happy... Better luck next time!";
                else
                    return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            }
            else if(quest==14)
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "Loki got away! Director Fury will not be happy... Better luck next time!";
                else
                    return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            }
            else if(quest==15)
                return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner. Enjoy shawarma with the other Avengers...";
            else
            {
                int random = (int)(Math.random()*10);
                if( random >= 4 )
                    return "Loki got away! Director Fury will not be happy... Better luck next time!";
                else
                    return "You successfully defeated Loki! Thor will take his brother back to Asgard as a prisoner.";
            }
        }
    }
    
    public int getNextQuestNum( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==2)
                return 4;
            else if(quest==3)
                return 5;
            else if(quest==4)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==5)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==6)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==7)
            {
                isPuzzleGame = false;
                return 8;
            }
            else if(quest==8)
                return 9;
            else if(quest==9)
                return 10;
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
                isMemGame = false;
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
                return 17;
            else if(quest==17)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 18;
            }
            else if(quest==18)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==19)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 20;
            }
            else if(quest==20)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==21)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 22;
            }
            else if(quest==22)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==23)
            {
                isEndGame = true;
                return quest;
            }
        }
        else //if(choice2)
        {
            if(quest==2)
                return 3;
            else if(quest==3)
                return 6;
            else if(quest==4)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==5)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==6)
            {
                isPuzzleGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 7;
            }
            else if(quest==7)
            {
                isPuzzleGame = false;
                return 16;
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
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 13;
            }
            else if(quest==13)
            {
                isMemGame = false;
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
                return 19;
            else if(quest==17)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 18;
            }
            else if(quest==18)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==19)
                return 21;
            else if(quest==20)
            {
                isEndGame = true;
                return quest;
            }
            else if(quest==21)
            {
                isMemGame = true;
                miniGameText = getMiniGameScreenText(choice1, choice2, quest);
                endMiniGameText = getEndMiniGameText(choice1, choice2, quest);
                return 23;
            }
            else if(quest==22)
            {
                isEndGame = true;
                return quest;
            }
            else //if(quest==23)
            {
                isEndGame = true;
                return quest;
            }
        }
    }
    
    public String returnMiniGameText()
    {
        return miniGameText;
    }
    
    public String getMiniGameScreenText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==4)
                return "Director Fury sends you an image of your target, but your communication device glitches and the picture is scrambled. Put the image back together to discover who you are chasing!";
            else if(quest==5)
                return "You discover a ripped up picture lying on the floor of the theater. Put it back together to discover who you are chasing!";
            else if(quest==6)
                return "In the mirror, you catch a glimpse of a shady figure. Put the image back together to try to remember what you saw!";
            else if(quest==9)
                return "Fury points you in the right direction. Put the colors back in order to track your target in the crowd!";
            else if(quest==12 || quest==17)
                return "Loki disappeared! Maybe it was a trick the whole time… Put the colors back in order to track your target in the crowd!";
            else if(quest==19)
                return "Fury points you in the right direction. Put the colors back in order to track your target in the crowd!";
            else
                return "Someone you’re talking to seems very suspicious. Analyze the colors by putting them back in order to figure out why!";           
        }
        else
        {
            if(quest==4)
                return "You discover a ripped up picture lying in the sand. Put it back together to discover who you were meant to be chasing!";
            else if(quest==5)
                return "Director Fury sends you an image of your target, but your communication device glitches and the picture is scrambled. Put the image back together to discover who you are chasing!";
            else if(quest==6)
                return "You see a shady figure in the distance. Put the image back together to discover who you are chasing!";
            else if(quest==9)
                return "Help the Scarlet Witch use her powers! Put the colors back in order to locate Loki.";
            else if(quest==12 || quest==17)
                return "Loki disappeared! Maybe it was a trick the whole time… Put the colors back in order to track your target in the crowd!";
            else
                return "Something looks familiar about a civilian you see across the pier. Put the colors back in order to track your target!";
        }
    }
    
    public String returnEndMiniGameText()
    {
        return endMiniGameText;
    }
    
    public String getEndMiniGameText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
        {
            if(quest==4)
                return "You're chasing the Asgardian trickster - Loki!";
            else if(quest==5)
                return "On the back of the picture, there are directions. You follow them and end up at the beach.";
            else if(quest==6)
                return "It's the Asgardian trickster - Loki!";
            else if(quest==9 || quest==12 || quest==17 || quest==19)
                return "You're able to track the signature of Loki's mischief magic.";
            else
                return "This civilian is wearing green and gold and has slick black hair. Hmm...";           
        }
        else
        {
            if(quest==4)
                return "Fury was going to send you after the Asgardian trickster - Loki!";
            else if(quest==5)
                return "You're chasing the Asgardian trickster - Loki!";
            else if(quest==6)
                return "It's the Asgardian trickster - Loki!";
            else if(quest==9 || quest==12 || quest==17)
                return "The Scarlet Witch thinks she found Loki! You go with her to search the area.";
            else
                return "This civilian is wearing green and gold and has slick black hair. Hmm...";
        }
    }    
    
    /*
    public void randomEvent( boolean checkRandom )
    {
        
    }
    */
}