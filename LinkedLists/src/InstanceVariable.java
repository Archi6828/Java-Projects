import java.util.LinkedList;

//Name: Archita Bathole
//Date: 9/12/17
//Per: 1
//AP Computer Science

public class InstanceVariable
{
	private ListNode theList;
	
	
	public InstanceVariable()
	{
		theList = new ListNode();
	}
	
	public void add(Comparable data)
	{
		theList = new ListNode(data, theList);
		
		
	}
	
	//this method will return the number of nodes present in list
	public int nodeCount()
	{
		ListNode head = theList;
   	int count=0;
   	while(theList != null && theList.getNext() != null)
    {
        count++;
        theList = theList.getNext();
        
    }
   	theList = head;
   	return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node at the front of the list.  Once finished, the first node will occur twice.
	public void doubleFirst()
	{
		ListNode head = theList;
		 ListNode a = new ListNode(theList.getValue(), theList.getNext());
         theList.setNext(a);
         theList = head;
				
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public void doubleLast()
	{
		int count = 0;
		ListNode head = theList;
		int size = nodeCount();
		for(int i = 0; i < size; i++) {
            if(count == size - 1)
            {
            		
            	 	ListNode last = new ListNode(theList.getValue(), theList.getNext());
                theList.setNext(last);
                
            }
            else
            {
            		theList = theList.getNext();
            		count++;
            }
           
		}
		theList = head;
		
	}
	
	//method skipEveryOther will remove every other node
	public void skipEveryOther()
	{
		ListNode head = theList;
		 while(theList != null && theList.getNext() != null)
         {
             theList.setNext(theList.getNext().getNext());
             theList = theList.getNext();
         }


	}

	//this method will set the value of every xth node in the list
	public void setXthNode(int x, Comparable value)
	{
		ListNode head = theList;
		int count = 1;
        int size = nodeCount();
        ListNode next = theList;
        
            for(int i = 0; i < size; i += x)
            {
            	   while(count == i)
            	   {
            		   theList.setValue(value);
            		   theList = theList.getNext();
            		   count++;
            		  
            	   }
            	   count++;
            	   theList = theList.getNext();
            	  if(i == 8)
            		  theList.setNext(null);
                
            }
            theList = head;

	
	}	

	//this method will remove every xth node in the list
	public void removeXthNode(int x)
	{
		ListNode head = theList;
		int count = 0;
        int size = nodeCount();
        ListNode next = theList;
        
            for(int i = x; i < size; i += x)
            {
            	   while(count != i)
            	   {
            		   next = next.getNext();
            		   count++;
            	   }
            	   theList.setNext(next);
            	   theList = next;
            	  if(i == 8)
            	  {
            		theList.getNext().setNext(null);
            	  }
                
            }
            theList = head;
	
	}		
	//this method will return a String containing the entire list
   public String toString()
   {
   	String output="";
   	ListNode head = theList;
   	while(theList != null && theList.getNext() != null)
   	{
   		output += theList.getValue() + " ";
   		theList = theList.getNext();
   	}
   	theList = head;
   	return output;
   }			
	
}