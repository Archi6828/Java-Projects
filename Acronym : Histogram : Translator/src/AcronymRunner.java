//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AcronymRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases
		Scanner input = new Scanner(new File("acro.dat"));
		String num = input.nextLine();
		
		int j = 0;
		int size = Integer.parseInt(num);
		String acro;
		
		Acronym a = new Acronym();
		
		while(j < size) {
			acro = input.nextLine();
			a.putEntry(acro);
			j++;
		}
		
		System.out.println("====    MAP CONTENTS    ====" + "\n\n" + a.toString());
		System.out.println("====    READ LINES    ====" + "\n" );
		while(input.hasNextLine()) {
			System.out.println(a.convert(input.nextLine()));
		}
		
		
	}
}