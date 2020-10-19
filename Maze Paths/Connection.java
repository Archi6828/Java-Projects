//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Connection
{
	private TreeMap<String, ArrayList<String>> map;
	private boolean connectionFound;
	String start, stop;
	
	public Connection(String line)
	{
		//TODO
		map = new TreeMap<String, ArrayList<String>>();
		
		String [] list = line.split(" ");
		
		for(String a: list)
		{
			if(!contains(a.charAt(0) + ""))
			{
				ArrayList n = new ArrayList<String>();
				n.add(a.charAt(1) + "");
				map.put(a.charAt(0) + "", n);
			}
			else
			{
				map.get(a.charAt(0) + "").add(a.charAt(1) + "");
			}
			
			if(!contains(a.charAt(1) + ""))
			{
				ArrayList n = new ArrayList<String>();
				n.add(a.charAt(0) + "");
				map.put(a.charAt(1) + "", n);
			}
			else
			{
				map.get(a.charAt(1) + "").add(a.charAt(0) + "");
			}
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
		//TODO
		start = first;
		stop = second;
	}
	
	public boolean connected(String first, String second, String placesUsed)
	{
		connectionFound = false;
		//TODO
		if(map.get(first).contains(second) || map.get(second).contains(first))
		{
			return true;
		}
		else
		{
			ArrayList<String> l = map.get(first);
			
			for(int i = 0; i < l.size(); i++)
			{
				placesUsed += first + second + " " + second + first + " ";
				
				first = l.get(i);
				if(!placesUsed.contains(first + second) && !placesUsed.contains(second + first))
				{
					connectionFound = connected(first, second, placesUsed);
					if(connectionFound)
						return true;
				}
			}
		}

		return connectionFound;
	}
	
	
	public String toString()
	{
//		System.out.println(map);
		if(connected(start, stop, ""))
			return start + " connects to " + stop + " == yes";
		return start + " connects to " + stop + " == no";
	}
}