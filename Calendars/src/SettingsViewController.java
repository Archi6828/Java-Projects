import java.time.ZoneId;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TimeZone;

public class SettingsViewController implements ViewController{
	private Scanner scan;
	private Settings session;
	
	public SettingsViewController() {
		scan = new Scanner(System.in);
		session = Main.getcurSession();
	}
	
	public void displaySettings() {
		System.out.println("---------------------------------------------");
    	System.out.println("                 App Settings\n");
		System.out.println("Current TimeZone ID: " + session.getZone());
		System.out.println("Current app theme: " + session.getTheme());
		System.out.println("---------------------------------------------");
	}
	public void timeZone() {
		System.out.println("Current TimeZone ID: " + session.getZone());
		System.out.println("List of valid TimeZone IDs: " + Arrays.toString(TimeZone.getAvailableIDs()));
		System.out.println("Enter TimeZone ID to switch to: ");
		String tzID = scan.next();
		ZoneId zone = ZoneId.of(tzID); //verify ID
		
		session.setTimeZone(tzID);
		System.out.println("TimeZone ID is set to: " + session.getZone());
	}
	public void theme() {
		session.switchTheme();
		System.out.println("Current app theme is " + session.getTheme());

	}
	//adding functionality for future changes
		public boolean add() { 
			return false;}
		public void update() { 
			return; }
		
		public boolean delete() {
			return false;
		}
	public void displayMenu() {
		//Settings Menu
    	System.out.println("---------------------------------------------");
    	System.out.println("                 Settings Menu:\n"
    					+ "change time zone             --> tz\n"
    					+ "change app's theme           --> at\n"
    					+ "view current app settings    --> vs\n"
    					+ "return to calendar menu      --> r\n");
    	System.out.println("---------------------------------------------");
	}
	public boolean navigate(String goTo) {
		if(goTo.equals("tz")) {
			timeZone();
			return true;
		}
		else if(goTo.equals("vs")) {
			displaySettings();
			return true;
		}
		else if(goTo.equals("at")) {
			theme();
			return true;
		}
		return false;
	}

}

