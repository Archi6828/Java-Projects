import java.util.ArrayList;
import java.util.Date;

public class Event {
	private String eventTitle;
	private Date start, end;
	private User createdBy;
	private calendar belongsToCal;
	public ArrayList<User> access;
	
	Event(String name, calendar belongsToCal, Date start, Date end){
		eventTitle = name;
		this.start = start; 
		this.end = end;
		this.belongsToCal = belongsToCal;
		createdBy = belongsToCal.getOwner();
		access = new ArrayList<User>();
	}
	
	public String getName() {
		return eventTitle;
	}
	
	public Date getStartTime() {
		return start;
	}
	
	public Date getEndTime() {
		return end;
	}
	
	public ArrayList<String> getaccessInfo() {
		ArrayList<String> sharedWith = new ArrayList<String>();
		
		for(User ur: access) 
			sharedWith.add(ur.getName());
		
		return sharedWith;
	}

	public String createdBy() {
		return createdBy.getName();
	}
	
	public void changeEventTime(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	
	public void setName(String n) {
		eventTitle = n;
	}
	
	public boolean shareEventWithUser(User u) {
		if(!access.contains(u)) {
			access.add(u);
			u.addToSharedList(this);
			return true; //shared
		}
		else
			access.remove(u);
		u.removeFromSharedList(this);
		return false; //unshared
	}
	
	public void getEventInfo() {
		System.out.println(eventTitle
				+ "\nStart: " + start
				+ "\nEnd: " + end);
	}
}
