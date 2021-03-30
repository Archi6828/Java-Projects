
public class MenuCatalog {
	public ViewController switchMenu(String type) {
		if(type.equals("u")) 
			return new UserViewController();
		else if(type.equals("s")) 
			return new SettingsViewController();
		else if(UserViewController.getAllUsers().size() == 0) {
			System.out.println("Add a user first.");
			switchMenu("u");
		}
		else if(type.equals("c")) {
				
			return new calendarViewController();
		}
		else if(UserViewController.getCurUser().getCals().size() == 0) {
			System.out.println("Add a calendar first.");
			switchMenu("c");
		}
		else if(type.equals("e")) {
			
			return new EventViewController();
		}
		return null;
	}
	
	public void displayCatalog() {
		//Main Menu
    	System.out.println("---------------------------------------------");
    	System.out.println("                 Main Catalog:\n"
    					+ "view User Menu                          --> u\n"
    					+ "view Calendar Menu                      --> c\n"
    					+ "view Event Menu                         --> e\n"
    					+ "view Settings Menu                      --> s\n"
    					+ "to quit                                 --> q");
    	System.out.println("---------------------------------------------");
	}
}
