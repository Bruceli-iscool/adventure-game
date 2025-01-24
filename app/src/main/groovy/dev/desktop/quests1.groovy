package dev.desktop

class quests extends character {
    // do another 2 quests in groovy, then create a new java class for quests
    // and rotate between them
    int attack, defence, health, stamina, gold

    quests(int a, int d, int h, int s, int g) {
        super(a, d, h, s, g)
        attack = a
        defence = d
        health = h
        stamina = s
        gold = g
    }

    void quest5() throws InterruptedException, IOException {
        println "=========================================================\nQuest 5\n===================================================================="
        sleep 500
        println "You arrive at a town and see a guard, 1 to talk to him, 2 to ignore him."
        sleep 500
        def n = App.ask ">";
        if ("1" == n) {
            println "You talk to the guard and he tells you about bandits in the area that have been attacking the town."
            sleep 500
            println "He offers you 100 gold to kill the bandit leader (Very Hard, +4 health), 1 to accept, 2 to decline."
            n = App.ask(">")
            if ("1" == n) {
                println "You accept the quest and head out to find the bandit leader."
                sleep 500
                App.save attack, defence, health, stamina, 6, gold
                quest6()
            } else {
                println "You decline the quest and continue walking."
            }

        }
        sleep 500
        System.out.println("You walk further into the town and enter the bar.")
        sleep 500
        println "The bar owner gives you a quest to find his lost sword in the Dungeons of Doom (+10 gold) (Hard, +3 health bonus)."
        sleep 500
        println "1 to accept, 2 to decline."
        n = App.ask(">")
        if ("1" == n) {
            println "You accept the quest and head out to find the sword."
            sleep 500
            App.save attack, defence, health, stamina, 7, gold
            quest7()
        } else {
            println "You decline the quest and continue walking."
            sleep 500
            println "Another guard approaches you and tells you about the king's missing crown. (+10 gold) (Easy, +1 health bonus), 1 to accept, 2 to decline and go on the Bar owner's quest."
            n = App.ask(">")
            if ("1" == n) {
                println "You accept the quest and head out to find the crown."
                sleep 500
                App.save attack, defence, health, stamina, 8, gold
                quest8()
            } else {
                println("You decide to go find the bar owner's sword.")
                App.save attack, defence, health, stamina, 7, gold
                quest7()
            }
        }
    }

    void quest6() throws InterruptedException, IOException {
        // The Bandit leader quest
        health += 4
        defence += 2
        shop()
        println "You travel in the woods to reach the bandit leader's hideout."
        sleep 500
        println "A group of bandits are ahead, patrolling the road, 1 to sneak past them, 2 to fight them."
        sleep 500
        def n = App.ask ">";
        if ("1" == n) {
            sleep 500
            println "You sneak into a bush and sneaks up to the patrol."
            sleep 500;
            println "Then, the leader of the group sees you and draws his sword! His men attack you!"
            sleep 500;
        }
        println "The first bandit swings first."
        combat 3, 0, 4, 3
        sleep 500;
        println "You killed the first bandit!"
        sleep 250
        println "The second bandit charges at you!"
        combat 3, 0, 4, 3
        sleep 500
        println "You killed the second bandit!"
        sleep 250
        println "The leader of the group runs away! He drops a potion of minor healing (+ 2 health)."
        health += 2
        println "Your stats are: Attack: " + attack + "\nDefence: " + defence + "\nHealth: " + health + "\nStamina: " + stamina
        sleep 500
        println "You continue down the path and exit the forest. Ahead is the bandit's hideout."
        sleep 500
        println "Two bandit guards are talking to the leader of the patrol. 1 to sneak kill them, 2 to sneak past them."
        n = App.ask ">"
        if ("1" == n) {
            sleep 500
            println "You sneak up behind the bandit guards and kill them! The the leader of the patrol sees you!"
            sleep 500
            println "The leader of the patrol charges at you, but you parry his attack."
            combat 3, 0, 6, 3
            println "You killed the leader of the patrol and received another potion of minor healing (+ 2 health)."
            health += 2
        } else {
            sleep 500
            println "As you sneak past the guards, the leader of the patrol sees you!"
            sleep 500
            println "You quickly kill the bandit guards, but the leader of the patrol lunges at you! (- 2 health) "
            health -= 2
            if (health <= 0) {
                death()
            }
            combat(3, 0, 6, 3)
            sleep 500
            println "You killed the leader of the patrol and received another potion of minor healing (+ 2 health)."
            health += 2
        }
        println "You enter the bandits hideout and sneak behind some ruins."
        sleep 500
        println "Two bandit guards are patrolling the entrance to the bandit leader's lair."
        sleep 500
        println "To the left, there is a damaged watch tower with a bandit archer watching the entrance to the bandit leader's lair."
        sleep 500
        println "1 to fight the guards, 2 to climb the watch tower and kill the archer."
        n = App.ask ">"
        if ("1" == n) {
            sleep 500
            println "You wait until the guards are close to the ruins and you attack the first guard."
            sleep 500
            println "You kill the first guard, but the second guard sees you and attacks you!"
            sleep 500
            combat 3, 0, 4, 3
            println "You killed the second guard!"
            sleep 500 
            println "You grab the dead bandit guard's bow and kill the bandit archer! You also find a potion of minor healing (+ 2 health)."
            health += 2
            sleep 500
        } else {
            // todo
        }        
        println "You enter the bandit leader's lair and see the bandit leader with a bandit patrol commander and 2 guards"
        sleep 500
        println "The first guard attacks you!"
        combat 3, 0, 4, 3
        sleep 500

    }

    void quest7() throws InterruptedException, IOException {
        // The bar owner's sword quest
        // hard difficulty
        // todo
        health += 3
        defence += 1
        shop()
    }
    void quest8() throws InterruptedException, IOException {
        // The king's crown quest
        // easy difficulty
        // todo
        health += 1
        shop()
    }
}