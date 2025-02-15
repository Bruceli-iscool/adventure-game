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
        println "The bar owner gives you a quest to find his lost sword in the Cliffs of Death (+10 gold) (Hard, +3 health bonus)."
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
        def n = App.ask ">"
        if ("1" == n) {
            sleep 500
            println "You sneak into a bush and sneaks up to the patrol."
            sleep 500
            println "Then, the leader of the group sees you and draws his sword! His men attack you!"
            sleep 500
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
            println "You sneak to the watch tower door but the bandit guards see you!"
            sleep 500
            combat 3, 0, 4, 3
            println "You killed the first guard!"
            sleep 500
            println "The second guard attacks you!"
            sleep 500
            combat 3, 0, 4, 3
            println "You killed the second guard!"
            sleep 500
            println "You move up the watch tower and kill the bandit archer."
            sleep 500
            println "You also find a potion of minor healing (+ 2 health)."
            health += 2
            sleep 500
        }        
        println "You enter the bandit leader's lair and see the bandit leader and 2 guards"
        sleep 500
        println "The first guard attacks you!"
        combat 3, 0, 4, 3
        sleep 500
        println "You killed the first guard!"
        sleep 500
        println "The second guard attacks you!"
        combat 3, 0, 4, 3
        sleep 500
        println "You killed the second guard!"
        sleep 500
        println "The bandit leader attacks you!"
        combat 3, 0, 10, 3
        sleep 500
        println "You killed the bandit leader and received another potion of minor healing (+ 2 health)."
        health += 2
        sleep 500
        println "You also find a chest with 40 gold in it."
        gold += 40
        sleep 500
        println "You return back to the forest to return to the town."
        sleep 500
        println "As you travel through the forest, a wolf attacks you!"
        combat 2, 0, 3, 1
        sleep 500
        println "You killed the wolf!"
        sleep 500
        println "You return to the town and receive your reward."
        gold += 100
        println "Your stats are: Attack: " + attack + "\nDefence: " + defence + "\nHealth: " + health + "\nStamina: " + stamina
        sleep 500
        App.save attack, defence, health, stamina, 9, gold
        def k = new quest2 (attack, defence, health, stamina, gold)
        k.quest9()
    }

    void quest7() throws InterruptedException, IOException {
        // The bar owner's sword quest
        // hard difficulty
        println "=========================================================\nQuest 7\n===================================================================="
        health += 3
        defence += 1
        shop()
        println "The bar owner tells you that his sword was last seen in the Cliffs of Death."
        sleep 500
	println "You travel along the roads and get ambushed by a bandit!"
	sleep 500
	println "They demand 10 gold. 1 to fight them, 2 to give them the gold"
	def n = App.ask ">"
	if (n == "1") {
	   println "You lunge at the bandit!"
	   sleep 500
	   combat 3, 0, 4, 3
	   println "You defeated the bandit!"
       sleep 500
	} else {
           println "You give the bandit 10 gold."
           sleep 500
           gold -= 10
    }
        println "You continue to the Cliffs of Death."
        sleep 500
        println "As you travel down the path, the path ends. You must climb down."
        sleep 500
        println "As you climb down, a wolf jumps at you! (-2 health)"
        health -= 2
        if (health < 0) {
            death()
        }
        combat 2, 0, 4, 1;
        println "You killed the wolf!"
        sleep 500
        println "You continue climbing down the cliffs until you reach the bottom."
        sleep 500
        println "You see two entrances to a cave, 1 to enter the left entrance, 2 to enter the right entrance."
        n = App.ask ">"
        if (n == "1") {
            sleep 500
            println "You enter the cave from the left entrance."
            sleep 500
            println "As you travel down, there is a split in the path. 1 to go left, 2 to go right."
            n = App.ask ">"
            if (n == "1") {
                println "You go left and see a chest with 20 gold in it. (+20 gold)"
                gold += 20
                sleep 500
                println "You continue down the left path and see a split in the path. 1 to go left, 2 to go right."
                n = App.ask ">"
                if (n == "1") {
                    println "You go left and encounter a dead end. You turn back to the split and go right."
                }
                println "You go right and see some dead bodies on the ground. 1 to search the bodies, 2 to continue down the path."
                if (n=="1") {
                    sleep 500
                    println "You search the bodies and find a potion of minor healing (+2 health)."
                    health += 2
                    sleep 500
                    println "You also find a note from the bar owner."
                }
                println "You continue down the path and see a mercenary guarding the path ahead"
                sleep 500
                combat 3, 0, 6, 3
                println "You killed the mercenary!"
                sleep 500
                println "The mercenary has 5 gold (+5 gold)"
                gold += 5
                sleep 500
                println "You continue down the path and see rocks blocking the path."
                sleep 500
                println "You see a locked chest on the floor. There is a code on the chest."
                sleep 500
                println "There is a missing number in the code. 12_375698"
                sleep 500
                while (!f){
                    n = App.ask "What is the code?"
                    def l = n.replaceAll "\\s", ""
                    if (l == "4") {
                        println "You must enter the entire code."
                    } else if (l == "124375698") {
                        println "You entered the correct code!"
                        break
                    } else {
                        println "You entered the wrong code!"
                    }
                }
                println "Inside the chest is a pickaxe."
                sleep 500
                println "You use the pickaxe to break the rocks blocking the path."
                sleep 500
                println "You continue down the path and see a spider!"
                sleep 500
                combat 2, 0, 4, 1
                println "You killed the spider!"
                sleep 500
                println "You continue down the path and see the sword!"
                sleep 500
                println "As you try to pull the sword out of the rock, the bar owner appears!"
                sleep 500
                println "He tells you that the sword is a ruse to kill you!"
                sleep 500
                println "He attacks you!"
                combat 3, 0, 5, 2
                println "You kill the bar owner! (+10 gold)"
                sleep 500
                println "You leave the cave and return to town."
                println "Your stats are: Attack: " + attack + "\nDefence: " + defence + "\nHealth: " + health + "\nStamina: " + stamina
                App.save attack, defence, health, stamina, 9, gold
                def k = new quest2 (attack, defence, health, stamina, gold)
                k.quest9()
            } else {
                println "You go down the right side of the path."
                sleep 500
                println "As you move down the path, you see a troll ahead."
                sleep 500
                println "The troll swings at you!"
                combat 3, 0, 4, 2    
                println "You killed the troll! He drops a piece of troll armor (+ 1 defence)"
                sleep 500
                println "You continue down the path and encounter a locked metal gate."
                sleep 500
                println "There is a puzzle on the keypad."
                sleep 500
                println "The puzzle says that you must find the missing word."
                sleep 500
                println "What is the missing word in high, low, down. ___?"
                while (true) {
                    n = App.ask ">"          
                    if (n == "up" || n == "Up" || n == "UP") {
                        break;
                    } else {
                        sleep 500
                        println "The door does not open! Try again!"
                    }
                }
                sleep 500
                println "You open the door and continue down the path."
                sleep 500
                println "You encounter a split in the path! 1 to go left, 2 to go right"
                n = App.ask ">"
                if (n=="1") {
                    sleep 500
                    println "You go down the left side of the path and encounter the bar owner's sword!"
                    sleep 500
                    println "You grab the sword, but suddenly the bar owner appears and tells you that the sword is a ruse to kill you!"
                    sleep 500 
                    println "But then a troll attacks and kill the bar owner!"
                    sleep 500
                    println "The troll attacks you!"
                    combat 4, 0, 8, 1
                    println "You killed the troll!"
                    sleep 500 
                    println "You grab the sword and take 10 gold from the bar owner's dead body."
                    golf += 10
                    App.save attack, defence, health, stamina, 9, gold
                    def k = new quest2(attack, defence, health, stamina, gold)
                    k.quest9()
                } else {
                    sleep 500
                    println "You go down the right side of the path."
                    sleep 500
                    println "As you travel down the path, you encounter a troll!"
                    sleep 500
                    combat 4, 0, 8, 1
                    println "You killed the troll!"
                    sleep 500
                    println "The troll dropped 10 gold! (+10 gold)"
		    sleep 500
		    gold += 10
		    println "You continue down the path and and encounter the bar owner's sword."
	   	    sleep 500
		    println "The bar owner appears and tells you the quest was a ruse to kill you!"
		    sleep 500
		    combat 3, 0, 8, 1
            println "You killed the bar owner and he drops 10 gold! (+10 gold)"
		    gold += 10
            sleep 500
		    println "You return back to the town."
		    App.save attack, defence, health, stamina, 9, gold
		    def k = new quest2(attack, defence, health, stamina, gold)
		    k.quest9() 
        	 }
          }
        } else {
            sleep 500
            println "You enter the cave on the right side."
            sleep 500
	         println "You see a treasure chest on the side. 1 to open it, 2 to ignore it."
	        n = App.ask ">"
	        if (n == "1") {
	   	        sleep 500
		        println "You try to open the chest but it was a trap!"
		        sleep 500
		        println "Poison arrows are fired at you! (-2 health)"
		        sleep 500
	    	    health -= 2
		        if (health <= 0) {
		         death()
		        }
            }
	        sleep 500
            println "As you continue down the path you encounter a rock slide!"
            sleep 500
            println "Now your path ahead is blocked by a pile of rocks!"
            sleep 500
            println "You see a lever connected to a wire nearby, 1 to pull the lever, 2 to inspect the wire."
            n = App.ask ">"
            if (n == "1") {
                sleep 500
                println "You pull the lever and the rocks are cleared away. But it also activated a wire connected to a trap! (-1 health)"
                health -= 1
                if (health <= 0) {
                    death()
                }
            } else {
                sleep 500
                println "You inspect the wire and see that there is two wires, one goes to the contraption that clears the rocks, one goes to a trap!"
                sleep 500
                println "You cut the wire that connects to the trap and pull the lever, clearing the rocks"
            }
            sleep 500
            println "You continue down the path and encounter a troll!"
            combat 3, 0, 8, 1
            print "You killed the troll! The troll dropped 10 gold (+ 10 gold)"
            gold += 10
            sleep 500
            println "You continue down the path and encounter the bar owner. He tells you that this quest is a ruse to kill you!"
            sleep 500
            println "The bar owner attacks you!"
            combat 2, 0, 12, 1
            sleep 500
            println "You killed the bar owner! He drops 10 gold (+10 gold)"
            gold += 10
            sleep 500
            println "You return back to the town"
            App.save attack, defence, health, stamina, gold
            def k = new quest2(attack, defence, health, stamina, gold)
            k.quest9()
        }
    }
    void quest8() throws InterruptedException, IOException {
        // The king's crown quest
        // easy difficulty
        // todo
        health += 1
        shop()
        println "You follow the guards directions to the location of the kings crown."
        sleep 500
        println "But as you continue down the path you encounter a bandit!"
        combat 3, 0, 4, 1
        println "You killed the bandit! He drops a potion of minor healing (+1 health)."
        health += 1
        sleep 500
        println "As you continue down the path you see a broken drawbridge ahead!"
        sleep 500
        println "1 to swim across the river, 2 to gather some wood to repair the bridge."
        def n = App.ask ">"
        if (n=="1") {
            sleep 500
            println "You swim across the river but you are hurt by the violent currents! (-2 health)"
            health -= 2
            if (health <= 0) {
                death()
            }
            sleep 500
        } else {
            sleep 500
            println "You walk into the forest to gather some wood and repair the bridge."
            sleep 500
        }
        println "You go into the forest on the other side of the river and encounter a witch!"
        combat 2, 0, 7, 1
        println "You kill the witch! The witch drops a potion of minor healing (+1 health)"
        sleep 500
        health += 1
        println "You also find a map to the witch house! 1 to travel to the witch house, 2 to continue on the path"
        n = App.ask ">"
        if (n=="1") {
            //todo
        }
    }
}
