package dev.desktop;

import java.io.IOException;
import java.util.Random;
// todo story
class character {
    int attack, defence, health, stamina;

    public character(int a, int d, int h, int s) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
    }

    public void start() throws InterruptedException, IOException {
        App.save(attack, defence, health, stamina, 0);
        System.out.println(
                "=============================================================================\nTutorial\n===============================================================================");
        Thread.sleep(100);
        Thread.sleep(100); 
        System.out.println("Welcome to the tutorial. Adventure-game is a game where you clear areas. \nThis Tutorial will help you kill your first enemy.");
        Thread.sleep(1500);
        System.out.println("Your first enemy is an Orc. He has 10 health.\n");
        Orc o = new Orc(10, 1, 4, 5);
        while (o.health > 0 && health > 0){
            System.out.println("""
                Your stats are: 
                attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
            System.out.println("1 to attack, 2 to block.");
            String n = App.ask(">");
            if (n.equals("1")) {
                Random k = new Random();
                int c = k.nextInt(4);
                if (c== 0) {
                    System.out.println("Your attack failed!");
                } else {
                o.attacked(attack);
                o.printStats();
                o.turn();}
            } else {
                defence = o.attack() - defence;
                health = health-defence+Math.round(stamina/2);
                o.turn();
                continue;
            } 
            health = health-o.attack()+Math.round(stamina/2);


    }
    if (health < 1) {
        System.out.println("Game Over!");
        System.exit(0);
    }
    System.out.println("You killed the Orc! You will now move on to the next area! Here is your reward of 1 stamina.");
    Thread.sleep(1000);
    stamina += 1;    
    System.out.println("""
        Your stats are: 
        attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(1000);
    App.save(attack, defence, health, stamina, 1);
    quest1();
}
public void quest1() throws InterruptedException {
    System.out.println("=========================================================\nArea 1\n====================================================================");
    // todo finish area 1 enemies and choices
    System.out.println("You enter a cave. There is two paths. 1 to go left, 2 to go right.");
    String k = App.ask(">");
    //noinspection StatementWithEmptyBody
    if ("1".equals(k)) {
        Thread.sleep(500);
        System.out.println("You travel down the left side of the cave and encounter two doors.");
        k = App.ask("1 to go through the first door, 2 to go through the second door.\n>");
        if ("1".equals(k)) {
            System.out.println("You find a health potion!");
            Thread.sleep(500);
            System.out.println("You received 1 health");
            health += 1;
            Thread.sleep(500);
            System.out.println("You leave the room.");
        } else {
            System.out.println("You fall into a pit with venom snakes!");
            Thread.sleep(500);
            System.out.println("You fight them off but you lose 2 health.");
            health -= 2;
            if (checkHealth(health)) {
                Thread.sleep(500);
                System.out.println("You climb out of the pit and leave the room.");
            } else {

            }
        }
    } else {
        //todo
    }
}
boolean checkHealth(int health) {
        if (health < 1) {
            return false;
        } else {
            return true;
        }
}
void death() throws InterruptedException {
    System.out.println("You Died!");
    Thread.sleep(500);
}
}

