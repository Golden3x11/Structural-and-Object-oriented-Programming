package Options;

import GUI.MainGUI;
import Kursy.Kursy;
import Pracownik.PracownikAdministracyjny;
import Pracownik.PracownikBadawczoDydaktycz;
import Student.Student;

import java.util.ArrayList;

public class Adding {
    public static void witchObject(int whitchObject,ArrayList<String> str) {
        switch (whitchObject) {
            case 4 -> createCourse(str);
            case 1 -> createStudent(str);
            case 2 -> createTeacher(str);
            case 3 -> createWorker(str);
        }
    }
    private static void createCourse(ArrayList<String> str){
        MainGUI.getArrayKursy().add(new Kursy(str.get(0),str.get(1),str.get(2),Integer.parseInt(str.get(3))));
    }
    private static void createStudent(ArrayList<String> str){
        MainGUI.getArray().add(new Student(str.get(0),str.get(1),str.get(2),Integer.parseInt(str.get(3)),"ND",str.get(4),false,false,false,false,false));
    }
    private static void createWorker(ArrayList<String> str){
        MainGUI.getArray().add(new PracownikAdministracyjny(str.get(0),str.get(1),str.get(2),Integer.parseInt(str.get(3)),"ND",str.get(4),Integer.parseInt(str.get(5)),Integer.parseInt(str.get(6)),0));
    }
    private static void createTeacher(ArrayList<String> str){
        MainGUI.getArray().add(new PracownikBadawczoDydaktycz(str.get(0),str.get(1),str.get(2),Integer.parseInt(str.get(3)),"ND",str.get(4),Integer.parseInt(str.get(5)),Integer.parseInt(str.get(6)),Double.parseDouble(str.get(7))));
    }
}
