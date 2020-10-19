// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

import java.util.LinkedList;

public class Basic
{
	private LinkedList<Integer> list;

	public Basic()
	{
		list = new LinkedList<Integer>();
	}

	public Basic(int[] nums)
	{
		list = new LinkedList<Integer>();
		for(int num : nums)
		{
			list.add(num);
		}
	}

	public double getSum(  )
	{
		double total=0;
                for(int i = 0; i < list.size(); i++)
                {
                    total += list.get(i);
                }
		return total;
	}

	public double getAvg(  )
	{
            double avg = 0;
            
            if(list.size() >= 1)
                avg = getSum() / (list.size());
		return avg;
	}

	public int getLargest()
	{
		int largest=Integer.MIN_VALUE;
                for(int i = 0; i < list.size(); i++)
                {
                    if(list.get(i) > largest)
                        largest = list.get(i);
                }
		return largest;
	}

	public int getSmallest()
	{
		int smallest = smallest=Integer.MAX_VALUE;
                for(int i = 0; i < list.size(); i++)
                {
                    if(list.get(i) < smallest)
                        smallest = list.get(i);
                }
		return smallest;
	}

	public String toString()
	{
		String output= "Sum " + getSum() + "\nAverage: " + getAvg() + "\nSmallest: " + getSmallest() + "\nLargest: " + getLargest();
		return output;
	}
}
