//Name: Archita Bathole
//Per: 1
//Date: 5/18/18
//AP Computer Science

import java.util.Iterator;

/**
   This program tests the red-black tree class.
*/
public class RedBlackTreeRunner
{ 
   public static void main(String[] args)
   {  
      RedBlackTree tree = new RedBlackTree();
      tree.add("D");
      tree.add("B");
      tree.add("A");
      tree.add("C");
      tree.add("F");
      tree.add("E");
      tree.add("I");
      tree.add("G");
      tree.add("H");
      tree.add("J");

		// DEBUG UTILITY
		System.out.println(BTreePrinter.printNode(tree.root));
/*
		       E        
		     /   \      
		   B       G    
		  / \     / \   
		 A   D   F   I  
		    /       / \ 
		    C       H J 
 */

      
 //     Iterator iter = tree.iterator();
//      while (((Iterator) tree).hasNext())
//      {
//         Object data = ((Iterator) tree).next();
//         System.out.print(data + " ");
//      }
//      System.out.println();
//      System.out.println("Expected: A B C D E F G H I J");
//      
   }
}

