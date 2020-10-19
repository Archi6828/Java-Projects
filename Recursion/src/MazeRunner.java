//Name: Archita Bathole
//Per: 1
//Date: 11/8/17
//AP Computer Science

import java.io.IOException;

public class MazeRunner {
	public static void main(String args[]) throws IOException {
            Maze a = new Maze(5, "1000111110001010111000001");
            //a.hasExitPath(0, 0);
            System.out.println(a.toString());
            
            Maze b = new Maze(7,"1000011111101000100100111010010101001011100101001");
        // b.hasExitPath(0, 0);
            System.out.println(b.toString());
         
	}
}
