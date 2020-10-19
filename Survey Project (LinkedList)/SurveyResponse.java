public class SurveyResponse 
{
	String name;
	boolean [] replies;
	
	public SurveyResponse( String n, int r )
	{
		name = n;
		replies = new boolean[ r ];
	}
	
	public void setAsnwer( int num, boolean ans )
	{
		if( num >= 0 && num < replies.length )
			replies[num] = ans;
	}
	
	public int getAnswer( int n )
	{
		if( replies[n] == true )
			return 1;
		
		return 0;
	}
	
}

