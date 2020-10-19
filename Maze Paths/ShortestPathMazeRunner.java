//Name: Archita Bathole
//Per: 1
//Date: 5/29/18
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShortestPathMazeRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("maze2.dat"));
		while(file.hasNext())
		{
			//TODO
			int rc = file.nextInt();
			int[][] maze = new int[rc][rc];
			file.nextLine();
			
			for(int r= 0; r < rc; r++)
			{
				for(int c =0; c < rc; c++)
				{
					maze[r][c]=file.nextInt();
				}
				file.nextLine();
			}

			ShortestPathMaze test = new ShortestPathMaze(maze);
			test.checkForExitPath();
			
			System.out.println(test + "\n");
		}
	}
}