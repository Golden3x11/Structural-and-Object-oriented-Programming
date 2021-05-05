package Options;

import GUI.MainGUI;
import Kursy.Kursy;
import Main.Main;
import Main.Opcje;
import Osoba.Osoba;

import java.util.Collections;
import java.util.Comparator;

public class Sort {
    private static OsobyCompareNazwisko Comparator1;
    private static OsobyCompareNazwiskoImie Comparator2;
    private static OsobyCompareNazwiskoWiek Comparator3;
    private static KursyCompareEcts Comparator4;
    private static KursyCompareNazwiskoProwadzacy Comparator5;

    public static void sort(String opcja){
        Comparator1= new OsobyCompareNazwisko();
        Comparator2= new OsobyCompareNazwiskoImie();
        Comparator3= new OsobyCompareNazwiskoWiek();
        Comparator4= new KursyCompareEcts();
        Comparator5= new KursyCompareNazwiskoProwadzacy();


        switch (opcja){
            case "Po nazwisku":{
                Collections.sort(MainGUI.getArray(),getComaprator1());
                break;
            }
            case "Po nazwisku i imieniu":{
                Collections.sort(MainGUI.getArray(),getComaprator2());
                break;

            }
            case "Po nazwisku i wieku":{

                Collections.sort(MainGUI.getArray(),getComaprator3());

                break;
            }
            case "Po nazwisku prowadzącego": {
                Collections.sort(MainGUI.getArrayKursy(),getComaprator5());

                break;
            }
            case "Po punktach ECTS": {
                Collections.sort(MainGUI.getArrayKursy(),getComaprator4());
                break;
            }
        }
    }
    static class OsobyCompareNazwisko implements Comparator<Osoba> {
        public int compare(Osoba o1, Osoba o2){
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    private static OsobyCompareNazwisko getComaprator1(){
        return Comparator1;
    }

    static class OsobyCompareNazwiskoImie implements Comparator<Osoba>{
        public int compare(Osoba o1, Osoba o2){
            if(o1.getSurname().equals(o2.getSurname())){
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    private static OsobyCompareNazwiskoImie getComaprator2(){
        return Comparator2;
    }

    static class OsobyCompareNazwiskoWiek implements Comparator<Osoba>{
        public int compare(Osoba o1, Osoba o2){
            if(o1.getSurname().equals(o2.getSurname())){
                if (o1.getAge()>o2.getAge()) return 1;
                if (o1.getAge()<o2.getAge()) return -1;
                return 0;

            }
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    private static OsobyCompareNazwiskoWiek getComaprator3(){
        return Comparator3;
    }

    static class KursyCompareEcts implements Comparator<Kursy>{
        public int compare(Kursy k1, Kursy k2){
            if (k1.getEcts()<k2.getEcts()) return 1;
            if (k1.getEcts()>k2.getEcts()) return -1;
            return 0;
        }
    }
    private static KursyCompareEcts getComaprator4(){
        return Comparator4;
    }

    static class KursyCompareNazwiskoProwadzacy implements Comparator<Kursy>{
        public int compare(Kursy k1, Kursy k2){
            return k1.getNazwisko_prowadzacy().compareTo(k2.getNazwisko_prowadzacy());
        }
    }
    private static KursyCompareNazwiskoProwadzacy getComaprator5(){
        return Comparator5;
    }
}
