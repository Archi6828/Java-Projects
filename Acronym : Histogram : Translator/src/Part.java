//Name: Archita Bathole
//Per: 1
//Date: 3/13/18
//AP Computer Science

public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;

	public Part(String line) 
	{
		String[] list = line.split(" ");
		rest = "";
		for(int i = 0; i < list.length; i++) {
			//year
			if(list[i].length() == 4 && (list[i].startsWith("1") || list[i].startsWith("2"))) {
				year = Integer.parseInt(list[i]);
			}
			//make
			else if(list[i].equals("Ford") || list[i].equals("Chevy") || list[i].equals("Dodge")) {
				make = list[i] + " " + list[i+1];
				i++;
			}
			else {
				//rest
				
				rest += list[i] + " ";
			}
		}

	}

	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{
		if(!make.equals(rhs.make)) {
			return make.compareTo(rhs.make);
		}
		if(year < rhs.year)
			return 1;
		if(year > rhs.year)
			return -1;
		if(!rest.equals(rhs.rest)) {
			return rest.compareTo(rhs.rest);
		}
		return 0;
	}

	public String toString()
	{
		return make + " " + year + " " + rest;
	}
}