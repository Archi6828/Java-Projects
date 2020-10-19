// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

import java.util.*;

public class ParameterRunner
{
	public static void main ( String[] args )
	{
		ListNode z = new ListNode("go",
			new ListNode("on",
				new ListNode("at",
					new ListNode("34",
						new ListNode("2.1",
							new ListNode("-a-2-1",
								new ListNode("up",		       		
									new ListNode("over",null))))))));
			 			
		System.out.println("Linked List Lab Test Code\n\n");	
		
		System.out.println("Original list values\n");	
		Parameter.print(z);
		System.out.println("\n");
		
		System.out.println("num nodes = " + Parameter.nodeCount(z));

		System.out.println("\nList values after calling nodeCount\n");	
		Parameter.print(z);
		System.out.println();		

		Parameter.doubleFirst(z);		
		System.out.println("\nList values after calling doubleFirst\n");							
		Parameter.print(z);
		System.out.println();	 

		Parameter.doubleLast(z);		
		System.out.println("\nList values after calling doubleLast\n");							
		Parameter.print(z);
		System.out.println();				
				
		Parameter.removeXthNode(z,2);		
		System.out.println("\nList values after calling removeXthNode(2)\n");					
		Parameter.print(z);
		System.out.println();			
				
		Parameter.setXthNode(z,2,"one");		
		System.out.println("\nList values after calling setXthNode(2,one)\n");										
		Parameter.print(z);
		System.out.println();				
	}
}