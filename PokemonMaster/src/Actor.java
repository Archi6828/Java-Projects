//Name: Last, First
//Per: 
//Date: 
//AP Computer Science

import java.util.Queue;
import java.util.LinkedList;

public abstract class Actor implements Comparable<Actor> {
	private String name;
	private Queue<Message> mailbox;
	private MailServer mailServer;
	
	public Actor(String nm) {
		name = nm;
		mailbox = new LinkedList<Message>();
	}
	
	// Returns the name of this Actor
	public String getName() {
		return name;
	}
	
	// Adds server as this Actor's message server
	public void addMailServer(MailServer server) {
		mailServer = server;
		mailServer.signUp(this);
	}
	
	// Checks whether this actor's mailbox has any messages;
	// returns true if it does, false if it doesn't.
	
	public boolean moreMail()
  {
      boolean flag = false;
      if(!mailbox.isEmpty())
          flag = true;
      return flag;
  }
	
	// Adds msg to this Actor's mailbox.
	public void receive(Message msg)
  {
      mailbox.add(msg);
  }
	
	// Removes and returns one message from this Actor's mailbox.
	public Message readNextMessage()
  {
      Message a = mailbox.remove();
      return a;
  }
	
	public abstract void readMail();
	
	// Creates a new message from this actor to the specified
	// recipient and adds it to mailServer
	public void send(Actor recipient, String text)
  {
      Actor a = this;
      Message msg = new Message(a, recipient, text);
      mailServer.add(msg);      
  }
	
	// Creates a new message from this actor with null recipient
	// and adds it to mailServer
	public void announce(String text)
  {
      Actor a = this;
      Message msg = new Message(a, null , text);
      mailServer.add(msg);
  }
	
	// Compares this Actor to another in alphabetical
	// order of their names
	public int compareTo(Actor other) {
		return name.compareTo(other.getName());
	}
	
	// Check whether this Actor's name is the same as other's
	public boolean equals(Object other) {
		return other != null && name.equals(((Actor) other).getName());
	}
	
	// Returns the hashCode for this Actor equal to the hashcode of its name
	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() {
		return name;
	}
}
