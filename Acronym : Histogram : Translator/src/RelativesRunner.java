//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class RelativesRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add more test cases	
		Scanner input = new Scanner(new File("relatives.dat"));
		String num = input.nextLine();
		
		int j = 0;
		int size = Integer.parseInt(num);
		String word;
		
		Relatives a = new Relatives();
		
		while(j < size) {
			word = input.nextLine();
			a.setPersonRelative(word);
			j++;
		}
		
		while(input.hasNextLine()) {
			a.getRelatives(input.nextLine());
			//System.out.println(a.getRelatives(input.nextLine()));
		}
		
		System.out.println(a.toString());
	}
}