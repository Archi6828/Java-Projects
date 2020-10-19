//Name: Last, First
//Per: 
//Date: 
//AP Computer Science

//Implements a PokemonMaster that can receive and send messages about
//its pokemon and give extra items that it doesn't need to others.
//The PokemonMaster's objective is to collect at least one of each pokemon.

import java.util.Collection;
import java.util.ArrayList;

public class PokemonMaster extends Actor {
	private static String[] items = { "bulbasaur", "charmander", "squirtle" };
	
	private Collection<String> myPossessions;
	private boolean allSetFlag; // = false;
	
	public PokemonMaster(String name) {
		super(name);
	}
	
	public PokemonMaster(String name, Collection<String> possessions) {
		super(name);
		myPossessions = new ArrayList<String>();
		myPossessions.addAll(possessions);
	}
	
	// Called by someone else to give an item to this PokemonMaster.
	// Checks whether this PokemonMaster still needs the item.  If so,
	// sends a thank-you message to giver and returns true;
	// otherwise returns false
	public boolean receiveItem(PokemonMaster giver, String item) {
		if (!myPossessions.contains(item)) {
			myPossessions.add(item);
			send(giver, "thx for the " + item);
			return true;
		} else
			return false;
	}
	
	// 1. Checks possessions for this PokemonMaster and sends a "need <item>"
	//    message to the list for each missing item.
	//
	// 2. Removes and processes messages from the mailbox,
	//    one by one.
	//    Processing messages:
	//    i)   Takes action only for messages with the text
	//         "need <item>", "have <item>", or "ship <item>".
	//         where <item> is the name of the item, such as "hat",
	//         "left glove", or "right glove".
	//         Skips all other messages.
	//    ii)  If this is a "need" message and this PokemonMaster has an extra item
	//         requested, it responds with a "have <item>" message.
	//    iii) If this is a "have" message and this PokemonMaster is missing the offered item,
	//         it responds with a "ship <item>" message.
	//    iv)  If this is a "ship" message and this PokemonMaster still has an extra item,
	//         then it calls sender's receiveItem method.  If receiveItem
	//         returns true, removes item from this PokemonMaster's possessions.
	//
	// 3. If allSetFlag is not set and this PokemonMaster is all set, that is has
	//    one of each item, sends "thx, all set" to the list.
	public void readMail()
  {
        while(!myPossessions.isEmpty())
        {
             for(int i = 0; i < items.length; i++)
             {
                 if(!myPossessions.contains(items[i]))
                     announce("need " + items[i]);
             }
        }
        while(moreMail() == true)
        {
        String msg = readNextMessage().getText();
        if(msg.contains("need") || msg.contains("have") || msg.contains("ship"))
        {
            
            String item = msg.substring(5);
            /*
            int count = 0;
                for(String a: myPossessions)
             {
                 if(a.equals(item))
                 {
                     count++;
                 }
             }*/
                
             //need   
            if(msg.contains("need") && myPossessions.contains(item))
            {
                
                if(countPossessions(item) >= 2)
                    send(readNextMessage().getSender(), "have " + item);
            }
            
            //have
            if(msg.contains("have") && !myPossessions.contains(item))
            {
                send(readNextMessage().getSender(), "ship " + item);
            }
            
            //ship
            if(msg.contains("ship") && myPossessions.contains(item))
            {
                if(countPossessions(item) > 2)
                    receiveItem((PokemonMaster)readNextMessage().getSender(), item);
            }
        }
        }
        
        if(allSet())
        {
        		announce("thx, all set");
        }
        
        
  }
	
	public String toString() {
		return super.toString() + " " + myPossessions;
	}
	
	//*************************************************************
	
	// Returns the number of times item occurs in myPossessions
	private int countPossessions(String item) {
		int count = 0;
		
		for (String str : myPossessions)
			if (item.equals(str))
				count++;
			
		return count;
	}
	
	// Checks whether this PokemonMaster has one of each items
	private boolean allSet() {
		for (String item : items) {
			if (countPossessions(item) != 1)
				return false;
		}
		allSetFlag = true;
		return true;
	}
}
