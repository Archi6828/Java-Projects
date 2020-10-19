//Name: Archita Bathole
//Per: 1
//Date: 4/10/18
//AP Computer Science

class Node
{
	int height;
	String key, def;
	Node left, right;
	
	Node(String k, String d)
	{
		key = k;
		def = d;
		height = 1;
	}
	
	public String getDef() {
		Dictionary test = new Dictionary(key);
		def = test.getSavedWord();
		return def;
	}
}