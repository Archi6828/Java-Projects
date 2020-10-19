// Name: Archita Bathole
// Date: 3/15/18
// Per: 1
// AP Computer Science

import java.util.LinkedList;
import java.util.Scanner;

public class HashTable
{
	private LinkedList[] table;

	public HashTable( )
	{
		table = new LinkedList[10];
		for( int i = 0; i < 10; i ++ )
			table[i] = new LinkedList<Object>();
	}

	public void add(Object obj)
	{
		LinkedList list = new LinkedList();
		//num
		int row = obj.hashCode();

		for(int j = 0; j < table.length; j++) {
			if(j == row) {
//				if(table[j] == null) {
//					list.add(obj);
//					table[j] = list;
//				}
//				else{
					boolean flag = true;
					for(Object a: table[row]) {
						if(a.equals(obj))
							flag = false;
					}
					
					if(flag) {
						LinkedList temp = table[j];
						temp.add(obj);
						table[j] = temp;
					    }
				  //  }
			   }
		   }
}	
	
	public String toString()
	{
		String output="HASHTABLE\n";
		
		for(int i = 0; i < 10; i++)
		{
			output += "bucket " + i + " ";
			//System.out.println(table[i]);
			for(int j = 0; j < table[i].size(); j++)
			{
				output += table[i].get(j);
				
				if(j < table[i].size())
					output += " ";
			}
			if(i < table.length)
				output += "\n";
		}
		
		return output;
	}
}
