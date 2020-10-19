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

public class RowColumnNumberBug extends NumberBug
{
	public RowColumnNumberBug(int num)
	{
	   super(num,Color.GREEN);
	   //set the direction to EAST  
	   setDirection(90);
	}
	
	public RowColumnNumberBug(int num, Color color)
	{
		super(num, color);
		setDirection(90);
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
		else if(getDirection() == 90)
		{
			setDirection(180);
			moveTo(loc.getAdjacentLocation(getDirection()));
			leaveNumberBehind(gr, loc);
			setDirection(270);
		}
		else
		{
			setDirection(270-90);
			moveTo(loc.getAdjacentLocation(getDirection()));
			leaveNumberBehind(gr, loc);
			setDirection(270-180);
		}
	}
}