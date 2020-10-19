//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Histogram
{
	private Map<String,Integer> histogram;

	public Histogram()
	{
		histogram = new HashMap<String, Integer>();
	}

	public Histogram(String sent)
	{
			setSentence(sent);
	}
	
	public void setSentence(String sent)
	{
		String[] list = sent.split(" ");
		
		//count
		int count = 0;
		for(int i = 0; i < list.length; i++) {
			for(int j = 0; j < list.length; j++) {
				if(list[i].equals(list[j]))
					count++;
			}
			histogram.put(list[i], count);
			count = 0;
		}
		//check
		//for(int i = 0; i < list.length; i++) {
		//	System.out.println(histogram.get(list[i]));
		//}
	}

	public String toString()
	{
		String temp="";
		String allStars="";
		String output = "";
		String output1 = "";
		int key = 0;
		temp += histogram.keySet();
		
		//add letters
		for(int i = 0; i < temp.length(); i++) {
			//System.out.println(temp.charAt(i));
			if(temp.charAt(i) != '[' && temp.charAt(i) != ']' && temp.charAt(i) != ',') {
				if(!output.contains(temp.charAt(i)+""))
				{
					
						output += temp.charAt(i);
				}
			}
		}
		output = output.substring(0, output.length());
		output.trim();
		//System.out.println(output);
		//print in format
		for(int i = 0; i < output.length(); i++) {
			int j = 0;
			//System.out.println(output.charAt(i));
			if(output.charAt(i) != ' ')
			{
				//check
				
				//System.out.println(histogram.get(output.charAt(i) + ""));
			int size = histogram.get(output.charAt(i) + "");
				while(j < size)
				{
					allStars += "*";
					j++;
				}
				System.out.println(output.charAt(i) + "    " + allStars);
				allStars = "";
			}
			
		}
		return output1;
	}
}