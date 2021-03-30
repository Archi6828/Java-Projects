import java.util.ArrayList;

public class User {
	private String name;
	public ArrayList<calendar> cals;
	private ArrayList<Event> eventsSharedWithMe;
	
	User(String userName){
		name = userName;
		cals = new ArrayList<calendar>();
		eventsSharedWithMe = new ArrayList<Event>();
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public ArrayList<calendar> getCals(){
		return cals;
	}
	
	public ArrayList<String> getPublicCalNames()
	{
		ArrayList<String> pubCals = new ArrayList<String>();
		for(calendar c: cals) {
			if(c.getPublicity().equals("Public"))
				pubCals.add(c.getName());
		}
		return pubCals;
	}
	
	public void getSharedEvents() {
		System.out.println("---------------------------------------------");
		System.out.println("         Events Shared with me: ");
		for(Event ev: eventsSharedWithMe) {
			System.out.println(ev.getName()
					+ "\nStart: " + ev.getStartTime()
					+ "\nEnd: " + ev.getEndTime()
					+ "\nShared by: " + ev.createdBy());
		}
		System.out.println("---------------------------------------------");
	}
	
	public void addToSharedList(Event ev) {
		eventsSharedWithMe.add(ev);
	}
	
	public void removeFromSharedList(Event ev) {
		eventsSharedWithMe.remove(ev);
	}
	
	public boolean addCalendar(String calName) {
		if(calNameExists(calName)) 
			return false;

		calendar cal = new calendar(calName, this);
		cals.add(cal); //add to user's list of calendars
		return true;
	}
	
	public boolean removeCalendar(String calName) {
		calendar cal = getCalendar(calName);
		
		if(cal == null) 
			return false;

		cals.remove(cal); 
		return true;
	}
	
	public void updateAllCalendars() {
		for(calendar c: cals) {
			c.updateAllEvents();
		}
	}
	
	//helper method
	public boolean calNameExists(String name) {
		for(calendar c: cals) {
			if(name.equals(c.getName()))
					return true;
		}
		
		return false;
	}
	
	public calendar getCalendar(String name) {
		if(calNameExists(name))
		{
			for(calendar c: cals) {
				if(name.equals(c.getName()))
						return c;
			}	
		}
		return null;
	}
	
}


