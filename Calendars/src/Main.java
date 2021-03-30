import java.util.Scanner;

public class Main {
	private static MenuCatalog menu = new MenuCatalog(); //single ton
	private static Settings curSession;
	
	private static void setUp() {
		menu = new MenuCatalog();
		curSession = Settings.getInstance(); //start session
	}
	public static Settings getcurSession() {
		return curSession;
	}
	public static void main(String[] args) {
		setUp();
		
		try { 
	        System.out.println("Welcome to Calendars");
	        ViewController view = menu.switchMenu("u");
	        
	        view.displayMenu();
	        
        	String ins;
        	Scanner scan = new Scanner(System.in);
        	
        	while (scan.hasNext()){
        		ins = scan.next().toLowerCase();
        		
        		if (ins.equalsIgnoreCase("q")) {
      	        	System.out.println("Good Bye!");
      	        	return;
      	        }
        		else  if (ins.equalsIgnoreCase("r")) {
     	        	menu.displayCatalog();
     	        	System.out.println("Enter which Menu to go to: ");
     	        	String goToMenu = scan.next();
     	        	
     	        	if (goToMenu.equalsIgnoreCase("Q")) {
          	        	System.out.println("Good Bye!");
          	        	return;
          	        }
     	        	view = menu.switchMenu(goToMenu);
     	        	
     	        	//ck
     	        	while(view == null) {
     	        		System.out.println("Invalid Input. Enter which Menu to go to: ");
     	        		goToMenu = scan.next();
         	        	
         	        	if (goToMenu.equalsIgnoreCase("Q")) {
              	        	System.out.println("Good Bye!");
              	        	return;
              	        }
     	        		view = menu.switchMenu(goToMenu);
     	        	}
     	        }
        		else if(!view.navigate(ins)) {
        			System.out.println("Invalid Input. Enter a valid command: ");
        			view.displayMenu();
        		}
        		view.displayMenu();
        	}	
	        
	    } catch (Exception e) {
	        System.out.println("Invalid Input. Sign-in again.\n" + e.getMessage());

	    }

	}

}

