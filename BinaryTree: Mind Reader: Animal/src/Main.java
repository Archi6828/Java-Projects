import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;



public class Main  
{
	public static void main( String [] args ) throws IOException 
	{
		Scanner s = new Scanner( System.in );
		
		//Input file w/ questions 
		String content = new String(Files.readAllBytes(Paths.get( "Tree Questions" ) ) );
		String [] questions = content.split( "\n" );
		
		//create questions tree
		Tree t = new Tree( questions );
		
		System.out.print( "Please think of an animal. Enter \"ok\" when you have thought of an animal." );
		String temp = s.nextLine().toLowerCase();
		
		//Start questions to begin process o guessing animal
		if( temp.equals( "ok" ) )
		{
			while( !temp.equals( "n" ) )
			{
				Node current = t.getRoot();
				game( current, t );
				System.out.print( "Do you wish to continue?: ");
				temp = s.nextLine().toLowerCase();
			}
		}
		
		
		//BTreePrinter.printNode( t.root );
		
	}
	
	
	private static Node increment( String s, Node n )
	{	
		String temp = s.toLowerCase();
		if( temp.equals( "y" ) )
			return n.getYesNode();
		return n.getNoNode();
	}
	
	
	
	
	private static void game( Node current, Tree t )
	{
		Scanner s = new Scanner( System.in );
		
		while( !current.isLeaf() )
		{
			System.out.print( current.getQuestion() + ": " );
			current = increment( s.next(), current );
		}
		
		if( current != null && current.isLeaf() )
		{
			System.out.print( current.getQuestion() + ": " );
			String input = s.next().toLowerCase();
			
			if( input.equals( "n" ) )
			{
				System.out.print( "What animal were you thinking of?: " );
				String animal = "Is it a " + s.next().toLowerCase() + "?";
				s.nextLine();
				
				System.out.print( "Please enter a question to differentiate the two animals: " );
				String Qadd = s.nextLine();
				t.insertNode(current, Qadd, animal);
			}
		}
		
	}
}
