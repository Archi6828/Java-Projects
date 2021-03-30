import java.util.ArrayList;
import java.util.Scanner;

public class UserViewController extends Main implements ViewController {
	private static User curUser; //changed
	private static ArrayList<User> currentUsers = new ArrayList<User>();
	
	public ViewController viewMenu(String type) {
		if(type.equals("user")) 
			return new UserViewController();
		else if(type.equals("a")) 
			return new UserViewController();
		else if(type.equals("u")) 
			return new UserViewController();
		else if(type.equals("d")) 
			return new UserViewController();
		else if(type.equals("s")) 
			return new UserViewController();
		else if(type.equals("q")) 
			return new UserViewController();
		return null;
	}
	
	//helper method
		public static boolean userNameExists(String name) {
			for(User u: currentUsers) {
				if(name.equals(u.getName())) {
						return true;
				}
			}
			
			return false;
		}
		public static ArrayList<User> getAllUsers(){
			return currentUsers;
		}
		public boolean add() {
			System.out.println("Enter username: ");
	        Scanner scan = new Scanner(System.in);
	        
	        String name = scan.next();
			if(userNameExists(name)) {
				System.out.println("Username " + name + " already in use.");
				return false;
			}
			

			User u = new User(name);
			currentUsers.add(u); 
			curUser = u; //set new user active
			System.out.println("new user " + name + " created.\n" 
					+ name + " account now active.");
			return true;
		}
		
		public void update() {
			System.out.println("Enter new username: ");
	        Scanner scan = new Scanner(System.in);
	        
	        String name = scan.next();
	        if(!userNameExists(name)) {
				curUser.setName(name);
				System.out.println("username changed to " + name);
	        }
	        else
	        	System.out.println("Username " + name + " already in use.");
		}
		
		public boolean delete() {
			System.out.println("Good Bye " + curUser.getName() + "!");
			currentUsers.remove(currentUsers.size() - 1);
			//default set to 2nd to last user
			curUser = currentUsers.get(currentUsers.size() - 1);
			System.out.println("user " + curUser.getName() + " is now activated.\n"
								+ "Switch user to activate another account.");
			return true;
		}
		
		public static User getUser(String name) {
			if(userNameExists(name))
			{
				for(User u: currentUsers) {
					if(name.equals(u.getName()))
							return u;
				}
			}
			return null;
		}
		public static User getCurUser() {
			return curUser;
		}
		
		public void switchUser() {
			System.out.println("Enter username to switch to: ");
			Scanner scan = new Scanner(System.in);
	        String uName = scan.next();
	        
	        User userExists = getUser(uName);
	        
	        if(userExists == null)
	        	System.out.println("Username " + uName + " does not exist.");
	        else {
	        	curUser = userExists;
	        	System.out.println(uName + " account now active.");
	        }
		}
		
		public static void updateAllToTime() {
			for(User u: currentUsers) {
				u.updateAllCalendars();
			}
		}
		
		public void displayAllUserNames() {
			System.out.println("---------------------------------------------");
	    	System.out.println("           Users in current session\n");
	    	for(User s: currentUsers)
	    		System.out.println(s.getName());
			System.out.println("---------------------------------------------");
		}
		
		public void displayMenu() {
			//Main Menu
	    	System.out.println("---------------------------------------------");
	    	System.out.println("                 User Menu:\n"
	    					+ "add user                                   --> a\n"
	    					+ "update user                                --> u\n"
	    					+ "delete user                                --> d\n"
	    					+ "switch user                                --> s\n"
	    					+ "view users in current session              --> vu\n"
	    					+ "return to main calatog                     --> r\n"
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
				switchUser();
				return true;
			}
			else if(goTo.equals("vu")) {
				displayAllUserNames();
				return true;
			}
			return false;
		}
}

