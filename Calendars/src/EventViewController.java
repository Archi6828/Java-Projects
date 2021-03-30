import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class EventViewController implements ViewController{
	private calendar cal;
	private User user;
	private Scanner scan;
	
	public EventViewController() {
		user = UserViewController.getCurUser();
		scan = new Scanner(System.in);
		cal = setUp();
	}
	
	public calendar setUp() {
		System.out.println("Enter Calendar that you wish to update/view: ");
		String calName = scan.next();
		
		if(!user.calNameExists(calName)) {
			System.out.println("Event " + calName + " does not exist.");
			return null;
		}
		
		return user.getCalendar(calName);
	}
	public boolean add(){
		System.out.println("Enter Event name: ");
		String eventName = scan.next();
		
		System.out.println("Enter Event start date \"dd MMM yyyy HH:mm a\": ");
		scan.nextLine(); //clear buffer
		String startStr = scan.nextLine();
		
		try {
			DateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm a", Locale.ENGLISH);
			Date start = format.parse(startStr);
			
			System.out.println("Enter Event end time \"dd MMM yyyy HH:mm a\": ");
			
			String endStr = scan.nextLine();
			Date end = format.parse(endStr);
			
			int eventAdded = cal.addEvent(eventName, start, end);
			
			if(eventAdded == 1) {
				System.out.println("Event " + eventName + " created.");
				return true;
			}
			else if(eventAdded == -1) {
				System.out.println("Event name is already in use.");
				return false;
			}
			else // 0
				System.out.println("Invalid Timings.");
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void update() {
		System.out.println("Enter Event name that you wish to update: ");
		String eventName = scan.next();
		
		if(!cal.eventNameExists(eventName)) {
			System.out.println("Event " + eventName + " does not exist.");
			return;
		}
		
		Event ev = cal.getEvent(eventName);
		
		displayUpdateMenu();
		System.out.print("Enter key: ");
		String key = scan.next().toLowerCase();
		
		if (key.equalsIgnoreCase("r")) {
	        	return;
	        }
		boolean validInput = navigateUpdateMenu(key, ev);
		
		while(!validInput){
			System.out.println("Invalid Input.");
			displayUpdateMenu();
			System.out.print("Enter a valid command: ");
			key = scan.next().toLowerCase();
			if (key.equalsIgnoreCase("r")) {
	        	return;
	        }
			validInput = navigateUpdateMenu(key, ev);
		}
		System.out.println("Event " + eventName + " updated."); 
	}
	public void time(Event ev) {
		DateFormat format = new SimpleDateFormat("dd MMM yyyy HH:mm a", Locale.ENGLISH);
		
		try {
			System.out.println("Enter Event start date \"dd MMM yyyy HH:mm a\": ");
			scan.nextLine(); //clear buffer
			String startStr = scan.nextLine();
			Date start = format.parse(startStr);
		
			System.out.println("Enter Event end time \"dd MMM yyyy HH:mm a\": ");
			String endStr = scan.nextLine();
			Date end = format.parse(endStr);
			
			//ck timings
			if(!start.before(end))
				System.out.println("Invalid Timings.");
			else {
				ev.changeEventTime(start, end);
				System.out.println("Event Timings have been updated.");
				ev.getEventInfo();
				System.out.println();
			}
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void changeName(Event ev) {
		System.out.println("Enter Event name: ");
		String name = scan.next();
		
		if(!cal.eventNameExists(name)) 
			ev.setName(name);
		else
			System.out.println("Event name is already in use.");
	}
		
	public boolean delete() {
		System.out.println("Enter Event name that you wish to delete: ");
		String eventName = scan.next();
		
		boolean eventDeleted = cal.removeEvent(eventName);
		
		if(eventDeleted) {
			System.out.println("Event " + eventName + " deleted.");
			return true;
		}
		else
			System.out.println("Event " + eventName + " does not exist.");
		return false;
	}
	
	public void shareEvent() {
		System.out.println("Enter event name to share: ");
		String evName = scan.next();
		
		if(!cal.eventNameExists(evName)) {
			System.out.println("Event " + evName + " does not exist.");
			return;
		}
		
		Event ev = cal.getEvent(evName);
		
		System.out.println("Enter USER'S NAME to share event " + evName + " with: ");
		String urName = scan.next();
		
		boolean userExists = UserViewController.userNameExists(urName);
		
		if(!userExists) {
			System.out.println("User " + urName + " does not exist.");
			return;
		}
		
		User ur = UserViewController.getUser(urName);
		
		//share event with user
		boolean shared = ev.shareEventWithUser(ur);
		
		if(shared)
			System.out.println("Event " + evName + " SHARED with user " + urName);
		else
			System.out.println("Event " + evName + " UNSHARED with user " + urName);
	}
	
	public void displayCalEvents(calendar cal) {
		//display
		System.out.println("---------------------------------------------");
		System.out.println("         Calendar " + cal.getName() + " Events List: ");
		for(Event ev: cal.events) {
			ev.getEventInfo();
		}
		System.out.println("---------------------------------------------");
	}
	
	public void viewPublicCalEvents() {
		System.out.println("Enter the OWNER'S NAME of the "
				+ "public calendar you wish to view: ");
		String ownerName = scan.next();
		User owner = UserViewController.getUser(ownerName);
		
		if(owner == null) {
			System.out.println("Invalid user.");
			return;
		}
			
		System.out.println("Enter calendar's name to view its events: ");
		String cal_name = scan.next();
		
		if(!owner.calNameExists(cal_name)) {
			System.out.println("Calendar " + cal_name + " does not exist.");
			return;
		}
		else {
			calendar ownerCal = owner.getCalendar(cal_name);
			String calPublicity = ownerCal.getPublicity();
			if(calPublicity.equals("Public"))
				displayCalEvents(ownerCal);
			else
				System.out.println("Calendar " + cal_name + " does not exist.");
		}
	}
	
	public void detailedEventInfo() {
		System.out.println("Enter event's name to view detailed info: ");
		String evN = scan.next();
		
		if(!cal.eventNameExists(evN)) {
			System.out.println("Calendar " + evN + " does not exist.");
			return;
		}
		
		Event ev = cal.getEvent(evN);
		ev.getEventInfo();
		System.out.println( "Shared with users:\n" 
							+ ev.getaccessInfo().toString());
	}
	
	public void displayUpdateMenu() {
		//Event Menu
 	   System.out.println("---------------------------------------------");
			System.out.println("        Event Change Menu:\n"
					+ "reset event time                  --> t\n"
					+ "change event name                 --> n\n"
					+ "return to Event Menu              --> r\n");
			System.out.println("---------------------------------------------");
	}
	public boolean navigateUpdateMenu(String goTo, Event ev) {
		if(goTo.equals("t")) {
			time(ev);
			return true;
		}
		else if(goTo.equals("n")) {
			changeName(ev);
			return true;
		}
		return false;
	}
	
	public void displayMenu() {
		//Event Menu
 	   System.out.println("---------------------------------------------");
			System.out.println("            Event Menu:\n"
					+ "add a new event                            --> a\n"
					+ "update an existing event                   --> u\n"
					+ "delete an existing event                   --> d\n"
					+ "(un)share an event with a User             --> s\n"
					+ "view calendar's events                     --> e\n"
					+ "view all Public Calendar's Events          --> p\n"
					+ "list a particular event's detailed info    --> de\n"
					+ "list events shared with me                 --> se\n"
					+ "return to main catalog                     --> r\n"
					+ "to quit                                    --> q");
			System.out.println("---------------------------------------------");
	}
	
	public boolean navigate(String goTo) {
		if(goTo.equals("a")) {
			add();
			return true;
		}
		else if(goTo.equals("u")) {
			update();
			return true;
		}
		else if(goTo.equals("d")) {
			delete();
			return true;
		}
		else if(goTo.equals("s")) {
			shareEvent();
			return true;
		}
		else if(goTo.equals("e")) {
			displayCalEvents(cal);
			return true;
		}
		else if(goTo.equals("p")) {
			viewPublicCalEvents();
			return true;
		}
		else if(goTo.equals("de")) {
			detailedEventInfo();
			return true;
		}
		else if(goTo.equals("se")) {
			user.getSharedEvents();
			return true;
		}
		return false;
	}
}
				

