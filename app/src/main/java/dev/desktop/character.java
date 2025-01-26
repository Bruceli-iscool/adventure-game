package dev.desktop;

import java.io.IOException;
import java.util.Random;

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
        System.out.println("Welcome to the tutorial. Adventure-game is a game where you complete quests. \nThis Tutorial will help you kill your first enemy.");
        Thread.sleep(1500);
        System.out.println("Your first enemy is an Orc. He has 10 health.\n");
// combat
    combat(2, 2, 6, 2);
    System.out.println("You killed the Orc! You will now move on to the next area! Here is your reward of 1 stamina.");
    Thread.sleep(1000);
    stamina += 1;    
    System.out.println("""
        Your stats are:\s
        attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(1000);
    App.save(attack, defence, health, stamina, 1, 0);
    quest1();
}
public void quest1() throws InterruptedException, IOException {
    health += 3;
    defence += 1;
    System.out.println("=========================================================\nQuest 1\n====================================================================");
    System.out.println("You enter a cave. There is two paths. 1 to go left, 2 to go right.");
    String k = App.ask(">");
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
combat(3, 0, 6, 1);
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
combat(3, 0, 6, 1);

        System.out.println("You killed the Orc! You continue down the path and exit the cave.");
        App.save(attack, defence, health, stamina, 2, 0);
        quest2();
        }}
}
public void quest2() throws InterruptedException, IOException {
    System.out.println("""
                Your stats are:\s
                attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    System.out.println("=========================================================\nQuest 2\n====================================================================");
    System.out.println("Congratulations! You unlocked the shop!");
    System.out.println("You can access the shop at the start of the quest.");
    Thread.sleep(1000);
    System.out.println("Here is 20 gold to get started!");
    gold = 20;
    System.out.println("Now you can choose which quest to go on.");
    Thread.sleep(500);
    System.out.println("1 to go to Cave of Death (reward 50 gold) (Hard, recommend health > 6, Bonus health +3), 2 to go to the Bandits Lair (reward 20 gold) (Easy, recommend health > 5, Bonus health +2)");
    String k = App.ask(">");
    if ("1".equals(k)) {
        quest3();
        App.save(attack, defence, health, stamina, 3, gold);
    }else {
        quest4();
        App.save(attack, defence, health, stamina, 4, gold);
    }
    }
