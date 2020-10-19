// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

public class HistogramList
{
	private HistogramNode front;

	public HistogramList( )
	{
		front = new HistogramNode((char) 0, 0, null);
	}


	//ADDS NEW NODE TO THE FRONT OF THE LIST FOR LET IF IT DOES NOT EXIST.
	//IF IT EXISTS, IT BUMPS UP LET'S COUNT BY ONE
	public void add(Object obj)
	{
		ListNode newNode = null;
		int count = 0;
		
		
			if(obj.equals(nodeAt(indexOf(obj))))
			{
				//nodeAt(indexOf(obj)) != null
				count++;
			
			}
			else
			{
			newNode = new HistogramNode((Comparable) obj, front);	
			front = newNode;
			//System.out.print(front.getValue());
			}
		
	}

	//RETURNS THE INDEX POSITION OF LET IN THE LIST
	public int indexOf(Object obj)
	{
		ListNode temp = front;
		int count = 0;
		int spot=-1;
		boolean a = obj instanceof Character;
		if(front != null) {
			while(front != null)
			{
			if(a)
			{
				if(front.getValue() == obj)
				//obj.equals(front))
				spot = count;
				return spot;
			}
			else
			{
			count++;
				front = front.getNext();
			}
			//System.out.print(front.getValue());
			}
		}
		front = temp;
		return spot;
	}

	//RETURNS A REFERENCE TO THE NODE AT SPOT
	private ListNode nodeAt(int spot)
	{
		ListNode temp = front;
		ListNode current=front;
		int count = 0;
		if(spot == -1)
			return null;
		while(front != null)
		{
			if(count == spot)
			{
				current = front;
				//System.out.print(current);
			}
			else
			{
				count++;
				front = front.getNext();
			}
			//count++;
		}
		front = temp;
		return current;
	}
	
	public void remove(char let)
	{
		int count = 0;
		while(front != null && front.getNext() != null)
		{
			if(front.getNext().getValue().equals(let) && count == 0)
				front.setNext(front.getNext().getNext());
			if(front.getNext().getValue().equals(let) && count > 0)
				count--;
		}
	}

	//RETURNS THE LIST AS A BIG STRING
	public String toString()
	{
		String output = "";
		//while(front.getValue() != null)
	   	{
	   		output += front.getValue() + " ";
	   		front = front.getNext();
	   	}
		return output;
	}
}