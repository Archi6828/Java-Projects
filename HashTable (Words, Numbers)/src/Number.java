// Name: Archita Bathole
// Date: 3/15/18
// Per: 1
// AP Computer Science

public class Number
{
	private int theValue;
	
	public Number(int value)
	{
		theValue = value;
	}	
	
	public int getValue()
	{
		return theValue;
	}
	
	public boolean equals(Object obj)
	{
		if(((Number) obj).getValue() == theValue)
			return true;
		return false;
	} 
	
	public int hashCode()
	{
		int rem = theValue % 10;
		return rem;
	}

	public String toString()
	{
		return "" + theValue;
	}	
}
