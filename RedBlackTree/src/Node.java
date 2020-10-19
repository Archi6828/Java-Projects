//Name: Archita Bathole
//Per: 1
//Date: 5/18/18
//AP Computer Science

/**
A node of a red-black tree stores a data item and references
of the child nodes to the left and to the right. The color
is the "cost" of passing the node; 1 for black or 0 for red.
Temporarily, it may be set to 2 or -1. 
*/
class Node
{
	public Comparable data;
	public Node left;
	public Node right;
	public Node parent;
	public int color;
	
	/**
	Constructs a red node with no data.
	*/
	public Node()
	{
	}
	
	/**
	Sets the left child and updates its parent reference.
	@param child the new left child
	*/
	public void setLeftChild(Node child)
	{
		left = child;
		if(child != null)
		{
			child.parent = this;
		}
	}
	
	/**
	Sets the right child and updates its parent reference.
	@param child the new right child
	*/
	public void setRightChild(Node child)
	{
		right = child;
		if(child != null)
		{
			child.parent = this;
		}
	}
	
	/**
	Inserts a new node as a descendant of this node.
	@param newNode the node to insert
	*/
	public void addNode(Node newNode)
	{
		int comp = newNode.data.compareTo(data);
		if(comp < 0)
		{
			if(left == null)
			{
				left = newNode;
				left.parent = this;
			}
			else
			{
				left.addNode(newNode);
			}
		}
		else if(comp > 0)
		{
			if(right == null)
			{
				right = newNode;
				right.parent = this;
			}
			else
			{
				right.addNode(newNode);
			}
		}
	}
}