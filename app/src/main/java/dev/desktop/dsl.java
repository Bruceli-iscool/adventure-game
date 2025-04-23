package dev.desktop;
import java.util.List;


// code for a dsl for adventure-game

public class dsl extends character {
	int attack, defence, health, stamina, gold;
	ArrayList<String> n = new ArrayList<>();
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
	protected void lex() {

	}
	protected void parse() throws InterruptedException{


	}	
}



