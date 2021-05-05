package Menus;

import GUI.MainGUI;
import Kursy.Kursy;
import Options.Serialization;
import Osoba.Osoba;
import Pracownik.PracownikAdministracyjny;
import Pracownik.PracownikBadawczoDydaktycz;
import Pracownik.PracownikUczelni;
import Student.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static GUI.MainGUI.*;

public class MenuMain {

    public static JPanel panelU= new JPanel();
    private static JPanel panelUniversity= new JPanel();
    private static JPanel panelStudent= new JPanel();
    private static JPanel panelTeacher= new JPanel();
    private static JPanel panelWorker= new JPanel();
    private static JPanel panelCourses= new JPanel();
    private static JTabbedPane tabbedPane=new JTabbedPane();
    private static Dimension d=new Dimension(580,400);
    private static boolean deletingDuplicates=false;
    private static JMenuItem confirm;

    public static void removeArrays(){
        panelUniversity.removeAll();
        panelStudent.removeAll();
        panelTeacher.removeAll();
        panelWorker.removeAll();
        panelCourses.removeAll();
    }
    public static void createUniversity(ArrayList<Osoba> array, ArrayList<Kursy> array_kursy){
        confirm=new JMenuItem("Potwierdzenie");
        confirm.addActionListener(new ActionMenuHashSet());
        hashset.add(confirm);
        panelU.add(tabbedPane);
        panelU.setPreferredSize(d);
        panelU.setLayout(new BoxLayout(panelU, BoxLayout.X_AXIS));
        tabbedPane.add("Uczelnia",panelUniversity);
        panelUniversity.setPreferredSize(d);
        tabbedPane.add("Studenci",panelStudent);
        panelStudent.setPreferredSize(d);
        tabbedPane.add("Pracownicy Administracyjni",panelWorker);
        panelWorker.setPreferredSize(d);
        tabbedPane.add("Pracownicy Dydaktyczni",panelTeacher);
        panelTeacher.setPreferredSize(d);
        tabbedPane.add("Lista Kursów",panelCourses);
        panelCourses.setPreferredSize(d);

        addArrays(array,array_kursy);


    }
    public static void addArrays(ArrayList<Osoba> array, ArrayList<Kursy> array_kursy){

        Object[] all_tab= {"Imie","Nzawisko","Pesel","Wiek"};
        Object[] workers_tab= {"Imie","Nzawisko","Pesel","Wiek","Stanowisko","Pensja","Staż"};
        Object[] teachers_tab= {"Imie","Nzawisko","Pesel","Wiek","Stanowisko","Pensja","Staż","Punkty"};
        Object[] students_tab= {"Imie","Nzawisko","Pesel","Wiek","Indeks"};
        Object[] courses_tab= {"Kurs","Prowadzący","ECTS"};

        DefaultTableModel allModel = new DefaultTableModel(all_tab,0);
        DefaultTableModel teachersModel = new DefaultTableModel(teachers_tab,0);
        DefaultTableModel workersModel = new DefaultTableModel(workers_tab,0);
        DefaultTableModel studentsModel = new DefaultTableModel(students_tab,0);
        DefaultTableModel coursesModel = new DefaultTableModel(courses_tab,0);
        for (int i = 0; i < array.size(); i++){
            String name = array.get(i).getName();
            String surname = array.get(i).getSurname();
            String pesel = array.get(i).getPesel();
            int age= array.get(i).getAge();

            if(array.get(i) instanceof Student){
                String indeks= ((Student)array.get(i)).getIndeks();
                Object[] studentsData = {name, surname, pesel, age,indeks};
                studentsModel.addRow(studentsData);
            }else if(array.get(i) instanceof PracownikUczelni){
                String post = ((PracownikUczelni)array.get(i)).getPost();
                int salary = ((PracownikUczelni)array.get(i)).getSalary();
                int seniority= ((PracownikUczelni)array.get(i)).getSeniority();
                if(array.get(i) instanceof PracownikBadawczoDydaktycz){
                    double points = ((PracownikBadawczoDydaktycz)array.get(i)).getAcademic_achievment();
                    Object[] data = {name, surname, pesel,age, post, salary,seniority, points};
                    teachersModel.addRow(data);
                }else if(array.get(i) instanceof PracownikAdministracyjny){
                    Object[] workersData = {name, surname, pesel, age, post, salary, seniority};
                    workersModel.addRow(workersData);
                }
            }

            Object[] allData = {name, surname, pesel, age};
            allModel.addRow(allData);
        }

        for (int i = 0; i < array_kursy.size(); i++){
            String name_surname=array_kursy.get(i).getNazwisko_prowadzacy()+" "+array_kursy.get(i).getImie_prowadzacy();
            String subject=array_kursy.get(i).getNazwa();
            int ects=array_kursy.get(i).getEcts();
            Object[] coursesData = {subject,name_surname, ects};
            coursesModel.addRow(coursesData);
        }

        JTable all= new JTable(allModel);
        all.setPreferredScrollableViewportSize(d);
        JTable teachers= new JTable(teachersModel);
        teachers.setPreferredScrollableViewportSize(d);
        JTable workers= new JTable(workersModel);
        workers.setPreferredScrollableViewportSize(d);
        JTable students= new JTable(studentsModel);
        students.setPreferredScrollableViewportSize(d);
        JTable courses= new JTable(coursesModel);
        courses.setPreferredScrollableViewportSize(d);
        courses.getColumnModel().getColumn(1).setPreferredWidth(120);

        panelUniversity.add(new JScrollPane(all));

        panelStudent.add(new JScrollPane(students));

        panelWorker.add(new JScrollPane(workers));

        panelTeacher.add(new JScrollPane(teachers));

        panelCourses.add(new JScrollPane(courses));
    }

    public static boolean isDeletingDuplicates() {
        return deletingDuplicates;
    }

    public static void setDeletingDuplicates(boolean deletingDuplicates) {
        MenuMain.deletingDuplicates = deletingDuplicates;
    }
    static class ActionMenuHashSet implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            HashSet<Osoba> setPersons = new HashSet<>(array);
            array = new ArrayList<>(setPersons);
            MenuMain.removeArrays();
            MenuMain.addArrays(MainGUI.getArray(),MainGUI.getArrayKursy());
        }
    }
}
