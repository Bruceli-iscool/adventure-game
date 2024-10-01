package dev.desktop;

// code for the orc enemy
public class Orc {
    int health = 10;
    int stamina = 1;
    int attack = 5;
    int defence = 2;
    boolean turn = true;
    public boolean attacked(int damage) {
        health = defence - damage;
        turn = true;
        if (health < 0) {
            return false;
        } else {
            return true;
        }
        
    }
    public boolean turn() {
        health += 1;
        if (turn == true) {
            return true;
        } else {
            return false;
        }
    }
    public int attack() {
        return attack;
    }
    public int health() {
        return health;
    }

}
