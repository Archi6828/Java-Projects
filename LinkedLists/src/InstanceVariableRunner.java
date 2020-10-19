// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

import java.util.*;

public class InstanceVariableRunner
{
	public static void main ( String[] args )
	{
		InstanceVariable funHouse = new InstanceVariable(); 
		
		funHouse.add("go");
		funHouse.add("on");
		funHouse.add("at");
		funHouse.add("34");
		funHouse.add("2.1");
		funHouse.add("-a-2-1");
		funHouse.add("up");		       		
		funHouse.add("over");
			 			
		System.out.println("Original list values\n");	
		System.out.println(funHouse);
		System.out.println("\n");
		
		System.out.println("num nodes = " + funHouse.nodeCount());

		System.out.println("\nList values after calling nodeCount\n");	
		System.out.println(funHouse);
		System.out.println();		

		funHouse.doubleLast();		
		System.out.println("\nList values after calling doubleLast\n");							
		System.out.println(funHouse);
		System.out.println();				


		funHouse.doubleFirst();		
		System.out.println("\nList values after calling doubleFirst\n");							
		System.out.println(funHouse);
		System.out.println();	
				
		
		funHouse.removeXthNode(2);		
		System.out.println("\nList values after calling removeXthNode(2)\n");					
		System.out.println(funHouse);
		System.out.println();			
		
		
		funHouse.setXthNode(2,"one");		
		System.out.println("\nList values after calling setXthNode(2,one)\n");										
		System.out.println(funHouse);
		System.out.println();				
	}
}