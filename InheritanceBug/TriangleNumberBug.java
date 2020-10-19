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

public class TriangleNumberBug extends NumberBug
{
	private int steps;
	private int maxSteps;
	
	public TriangleNumberBug(int num)
	{
	   super(num);
	   setDirection(Location.SOUTH);	   
	   maxSteps=1;
	   steps=1;
	}

	public TriangleNumberBug(int num, Color color)
	{
		super(num,color);
		setDirection(Location.SOUTH);	   
		   maxSteps=1;
		   steps=1;
	}

	public void move()
	{		
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(Location.SOUTH);
		maxSteps =10;
		
		if(canMove() && steps == 1)
		{
			moveTo(loc.getAdjacentLocation(Location.SOUTH));
			leaveNumberBehind(gr, loc);
			setDirection(90);
			timesCalled();
			//steps = 2; 
		}
		else if(canMove() && getDirection() == Location.EAST && steps == 2)
			{
				moveTo(loc.getAdjacentLocation(Location.EAST));
				leaveNumberBehind(gr, loc);
				setDirection(135);
				timesCalled();
				//steps = 3;
			}
		else if(canMove() && getDirection() == Location.SOUTHEAST && steps == 3)
				{
					moveTo(loc.getAdjacentLocation(Location.SOUTHEAST));
					leaveNumberBehind(gr, loc);
					setDirection(Location.WEST);
					timesCalled();
				}
		else if(canMove() && getDirection() == Location.WEST && steps == 4 || steps == 5)
		{
			moveTo(loc.getAdjacentLocation(Location.WEST));
			leaveNumberBehind(gr, loc);
			timesCalled();
			if(steps == 6)
			{
				setDirection(Location.SOUTH);
				timesCalled();
			}
			
		}
		else if(canMove() && getDirection() == Location.SOUTH && steps == 7)
		{
			moveTo(loc.getAdjacentLocation(Location.SOUTH));
			leaveNumberBehind(gr, loc);
			setDirection(Location.EAST);
			timesCalled();
		}
		else if((canMove() && getDirection() == Location.EAST) && steps < maxSteps+1)
		{
			moveTo(loc.getAdjacentLocation(Location.EAST));
			leaveNumberBehind(gr, loc);
			timesCalled();
		}
		else if(steps == 11 && steps < 12)
		{
			setDirection(Location.SOUTHEAST);
			moveTo(loc.getAdjacentLocation(Location.SOUTHEAST));
			leaveNumberBehind(gr, loc);
			
			setDirection(Location.SOUTHEAST);
			timesCalled();
		}
			
		System.out.println(steps);
		}
	public void timesCalled()
	{
			steps++;
	}
	
	
	public boolean canMove()
	{
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		
		if(gr.isValid(next))
			return true;
		else
			return false;
	}
}
