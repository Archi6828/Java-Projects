//Name: Last, First
//Per: 
//Date: 
//AP Computer Science

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MailServer extends LinkedList<Message> {
	private Set<Actor> actors;
	
	public MailServer() {
		actors = new TreeSet<Actor>();
	}
	
	public void signUp(Actor actor) {
		actors.add(actor);
	}
	
	public void dispatch(Message msg) {
		if (msg.getRecipient() != null) {
			msg.getRecipient().receive(msg);
		} else // send to all recipients on the list
		{
			for (Actor actor : actors)
				if (actor != msg.getSender())
					actor.receive(msg);
		}
	}
}
