//Name: Last, First
//Per: 
//Date: 
//AP Computer Science

public class Message {
	private Actor sender;
	private Actor recipient;
	private String text;
	
	public Message(Actor a1, Actor a2, String str) {
		sender = a1;
		recipient = a2;
		text = str;
	}
	
	public Actor getSender() {
		return sender;
	}
	
	public Actor getRecipient() {
		return recipient;
	}
	
	public String getText() {
		return text;
	}
	
	public String toString() {
		String toName;
		
		if (recipient != null)
			toName = recipient.getName();
		else
			toName = "all";
		
		return "From: " + sender.getName() + "\n" + "To: " + toName + "\n" + text + "\n";
	}
}
