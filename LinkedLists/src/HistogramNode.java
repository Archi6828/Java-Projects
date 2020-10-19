// Name: Archita Bathole
// Date: 9/12/17
// Per: 1
// AP Computer Science

public class HistogramNode
{
	private char letter;
	private int letterCount;
	private HistogramNode next;

	public HistogramNode(char let, int cnt, HistogramNode n)
	{
		letter=let;
		letterCount=cnt;
		next=n;
	}

	public char getLetter()
	{
		return letter;
	}

	public int getLetterCount()
	{
		return letterCount;
	}

	public HistogramNode getNext()
	{
	   return next;
	}

	public void setLetter(char let)
	{
		letter=let;
	}

	public void setLetterCount(int cnt)
	{
		letterCount=cnt;
	}

	public void setNext(HistogramNode n)
	{
		next = n;
	}
}


