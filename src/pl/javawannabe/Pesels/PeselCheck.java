package pl.javawannabe.Pesels;
import java.util.ArrayList;

public class PeselCheck extends Pesel implements IPesels {
    public PeselCheck(String pesel){
        super();
        this.day = returnDay(pesel);
        this.month = returnMonth(pesel);
        this.year = returnYear(pesel);
        this.serial = returnSerial(pesel);
        this.sex = returnSex(pesel);
        this.pesel = pesel;
        this.dateOfBirth = returnDateOfBirth(this.day , this.month, this. year);
        this.validationDigit = returnValidationDigit(pesel);
        this.isValidate = checkValidation(pesel);
        this.isCorrect = checkIfCorrect(this.day, this.month, this.year);
    }

    private String returnDay(String pesel) {
        return pesel.substring(4,6);
    }
    private String returnMonth(String pesel) {
        int month = Integer.parseInt(String.valueOf(pesel).substring(2,4));
        if(month >= 81 && month <= 92){
            month = month % 80;
        }
        else if(month >= 1 && month <= 12) {
            month = month;
        }
        else if(month >= 21 && month <= 32){
            month = month % 20;
        }

        if(month < 10){
            return "0" + month;
        }
        else{
            return String.valueOf(month);
        }


    }
    private String returnYear(String pesel) {
        int month = Integer.parseInt(String.valueOf(pesel).substring(2,4));
        String year = pesel.substring(0,2);
        if(month >= 81 && month <= 92){
            return "18" + year;
        }
        else if(month >= 1 && month <= 12) {
            return "19" + year;
        }
        else if(month >= 21 && month <= 32){
            return "20" + year;
        }
        else {
            return null;
        }
    }
    private String returnSerial(String pesel){
        return pesel.substring(6,8);
    }
    private String returnSex(String pesel){
        int sex = Integer.parseInt(pesel.substring(9, 10));
        if(sex % 2 == 0){
            return "Female";
        }
        else {
            return "Male";
        }
    }
    private String returnValidationDigit(String pesel){
        return pesel.substring(10, 11);
    }
    private String returnDateOfBirth(String day, String month, String year){
        return day + "." + month + "." + year;
    }
    private boolean checkValidation(String pesel){
        String _pesel = String.valueOf(pesel);
        char[] chars = _pesel.toCharArray();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(char elem: chars){
            numbers.add(Integer.valueOf(Character.toString(elem)));
        }
        int key_digit = numbers.get(10);
        int total = (numbers.get(0) + numbers.get(4) + numbers.get(8) + (numbers.get(1) + numbers.get(5) + numbers.get(9)) * 3 + (numbers.get(2) + numbers.get(6)) * 7 + (numbers.get(3) + numbers.get(7)) * 9) % 10;
        total = 10 - total;
        if(key_digit == total){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean checkIfCorrect(String day, String month, String year) {
        return Integer.parseInt(day) <= 31 && Integer.parseInt(month) <= 12 && Integer.parseInt(year) >= 1800;
    }

    @Override
    public void showInformation(Pesel pesel) {
        if(this.isCorrect()){
            System.out.println("");
            System.out.println("**************************");
            System.out.println("PESEL: " + pesel.getPesel());
            System.out.println("Date of birth: " + pesel.getDateOfBirth());
            System.out.println("Sex: " + pesel.getSex());
            System.out.println("Validation: " + pesel.isValidate());
            System.out.println("**************************");
            System.out.println("");
        }
        else{
            System.out.println("Pesel format is incorrect. Try again.");
        }
    }
}
