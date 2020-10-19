public class Tree 
{
	Node root;
	
	public Tree( String [] s )
	{
		
		Node [] nodes = new Node[ s.length ];
		
		for (int i = 0; i < s.length; i++) 
		{
			if( s[i].equals( "-1" ) )
				nodes[i] = null;
			else
				nodes[i] = new Node( s[i] );
		}
		
		
		for( int i = 0; i < nodes.length; i ++ )
		{
			if( nodes[i] != null )
			{
				if( 2*i + 1 < nodes.length )
					nodes[i].setNoNode( nodes[ 2*i + 1 ] );
				if( 2*i + 2 < nodes.length)
					nodes[i].setYesNode( nodes[ 2*i + 2 ] );
			}
		}
		
		root = nodes[0];

	}
	
	
	//insert node after this node  NOT SURE IF THIS WORKS (so the left node would have to always be the new node animal and yes node will be the current animal
	public void insertNode( Node n, String question, String animal ) 
	{
		n.setNoNode( new Node( n.getQuestion() ) );
		n.setYesNode( new Node( animal ) );
		n.setQuestion( question );
	}
	
	public Node getRoot()
	{
		return root;
	}
	
}

