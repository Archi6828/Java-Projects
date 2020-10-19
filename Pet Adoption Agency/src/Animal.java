public class Animal implements Comparable
{
	String name, species, color;
	int size, age;

	public Animal(String name, String species, String color, int size, int age) 
	{
		this.name = name;
		this.species = species;
		this.color = color;
		this.size = size;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public String getSpecies() {
		return species;
	}
	public int getAge() {
		return age;
	}
	public String getColor() {
		return color;
	}
	public int getSize() {
		return size;
	}
	
	public boolean equals(Animal a) 
	{
	
		if(a.getSpecies().equals(species) && a.getAge() == age && a.getSize() == size && a.getColor().equals(color) && a.getName().equals(name))
			return true;
		return false;
	}
	
	public int compareTo( Object a )
	{
		if( this.equals(a) )
			return 0;
		if( name.equals( ((Animal)a).getName() ) )
		{
			if( species.equals( ((Animal)a).getSpecies() ) )
			{
				if( size == ((Animal)a).getSize() )
				{
					if( age == ((Animal)a).getAge() )
					{
						return color.compareTo( ((Animal)a).getColor() );
					}
					
					if( age > ((Animal)a).getAge() )
						return 1;
					else
						return 0;
				}
				if( size > ((Animal)a).getSize() )
					return 1;
				else
					return 0;
			}
			return species.compareTo( ((Animal)a).getSpecies() );
		}
		return name.compareTo( ((Animal)a).getName() );
	}
	
	public String toString() 
	{
		return "Name: " + name + "\nSpecies: " + species + "\nColor: " + color + "\nsize: " + size;
	}

	
	
}
