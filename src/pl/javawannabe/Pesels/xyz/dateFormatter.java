package pl.javawannabe.Pesels.xyz;

public class dateFormatter {
    public static String getFormatDate(int year, int month, int day){
        if(month >= 81 && month <= 92){
            month = month % 80;
            year = Integer.parseInt("18" + year);
        }
        else if(month >= 1 && month <= 12) {
            year = Integer.parseInt("19" + year);
        }
        else if(month >= 21 && month <= 32){
            month = month % 20;
            year = Integer.parseInt("20" + year);
        }

        String _day = String.valueOf(day);
        String _month = String.valueOf(month);
        if(day < 10){
            _day = "0" + day;
        }
        if(month < 10){
            _month = "0" + month;
        }
        return _day + "." + _month + "." + year;
    }
}
