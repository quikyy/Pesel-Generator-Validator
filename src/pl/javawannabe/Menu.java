package pl.javawannabe;
import pl.javawannabe.Pesels.PeselCheck;
import pl.javawannabe.Pesels.PeselGenerate;
import pl.javawannabe.Pesels.Pesel_Datebase;

import java.util.Scanner;

public class Menu {
    Pesel_Datebase pesel_datebase = new Pesel_Datebase();
    Scanner sc = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("");
        System.out.println("Choose option from menu:");
        System.out.println("1. Check PESEL for details");
        System.out.println("2. Show checked PESELS");
        System.out.println("3. Generate PESEL");
        System.out.println("4. Exit");
        System.out.println("");
    }

    public void checkPesel(){
        System.out.println("Enter PESEL: ");
        String userInput = sc.nextLine();
            try {
                PeselCheck pesel = new PeselCheck(userInput);
                pesel.showInformation(pesel);
                pesel_datebase.add(pesel);
            }
            catch (Exception e){
                wrongInput();
            }
    }

    public void generatePesel() {
        System.out.println("How many? Enter number:");
        try {
            int userInput = sc.nextInt();
            for(int i = 1; i <= userInput; i++){
                PeselGenerate peselGenerate = new PeselGenerate();
                System.out.print(i + ". ");
                peselGenerate.showInformation(peselGenerate);
            }
        }
        catch (Exception e){
            wrongInput();
        }
    }

    public void showCheckedPesels(){
        if(pesel_datebase.getCheckedSize() > 0){
            for(PeselCheck obj: Pesel_Datebase.getCheckedPesels()){
                obj.showInformation(obj);
            }
        }
        else{
            System.out.println("List is empty.");
        }
    }

    public void wrongInput(){
        System.out.println("Wrong input.");
    }

    public boolean quit() {
            return false;
    }
}
