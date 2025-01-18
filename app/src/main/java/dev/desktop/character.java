package dev.desktop;

import java.io.IOException;
import java.util.Random;
// todo story
class character {
    int attack, defence, health, stamina, gold;

    public character(int a, int d, int h, int s, int g) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
        gold = g;
    }

    public void start() throws InterruptedException, IOException {
        App.save(attack, defence, health, stamina, 0, 0);
        System.out.println(
                "=============================================================================\nTutorial\n===============================================================================");
        Thread.sleep(100);
        Thread.sleep(100); 
        System.out.println("Welcome to the tutorial. Adventure-game is a game where you clear areas. \nThis Tutorial will help you kill your first enemy.");
        Thread.sleep(1500);
        System.out.println("Your first enemy is an Orc. He has 10 health.\n");
// combat

    System.out.println("You killed the Orc! You will now move on to the next area! Here is your reward of 1 stamina.");
    Thread.sleep(1000);
    stamina += 1;    
    System.out.println("""
        Your stats are: 
        attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(1000);
    App.save(attack, defence, health, stamina, 1, 0);
    quest1();
}
public void quest1() throws InterruptedException, IOException {
    System.out.println("=========================================================\nArea 1\n====================================================================");
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
                death();
            }
 
        }
        System.out.println("You continue down the cave.");
        Thread.sleep(500);
        k = App.ask("You encounter a split in the path again. 1 to go left, 2 to go right.\n>");
        if ("1".equals(k)) {
            System.out.println("You continue down the left path and leave the cave.");
            App.save(attack, defence, health, stamina, 2, 0);
            Thread.sleep(500);
            System.out.println("You have completed the first quest!");
            quest2();
        } else {
            System.out.println("You continue down the right path and encounter another Orc!");
//combat
        System.out.println("You killed the Orc! You continue down the path and exit the cave.");
        App.save(attack, defence, health, stamina, 2, 0);
        Thread.sleep(500);
        System.out.println("You have completed the first quest!");
        quest2();
        }
    } else {
        System.out.println("You move to the right side of the cave and continue down the path.");
        Thread.sleep(500);
        k = App.ask("You path is blocked by a door. 1 to sneak in, 2 to knock it down.");
        if ("1".equals(k)) {
            System.out.println("You see a orc, but he does not see you.");
            Thread.sleep(500);
            k = App.ask("1 to exit the room, 2 to silently kill the orc.");
            if ("1".equals(k)) {
                System.out.println("You sneak out of the room and continue down the path.");
            } else {
                System.out.println("You kill the orc and continue down the path and exit the cave.");
                App.save(attack, defence, health, stamina, 2, 0);
                quest2();
            }
        } else {
            System.out.println("You knock down the door and encounter an Orc!");
//combat
        System.out.println("You killed the Orc! You continue down the path and exit the cave.");
        App.save(attack, defence, health, stamina, 2, 0);
        quest2();
        }}
}
public void quest2() throws InterruptedException, IOException {
    System.out.println("""
                Your stats were:\s
                attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    System.out.println("=========================================================\nArea 2\n====================================================================");
    System.out.println("Congratulations! You unlocked the shop!");
    System.out.println("You can access the shop at the start of the quest.");
    Thread.sleep(1000);
    System.out.println("Here is 20 gold to get started!");
    gold = 20;
    System.out.println("Now you can choose which quest to go on.");
    Thread.sleep(500);
    System.out.println("1 to go to Cave of Death (reward 50 gold), 2 to go to the Bandits Lair (reward 20 gold)");
    String k = App.ask(">");
    if ("1".equals(k)) {
        quest3();
        App.save(attack, defence, health, stamina, 3, gold);
    }else {
        quest4();
        App.save(attack, defence, health, stamina, 4, gold);
    }
    }
public void quest3() throws InterruptedException{
     // cave of death

    shop();
    System.out.println("=========================================================\nArea 3\n====================================================================");
    System.out.println("You enter the Cave of Death. Suddenly, a bandit jumps out and attacks you! (-2 health)");
    health -= 2;
    if (health < 1) {
        death();
    }
//combat
    System.out.println("You defeated the bandit! You continue down the path.");
    Thread.sleep(500);
}
public void quest4() throws InterruptedException{
    // bandits lair
    shop();
    // todo
}

boolean checkHealth(int health) {
    return health >= 1;
}
void shop() throws InterruptedException {
     // opens a shop
    System.out.println("Welcome to the shop!");
    Thread.sleep(500);
    System.out.println("1 for a health potion (cost 20 gold) (+ 5 health)\n2 for potion of minor healing (10 gold) (+ 2 health)\n3 for a set of Orc armor (200 gold) (+ 5 defence)\n4 for an Imperial Sword (200 gold) (+ 3 attack)\n5 for Imperial armor (300 gold) (+ 7 defence)\n6 to exit the shop");
    String k = App.ask(">");
    if (1 == Integer.parseInt(k)) {
        if (gold >= 20) {
            health += 5;
            gold -= 20;
        } else {
            System.out.println("You do not have enough gold.");
        }
    } else if (2 == Integer.parseInt(k)) {
        if (gold >= 10) {
            health += 2;
            gold -= 10;
        } else {
            System.out.println("You do not have enough gold.");
        }
    } else if (3 == Integer.parseInt(k)) {
        if (gold >= 200) {
            defence += 5;
            gold -= 200;
        } else {
            System.out.println("You do not have enough gold.");
        }
    } else if (4 == Integer.parseInt(k)) {
        if (gold >= 200) {
            attack += 3;
            gold -= 200;
        } else {
            System.out.println("You do not have enough gold.");
        }
    } else if (5 == Integer.parseInt(k)) {
        if (gold >= 300) {
            defence += 7;
            gold -= 300;
        } else {
            System.out.println("You do not have enough gold.");
        }
    } else {
        return;
    }
}
void death() throws InterruptedException {
    System.out.println("You Died!");
    System.out.println("""
                Your stats were:\s
                attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(500);
    System.exit(0);
}
void combat(int a, int d, int h, int s) throws InterruptedException {

}
}

