//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

public class Maze
{
	private int[][] maze;
	private boolean exitFound;
	
	public Maze(int[][] m)
	{
		//TODO
		maze = m;
	}
	
	public boolean checkForExitPath(int r, int c)
	{
		//TODO
		exitFound = false;
		if(valid(r,c))
		{
				//visited
				maze[r][c] = 4;
				//System.out.println(" maze.length "  + maze.length  + " " + " maze[0].length " + maze[0].length);	(r == maze.length - 1 && c >= 0 && c < maze[0].length) ||  
				if((c == maze[0].length - 1 && r >= 0 && r < maze.length))
				{
					//System.out.println(" DONE \n"  + printMaze());
					return true;
				}
				else
				{
					exitFound =	checkForExitPath(r -1, c) || checkForExitPath(r + 1, c) || checkForExitPath(r, c - 1) || checkForExitPath(r, c + 1);
				}
				
				if(exitFound)
					maze[r][c] = 1;
		}
	
//		System.out.println(" r "  + r  + " " + " c " + c);
//		System.out.println(" this \n"  + printMaze());
		return exitFound;
	}
	
	//to check validity
	public boolean valid(int r, int c)
	{
		if(maze.length > r && r >= 0 && maze[0].length > c && c >= 0 && maze[r][c] == 1)
		{
			
			return true;
		}
		return false;
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
		
		if(checkForExitPath(0, 0))
			returnString += "Exit found";
		else
			returnString += "Exit not found";
		
		return returnString;
	}
}