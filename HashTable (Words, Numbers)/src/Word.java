// Name: Archita Bathole
// Date: 3/15/18
// Per: 1
// AP Computer Science

public class Word
{
	private String theValue;
	
	//write a constructor method
	public Word(String value)
	{
		theValue = value;
	}

	//write the getValue method
	public String getValue() {
		return theValue;
	}
	
	//write the equals method
	public boolean equals(Object obj)
	{
		if(((Word) obj).getValue().equals(theValue))
			return true;
		return false;
	} 

	//write the hashCode method
	public int hashCode()
	{
		int count = 0;
		for(int i = 0; i < theValue.length(); i++) {
			if(theValue.charAt(i) == 'a')
				count++;
			else if(theValue.charAt(i) == 'e')
				count++;
			else if(theValue.charAt(i) == 'i')
				count++;
			else if(theValue.charAt(i) == 'o')
				count++;
			else if(theValue.charAt(i) == 'u')
				count++;
		}
	//	System.out.println("length" + " " + theValue.length() + " " + theValue);
		/*
		String vowels = "aeiou";
		int count = 0;
		for(int i = 0; i < theValue.length(); i++) {
			for(int j = 0; j < vowels.length(); j++) {
				if(theValue.charAt(i) == vowels.charAt(j))
					count++;
			}
		}
		*/
		int rem = (count * theValue.length()) % 10;
		//System.out.println(rem + " " + rem + " " + theValue);
		return rem;
	}
	
	
	//write the toString method
	public String toString()
	{
		return "" + theValue;
	}
	
}