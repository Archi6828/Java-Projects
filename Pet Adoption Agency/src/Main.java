import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main 
{
	public static void main( String [] args ) throws IOException
	{
		Scanner input = new Scanner(System.in);
		
		PetAdoption p = new PetAdoption();
		createTree( p, "Irvine" );
		createTree( p, "Paris" );
		createTree( p, "Tokyo" );
		createTree( p, "Beijing" );
		
		boolean continueAdoption = true;
		
		while( continueAdoption )
		{
			System.out.println( "Would you like to adopt an animal(1) or put an animal up for adoption(2)?: " );
			int choice = input.nextInt();
			
			while( choice != 1 && choice != 2 )
			{
				System.out.println( "That is not a valid choice. Please input another choice: ");
				choice = input.nextInt();
			}
			
			input.nextLine();
			
			System.out.println( "What is your location?: " );
			String location = input.nextLine();
			
			while( !p.contains( location ) && p.isEmpty( location ) )
			{
				System.out.println( "That is not a valid location. Please input another location: " );
				location = input.nextLine();
			}
			
			if( choice == 1 )
				adopt( location, p );
			
			else if( choice == 2 )
				putUpForAdoption( location, p );
			
			System.out.println( "Do you want to repeat? no(1) yes(2): ");
			choice = input.nextInt();
			
			while( choice != 1 && choice != 2 )
			{
				System.out.println( "That is not a valid choice. Please input another choice: ");
				choice = input.nextInt();
			}
			
			if( choice == 1 )
				continueAdoption = false;
		}
		
		
	}
	
	
	public static void writeToTextFile(String fileName, String content) throws IOException 
	{   
		content = "\n" + content;
		//Files.write(Paths.get("src/" + fileName), content.getBytes(), StandardOpenOption.APPEND);
		Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.APPEND);
    }
	
	public static void createTree( PetAdoption p, String file ) throws FileNotFoundException
	{
		//Scanner s = new Scanner( new File( "src/" + file ) );
		Scanner s = new Scanner( new File(file ) );
		
		while( s.hasNext() )
		{
			String temp = s.nextLine();
			if( temp.length() > 0 )
			{
				String [] aComponents = temp.split( "-" );
				String size = aComponents[3].toLowerCase();
				
				int sizeNum = 1;
				if( size.equals( "medium" ) )
					sizeNum = 2;
				else if( size.equals( "large" ) )
					sizeNum = 3;
				
				Animal a = new Animal( aComponents[0], aComponents[1], aComponents[2], sizeNum, Integer.parseInt( aComponents[4] ) );
				
				p.add( file, a );
			}
		}
	}
	
	public static void adopt( String location, PetAdoption p )
	{
		int choice = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println( "How would you like to search by? Species(1) Age(2) Size(3) Color(4) All(5)");
		choice = input.nextInt();
		
		while( choice < 1 && choice > 5 )
		{
			System.out.println( "That is not a valid choice. Please input another choice: ");
			choice = input.nextInt();
		}
		
		if( choice == 1)
			System.out.println( p.printSpecies( location ) );
		else if( choice == 2)
			System.out.println( p.printAge( location ) );
		else if( choice == 3)
			System.out.println( p.printSize( location ) );
		else if( choice == 4)
			System.out.println( p.printColor( location ) );
		else if( choice == 5)
			System.out.println( p.printAll( location ) );
		
		input.nextLine();
		
		System.out.println( "Please enter the name of the animal you wish to adopt: " );
		String name = input.nextLine();
		
		while( !p.contains( location, name ) )
		{
			System.out.println( "That is an invalid name. Please input another name: " );
			name = input.nextLine();
		}
		
		System.out.println( "Please enter the species of the animal you wish to adopt: " );
		String species = input.nextLine();
		
		while( !p.contains( location, name, species ) )
		{
			System.out.println( p.printSpecies(location ) );
			System.out.println( "That is an invalid species. Please input another species: " );
			species = input.nextLine();
		}
		
		p.remove(location, name, species );
		
		System.out.println( "Congratulations! You have adopted " + name + "!" );
	}
	
	public static void putUpForAdoption( String location, PetAdoption p )
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println( "What is the animal's name?: " );
		String name = input.nextLine();
		
		System.out.println( "What is the animal's species?: " );
		String species = input.nextLine();
	
		System.out.println( "What is the animal's color?: " );
		String color = input.nextLine();
		
		System.out.println( "What is the animal's size (small, medium, large)?: " );
		String size = input.nextLine();
		
		System.out.println( "What is the animal's age?: " );
		int age = input.nextInt();
		
		int sizeNum = 1;
		if( size.equals( "medium" ) )
			sizeNum = 2;
		else if( size.equals( "large" ) )
			sizeNum = 3;
		
		Animal a = new Animal( name, species, color, sizeNum, age );
		
		p.add( location, a);
		
		String temp = name + "-" + species + "-" + color + "-" + size + "-" + age;
		
		try {
			writeToTextFile( location, temp );
		}
		catch (IOException e) {
		}
	}
	
}

//http://www.vogella.com/tutorials/JavaIO/article.html info on how to save text to a doc
