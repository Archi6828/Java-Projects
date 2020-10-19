//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.util.*;

public class GCF {
	//instance variables, constructors, and other methods not shown 
	
	public static int gcf(int n1, int n2) {
            int r = n1 % n2;
		if(r == 0)
                    return n2;
                else
		return gcf(n2,r);
	}
}
