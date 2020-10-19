//Name: Archita Bathole
//Per: 1
//Date: 4/29/18
//AP Computer Science

public class SplayBSTRunner
{
	public static void main(String[] args)
	{
		SplayBST<Integer, Integer> tree1 = new SplayBST<Integer, Integer>();
		tree1.put(5, 5);
//		System.out.println(BTreePrinter.printNode(tree1.root));
		tree1.put(9, 9);
//		System.out.println(BTreePrinter.printNode(tree1.root));
		tree1.put(13, 13);
//		System.out.println(BTreePrinter.printNode(tree1.root));
		tree1.put(11, 11);
//		System.out.println(BTreePrinter.printNode(tree1.root));
		tree1.put(1, 1);
		
		// DEBUG UTILITY
		System.out.println(BTreePrinter.printNode(tree1.root));
		
		SplayBST<String, String> tree2 = new SplayBST<String, String>();
		tree2.put("A", "Apple-100");
		tree2.put("A", "Apple-200");
		tree2.put("A", "Apple-300");
		tree2.put("B", "Banana-100");
		tree2.put("D", "Durian-100");
		tree2.put("C", "Carrot-100");
		
		// DEBUG UTILITY
		System.out.println(BTreePrinter.printNode(tree2.root));
		
		System.out.println("Size: " + tree2.size());
		tree2.remove("D");
		System.out.println("Size: " + tree2.size());
		tree2.remove("B");
		System.out.println("Size: " + tree2.size());
		tree2.remove("X");
		System.out.println("Size: " + tree2.size());
		System.out.println(tree2.get("A"));
		System.out.println("Size: " + tree2.size());
		System.out.println(tree2.get("D"));
		System.out.println("Size: " + tree2.size());
		System.out.println(tree2.get("C"));
		System.out.println("Size: " + tree2.size());
		System.out.println();
	}
}
