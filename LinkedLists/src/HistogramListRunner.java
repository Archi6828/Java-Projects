// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

public class HistogramListRunner
{
	public static void main(String[] args)
	{
		HistogramList test = new HistogramList();
		String testString = "ABCDEFABCDEFFEDCBAAAAABBBBBCCCDAAAAAAAEEFFF";
		for(char c : testString.toCharArray())
		{
			test.add(c);
		}
		System.out.println(test);


		//add more test cases
		/*
		test.add("A");
		test.add("A");
		test.add("A");
		test.add("A");
		test.indexOf("C");
		test.remove('D');
		System.out.println(test);*/
		
		//demonstrate bad data check
		test = new HistogramList();
		test.add("dog");
		test.add(33);
		test.add(3.4);
		System.out.println(test);
	}
}