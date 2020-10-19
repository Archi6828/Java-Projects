//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

public class ShortestPathMaze
{

	private int[][] maze;
	private int[][] m;
	private int shortest;
	boolean exitFound;
	
	public ShortestPathMaze(int[][] a)
	{
		shortest = Integer.MAX_VALUE;
		//TODO
		maze = a;
		m = new int[maze.length][maze.length];
		
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze.length; c++)
			{
				m[r][c] = Integer.MAX_VALUE;
			}
		}
	}
	

	
	//checking last c
	public void checkForExitPath()
	{
		//TODO
		checkForExitPath(0,0,1);
		
		int temp = m[0][maze.length - 1];
		
		for(int i = 0; i < maze.length; i++)
		{
			if(m[i][maze.length - 1] < temp)
				temp = m[i][maze.length - 1];
		}
		
		if(temp != Integer.MAX_VALUE)
			shortest = temp;
		else
			shortest =  0;
	}
	
	//to check validity
	public void checkForExitPath(int r, int c, int path)
	{

		if(maze.length > r && r >= 0 && maze[0].length > c && c >= 0 && maze[r][c] == 1 && m[r][c] > path)
		{
			m[r][c] = path;
			checkForExitPath(r -1, c, path + 1) ;
		    checkForExitPath(r + 1, c, path + 1);
		    checkForExitPath(r, c - 1, path + 1) ;
		    checkForExitPath(r, c + 1, path + 1);
		}
	}
	
	public String printMaze()
	{
		String output = "";
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[r].length; c++)
			{
				output += maze[r][c] + " ";
			}
			output += "\n";
		}
		return output;
	}
	
	public String toString()
	{
		String returnString = "";
		
		returnString += printMaze() + "";
		
		if(shortest != Integer.MAX_VALUE && shortest != 0)
			returnString += "shortest path of " + shortest;
		else
			returnString += "no path";
		
		return returnString;
	}
}