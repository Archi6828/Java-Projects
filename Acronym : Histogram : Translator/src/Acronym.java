//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Set;

public class Acronym
{
	private Map<String,String> acronymTable;

	public Acronym()
	{
		acronymTable = new HashMap<String, String>();
	}

	public void putEntry(String entry)
	{
		String[] words = entry.split(" - ");
		acronymTable.put(words[0], words[1]);
		//System.out.println(words[0] + " " + words[1]);
	}

	public String convert(String sent)
	{
		Scanner chop = new Scanner(sent);
		String acro = "";  // chop.next();
		String output ="";
		while(chop.hasNext()) {
			acro = chop.next();
			if(acronymTable.containsKey(acro))
			{
				output += acronymTable.get(acro) + " ";
			}
			else {
				if(acro.contains(".") && acronymTable.containsKey(acro.substring(0, acro.length()-1)))
					output += acronymTable.get(acro.substring(0, acro.length()-1)) + ". ";
				else
					output += acro + " ";
			}
			//acro = chop.next();
		}
		return output;
	}

	public String toString()
	{
		String output="";
		Set<String> tempSet;
		tempSet = acronymTable.keySet();
		//map into set
		for(String a: tempSet) {
			output += "" + a + " = " + acronymTable.get(a) + "\n";
		}
		
		return output;
	}
}