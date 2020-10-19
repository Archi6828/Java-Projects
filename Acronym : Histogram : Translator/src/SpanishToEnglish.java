//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;

public class SpanishToEnglish
{
	private Map<String,String> pairs;

	public SpanishToEnglish()
	{
		pairs = new HashMap<String, String>();


	}

	public void putEntry(String entry)
	{
		String[] list = entry.split(" ");
		pairs.put(list[0], list[1]);

	}

	public String translate(String sent)
	{
		Scanner chop = new Scanner(sent);
		String output ="";
		
		while(chop.hasNext()) {
			String word = chop.next();
			if(pairs.containsKey(word))
				output += pairs.get(word) + " ";
		}

		return output;
	}

	public String toString()
	{
		return pairs.toString().replaceAll("\\,","\n");
	}
}