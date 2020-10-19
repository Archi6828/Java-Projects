//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BlockCounterRunner {
	public static void main(String args[]) throws IOException {
		BlockCounter a = new BlockCounter();
		System.out.println(a.findMax("3"));
		System.out.println(a.toString());
		String [] vals =  {"1","4" ,"5","2", "1", "2" ,"4" ,"4", "1" ,"2" ,"5", "1", "5" ,"4" ,"3" ,"5","4" ,"5" ,"3" ,"2", "5","2" ,"4" ,"3" ,"3","3", "5","1", "3", "1" ,"4", "1"};
		a.setGrid(4, 8,vals);
		System.out.println(a.findMax("3"));
		System.out.println(a.toString());
	}
}