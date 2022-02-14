package pl.javawannabe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        boolean keep = true;
        while (keep) {
            menu.displayMenu();
            String userChoice = sc.nextLine();
            switch (userChoice) {
                case "1":
                    menu.checkPesel();
                    break;
                case "2":
                    menu.showCheckedPesels();
                    break;
                case "3":
                    menu.generatePesel();
                    break;
                default:
                    menu.wrongInput();
                    break;

            }
        }

    }
}

