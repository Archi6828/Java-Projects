public class Node 
{
	private SurveyResponse sr;
	private Node next;
	
	public Node( SurveyResponse s )
	{
		sr = s;
		next = null;
	}
	
	
	public SurveyResponse getValue() {
		return sr;
	}
	
	
	public Node getNext() {
		return next;
	}
	
	public void setValue( SurveyResponse v) {
		sr = v;
	}
	
	
	public void setNext(Node nx) {
		next = nx;
	}
	
	
	
	
}

