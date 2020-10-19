//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

public class ChickenCounter {
	public static int countChickens(String word) {
		if(word.indexOf("chicken") != -1)
		{
			word = word.substring(0,word.indexOf("chicken")) + word.substring(word.indexOf("chicken") + "chicken".length() );
            return 1 + countChickens(word);
		}
		return 0;
        }
}


