import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
	public static void main( String [] args )
	{
		Node head = null, tail = null;
		Scanner s = new Scanner( System.in );
		int l = 0;
		
		try {
		//set up # of questions
		System.out.println( "How many questions do you want to ask?: " );
	    l = s.nextInt(); //CHECK IF VALID (number and positive)
		
		while( l <= 0 )
		{
			System.out.println( "Sorry, that is an invalid number, please enter another: " );
			l = s.nextInt(); //CHECK IF VALID (number and positive)
		}
		}
		catch(InputMismatchException exception)
		{
		  //Print "This is not an integer"
		  //when user put other than integer
		  System.out.println("This is not an integer.");
		  l = 1;
		}
		/*
		if(!s.hasNextInt()) {
	        System.out.println("Invalid input!");
	        System.out.print("Enter an integer: ");
	        return;
	    }
		*/
		
		//question array
		String [] q = new String[l];
		
		//clear scanner
		s.nextLine();
		
		//store questions
		for( int i = 0; i < q.length; i ++ )
		{
			System.out.println( "Please enter true/false question number " + (i+1) + ": " );
			String question = s.nextLine();
			
			q[i] = question;
		}

		
		boolean flag = true; //controls while loop
		
		//surveyors
		while( flag )
		{
			System.out.println( "Please enter your name: " );
			String name = s.nextLine();
			SurveyResponse sr = new SurveyResponse( name, l );
			
			try {
			//gets input for all questions
			for( int i = 0; i < l; i ++ ) 
			{
				System.out.println( "Please input true or false." );
				System.out.println( q[i] );
				boolean ans = s.nextBoolean();
				System.out.println(ans);
				//if(s.hasNextBoolean())
				//{
					sr.setAsnwer(i, ans);
				    s.nextLine();
				//}
				/*
				else
				{
					System.out.println("invalid answer!");
					System.out.print("Enter an integer: ");
					break;
				}
					*/
			}
			}
			catch(InputMismatchException exception)
			{
			  //Print "This is not an integer"
			  //when user put other than integer
			  System.out.println("This is not a boolean. Please retake the survey.");
			  return;
			}
			
			
			//adds responses to end of the linked list
			Node ans = new Node( sr );
			
			ans.setNext(head);
			head = ans;
			
//			if( head == null )
//				head = ans;
//			else
//			{
//				//tail.setNext( ans );
//				tail = ans;
//			}
			
			//checks whether to continue to next person or not
			System.out.println( "Enter \"yes\" to continue to next person and anything else to end." );
			String response = s.nextLine();
			
			response = response.toUpperCase();
			if( !response.equals( "YES" ) )
			{
				flag = false;
			}
		}
		
		
		//Calculate answers- counts number of people who responded and how many said true for each question
		Node temp = head;
		int numSurveyors = 0;
		int [] responses = new int [l];
		while( temp != null )
		{
			numSurveyors ++;
			SurveyResponse sr = temp.getValue();
			
			for( int i = 0; i < l; i ++ )
			{
				responses[i] += sr.getAnswer(i);
			}
			
			temp = temp.getNext();
		}
		
		//print answers
		System.out.println( numSurveyors + " took the survey." );
		for( int i = 0; i < l; i ++ )
		{
			System.out.println( responses[i] + " said true to " + q[i] );
		}
		
		
		
		
		
	}
}

