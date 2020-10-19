//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HistogramRunner
{
	public static void main( String args[] ) throws IOException
	{
		//add test cases		
		
		Histogram a = new Histogram();
		
		String test = "a b c d e f g h i a c d e g h i h k";
		String test1 = "1 2 3 4 5 6 1 2 3 4 5 1 3 1 2 3 4"; // Y U I O Q W E R T Y";
				//"4T#@^###";
		
		a.setSentence(test);
		System.out.println("char 1---5----01---5");
		System.out.println(a.toString());
		
		Histogram b = new Histogram();
		b.setSentence(test1);
		System.out.println("char 1---5----01---5");
		System.out.println(b.toString());
	}
}