package dev.desktop;
class character {
    int attack, defence, health, stamina;
    public character(int a, int d, int h, int s) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
    }
    public void start() {
        System.out.println("Welcome explorer! You must find the map of the known lands!\nChoose a ability to train in\n1 for attack, 2 for defence, 3 for health, 4 for stamina");
        
    }
}

