package pl.javawannabe.Pesels;
import java.util.ArrayList;
public class Pesel_Datebase {

    static ArrayList<PeselCheck> checkedPesels = new ArrayList<>();

   public void addToDataBase(PeselCheck peselCheck){
        checkedPesels.add(peselCheck);
    }
    public int getDataBaseSize(){
       return checkedPesels.size();
    }
    public static ArrayList<PeselCheck> getDataBase() {
        return checkedPesels;
    }


}
