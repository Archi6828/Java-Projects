class Tree 
{
	Node root;
	Values val = new Values();

	// A utility function to find min and max distances with respect
	// to root.
	void findMinMax(Node node, Values min, Values max, int hd) 
	{
		// Base case
		if (node == null) 
			return;

		// Update min and max
		if (hd < min.min) 
			min.min = hd;
		else if (hd > max.max) 
			max.max = hd;

		// Recur for left and right subtrees
		findMinMax(node.left, min, max, hd - 1);
		findMinMax(node.right, min, max, hd + 1);
	}

	// A utility function to print all nodes on a given line_no.
	// hd is horizontal distance of current node with respect to root.
	String printVerticalLine(Node node, int line_no, int hd) 
	{
		String output = "";
		// Base case
		if (node == null) 
			return output;

		// If this node is on the given line number
		if (hd == line_no) 
			output += node.key + " ";	 

		// Recur for left and right subtrees
		printVerticalLine(node.left, line_no, hd - 1);
		printVerticalLine(node.right, line_no, hd + 1);
		return output;
	}

	// The main function that prints a given binary tree in
	// vertical order
	String verticalOrder(Node node) 
	{
		String output = "";
		// Find min and max distances with resepect to root
		findMinMax(node, val, val, 0);

		// Iterate through all possible vertical lines starting
		// from the leftmost line and print nodes line by line
		for (int line_no = val.min; line_no <= val.max; line_no++) 
		{
			output += printVerticalLine(node, line_no, 0) + "\n";
		}
		return output;
	}
}