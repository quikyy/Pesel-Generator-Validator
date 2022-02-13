package pl.javawannabe;
import pl.javawannabe.Pesels.Pesel;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public void displayMenu(){
        System.out.println("");
        System.out.println("Choose option from menu:");
        System.out.println("1. Check PESEL for details.");
        System.out.println("2. Generate PESEL");
        System.out.println("");
    }

    public void checkPesel(){
        System.out.println("Enter PESEL: ");
        String userInput = sc.nextLine();
        try {
            Pesel pesel = new Pesel(userInput);
            pesel.showDetailedInformation(pesel);
        }
        catch (Exception e){
            System.out.println("Pesel format is invalid.");
        }

    }

    public void generatePesel() {
            Pesel pesel = new Pesel();
            pesel.showPesel(pesel);

    }
}
