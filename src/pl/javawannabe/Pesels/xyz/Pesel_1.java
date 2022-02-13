package pl.javawannabe.Pesels.xyz;

public class Pesel_1 {
    public void showPersonInformation(long pesel){
       boolean isCorrect = checkLenght(pesel);
       if(!isCorrect){
           return;
       }
       else{
           System.out.println("Validation: " + checkIfCorrect.checkIfCorrect(pesel));
           System.out.println("Sex: " + getSex(pesel));
           System.out.println("Date of birth: " + getDate(pesel));
       }
    }


    public boolean checkLenght(long pesel){
        if(String.valueOf(pesel).length() == 11){
            return true;
        }
        else{
            return false;
        }
    }

    public String getDate(long pesel){
        String _pesel = Long.toString(pesel);
        int year = Integer.parseInt(_pesel.substring(0,2));
        int month = Integer.parseInt(_pesel.substring(2, 4));
        int day = Integer.parseInt(_pesel.substring(4, 6));
        return dateFormatter.getFormatDate(year, month, day);
    }

    public String getSex(long pesel){
        String _pesel = Long.toString(pesel);
        int sex = Integer.parseInt(_pesel.substring(9, 10));
        if(sex % 2 == 0){
            return "Female";
        }
        else {
            return "Male";
        }

    }






}
