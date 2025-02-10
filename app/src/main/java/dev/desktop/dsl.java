package dev.desktop;
import java.util.List;
import java.util.ArrayList;


// code for a dsl for adventure-game

public class dsl {
	int attack, defence, health, stamina, gold;
	List<String> content;
	public dsl(int a, int d, int h, int s, int g, List<String> c) {
		// create a new character.
		attack = a;
		defence = d;
		health = h;
		stamina = s;
		gold = g;
		content = c;
	}
	protected void parse() throws InterruptedException{
		for (String n:content) {
			content.forEach(number->System.out.println(number));
		}

	}	
}



