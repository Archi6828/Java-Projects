//Name: Archita Bathole 
//Date: 9/ 1/ 17
//Per: 1
//AP Comp Sci

import java.awt.Color; 
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;

public class ColumnRowNumberBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.add(new Location(1,0), new ColumnRowNumberBug(1, Color.GREEN));
		world.add(new Location(3,5), new ColumnRowNumberBug(3, Color.YELLOW));
		world.show(); 
	}
}