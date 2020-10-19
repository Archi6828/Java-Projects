//Name: Archita Bathole 
//Date: 9/ 1/ 17
//Per: 1
//AP Comp Sci

import java.awt.Color; 
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class ColumnRowNumberBug extends NumberBug
{
	public ColumnRowNumberBug(int num)
	{
		super(num);
		//set direction to SOUTH
		setDirection(getDirection() + 90);
  	}

	public ColumnRowNumberBug(int num, Color color)
	{
		super(num, color);
		setDirection(180);
	}

	public void act()
	{
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		
		
		
		if(gr.isValid(next))
		{
			moveTo(next);
			leaveNumberBehind(gr, loc);
		}
		else if(getDirection() == 180)
		{
			setDirection(90);
			moveTo(loc.getAdjacentLocation(getDirection()));
			leaveNumberBehind(gr, loc);
			setDirection(0);
		}
		else
		{
			setDirection(90);
			moveTo(loc.getAdjacentLocation(getDirection()));
			leaveNumberBehind(gr, loc);
			setDirection(180);
		}

	}
}