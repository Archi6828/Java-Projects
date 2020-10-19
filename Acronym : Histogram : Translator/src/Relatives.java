//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Scanner;
import static java.lang.System.*;

public class Relatives
{
	private Map<String,Set<String>> map;

	public Relatives()
	{
		map = new HashMap<String,Set<String>>();
	}

	public void setPersonRelative(String line)
	{
		String[] personRelative = line.split(" ");
		Set<String> testSet = new HashSet<String>();
		
		if(map.get(personRelative[0]) == null) {
			testSet.add(personRelative[1]);
			map.put(personRelative[0], testSet);
		}
		else {
			map.get(personRelative[0]).add(personRelative[1]);
		}
	} 


	public String getRelatives(String person)
	{
		
		return person + " is related to " + "" + map.get(person);
	}


	public String toString()
	{
		String output="";
		Set<String> tempSet;
		tempSet = map.keySet();
		//map into set
		for(String a: tempSet) {
			output += getRelatives(a) + "\n";
		}
		
		return output;
		/*
		String output="";
		Set<String> tempSet;
		tempSet = map.keySet();
		//map into set
		for(String a: tempSet) {
			output += "" + getRelatives(a) + "\n";
		}
		
		return output;
		*/
	}
}