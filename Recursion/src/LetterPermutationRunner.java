//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.util.*;

public class LetterPermutationRunner {
	public static void main(String args[]) {
		//add test cases	  
		LetterPermutation a = new LetterPermutation("ABC");
		a.permutation();
		a.toString();
		LetterPermutation b = new LetterPermutation("abc");
		b.permutation();
		b.toString();
		LetterPermutation c = new LetterPermutation("boat");
		c.permutation();
		c.toString();
		LetterPermutation d = new LetterPermutation("it");
		d.permutation();
		d.toString();
	}
}