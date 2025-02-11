package dev.desktop;
import java.util.List;


// code for a dsl for adventure-game

public class dsl extends character {
	int attack, defence, health, stamina, gold;
	List<String> content;
	public dsl(int a, int d, int h, int s, int g, List<String> c) {
		super(a, d, h, s, g);
		// create a new character.
		attack = a;
		defence = d;
		health = h;
		stamina = s;
		gold = g;
		content = c;
	}
	protected void parse() throws InterruptedException{
		boolean in = false;
		boolean on = false;
		boolean control = false;
		for (String n:content) {
			n = n.trim();
			if (n.contains("text") && n.contains("{")) {
				on = true;
			} else if (n.contains("option") && n.contains("{") && on) {
					in = true;
			} else {
				if (in && n.contains("}")) {
					in = false;
					continue;
				} else if (on && !in && n.contains("}")) {
					on = false;
					continue;
				} else if (in && n.contains("choice") && n.contains("{")) {
					//todo
				} else if (in && n.contains("control") && n.contains("{")) {
					control = true;
					continue;
				} else if (control && n.contains("}")) {
					control = false;
					continue;
				} 
					System.out.println(n);
					Thread.sleep(500);
				} 
			
		}

	}	
}



