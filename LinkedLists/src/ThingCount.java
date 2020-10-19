// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

public class ThingCount implements Comparable
{
	private int count;
	private Object thing;
	
	public ThingCount()
	{
		thing = null;
		count = 0;
	}
	
	public ThingCount(Object thang, int cnt)
	{
		thing = thang;
		count = cnt;
	}
	
	public int getCount()
	{
		
		return count;
	}
	
	public void setCount(int cnt)
	{
		count = cnt;
	}

	public void setThing(Object obj)
	{
		thing = obj;
	}	
	
	public Object getThing()
	{
		
		return thing;
	}
	
	public boolean equals(Object obj)
	{
		boolean flag = false;
		ThingCount other = (ThingCount)obj;
		
		if(thing.equals(other.getThing()) && count == other.getCount() )
			flag = true;
	//System.out.print(other.getThing());
		return flag;
	}
	
	public int compareTo(Object obj)
	{
		int flag = -1;
		ThingCount other = (ThingCount)obj;
		if(thing == other.getThing() && count == other.getCount() )
			flag = 0;
		else if(((ThingCount) thing).compareTo(other.getThing()) == 1 && count > other.getCount() )
			flag = 1;
		else 
			flag = -1;
		return flag;		
	}
	
	public String toString()
	{
		return ""+ getThing() + " - " + getCount();
	}
}