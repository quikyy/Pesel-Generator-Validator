package pl.javawannabe.Pesels;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Random;

public class Pesel{
    public String day;
    public String month;
    public String year;
    public String dateOfBirth;
    public String sex;
    public String serial;
    public String finalPesel;

    public int sexInt;
    public String validationDigit;

    public boolean validation;
    public boolean correct;

    public Pesel(String pesel){
        this.day = returnDay(pesel);
        this.month = returnMonth(pesel);
        this.year = returnYear(pesel);
        this.dateOfBirth = day + "." + month + "." + year; //TODO poprawić walidację dla month
        this.sex = returnSex(pesel);
        this.validation = returnValidation(pesel);
        this.correct = checkIfCorrect(this, day, month, year);
    }

    public Pesel(){
        this.month = generateMonth();
        this.year = generateYear();
        this.day = generateDay(month, year);
        this.dateOfBirth = day + "." + month + "." + year;
        this.serial = generateSerial();
        this.sex = generateSex();
        this.finalPesel = generateValidation(year, day, month, serial, sex);
    }

    public void showDetailedInformation(Pesel pesel){
        if(pesel.isCorrect()){
            System.out.println("Pesel format is correct.");
            System.out.println("Date of birth: " + pesel.getDateOfBirth());
            System.out.println("Sex: " + pesel.getSex());
            System.out.println("Validation: " + pesel.isValidation());
        }
        else {
            System.out.println("Pesel format is incorrect.");
        }
    }

    public void showPesel(Pesel pesel){
        System.out.println("Pesel: " + pesel.getFinalPesel());
        System.out.println("Date of birth: " + pesel.getDateOfBirth());
        System.out.println("Sex: " + pesel.getSex());
    }

    private String getDay() {
        return day;
    }
    private String getMonth() {
        return month;
    }
    private String getYear() {
        return year;
    }
    private String getDateOfBirth() {
        return dateOfBirth;
    }
    private String getSex() {
        if(Integer.parseInt(sex) % 2 == 0){
            return "Female";
        }
        else {
            return "Male";
        }
    }
    private boolean isValidation() {
        return validation;
    }
    public String getFinalPesel() {
        return finalPesel;
    }

    private boolean isCorrect() {
        return correct;
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
    private String returnSex(String pesel){
            int sex = Integer.parseInt(String.valueOf(pesel).substring(9, 10));
            if(sex % 2 == 0){
                return "Female";
            }
            else {
                return "Male";
            }
        }
    private boolean returnValidation(String pesel) {
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
    private boolean checkIfCorrect(Pesel pesel, String day, String month, String year) {
        if(Integer.parseInt(pesel.getDay()) <= 31 && Integer.parseInt(pesel.getMonth()) <= 12 && Integer.parseInt(pesel.getYear()) >=1800) {
            return true;
        }
        else{
            return false;
        }
    }

    Random random = new Random();

    private String generateMonth(){
        int max = 4;
       int min = 1;
       int value = random.nextInt(max - min) + min;
        if(value == 1){
            return String.valueOf(random.nextInt(92 - 81) + 81);
        }
        else if(value == 2) {
            int month = random.nextInt(12 - 1) + 1;
            if(month < 10){
                return "0" + month;
            }
            else {
                return String.valueOf(month);
            }
        }
        else{
            return String.valueOf(random.nextInt(32 - 21) + 21);
        }
    }
    private String generateYear(){
        int max = 2099;
        int min = 1800;
        return String.valueOf(random.nextInt(max - min) + min);
    }
    private String generateDay(String month, String year) {
        int max;
        int _month = (Integer.parseInt(month) % 10);
        if(_month == 0){
            _month = 10;
        }
        YearMonth yearMonth = YearMonth.of(Integer.parseInt(year), _month);
        max = yearMonth.lengthOfMonth();
        int day = random.nextInt(max - 1) + 1;
        if(day < 10){
            return "0" + day;
        }
        else{
            return String.valueOf(day);
        }
    }
    private String generateSerial(){
        int min = 0;
        int max = 9;
        String serial = "";
        for(int i = 0; i < 3; i++){
            serial += Integer.parseInt(String.valueOf(random.nextInt(max - min) + min));
        }
        return serial;
    }
    private String generateSex() {
        int min = 0;
        int max = 9;
        return String.valueOf(random.nextInt(max - min) +min);
    }
    private String generateValidation(String year, String month, String day, String serial, String sex){
        String calculate = year.substring(2, 4) + day + month + serial + sex;
        ArrayList<Integer> digits = new ArrayList<>();
        char[] chars = calculate.toCharArray();
        for(char elem: chars){
            digits.add(Integer.valueOf(Character.toString(elem)));
        }
        int total = (digits.get(0) + digits.get(4) + digits.get(8) + (digits.get(1) + digits.get(5) + digits.get(9)) * 3 + (digits.get(2) + digits.get(6)) * 7 + (digits.get(3) + digits.get(7)) * 9) % 10;
        if(10 - total == 10){
            return calculate + "0";
        }
        else{
            return calculate + (10 - total);
        }
    }





}
