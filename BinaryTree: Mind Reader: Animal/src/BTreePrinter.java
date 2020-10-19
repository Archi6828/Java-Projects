import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BTreePrinter
{
	
	public static <T extends Comparable<?>> void printNode(Node root)
	{
		int maxLevel = BTreePrinter.maxLevel(root);
		
		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	
	private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel)
	{
		if(nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return;
		
		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
		
		BTreePrinter.printWhitespaces(firstSpaces);
		
		List<Node> newNodes = new ArrayList<Node>();
		for(Node node : nodes)
		{
			if(node != null)
			{
				System.out.print(node.getQuestion() );
				newNodes.add(node.getNoNode() );
				newNodes.add(node.getYesNode() );
			}
			else
			{
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}
			
			BTreePrinter.printWhitespaces(betweenSpaces);
		}
		System.out.println("");
		
		for(int i = 1; i <= endgeLines; i++)
		{
			for(int j = 0; j < nodes.size(); j++)
			{
				BTreePrinter.printWhitespaces(firstSpaces - i);
				if(nodes.get(j) == null)
				{
					BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}
				
				if(nodes.get(j).getNoNode() != null)
					System.out.print("/");
				else
					BTreePrinter.printWhitespaces(1);
				
				BTreePrinter.printWhitespaces(i + i - 1);
				
				if(nodes.get(j).getYesNode() != null)
					System.out.print("\\");
				else
					BTreePrinter.printWhitespaces(1);
				
				BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
			}
			
			System.out.println("");
		}
		
		printNodeInternal(newNodes, level + 1, maxLevel);
	}
	
	private static void printWhitespaces(int count)
	{
		for(int i = 0; i < count; i++)
			System.out.print(" ");
	}
	
	private static <T extends Comparable<?>> int maxLevel(Node node)
	{
		if(node == null)
			return 0;
		
		return Math.max(BTreePrinter.maxLevel(node.getNoNode()), BTreePrinter.maxLevel(node.getYesNode())) + 1;
	}
	
	private static <T> boolean isAllElementsNull(List<T> list)
	{
		for(Object object : list)
		{
			if(object != null)
				return false;
		}
		
		return true;
	}
}

/*
tree.root = new Node(1);

tree.root.left = new Node(2);
tree.root.right = new Node(3);

tree.root.left.left = new Node(4);
tree.root.left.right = new Node(5);

tree.root.right.left = new Node(6);
tree.root.right.right = new Node(7);

tree.root.left.left.left = new Node(8);
tree.root.left.left.right = new Node(9);
tree.root.left.right.left = new Node(0);
tree.root.left.right.right = new Node(1);

tree.root.right.left.left = new Node(2);
tree.root.right.left.right = new Node(3);
tree.root.right.right.left = new Node(4);
tree.root.right.right.right = new Node(5);
*/