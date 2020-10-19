import java.util.Arrays;

//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

public class AtCounter {
	private String[][] atMat;
	
	public AtCounter(int rows, int cols) {
		// size the matrix
		// use nested loops to randomly load the matrix
		// you will need to use Math.random()
                atMat = new String[rows][cols];
                for(int r = 0; r < rows; r++)
                {
                    for(int c = 0; c < cols; c++)
                    {
                        int i = (int)(Math.random() * 2 + 1);
                        if(i == 1)
                            atMat[r][c] = "@";
                        if(i == 2)
                            atMat[r][c] = "-"; 
                       
                    }
                }
	}
	
	public int countAts(int r, int c) {
		// add in recursive code to count up the # of @s connected
		// start checking at spot [r,c]
               
                if(r >= 0 && c >= 0 && r < atMat.length && c < atMat[r].length && "@".equals(atMat[r][c]))
                {
                    atMat[r][c] = "*";
                    return 1 + countAts(r,c-1) + countAts(r - 1,c) + countAts(r,c + 1) + countAts(r + 1,c);
                 
                }
		return 0;
	}
	
	/* this method will return all values in the matrix this method should
	 * return a view of the matrix that looks like a matrix */
	public String toString() {
            String answer = "";
        
             for(int r = 0; r < atMat.length; r++)
                {
                    for(int c = 0; c < atMat[r].length; c++)
                    {
                        answer += " " + atMat[r][c];
                    }
                    answer += "\n";
                }
	return answer;
	}
}
