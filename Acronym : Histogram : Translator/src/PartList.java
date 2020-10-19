//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.*;

public class PartList
{
	private TreeMap<Part, Integer> partsMap;
	
	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}
	
	public PartList(String fileName)
	{
		this();
		try
		{
			//add code here to read from the file 
			//and add Parts to the map
			Scanner input = new Scanner(new File("partinfo.dat"));
		
			while(input.hasNextLine()) {
				String words = input.nextLine();
				Part p = new Part(words);
					
					if(partsMap.containsKey(p)) {
						partsMap.put(p, partsMap.get(p) + 1);

					}
					else
						partsMap.put(p,1);
				}
		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			//out.println(e);
		}
		catch( RuntimeException e )
		{
			//out.println(e);
		}
		catch( Exception e )
		{
			//out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}
	
	public String toString()
	{
		String output="";
		Set<Part> tempSet;
		tempSet = partsMap.keySet();
		//map into set
		for(Part a: tempSet) {
			output += "" + a + " - " + partsMap.get(a) + "\n";
		}
		
		return output;
	}
}