//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//Computer Science Data Structures

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglishRunner
{
	public static void main( String args[] ) throws IOException
	{
		String [] questions = null;
		
		Scanner input = new Scanner(new File("spantoeng.dat"));
		String num = input.nextLine();
		
		int j = 0;
		int size = Integer.parseInt(num);
		String word;
		
		SpanishToEnglish a = new SpanishToEnglish();
		
		while(j < size) {
			word = input.nextLine();
			a.putEntry(word);
			j++;
		}
		
		while(input.hasNextLine()) {
			System.out.println(a.translate(input.nextLine()));
		}
		
		System.out.println(a.toString());
	
	}
}