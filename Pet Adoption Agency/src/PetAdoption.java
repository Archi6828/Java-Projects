import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PetAdoption 
{
 	private Map<String, Set<Animal>> map;
	
	public PetAdoption() 
	{
		map = new TreeMap<String, Set<Animal>>();
	}
	
	public void add(String l, Animal a) {
		Set<Animal> temp = map.get( l );
		
		if( temp != null )
		{
			temp.add( a );
			if( temp.contains( a ) )
				map.put( l, temp );
		}
		
		else
		{
			temp = new TreeSet<Animal>();
			temp.add( a );
			map.put( l, temp );
		}
		
	}
	
	public Set<Animal> get( String l )
	{
		return map.get(l);
	}
	
	public String printSpecies( String l )
	{
		Set<Animal> temp = map.get( l );
		String ans = "";
		
		if( temp != null )
		{
			int counter = 0;
			for( Animal a : temp )
			{
				counter ++;
				ans += "Name: " + a.getName() + "\tSpecies: " + a.getSpecies();
				if( counter < temp.size() )
					ans += "\n";
			}
			return ans;
		}
		
		return "This location doesn't exist";
	}
	
	public String printAge( String l )
	{
		Set<Animal> temp = map.get( l );
		String ans = "";
		
		if( temp != null )
		{
			int counter = 0;
			for( Animal a : temp )
			{
				counter ++;
				ans += "Name: " + a.getName() + "\tAge: " + a.getAge();
				if( counter < temp.size() )
					ans += "\n";
			}
			return ans;
		}
		
		return "This location doesn't exist";
	}
	
	public String printSize( String l )
	{
		Set<Animal> temp = map.get( l );
		String ans = "";
		
		if( temp != null )
		{
			int counter = 0;
			for( Animal a : temp )
			{
				counter ++;
				ans += "Name: " + a.getName() + "\tSize: " + a.getSize();
				if( counter < temp.size() )
					ans += "\n";
			}
			return ans;
		}
		
		return "This location doesn't exist";
	}
	
	public String printColor( String l )
	{
		Set<Animal> temp = map.get( l );
		String ans = "";
		
		if( temp != null )
		{
			int counter = 0;
			for( Animal a : temp )
			{
				counter ++;
				ans += "Name: " + a.getName() + "\tColor: " + a.getColor();
				if( counter < temp.size() )
					ans += "\n";
			}
			return ans;
		}
		
		return "This location doesn't exist";
	}
	
	public String printAll( String l )
	{
		Set<Animal> temp = map.get( l );
		String ans = "";
		
		if( temp != null )
		{
			int counter = 0;
			for( Animal a : temp )
			{
				counter ++;
				ans += a.toString();
				if( counter < temp.size() )
					ans += "\n";
			}
			return ans;
		}
		
		return "This location doesn't exist";
	}
	
	public String toString()
	{
		String ans = "";
		
		int counter = 0;
		
		for( Map.Entry<String, Set<Animal>> m : map.entrySet() )
		{
			counter ++;
			ans += m.getKey() + "\n";
			ans += printAll( m.getKey() );
			
			if( counter < map.size() )
				ans += "\n\n";
		}
		return ans;
	}
	
	public boolean contains( String l )
	{
		return map.containsKey( l );
	}
	
	public boolean contains( String l, String name )
	{
		if( contains(l) )
		{
			Set<Animal> set = map.get(l);
			for( Animal a : set )
			{
				if( a.getName().equals( name ) )
					return true;
			}
		}
		
		return false;
	}
	
	public boolean contains( String l, String name, String species )
	{
		if( contains( l, name ) )
		{
			Set<Animal> set = map.get(l);
			for( Animal a : set )
			{
				if( a.getSpecies().equals( species ) )
					return true;
			}
		}
		
		return false;
	}
	
	public boolean remove( String l, String name, String species )
	{
		if( map.containsKey(l) )
		{
			Set<Animal> set = map.get(l);
			for( Animal a : set )
			{
				if( a.getName().equals( name) && a.getSpecies().equals( species ) )
				{
					set.remove( a );
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isEmpty( String l )
	{
		if( map.containsKey( l ) )
		{
			Set<Animal> set = map.get( l );
			return set.size() == 0;
			
		}
		
		return true;
	}
}