public void quest3() throws InterruptedException, IOException {
     // cave of death
    health += 3;
    defence += 1;
    shop();
    System.out.println("=========================================================\nQuest 3\n====================================================================");
    System.out.println("You enter the Cave of Death. Suddenly, a bandit jumps out and attacks you! (-2 health)");
    health -= 2;
    if (health < 1) {
        death();
    }
//combat
combat(3, 0, 4, 3);
    System.out.println("You defeated the bandit! You continue down the path.");
    Thread.sleep(500);
    System.out.println("You travel down the cave and see trap ahead with a puzzle you must solve. The trap says 'The beast shall past.'");
    Thread.sleep(500);
    System.out.println("Dragon, Fish, Wolf, Cat statues are next to the trap. You must choose the correct option.");
    String k = App.ask(">");
    String cleanedK = k.replaceAll("\\s", "");
    if (cleanedK.equals("Dragon")) {
        Thread.sleep(500);
        System.out.println("The drawbridge lowers over the trap and you continue down the path.");
    } else {
        Thread.sleep(500);
        System.out.println("The drawbridge does not lower and you fall into the trap. You lose 2 health.");
        System.out.println("""
            Your stats are:\s
            attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
        Thread.sleep(500);
        System.out.println("You climb out of the trap and continue down the path.");
        health -= 2;
        if (health < 1) {
            death();
        }
    }
    System.out.println("You travel down the cave and see ruins. 1 to go explore the ruins, 2 to go deeper in the cave.");
    k = App.ask(">");
    Thread.sleep(500);
    if ("1".equals(k)) {
        System.out.println("You explore the ruins and discover two chests. 1 to open the first chest, 2 to open the second chest.");
        k = App.ask(">");
        Thread.sleep(500);
        if ("1".equals(k)) {
            System.out.println("You open the first chest and find 20 gold! (+ 20 gold)");
            gold += 20;
        } else {
            System.out.println("You open the second chest and discover an rotten health potion. (-1 stamina)");
            if (stamina > 0) {
                stamina -= 1;
            } else {
                stamina = 0;
            }
        }
        Thread.sleep(500);
        System.out.println("You continue down the path and leave the ruins.");
    }
    System.out.println("You continue down the cave and encounter a skeleton!");
    combat(4, 2, 4, 1);
    System.out.println("You killed the skeleton! You continue down the path.");
    Thread.sleep(500);
    System.out.println("You encounter a room ahead. 1 to enter the room, 2 to continue down the path.");
    k = App.ask(">");
    Thread.sleep(500);
    if ("1".equals(k)) {
        System.out.println("You enter the room, it turns out to be an abandoned hideout.");
        Thread.sleep(500);
        System.out.println("You explore the room and discover a health potion! (+ 2 health)");
        health += 2;
        Thread.sleep(500);
    }
    System.out.println("You continue down the path and reach the Trolls Lair.");
    System.out.println("The Troll King is a powerful enemy, unlike regular trolls, he has high defense.");
    combat(4, 7, 8, 1);
    System.out.println("You killed the Troll King, he had one health potion (+ 2 health)! You continue down the path and exit the cave. (+50 gold)");
    gold += 50;
    health += 2;
    App.save(attack, defence, health, stamina, 5, gold);
    quests(5);
}
public void quest4() throws InterruptedException, IOException {
    health += 2;
    defence += 1;
    System.out.println("=========================================================\nQuest 4\n====================================================================");
    // bandits lair
    shop();
    System.out.println("You enter the Bandits Lair. It is a tiny cave with some bandits roaming around. You must fight them.");
    System.out.println("You see a bandit and he draws his weapon!");
    combat(3, 0, 4, 3);
    System.out.println("You defeated the bandit! You continue down the path.");
    Thread.sleep(500);
    System.out.println("You travel through the cave and see a room labeled 'Loot', 1 to enter the room, 2 to continue down the path.");
    String k = App.ask(">");
    Thread.sleep(500);
    if ("1".equals(k)) {
        System.out.println("You enter the room, a bandit master sees you!");
        combat(3, 2, 5, 3);
        System.out.println("You defeated the bandit master! You start exploring the room.");
        Thread.sleep(500);
        System.out.println("You explore the room and discover 4 gold! (+ 4 gold)");
        gold += 4;
        Thread.sleep(500);
    }
    System.out.println("You continue down the path and see a split in the cave. 1 to go left, 2 to go right.");
    k = App.ask(">");
    Thread.sleep(500);
    if ("1".equals(k)) {
        System.out.println("You go left and see two bandits!");
        combat(3, 0, 4, 3);
        System.out.println("You defeated the first bandit.");
        combat(3, 0, 4, 3);
        System.out.println("You defeated the second bandit, he has a potion of minor healing (+1 health)! You continue down the path and exit the cave (+20 gold).");
        gold += 20;
        health += 1;
        App.save(attack, defence, health, stamina, 5, gold);
        quests(5);
    } else {
        System.out.println("You go right and see a dead bandit and an Orc!");
        combat(3, 0, 10, 1);
        System.out.println("You defeat the Orc, he has a damaged Orc chest plate (+2 defense)! You continue down the path and exit the cave (+20 gold).");
        gold += 20;
        defence += 2;
        App.save(attack, defence, health, stamina, 5, gold);
        quests(5);
    }

}
public void quests(int level) throws IOException, InterruptedException {
    quests j = new quests(attack, stamina, defence, health, gold);
    quest2 k = new quest2(attack, stamina, defence, health, gold);
    switch (level) {
        case 5 -> j.quest5();
        case 6 -> j.quest6();
        case 7 -> j.quest7();
        case 8 -> j.quest8();
        case 9 -> k.quest9();
    }
}

boolean checkHealth(int health) {
    return health >= 1;
}

void shop() throws InterruptedException {
     // opens a shop
     System.out.println("""
                Your stats are:\s
                attack:\s""" + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    System.out.println("=========================================================\nShop\n====================================================================");
    System.out.println("Welcome to the shop!");
    Thread.sleep(500);
    System.out.println("You have " + gold + " gold.");
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
        Random g = new Random();
        Enemy e = new Enemy(h, s, a, d);
        while (e.health > 0 && health > 0) {
            System.out.println("Your stats are:\nattack: " + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
            String ans = App.ask("1 to attack, 2 to block");
            if ("1".equals(ans)) {
                int c = g.nextInt(10);
                if (c == 7) {
                    System.out.println("Your attack failed!");
                } else {
                    e.attacked(attack);
                }
                health = health - e.attack();
            } else {
                if (defence < 0) {
                    defence = 0;
                }
                if (defence >= e.attack) {
                    defence -= e.attack;
                    health +=  Math.round( stamina/3);
                } else {
                health = health - (e.attack - defence);
                health +=  Math.round( stamina/3);
                defence = defence - e.attack;
                }
            }
            e.stats();
        }
    if (health < 1) {
        death();
    }
    }

}

