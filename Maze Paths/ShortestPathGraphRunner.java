//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

public class ShortestPathGraphRunner
{
	public static void main( String[] args )
	{
		ShortestPathGraph test = new ShortestPathGraph("CA XY RS YS ST TB AB BD RJ");
		test.setValues("C","D");
		System.out.println(test);
		
		//TODO: add more test cases
		ShortestPathGraph test1 = new ShortestPathGraph("PQ QX AX BH CH DX EX FX GH AB BC CD DE AE CE FD TH");
		test1.setValues("P","T");
		System.out.println(test1);
		
		ShortestPathGraph test2 = new ShortestPathGraph("AE EI IO OU BC CD DF FG");
		test2.setValues("A","G");
		System.out.println(test2);
		
		ShortestPathGraph test3 = new ShortestPathGraph("HI HJ HK KQ KM KN MO MP MQ");
		test3.setValues("H","Q");
		System.out.println(test3);
		
//		ShortestPathGraph test4 = new ShortestPathGraph("HI HJ HK KL KM KN MO MP MQ");
//		test4.setValues("H","Q");
//		System.out.println(test4);
//		
//		ShortestPathGraph test5 = new ShortestPathGraph("HI HJ HK KL KM KN MO MP MQ");
//		test5.setValues("H","Q");
//		System.out.println(test5);
//		
//		ShortestPathGraph test6 = new ShortestPathGraph("HI HJ HK KL KM KN MO MP MQ");
//		test6.setValues("H","Q");
//		System.out.println(test6);
	}
}