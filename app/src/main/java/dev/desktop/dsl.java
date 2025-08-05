package dev.desktop;
import java.util.*;


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
	protected ArrayList<String> lex() {
        ArrayList<String> result = new ArrayList<String>();
        String z = "";
        boolean ifString = false;
        // Use content instead of input
        String input = String.join(" ", content);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(': case ')': case ';': case '=': case '+': case '-': case '*': case '/':
                    if (!z.isEmpty()) {
                        result.add(z);
                        z = "";
                    }
                    result.add(String.valueOf(c));
                    break;
                case '"':
                    if (!z.isEmpty() && ifString) {
                        ifString = false;
                        result.add(z);
                        z = "";
                    } else {
                        ifString = true;
                    }
                    result.add("\"");
                    break;
                case ' ':
                    if (!z.isEmpty() && !ifString) {
                        result.add(z);
                        z = "";
                    } else if (ifString) {
                        z += c;
                    }
                    break;
                default:
                    z += c;
                    break;
            }
        }
        if (!z.isEmpty()) {
            result.add(z);
        }

        return result;		
	}
	protected void parse(ArrayList<String> tokens) throws InterruptedException{


	}	
}



