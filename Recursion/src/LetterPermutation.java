//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.util.*;

public class LetterPermutation {
	private String orig;
	private String list;
	
	public LetterPermutation(String word) {
		orig = word;
		list = "";
	}
	
	public void permutation() {
		System.out.println("\nPERMUTATION OF WORD :: " + orig);
		permutation(orig, "");
	}
	
	private void permutation(String orig, String sent) {
		if(orig.length() == sent.length())
			System.out.println(sent);
		else
			for(int i = 0; i < orig.length(); i++)
			{
				if(!sent.contains(Character.toString(orig.charAt(i))))
					 permutation(orig, sent + Character.toString(orig.charAt(i)));
			}
	}
	
	public String toString() {
		return list;
	}
}