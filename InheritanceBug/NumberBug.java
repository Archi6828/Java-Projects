//Name: Archita Bathole 
//Date: 9/ 1/ 17
//Per: 1
//AP Comp Sci

import java.awt.Color;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class NumberBug extends Bug
{
	private Number number;
	
	public NumberBug()
	{
		super(Color.ORANGE);
		//instantiate a new number
		number = new Number(1);
	}
	
	public NumberBug(int num)
	{
		super(Color.YELLOW);	
		number = new Number(num);
	}

	public NumberBug(int num, Color color)
	{
		super(color);
		number = new Number(num, color);
	}
	
	public NumberBug(int num, Color color, Color c)
	{
		super(color);
		number = new Number(num, color, c);
	}
	
	public void leaveNumberBehind(Grid<Actor> grid, Location loc)
	{
		grid.put(loc, number);
		Color textColor = number.getTextColor();
		Color c = number.getColor();
		int num = number.getNum();
		
		number = new Number(num + 1, c, textColor);
	}
	
	public void move()
	{
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		
	   if(canMove())
	   {
		   moveTo(next);
		   leaveNumberBehind(gr, loc);
	   }
	   else
	   {
		  turn();
	   }
	}
}