//Name: Archita Bathole
//Per: 1
//Date: 5/18/18
//AP Computer Science

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
   This class implements a red-black tree.

	Red-Black Tree is a self-balancing Binary Search Tree (BST) where every node follows following rules.
   1)Each node is either red or black.
   2)The root is black. This rule is sometimes omitted. Since the root can always be changed from red to black, but not necessarily vice versa, this rule has little effect on analysis.
   3)All leaves (NULL) are black.
   4)There are no two adjacent red notes. (Meaning if a node is red, then both its children are black).
   5)Every path from a given node to any of its descendant NULL nodes contains the same number of black nodes.

   Helpful resources:
   http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap14.htm
   https://www.youtube.com/watch?v=YCo2-H2CL6Q
   https://www.youtube.com/watch?v=A3JZinzkMpk
 */
public class RedBlackTree
{  
    Node root;

    //helper variables
    static final int BLACK = 1;
    static final int RED = 0;
    private static final int NEGATIVE_RED = -1;
    private static final int DOUBLE_BLACK = 2;

    /**
  	Constructs an empty tree.
     */
    public RedBlackTree()
    {  
   	 root = null;
    }

    /**
  	Inserts a new node into the tree.
  	@param obj the object to insert
     */
    public void add(Comparable obj)
    {  
   	 //TODO
   	 //add code
   	 Node n = new Node();  
   	 n.data = obj;
   	 //   	n.left = null;
   	 //   	n.right = null;

   	 Node y = null;
   	 //  	Node x = root;
   	 Node current = root;
   	 while(current != null)
   	 {
   		 y = current;
   		 if(n.data.compareTo(root.data) < 0)
   			 current = current.left;
   		 else
   			 current = current.right;
   	 }


   	 n.parent = y;
   	 if(y == null)
   		 root = n;
   	 else
   		 if(n.data.compareTo(y.data) < 0)
   			 y.left = n;
   		 else
   			 y.right = n;
   	 n.left = null;
   	 n.right = null;
   	 n.color = RED;
   	 //       	root = new Node();
   	 //       	root.data = "k";
   	 //       	Node test = new Node();
   	 //       	test.data = "g";
   	 //       	root.left= test;
//   	 System.out.println("the insertion looks like:");
//   	 System.out.println(BTreePrinter.printNode(root));

   	 fixup(root,n);
   	 /*
    	The insert() method places a data item into the tree.

     	Insertions
     	pseudocode for
     	RB-Insert(T,z)
        	y = nil[T]
        	x = root[T]
        	while x != nil[T]
             	y = x
             	if key[z] < key[x] then
                 	x = left[x]
             	else
                 	x = right[x]
        	p[z] = y
        	if y = nil[T]
             	root[T] = z
        	else
           	if key[z] < key[y] then
              	left[y] = z
           	else
              	right[y] = z
        	left[z] = nil[T]
        	right[z] = nil[T]
        	color[z] = RED
        	RB-Insert-fixup(T,z)
   	  */
    }

    /**
  	Tries to find an object in the tree.
  	@param obj the object to find
  	@return true if the object is contained in the tree
     */
    public boolean find(Comparable obj)
    {
   	 //TODO
   	 //add code
   	 boolean flag = false;
   	 int cmp = obj.compareTo(root.data);
   	 while(root != null) {
   		 if(cmp < 0)
   		 {
   			 root =  root.left;
   		 }
   		 else if(cmp > 0)
   			 root = root.right;
   		 else
   			 flag = true;    
   	 }
   	 return flag;
    }

    /**
  	Tries to remove an object from the tree. Does nothing
  	if the object is not contained in the tree.
  	@param obj the object to remove
     */
    public void remove(Comparable obj)
    {
   	 fixup(root, deleteNode(root, obj));
    }
    public Node deleteNode( Node root, Comparable obj)
    {
   	 Node curr = root;
   	 if( root == null )
   		 return root;
   	 else if( curr.data.compareTo(obj) < 0 )
   	 {
   		 root.right = deleteNode( root.right, obj );
   	 }
   	 else if( curr.data.compareTo(obj) > 0 )
   	 {
   		 root.left = deleteNode( root.left, obj );
   	 }
   	 else if( root.left != null && root.right != null ) // Two children
    	{
//   		 System.out.println("The min value at point " + root.data + "is " + minValue(root.right).data);
        	root.data = minValue( root.right ).data;
       	 
        	root.right = deleteNode(root.right, root.data );
    	}
    	else
        	root = ( root.left != null ) ? root.left : root.right;
    	return root;
	}
    public Node minValue(Node n)
    {
   	 if( n.left == null)
   		 return n;
   	 else
   		 return minValue(n.left);
    }

    //TODO
    //helper functions

    //4 scenarios for recoloring
    //1. Z=root -> color black
    //2. Z.uncle = red -> recolor
    //3. Z.uncle = black (triangle) -> rotate Z.parent
    //4. Z.uncle = black (line) -> rotate Z.parent & recolor


