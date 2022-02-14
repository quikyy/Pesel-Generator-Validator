package pl.javawannabe.Pesels;

import java.time.YearMonth;
import java.util.Random;
public class PeselGenerate extends Pesel implements IPesels {
    Random random = new Random();
    private String Iyear;
    private String _sex;
    public PeselGenerate(){
        super();
        this.month = generateMonth();
        this.year = generateYear();
        this.Iyear = year.substring(2, 4);
        this.day = generateDay(month, year);
        this.serial = generateSerial();
        this.sex = generateSex();
        this.validationDigit = generateValidation(Iyear, month, day, serial, sex);
        this.pesel = generatePesel(Iyear, month, day, serial, sex, validationDigit);
    }
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
        int value = random.nextInt(max - min) + min;
        return String.valueOf(value);
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
        return String.valueOf(random.nextInt(max - min) + min);
    }
        private String generateValidation(String year, String month, String day, String serial, String sex){
        String calculate = year + month + day + serial + sex;
        int[] digits = new int[10];
        char[] chars = calculate.toCharArray();
       for(int i = 0; i < digits.length ; i++){
           digits[i] = Integer.parseInt(Character.toString(chars[i]));
       }

       int total = (digits[0] + digits[1] * 3 + digits[2] * 7 + digits[3] * 9 + digits[4] + digits[5] * 3 + digits[6] * 7 + digits[7] * 9 + digits[8] + digits[9] * 3) % 10;
       if(total == 0){
           return "0";
       }
       else {
           return String.valueOf(10 - total);
       }
    }
        private String generatePesel(String year, String month, String day, String serial, String sex, String validationDigit) {
        return year + month + day + serial + sex + validationDigit;
    }

    @Override
    public void showInformation(Pesel pesel) {
        System.out.println(pesel.getPesel());
    }
}

