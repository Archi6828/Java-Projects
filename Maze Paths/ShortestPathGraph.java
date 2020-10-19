//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class ShortestPathGraph
{
	private TreeMap<String, ArrayList<String>> map;
	private boolean connectionFound;
	private int shortest;
	String start, stop;

	public ShortestPathGraph(String line)
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
	
	public int isConnected(String first, String second, String placesUsed, int path)
	{
		int temp = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		//TODO
		
		if(!connected(first, second, placesUsed))
		{
			return 0;
		}
		
		if(map.get(first).contains(second))
			return 1 + path;
		else
		{
			
			for(String a: map.get(first))
			{
				if(placesUsed.indexOf(a) == -1)
				{
					placesUsed +=  a;
					temp = isConnected(a, second, placesUsed, path + 1);
				}
				if(temp != 0 && temp < min)
					min = temp;
			}
		}
		return min;
	}
	
	public String toString()
	{
		int temp = isConnected(start, stop, "", 0);
		//System.out.println(temp);
		if(temp != Integer.MAX_VALUE)
			shortest = temp;
		if(connected(start, stop, ""))
		{
			return start + " connects to " + stop + " == yes in " + shortest + " steps";
		}
		return start + " connects to " + stop + " == no";
	}
}