//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

public class Maze {
	private int[][] maze;
	
	public Maze(int size, String line) {
            int i = 0;
            maze = new int[size][size];
		for(int r = 0; r < size; r++)
                {
                    for(int c = 0; c < size; c++)
                    {
                        if(i < line.length())
                            maze[r][c] = Character.getNumericValue(line.charAt(i++)); //Integer.parseInt(Character.toString(line.charAt(c)));
                       // System.out.print(maze[r][c]);
                    }
                    
                }
	}
	 
	public boolean hasExitPath(int r, int c) {
		boolean flag = false;
		
		
		 if(r >= 0 && c >= 0 && r < maze.length && c < maze.length && maze[r][c] == 1)  
            {
            		
                maze[r][c] = 5;
                
                if(c == maze.length - 1 && maze[r][c] == 5)
					return true; 
                return hasExitPath(r,c + 1) || hasExitPath(r + 1,c) || hasExitPath(r - 1,c);
               
            }
		
            
            //System.out.println(flag);
		return flag;
	}
	
	
	public String toString() {
		
		String output = "";
                  for(int r = 0; r < maze.length; r++)
                {
                    for(int c = 0; c < maze.length; c++)
                    {
                        output += " " + maze[r][c];
                    }
                    output += "\n";
                }
        int r = 0;
		int c = 0;
		if(hasExitPath(r,c))
		{
        		return output + "exit found";
		}
		else
		{
		return output + "exit not found";
		}
	}
}
