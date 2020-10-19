//Name: Last, First
//Per: 
//Date: 
//AP Computer Science

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PokemonMasterRunner extends JFrame {
	private JTextArea display;
	
	public PokemonMasterRunner() {
		display = new JTextArea();
		display.setEditable(false);
		Container c = getContentPane();
		c.add(new JScrollPane(display), BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		PokemonMasterRunner window = new PokemonMasterRunner();
		window.setSize(400, 300);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
		
		String[] ashPossessions = { "bulbasaur", "bulbasaur", "bulbasaur", "squirtle" };
		String[] mistyPossessions = { "charmander" };
		String[] brockPossessions = { "charmander", "charmander", "squirtle", "squirtle" };
		
		List<PokemonMaster> pokeBank = new ArrayList<PokemonMaster>();
		pokeBank.add(new PokemonMaster("Ash", Arrays.asList(ashPossessions)));
		pokeBank.add(new PokemonMaster("Misty", Arrays.asList(mistyPossessions)));
		pokeBank.add(new PokemonMaster("Brock", Arrays.asList(brockPossessions)));
		
		MailServer server = new MailServer();
		for (PokemonMaster pokemonTrainer : pokeBank)
			pokemonTrainer.addMailServer(server);
		
		while (true) {
			while (!server.isEmpty()) {
				Message msg = server.remove();
				window.display.append(msg + "\n");
				server.dispatch(msg);
			}
			
			// Collections.shuffle(pokemonTrainer);
			
			for (PokemonMaster pokemonTrainer : pokeBank)
				pokemonTrainer.readMail();
		}
	}
}
