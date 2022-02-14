package pl.javawannabe.Pesels;

import java.util.ArrayList;

public class Pesel_Datebase {
    static ArrayList<PeselCheck> checkedPesels = new ArrayList<>();
   public void add(PeselCheck peselCheck){
        checkedPesels.add(peselCheck);
    }
    public int getCheckedSize(){
       return checkedPesels.size();
    }
    public static ArrayList<PeselCheck> getCheckedPesels() {
        return checkedPesels;
    }


}
