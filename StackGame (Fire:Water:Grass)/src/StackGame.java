import java.util.*;
public class StackGame {
private int size;
private Stack<String> stack;
private int bonus;
int x;
public StackGame() {
	stack=new Stack<String>();
	size=(int)Math.random()*6+5; //size 5 stack
	int count=0;
	bonus=0;
	
	while(count!=size)
	{
		int add=(int)(Math.random()*3);
		if(add==0)
		stack.add("fire");
		else if(add==1)
		stack.add("water");
		else
		stack.add("grass");
		count++;
	}
	System.out.println(stack);
}
public void startGame()
{
	Scanner guess=new Scanner(System.in);
	String input="something";
	System.out.println("Welcome to StackBreaker.\n Your goal is to reduce \n the stack size to zero by entering the opposite element of the one \n that is on top of the stack. If you fail to enter the opposite \n element,\n then your input will be added to the stack, so be \n careful!");
	System.out.println();
	while(stack.size()>0&&!input.equals("quit"))
	{
		System.out.println("The stack currently has "+stack.size()+" elements.");
		System.out.println("Please choose an element: fire, water, grass. Type \"quit\" to exit.");
		input=guess.nextLine();
		if(input.equals("quit"))
		{
			System.out.println();
		}
		else if(input.equals("fire") && stack.peek().equals("grass"))
		{
			bonus++;
			System.out.println();
			System.out.println("Good job! You guessed it correctly!");
			stack.pop();
			System.out.println("The stack now has "+stack.size()+" elements.");
		}
		else if(input.equals("water") && stack.peek().equals("fire"))
		{
			bonus++;
			System.out.println();
			System.out.println("Good job! You guessed it correctly!");
			stack.pop();
			System.out.println("The stack now has "+stack.size()+" elements.");
		}
		else if(input.equals("grass") && stack.peek().equals("water"))
		{
			bonus++;
			System.out.println();
			System.out.println("Good job! You guessed it correctly!");
			stack.pop();
			System.out.println("The stack now has "+stack.size()+" elements.");
		}
		else if(input.equals("fire")||input.equals("water")||input.equals("grass"))
		{
			stack.add(input);
			bonus--;
			System.out.println("You failed to match the proper element. Placing \n your guess on top of the stack now...");
		}
		else
		{
			System.out.println("Please enter a valid input.");
		}
		if(bonus==2&&!stack.isEmpty())
		{
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Congratulations! You have successfully removed an \n element from the stack!\n Would you like to answer a bonus riddle to \n remove an extra element from the stack? Answer \"yes\" or\"no\"");
			input=guess.nextLine();
		if(input.equals("yes"))
		{
			System.out.println(riddle());
			input=guess.nextLine();
			if(answer().equals(input))
			{
				System.out.println("Great job! You solved the riddle, and removed an \n additional element from the stack!");
				stack.pop();
			}
			else
				System.out.println("Better luck next time!");
			}
				System.out.println();
				System.out.println("Thanks for playing the bonus game! Now back to  \n StackBreaker...");
				System.out.println();
				bonus=0;
			}
	}
	System.out.println("Thanks for playing StackBreaker! GG");
}
public String riddle()
{
	x=(int)(Math.random()*6);
	if(x==0)
		return "I get bigger when I eat, but get weaker when I drink. What element am I?";
	else if(x==1)
		return "Wash it and it isn't clean. Don't wash it and then it's clean. What I Am?";
	else if(x==2)
		return "I have blades but I’m not a fan\r\n" +
		"I get cut but I’m not hair\r\n" +
		"I get walked on but I’m not carpet";
	else if(x==5)
		return  "Many sports on it are played\r\n" +
		"Even though it’s what gets cut\r\n" +
		"A piece of it’s called a blade";
	else if(x==4)
		return "If you go to Niagara Falls\r\n" +
		"You’ll see lots of this in motion\r\n" +
		"You also see it in a bath\r\n" +
		"In a glass and in the ocean";
	else if(x==3)
		return "I eat, I live, I breathe, I live, I drink, I die what am I?";
	return null;
}
public String answer()
{
	if(x==0||x==3)
		return "fire";
	else if(x==1||x==4)
		return "water";
	else if(x==2||x==5)
		return "grass";
return null;
}
	public static void main(String[]args)
	{
		StackGame game=new StackGame();
		game.startGame();
	}
}
