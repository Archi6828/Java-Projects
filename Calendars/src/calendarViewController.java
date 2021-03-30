import java.util.ArrayList;
import java.util.Scanner;

public class calendarViewController implements ViewController{
	private User user;
	private Scanner scan;
	
	public calendarViewController() {
		user = UserViewController.getCurUser();
		scan = new Scanner(System.in);
	}
	
	public boolean add() {
		System.out.println("Enter Calendar name: ");
		String calName = scan.next();

		boolean calAdded = user.addCalendar(calName);
		
		if(calAdded) {
			System.out.println("Calendar " + calName + " created.");
			return true;
		}
		else
			System.out.println("Calendar name is already in use.");
		return false;
	}
	
	public void update() {
		System.out.println("Enter Calendar name that you wish to update: ");
		String calName = scan.next();
		
		if(!user.calNameExists(calName)) 
			return;
		
		System.out.println("Enter a new name for the Calendar: ");
		String name2 = scan.next();
		
		if(user.calNameExists(name2)) { 
			System.out.println("Calendar " + name2 + " already exists.");
			return;
		}
		calendar cal = user.getCalendar(calName);
		cal.setName(name2);
	}
	
	public boolean delete() {
		System.out.println("Enter Calendar name that you wish to delete: ");
		String calName = scan.next();
		
		boolean calDeleted = user.removeCalendar(calName);
		
		if(calDeleted) {
			System.out.println("Calendar " + calName + " deleted.");
			return true;
		}
		else
			System.out.println("Calendar " + calName + " does not exist.");
		return false;
	}
	public void changePublicity() {
		System.out.println("Enter Calendar name to change its publicity: ");
		String calName = scan.next();
		
		if(!user.calNameExists(calName)) {
			System.out.println("Calendar " + calName + " does not exist.");
			return;
		}
		
		calendar cal = user.getCalendar(calName);
		cal.changePublicity();
		System.out.println("calendar " + cal.getName() + " is a " 
							+ cal.getPublicity() + " calendar.");
	}
	
	public void viewMyCals() {
		System.out.println("---------------------------------------------");
		System.out.println("         " + user.getName() + "'s Calendar List: ");
		for(calendar c: user.cals) {
			System.out.println(c.getName());
		}
		System.out.println("---------------------------------------------");
	}
	
	public static void viewAllCalendars() {
		System.out.println("---------------------------------------------");
		System.out.println("       All Users' Public Calendar List: ");
		ArrayList<User> allUsers = UserViewController.getAllUsers();
		
		for(User u: allUsers) {
			System.out.println(u.getName() + "'s Public Calendars:"
							+ u.getPublicCalNames().toString());
		}
		System.out.println("---------------------------------------------");
	}
	public void displayMenu() {
		//calendar Menu
    	System.out.println("---------------------------------------------");
    	System.out.println("                 Calendar Menu:\n"
    					+ "add a new calendar                --> a\n"
    					+ "change a calendar's publicity     --> p\n"
    					+ "update an existing calendar       --> u\n"
    					+ "delete an existing calendar       --> d\n"
    					+ "view my calendars                 --> c\n"
    					+ "view all Public Calendars         --> p\n"
    					+ "return to main catalog            --> r\n"
    					+ "to quit                           --> q");
    	System.out.println("---------------------------------------------");
	}
	
	public boolean navigate(String goTo) {
		if(goTo.equals("a")) {
			add();
			return true;
		}
		else if(goTo.equals("p")) {
			changePublicity();
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
		else if(goTo.equals("c")) {
			viewMyCals();
			return true;
		}
		else if(goTo.equals("p")) {
			viewAllCalendars();
			return true;
		}
		return false;
	}

}

