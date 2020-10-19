// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

public class Parameter
{
	//this method will print the entire list on the screen
   public static void print(ListNode list)
   {
       while(list != null)
       {
            System.out.print(list.getValue() + " " );
            list = list.getNext();
       }
   }
	
	//this method will return the number of nodes present in list
	public static int nodeCount(ListNode list)
	{
   		int count=0;
                
                while(list != null)
                {
                    count++;
                    list = list.getNext();
                    
                }
		return count;
	}
		
	//this method will create a new node with the same value as the first node and add this
	//new node to the list.  Once finished, the first node will occur twice.
	public static void doubleFirst(ListNode list)
	{
            ListNode a = new ListNode(list.getValue(), list.getNext());
             list.setNext(a);
	}

	//this method will create a new node with the same value as the last node and add this
	//new node at the end.  Once finished, the last node will occur twice.
	public static void doubleLast(ListNode list)
	{
		int size = nodeCount(list);
		for(int i = 0; i < size; i++) {
            if(list.getNext() == null)
            {
            		
            	 	ListNode last = new ListNode(list.getValue(), list.getNext());
                list.setNext(last);
                
            }
            else
            		list = list.getNext();
		}
	}
		
	//method skipEveryOther will remove every other node
	public static void skipEveryOther(ListNode list)
	{
            while(list != null && list.getNext() != null)
            {
                list.setNext(list.getNext().getNext());
                list = list.getNext();
            }
	}

	//this method will set the value of every xth node in the list
	public static void setXthNode(ListNode list, int x, Comparable value)
	{
		int count = 1;
        int size = nodeCount(list);
        ListNode next = list;
        
            for(int i = 0; i < size; i += x)
            {
            	   while(count == i)
            	   {
            		   list.setValue(value);
            		   list = list.getNext();
            		   count++;
            		  
            	   }
            	   count++;
            	   list = list.getNext();
            	  if(i == 8)
            		  list.setNext(null);
                
            }
	}	

	//this method will remove every xth node in the list
	public static void removeXthNode(ListNode list, int x)
	{
			int count = 0;
            int size = nodeCount(list);
            ListNode next = list;
            
                for(int i = x; i < size; i += x)
                {
                	   while(count != i)
                	   {
                		   next = next.getNext();
                		   count++;
                	   }
                	   list.setNext(next);
                	   list = next;
                	  if(i == 8)
                		  list.setNext(null);
                    
                }
               
	}		
}
