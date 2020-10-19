//Name: Archita Bathole
//Date: 8/30/17
//Per: 1
//AP Comp Sci

import java.awt.Color;
import info.gridworld.actor.Actor;

public class Number extends Actor
{
	private int number;
	private Color textColor;
	
	public Number(int num)
	{
		setColor(Color.YELLOW);
		number=num;
		textColor=Color.BLUE;
	}
	
	//add the remaining constructors
	public Number(int num, Color color)
	{
		setColor(color);
		number = num;
		textColor = Color.BLUE;
	}
	
	public Number(int num, Color color, Color c)
	{
		setColor(color);
		number = num;
		textColor = c;
	}
	
		
	
	//add set methods
	
	public int getNum()
	{
		return number;
	}
	
	
	public String getText()
	{
		return ""+ number;
	}
	
	public Color getTextColor()
	{
		return textColor;
	}	
}