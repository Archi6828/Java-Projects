//Name: Archita Bathole
//Per: 1
//Date: 4/10/18
//AP Computer Science

public class Utility
{
	// A utility function to get height of the tree
	static int height(Node N)
	{
		//TODO: Implement this
		if(N == null)
			return 0;
		return N.height;
	}
	
	// A utility function to get maximum of two integers
	static int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	
	// A utility function to right rotate subtree rooted with y
	static Node rightRotate(Node y)
	{
		Node x = y.left;
		Node temp = x.right;
		
		//TODO: Perform rotation
		x.right = y;
		y.left = temp;
		
		//TODO: Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		
		//TODO: Return updated root
		return x;
	}
	
	// A utility function to left rotate subtree rooted with x
	static Node leftRotate(Node x)
	{
		Node y = x.right;
		Node temp = y.left;
		
		//TODO: Perform rotation
		y.left = x;
		x.right = temp;
		
		//TODO: Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		//TODO: Return updated root
		return y;
	}
	
	// Get Balance factor of node
	static int getBalance(Node node)
	{
		if(node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	/* Given a non-empty binary search tree, return the
	   node with minimum key value found in that tree.
	   Note that the entire tree does not need to be
	   searched. */
	static Node minValueNode(Node node)
	{
		Node current = node;
		
		/* loop down to find the leftmost leaf */
		while(current.left != null)
			current = current.left;
		
		return current;
	}

	// A utility function to print preorder traversal of
	// the tree. The function also prints height of every
	// node
	static void preOrder(Node node)
	{
		if(node != null)
		{
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}
