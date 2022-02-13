package pl.javawannabe.Pesels.xyz;

import java.util.ArrayList;

public class checkIfCorrect {
    public static String checkIfCorrect(long pesel) {
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
           return "Correct";
       }
       else{
           return "Incorrect";
       }




    }

}
