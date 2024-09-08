package dev.desktop;
import java.util.Scanner;
public class App {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Welcome to Adventure Game");
        System.out.println();
        String ans = ask("Create a new character? Y, n");
        if ("Y".equals(ans.strip())) {
            @SuppressWarnings("unused")
            characterCreator c = new characterCreator();
            c.create();
        }
    }
    @SuppressWarnings("resource")
    public static String ask(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println(input);
        return scan.nextLine();
    }
}
