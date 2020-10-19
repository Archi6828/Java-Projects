//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BlockCounter {
	private String[][] grid;
	
	public BlockCounter() {
		int rows = (int)(Math.random() * 10 + 1);
		int cols = (int)(Math.random() * 10 + 1);

		grid = new String[rows][cols];
		
		for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
            		String random = "" + (int)(Math.random() * 5 + 1);
            		grid[r][c] =  random;
            		
            }
        }

	}
	
	public BlockCounter(int rows, int cols, String[] vals) {
		setGrid(rows, cols, vals);
		
	}
	
	public void setGrid(int rows, int cols, String[] vals) {
		int i = 0;
		grid = new String[rows][cols];
		for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
            		grid[r][c] = vals[i++];
            }
        }		
	}
	
	public int findMax(String val) {
		int max = 0;
		
		for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
            		int answer = findMax(r , c, val);
            			if(max < answer)
            				max = answer;	
            			if(grid[r][c] == "*")
            				grid[r][c] = val;
            }
        }
		
		return max;
	}
		
	private int findMax(int r, int c, String search) {
		if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && search.equals(grid[r][c]))
		{
			grid[r][c] = "*";
			return 1 + findMax(r + 1, c, search) + findMax(r, c + 1, search) + findMax(r - 1, c, search) + findMax(r, c - 1, search);
		}

		return 0;
	}
	
	public String toString() {
		String output = "";
		
		 for(int row = 0; row < grid.length; row++)
         {
             for(int col = 0; col < grid[row].length; col++)
             { 
                 output += " " + grid[row][col];
             }
             output += "\n";
         }
		
		return output;
	}
}