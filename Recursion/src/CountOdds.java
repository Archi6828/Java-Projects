//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

public class CountOdds {
	public static int countOddDigits(int num) {
           int i = num % 10;
           num = num / 10;
            if(i > 0)
            {
                if(i % 2 != 0)
                {
                    return 1 + countOddDigits(num);
                }
                return 0 + countOddDigits(num);
            }
            return 0;
	}
}
