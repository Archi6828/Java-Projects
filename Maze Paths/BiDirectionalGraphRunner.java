//Name: 
//Per: 
//Date: 
//AP Computer Science

public class BiDirectionalGraphRunner
{
	public static void main( String[] args )
	{
		BiDirectionalGraph test = new BiDirectionalGraph("JON BOB BOB SALLY SALLY SUE");
		test.setValues("JON", "SUE");
		System.out.println(test);
		
		//TODO: add more test cases
		BiDirectionalGraph test1 = new BiDirectionalGraph("JON BOB JON SUE SALLY BOB");
		test1.setValues("SALLY", "SUE");
		System.out.println(test1);
		
		BiDirectionalGraph test2 = new BiDirectionalGraph("JON BOB JON SUE FRED SALLY");
		test2.setValues("SALLY", "SUE");
		System.out.println(test2);
		
		BiDirectionalGraph test3 = new BiDirectionalGraph("JON BOB TIM CHUCK JON SUE FRED SALLY");
		test3.setValues("SALLY", "CHUCK");
		System.out.println(test3);
		
		BiDirectionalGraph test4 = new BiDirectionalGraph("JON BOB TIM CHUCK JON SUE FRED SALLY TIM FRED");
		test4.setValues("SALLY", "CHUCK");
		System.out.println(test4);
	}
}