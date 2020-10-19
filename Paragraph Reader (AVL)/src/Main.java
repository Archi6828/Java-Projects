import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) throws FileNotFoundException {
		AVLTree tree = new AVLTree();
	//	Tree t = new Tree();
		//Dictionary test = new Dictionary("to");
		//System.out.println(test.getSavedWord());
		
		Scanner s = new Scanner( new File("src/text"));
		
		while(s.hasNext()) {
			String word = s.next();
			if( word.length() >= 5 )
				tree.root = tree.insert(tree.root, word);
		} 
		
		System.out.println("AVL Tree with moderately difficult words: ");
		System.out.println();
		//System.out.println(t.verticalOrder(t.root));
		System.out.println(BTreePrinter.printNode(tree.root));
		System.out.println();
		boolean flag = true;
		do{
			System.out.println("Please enter a word that you would like to define: ");
			Scanner input = new Scanner( System.in );
			String word = input.nextLine();
			Node temp = tree.Contains(word);
			if( temp != null ) {
				flag = false;
				System.out.println("The definition of the word " + temp.key + " is:");
				//temp.setDef();
				//System.out.println(temp.def);
				//Dictionary test = new Dictionary(word);
				//System.out.println(test.getSavedWord());
				System.out.println(temp.getDef());
				System.out.println("\n");
				System.out.println("What you like to look up another word? (y or n)");
				String cont = input.nextLine();
				if(cont.equals("y"))
					flag = true;
				else
					flag = false;
			}
				
		}while(flag);
		
	}
		
}
	
