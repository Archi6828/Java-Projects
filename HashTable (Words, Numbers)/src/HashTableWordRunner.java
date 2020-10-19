// Name: Archita Bathole
// Date: 3/15/18
// Per: 1
// AP Computer Science

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class HashTableWordRunner
{
  public static void main ( String[] args )
  {
		try{
			//make a new table			
			HashTable a = new HashTable();
			//read from the file	
			File file = new File("words.dat");
			Scanner input = new Scanner(file);
			int size = input.nextInt();
			//load stuff into the table			
			while(input.hasNext()) {
				a.add(new Word(input.nextLine().trim()));
			}
	
			//print out the table
			System.out.println(a.toString());
		}
		catch(Exception e)
		{
			System.out.println("Houston, we have a problem!");
		}
  }
}