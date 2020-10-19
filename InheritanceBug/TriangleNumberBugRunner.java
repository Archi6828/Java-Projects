//Name: Archita Bathole 
//Date: 9/ 1/ 17
//Per: 1
//AP Comp Sci

import java.awt.Color;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;

public class TriangleNumberBugRunner
{
	public static void main(String[] args)
	{		
		ActorWorld world = new ActorWorld();
		world.add(new Location(1,1), new TriangleNumberBug(1, Color.RED));
		world.add(new Location(5,0), new TriangleNumberBug(6, Color.YELLOW));
		world.show();
	}
}