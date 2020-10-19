//Name: Archita Bathole
//Per: 1
//Date: 4/29/18
//AP Computer Science



// BST helper node data type
class Node<Key extends Comparable<Key>, Value>
{
	Key key; // key
	Value value; // associated data
	Node left, right; // left and right subtrees
	
	public Node(Key key, Value value)
	{
		this.key = key;
		this.value = value;
	}
}