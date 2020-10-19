
public class Node 
{
	private String question;
	private Node noLeft, yesRight;
	
	public Node( String q )
	{
		question = q;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public void setQuestion( String s )
	{
		question = s;
	}
	
	public void setNoNode( Node n )
	{
		noLeft = n;
	}
	
	public void setYesNode( Node n )
	{
		yesRight = n;
	}
	
	public Node getNoNode()
	{
		return noLeft;
	}
	
	public Node getYesNode()
	{
		return yesRight;
	}
	
	public boolean isLeaf()
	{
		if( this.noLeft == null && this.yesRight == null )
			return true;
		return false;
	}
	
}