    public void fixup(Node root, Node z)
    {
   	 //root = this.root;
//   	 System.out.println("The starting root is: " + root.data);
   	 if(z.data == root.data)
   	 {
   		 root.color = BLACK;
   		 return;
   	 }
   	 //PRINT OUT NUMBER ONE
//   	 System.out.println("z.parent.data is " + z.parent.data);
//   	 System.out.println("z.data is " + z.data);
//   	 
//   	 if(z.parent.right != null)
//   		 System.out.println("z.parent.right.data is " + z.parent.right.data);

   	 while(z.parent.color == RED)
   	 {

   		 //System.out.println(root.left.data);
   		 if( z.parent == z.parent.parent.left)
   		 {

   			 Node y = z.parent.parent.right;

   			 if(y != null &&y.color == RED)
   			 {
   				 z.parent.color = BLACK;
   				 y.color = BLACK;
   				 z.parent.parent.color = RED;
   				 z = z.parent.parent;
   			 }
   			 else {
   				 //PRINT OUT NUMBER ONE IN WHILE
//   				 System.out.println("(in while) z.parent.data is " + z.parent.data);
//   				 System.out.println("(in while) z.data is " + z.data);
//   				 if(z.parent.right != null)
//   					 System.out.println("(in while) z.parent.right.data is " + z.parent.right.data);
   				 if(z == z.parent.right)
   				 {
   					 z.parent.color = BLACK;
   					 z.parent.parent.color = RED;
   					 // left rotate
//   					 System.out.println("I am ready to rotate left around: " + z.parent.data);
   					 rotateLeft(z.parent);
   					 root = this.root;
   				 }
   				 else {
   					 z.parent.color = BLACK;
   					 z.parent.parent.color = RED;
   					 // right rotate
//   					 System.out.println("I am ready to rotate right around : " + z.parent.data);

   					 rotateRight(z.parent);
   					 root = this.root;
   				 }

   			 }
   		 }
   		 else
   		 {
   			 //PRINT OUT NUMBER TWO
//   			 System.out.println("z.parent.parent.left's data is: " +z.parent.parent.left.data);
//   			 System.out.println("z.parent.parent.right data is: " +z.parent.parent.right.data);
   			 Node y = z.parent.parent.left;
   			 if(y != null && y.color == RED)
   			 {
   				 z.parent.color = BLACK;
   				 y.color = BLACK;
   				 z.parent.parent.color = RED;
   				 z = z.parent.parent;

   			 }

   			 else
   			 {
   				 if(z == z.parent.left)
   				 {
   					 z = z.parent;
//   					 System.out.println("I entered the right rotate methods at the bottom");
   					 rotateRight(z.parent);
   				 }
   				 z.parent.color = BLACK;
   				 z.parent.parent.color = RED;
//   				 System.out.println("I entered the left rotate methods at the bottom");
   				 rotateLeft(z.parent);
   			 }
   		 }
   	 }
   	 this.root.color = BLACK;
//   	 System.out.println("The ending root is: " + root.data);
   	 //System.out.println(BTreePrinter.printNode(root));
    }

    // right rotate
    private Node rotateRight(Node h) {
   	 if( h.right == null )
   	 {
   		 Node x = h.right;
   		 h.right = h.parent;
   		 h.right.color = RED;
   		 h.right.left = x;
   		 root = h;
   		 h.left.parent = root;
   		 h.right.parent = root;
   		 return h;
   	 }
   	 h.parent.left = h.right;
   	 h.right = h.parent;
   	 h.right.color = RED;
   	 root = h;
   	 h.left.parent = root;
   	 h.right.parent = root;
   	 return h;
    }

    // left rotate
    private Node rotateLeft(Node h) {
   	 if(h.left == null)
   	 {
   		 Node x = h.left;
   		 h.left = h.parent;
   		 x.left.right = x;
   		 x.left.color = RED;
   		 root = h;
   		 h.left.parent = root;
   		 h.right.parent = root;
   		 return h;
   	 }

   	 h.parent.right = h.left;
   	 h.left = h.parent;
   	 h.left.color = RED;
   	 root = h;
   	 h.left.parent = root;
   	 h.right.parent = root;
   	 return h;


    }

    //   private Node rotateLeft(Node h) {
    //   	Node x = h.right;
    //   	h.right = x.left;
    //   	x.left = h;
    //   	return x;
    //   }
    //   
    //   private Node rotateRight(Node h) {
    //   	Node x = h.parent;
    //   	h.right = x;
    //  	 
    //   	return h;
    //   }

    /*
  	Fixing up the tree so that Red Black Properties are preserved.

  	Pseudo-code for RB-Insert-fixup
  	RB-Insert-fixup(T,z)
  	while color[p[z]] = RED {
    	if p[z] == left[p[p[z]]] {
         	y = right[p[p[z]]]
         	if color[y] = RED {
             	color[p[z]] = BLACK
             	color[y] = BLACK
             	color[p[p[z]]] = RED
             	z = p[p[z]]
         	}
         	else {
             	if z = right[p[z]] {
                  	z = p[z]
                  	LEFT-Rotate(T,z)
             	}
             	color[p[z]] = BLACK
             	color[p[p[z]]] = RED
             	RIGHT-Rotate(T,p[p[z]])
         	}
    	}
    	else {
         	y = left[p[p[z]]]
         	if color[y] = RED {
             	color[p[z]] = BLACK
             	color[y] = BLACK
             	color[p[p[z]]] = RED
             	z = p[p[z]]
         	}
         	else
             	{
             	if z = left[p[z]] {
                  	z = p[z]
                  	RIGHT-Rotate(T,z)
             	}
             	color[p[z]] = BLACK
             	color[p[p[z]]] = RED
             	LEFT-Rotate(T,p[p[z]])
         	}
    	}
    	color[root[T]] = BLACK
  	}
     */
}









