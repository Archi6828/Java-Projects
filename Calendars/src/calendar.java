import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class calendar {
	private String name;
	private User owner;
	public ArrayList<Event> events;
	private boolean publicity;
	private static final String DATE_FORMAT ="dd MMM yyyy HH:mm a";
	
	calendar(String calName, User owner){
		name = calName;
		this.owner = owner;
		events = new ArrayList<Event>();
		publicity = false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public String getPublicity() {
		if(publicity)
			return "Public";
		else
			return "Private";
	}
	
	public void changePublicity() {
		if(publicity)
			publicity = false;
		else
			publicity = true;
	}
	
	//helper
	public boolean eventNameExists(String name) {
		for(Event e: events) {
			if(name.equals(e.getName()))
					return true;
		}
		return false;
	}
	
	public Event getEvent(String name) {
		if(eventNameExists(name))
		{
			for(Event e: events) {
				if(name.equals(e.getName()))
						return e;
			}	
		}
		return null;
	}
	
	public int addEvent(String eventName,Date start, Date end) {
		if(eventNameExists(eventName)) 
			return -1;
		//ck timings
		if(!start.before(end))
			return 0; //invalid timings
		//Calendar cal = new GregorianCalendar();
		
		Event ev = new Event(eventName, this, start, end);
		events.add(ev); //add to user's list of calendars
		return 1;
	}
	
	public boolean removeEvent(String eventName) {
		Event ev = getEvent(eventName);
		
		if(ev == null) 
			return false;
		
		events.remove(ev); 
		return true;
	}
	
	public void updateAllEvents() {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
		Settings session = Main.getcurSession();
		String newtzID = session.getZone();
		TimeZone newtz = TimeZone.getTimeZone(newtzID);
		
		try {
			for(Event e: events) {
				Date start = e.getStartTime();
				Date end = e.getEndTime();
				//convert
				SimpleDateFormat sdfnewTZ = new SimpleDateFormat(DATE_FORMAT);
				sdfnewTZ.setTimeZone(newtz);
				
				String strNewStart = sdfnewTZ.format(start);
				Date dateNewStart = formatter.parse(strNewStart);
				
				String strNewEnd = sdfnewTZ.format(end);
				Date dateNewEnd = formatter.parse(strNewEnd);
				
				e.changeEventTime(dateNewStart, dateNewEnd);
			}
		}catch (ParseException e) {
			e.getMessage();
		} 	
	}
}

