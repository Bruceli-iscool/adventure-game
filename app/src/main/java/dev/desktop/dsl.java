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
        boolean mode = false;
		for (String n:content) {
			n = n.trim();
			if (n.contains("combat(")) {
				String newN = n.replace("combat(", "");
				try {
					newN = newN.replace(")", "");
					newN = newN.replace(";", "");
					String[] arr = newN.split(",");
					int[] arr2 = new int[3];
					int index = 0;
					for (String i:arr) {
						int current = Integer.parseInt(i);
						arr2[index] = current;
						index++;
					}
				} catch (Exception e) {
					System.err.println("Adv: An Error Occured: " + e);
				}
			}
			
		}

	}	
}



