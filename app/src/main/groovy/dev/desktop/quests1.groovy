package dev.desktop

class quests1 {
    // do another 2 quests in groovy, then create a new java class for quests
    // and rotate between them
    def attack, defence, health, stamina, gold
    quests1(def a, def d, def h, def s, def g) {
        attack = a
        defence = d
        health = h
        stamina = s
        gold = g
    }
    void quest5() throws InterruptedException, IOException {
        println "=========================================================\nQuest 5\n====================================================================";
        Thread.sleep(500);
        println "You arrive at a town and see a guard, 1 to talk to him, 2 to ignore him.";
        Thread.sleep(500);
        def n = App.ask(">");
        if ("1".equals(n)) {
            println "You talk to the guard and he tells you about bandits in the area that have been attacking the town.";
            Thread.sleep(500);
            println "He offers you 100 gold to kill the bandit leader (Very Hard, +3 health), 1 to accept, 2 to decline.";
            n = App.ask(">");
            if ("1".equals(n)) {
                println "You accept the quest and head out to find the bandit leader.";
                Thread.sleep(500);
                App.save(attack, defence, health, stamina, 6, gold);
                quest6();
            } else {
                println "You decline the quest and continue walking.";
            }

        }
        Thread.sleep(500);
        System.out.println("You walk further into the town and enter the bar.");
        Thread.sleep(500);
        println "The bar owner gives you a quest to find his lost sword in the Dungeons of Doom (+10 gold) (Hard, +3 health bonus)."
        Thread.sleep(500);
        println "1 to accept, 2 to decline.";
        n = App.ask(">");
        if ("1".equals(n)) {
            println "You accept the quest and head out to find the sword.";
            Thread.sleep(500);
            App.save(attack, defence, health, stamina, 7, gold);
            quest7();
        } else {
            println "You decline the quest and continue walking.";
            Thread.sleep(500);
            println "Another guard approaches you and tells you about the king's missing crown. (+10 gold) (Easy, +1 health bonus), 1 to accept, 2 to decline and go on the Bar owner's quest.";
            n = App.ask(">");
            if ("1".equals(n)) {
                println "You accept the quest and head out to find the crown.";
                Thread.sleep(500);
                App.save(attack, defence, health, stamina, 8, gold);
                quest8();
            } else {
                println("You decide to go find the bar owner's sword.");
                App.save(attack, defence, health, stamina, 7, gold);
                quest7();
        }
        }
    }
    void quest6() throws InterruptedException, IOException {
        // The Bandit leader quest
        // todo
        health += 3;
        defence += 2;
        shop();
        println "You travel in the woods to reach the bandit leader's hideout.";
        Thread.sleep(500);
        
    }
    void quest7() throws InterruptedException, IOException {
        // The bar owner's sword quest
        // hard difficulty
        // todo
        health += 3;
        defence += 1;
        shop();
    }
    void quest8() throws InterruptedException, IOException {
        // The king's crown quest
        // easy difficulty
        // todo
        health += 1;
        shop();
    }
}