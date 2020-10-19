//Name: 
//Per: 
//Date: 
//AP Computer Science

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class BiDirectionalGraph
{
	private TreeMap<String, TreeSet<String>> map;
	private boolean connectionFound;
	String start, stop;

	public BiDirectionalGraph(String line)
	{
		//TODO
		map = new TreeMap<String, TreeSet<String>>();
		
		String [] list = line.split(" ");
		for(int i = 0; i < list.length; i+=2)
		{
			if(!contains(list[i] + ""))
			{
				TreeSet n = new TreeSet<String>();
				n.add(list[i+1] + "");
				map.put(list[i] + "", n);
			}
			else
			{
				map.get(list[i] + "").add(list[i+1] + "");
			}
			
			if(!contains(list[i+1] + ""))
			{
				TreeSet n = new TreeSet<String>();
				n.add(list[i] + "");
				map.put(list[i+1] + "", n);
			}
			else
			{
				map.get(list[i+1] + "").add(list[i] + "");
			}
//			count++;
		}
	}
	
	public boolean contains(String l) 
	{
		if(map.containsKey(l))
			return true;
		return false;
	}
	
	public void setValues(String first, String second)
	{
		start = first;
		stop = second;
	}
	
	public boolean connected(String first, String second, String placesUsed)
	{
		//TODO
		connectionFound = false;
		//TODO
		if(map.get(first).contains(second) || map.get(second).contains(first))
		{
			return true;
		}
		else
		{
//			TreeSet<String> l = map.get(first);
			
			for(String l: map.get(first))
			{
				placesUsed += first + second + " " + second + first + " ";
//				String[] a = l.toArray();
				first = l;
				if(!placesUsed.contains(first + second) && !placesUsed.contains(second + first))
				{
					//shortest++;
					connectionFound = connected(first, second, placesUsed);
					if(connectionFound)
					{
						return true;
					}
				}
			}
		}
		return connectionFound;
	}

	
	
	public String toString()
	{
//		System.out.println(map);
		if(connected(start, stop, ""))
			return start + " CONNECTS TO " + stop + " == YAH";
		return start + " CONNECTS TO " + stop + " == NAH";
	}
}