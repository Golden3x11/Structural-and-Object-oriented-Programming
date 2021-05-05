package Options;

import Kursy.Kursy;
import Osoba.Osoba;

import java.io.*;
import java.util.ArrayList;

public class Serialization {
    public static void read(ArrayList array, ArrayList array_kursy){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("Uczelnia.ser"))){
            Object object =is.readObject();
            ArrayList<Osoba> arrayO = (ArrayList) object;
            if(array !=null) {
                array.clear();
                for (Osoba osoba : arrayO) {
                    //osoba.getStan();
                    array.add(osoba);
                    //System.out.println("_____________________");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("ListaK.ser"))){
            Object object =is.readObject();
            ArrayList<Kursy> arrayK = (ArrayList) object;
            if(array_kursy!=null) {
                array_kursy.clear();
                for (Kursy kursy : arrayK) {
                    //osoba.getStan();
                    array_kursy.add(kursy);
                    //System.out.println("_____________________");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void save(ArrayList array,ArrayList array_kursy){
        try(ObjectOutputStream so= new ObjectOutputStream(new FileOutputStream("Uczelnia.ser"))) {
            so.writeObject(array);

        }catch(IOException e){
            e.printStackTrace();
        }
        try(ObjectOutputStream so= new ObjectOutputStream(new FileOutputStream("ListaK.ser"))) {
            so.writeObject(array_kursy);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
