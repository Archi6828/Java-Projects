//Name: Archita Bathole
//Per: 1
//Date: 5/18/18
//AP Computer Science

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BTreePrinter
{
	public static <T extends Comparable<?>> String printNode(Node root)
	{
		int maxLevel = BTreePrinter.maxLevel(root);
		
		return printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}
	
	private static <T extends Comparable<?>> String printNodeInternal(List<Node> nodes, int level, int maxLevel)
	{
		String returnStr = "";
		
		if(nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
			return returnStr;
		
		int floor = maxLevel - level;
		int edgeLines = (int) Math.max(Math.pow(2, floor - 1), 0);//int endgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
		int firstSpaces = (int) Math.pow(2, floor) - 1;
		int betweenSpaces = (int) Math.pow(2, floor);
		
		//returnStr += printWhitespaces(firstSpaces);
		
		List<Node> newNodes = new ArrayList<Node>();
		for(Node node : nodes)
		{
			returnStr += printWhitespaces(firstSpaces);
			
			if(node != null)
			{
				returnStr += node.data;
				
				//if needed, hide this line of code to see contents of tree
				returnStr += (node.color == 1 ? "(b)" : "(r)");
					
				newNodes.add(node.left);
				newNodes.add(node.right);
			}
			else
			{
				returnStr += printWhitespaces(1);//prints space for every null node
				newNodes.add(null);
				newNodes.add(null);
			}
			
			returnStr += printWhitespaces(betweenSpaces);
		}
		returnStr += "\n";
		
		for(int i = 1; i <= edgeLines; i++)
		{
			if(i != Math.ceil(edgeLines / 2.0))//hide this to show long edges
				continue;
			
			for(int j = 0; j < nodes.size(); j++)
			{
				returnStr += printWhitespaces(firstSpaces - i);//before the /
				if(nodes.get(j) == null)
				{
					returnStr += printWhitespaces(edgeLines*2 + i + 1);//after the invisible \
					continue;
				}
				
				if(nodes.get(j).left != null)
					returnStr += "/";
				else
					returnStr += printWhitespaces(1);//instead of /
				
				returnStr += printWhitespaces(i + i - 1);//inside triangle of / and \
				
				if(nodes.get(j).right != null)
					returnStr += "\\";
				else
					returnStr += printWhitespaces(1);//instead of \
				
				returnStr += printWhitespaces(edgeLines*2 - i);//after the \
			}
			
			returnStr += "\n";
		}
		
		returnStr += printNodeInternal(newNodes, level + 1, maxLevel);
		
		return returnStr;
	}
	
	private static String printWhitespaces(int count)
	{
		return printWhitespaces(count, ' ');
	}
	
	private static String printWhitespaces(int count, char ch)
	{
		String returnStr = "";
		for(int i = 0; i < count; i++)
			returnStr += ch;
		
		return returnStr;
	}
	
	private static <T extends Comparable<?>> int maxLevel(Node node)
	{
		if(node == null)
			return 0;
		
		return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
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