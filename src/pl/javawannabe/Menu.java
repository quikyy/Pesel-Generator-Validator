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
        System.out.println("1. Check PESEL for details\n2. Show checked PESELS\n3. Generate PESEL\n4. Exit\n");
    }

    public void checkPesel(){
        System.out.println("Enter PESEL: ");
        String userInput = sc.nextLine();
            try {
                PeselCheck pesel = new PeselCheck(userInput);
                pesel.showInformation(pesel);
                if(pesel.isCorrect()){
                    pesel_datebase.addToDataBase(pesel);
                }
            }
            catch (Exception e){
                System.out.println("PESEL format or lenght is incorrect");
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
        if(pesel_datebase.getDataBaseSize() > 0){
            for(PeselCheck obj: Pesel_Datebase.getDataBase()){

                obj.showInformation(obj);
            }
        }
        else{
            System.out.println("List is empty.");
        }
        System.out.println("Amount: " + pesel_datebase.getDataBaseSize());
    }

    public void wrongInput(){
        System.out.println("Wrong input.");
    }

    public boolean quit() {
            return false;
    }
}
