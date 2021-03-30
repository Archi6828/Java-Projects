import java.util.TimeZone;

public class Settings {
	private static Settings session;
	private static TimeZone tz;
	private static String theme;
	
	private Settings(){
		tz = TimeZone.getDefault();
		theme = "light";
	}
	
	public static Settings getInstance() {
		if(session == null)
			session = new Settings();
		return session;
	}
	
	public String getZone() {
		return tz.getID();
	}
	
	public String getTheme() {
		return theme;
	}
	
	public void setTimeZone(String ID) {
		tz = TimeZone.getTimeZone(ID);
		
		UserViewController.updateAllToTime();
	}
	public void switchTheme() {
		if(theme.equals("light"))
			theme = "dark";
		else
			theme = "light";
	}
}
