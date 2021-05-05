package Options;

import GUI.MainGUI;
import Kursy.Kursy;
import Osoba.Osoba;
import Pracownik.PracownikAdministracyjny;
import Pracownik.PracownikBadawczoDydaktycz;
import Pracownik.PracownikUczelni;
import Student.Student;

import java.util.ArrayList;

import static GUI.MainGUI.getArray;
import static GUI.MainGUI.getArrayKursy;

public class Search {
    private static ArrayList<Integer> foundPersons= null;
    public static void whichObject(int whichObject, String str,int aspect){
        foundPersons=null;
        switch (whichObject) {
            case 1 -> findStudent(str,aspect);
            case 2 -> findWorker(str,aspect);
            case 3 -> findCourse(str,aspect);
        }
    }
    public static ArrayList<Integer> getFoundPersons(){
        return foundPersons;
    }
    private static void findCourse(String str,int aspect){
        for(int i = 0; i< getArrayKursy().size(); i++){
            switch (aspect){
                case 1-> searchNameCourse(str,i,getArrayKursy());
                case 0-> searchSurnameCourse(str,i,getArrayKursy());
            }
        }
    }
    private static void findStudent(String str,int aspect){
        for(int i=0;i< getArray().size();i++){
            if (getArray().get(i) instanceof Student) {
                switch (aspect) {
                    case 0 -> searchName(str, i, getArray());
                    case 1 -> searchSurname(str, i, getArray());
                    case 2 -> searchPesel(str, i, getArray());
                    case 3 -> searchIndex(str, i, getArray());
                }
            }
        }
    }
    private static void findWorker(String str,int aspect){
        for(int i=0;i< getArray().size();i++){
            if (getArray().get(i) instanceof PracownikAdministracyjny ||getArray().get(i) instanceof PracownikBadawczoDydaktycz) {
                switch (aspect) {
                    case 0 -> searchName(str, i, getArray());
                    case 1 -> searchSurname(str, i, getArray());
                    case 2 -> searchPesel(str, i, getArray());
                    case 3 -> searchPost(str, i, getArray());
                }
            }
        }
    }
    private static void searchNameCourse(String s,int i, ArrayList<Kursy> array) {
        if (array.get(i).getNazwa().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchSurnameCourse(String s2, int i, ArrayList<Kursy> array) {
        if (array.get(i).getNazwisko_prowadzacy().equals(s2)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchName(String s, int i, ArrayList<Osoba> array) {
        if (array.get(i).getName().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchSurname(String s, int i, ArrayList<Osoba> array) {
        if (array.get(i).getSurname().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchPesel(String s, int i, ArrayList<Osoba> array) {
        if (array.get(i).getPesel().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchIndex(String s, int i, ArrayList<Osoba> array) {
        if (((Student) array.get(i)).getIndeks().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }
    private static void searchPost(String s, int i, ArrayList<Osoba> array) {
        if (((PracownikUczelni) array.get(i)).getPost().equals(s)) {
            if(foundPersons==null)
                foundPersons= new ArrayList<>();
            foundPersons.add(i);
        }
    }

}
