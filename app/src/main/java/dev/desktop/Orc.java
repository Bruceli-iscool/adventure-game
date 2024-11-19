package dev.desktop;

// code for the orc enemy
public class Orc {
    int health;
    int stamina;
    int attack;
    int defence;
    boolean turn = true;
    public Orc(int h, int s, int a, int d) {
        health = h;
        stamina = s;
        attack = a;
        defence = d;

    }
    public boolean attacked(int damage) {
        health = defence - damage;
        turn = true;
        if (health < 0) {
            return false;
        } else {
            return true;
        }
        
    }
    public void turn() {
        health += 1;
    }
    public int attack() {
        return attack;
    }
    public int health() {
        return health;
    }

}
