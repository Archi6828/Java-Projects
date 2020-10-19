public class Character
{
    private int characterChoice;
    private int questionNumber;
    private Character player;
    private boolean isEndGame;
    private boolean isPuzzleGame;
    private boolean isMemGame;
    private String miniGameText, endMiniGameText;
                
    public Character( int charChoice, int questNum )
    {
        characterChoice = charChoice;
        questionNumber = questNum;
        isEndGame = false;
        isPuzzleGame = false;
        isMemGame = false;
        miniGameText = "";
    }
    
    public int getCharNum()
    {
        return characterChoice;
    }
    
    public int getQuestNum()
    {
        return questionNumber;
    }
    
    public String getQuestion( int quest )
    {
        return "test this question";
    }
    
    public String getOption1( int quest )
    {
        return "test answer 1";
    }
    
    public String getOption2( int quest )
    {
        return "test answer 2";
    }
    
    public int getNextQuestNum( boolean choice1, boolean choice2, int quest )
    {
        return questionNumber++;
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
        return "GAME OVER";
    }
    
    public String getMiniGameScreenText( boolean choice1, boolean choice2, int quest )
    {
        if(choice1)
            miniGameText = "MINIGAME";
        else
            miniGameText = "MINIGAME";
        return miniGameText;
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
            endMiniGameText = "END OF MINIGAME";
        else
            endMiniGameText = "END OF MINIGAME";
        return endMiniGameText;
    }
    
    /*
    //basic one, add to it with super() then add stuff in individual classes
    //override to NOT do anything in Cap
    public void randomEvent( boolean checkRandom )
    {
        if( checkRandom == false )
        {
            
        }
        
        
    }
    */
}