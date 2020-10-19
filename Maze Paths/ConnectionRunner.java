//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

public class ConnectionRunner
{
	public static void main( String[] args )
	{
		Connection test = new Connection("CA XY RS YS ST TB AX BD RJ");
		test.setValues("C","D");
		System.out.println(test);
		
		//TODO: add more test cases
		Connection test1 = new Connection("PQ QX AX BX CX DX EX FX GX AB BC CD DE AE CE FD TG");
		test1.setValues("P","T");
		System.out.println(test1);
		
		Connection test2 = new Connection("AE EI IO OU BC CD DF FG");
		test2.setValues("A","G");
		System.out.println(test2);
		
		Connection test3 = new Connection("HI HJ HK KL KM KN MO MP MQ");
		test3.setValues("H","Q");
		System.out.println(test3);
		
	}
}