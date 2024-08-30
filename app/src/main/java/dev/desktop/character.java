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
        System.out.println("Welcome explorer! The emperor wants to see you!\nChoose a ability to train in\n1 for attack, 2 for defence, 3 for health, 4 for stamina");
        String ans = App.ask(">");
        if ("1".equals(ans.strip())) {
            attack += 1;
        }
        if ("2".equals(ans.strip())) {
            defence += 1;
        }
    }
}

