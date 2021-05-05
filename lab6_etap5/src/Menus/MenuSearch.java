package Menus;

import GUI.MainGUI;
import Kursy.Kursy;
import Options.Adding;
import Options.Search;
import Osoba.Osoba;
import Pracownik.PracownikAdministracyjny;
import Pracownik.PracownikBadawczoDydaktycz;
import Pracownik.PracownikUczelni;
import Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static GUI.MainGUI.*;

public class MenuSearch {
    private static JPanel panelRightAdd,panelFound,panelSearch;
    private static JMenuItem studentSearch,workerSearch,courseSearch;
    private static String[] comboPerson={"Imie","Nazwisko", "Pesel"};
    private static String comboStudent ="Indeks";
    private static String comboWorker="Stanowisko";
    private static String[] comboCourses={"Nazwisko Prowadzącego", "Nazwa Kursu"};
    private static JTextField textField;
    private static JComboBox<String> comboBox;
    private static JButton buttonSearch;
    private static ArrayList<JLabel> labels=null;
    private static int whichObject=0;
    private static JCheckBox deleting;

    public static void createSearch(){
        studentSearch= new JMenuItem("Studenta");
        studentSearch.addActionListener(new ActionMenuSearch());
        workerSearch=new JMenuItem("Pracownika");
        workerSearch.addActionListener(new ActionMenuSearch());
        courseSearch=new JMenuItem("Kursu");
        courseSearch.addActionListener(new ActionMenuSearch());

        search.add(studentSearch);
        search.add(workerSearch);
        search.add(courseSearch);
    }
    private static void createRightPanel(String s){
        panelRightAdd= new JPanel();
        panelRightAdd.setLayout(new BorderLayout());
        panelSearch= new JPanel();
        panelRightAdd.add(panelSearch,BorderLayout.NORTH);
        panelSearch.setLayout(new BoxLayout(panelSearch,BoxLayout.X_AXIS));
        deleting= new JCheckBox("Usuwanie");
        textField=new JTextField(30);
        buttonSearch=new JButton("Wyszukaj");
        buttonSearch.addActionListener(new ActionButtonSearchObject());
        if(s.equals("Kursu")){
            whichObject=3;
            comboBox=new JComboBox<>(comboCourses);
        }
        else{
            comboBox=new JComboBox<>(comboPerson);
            if(s.equals("Studenta")){
                whichObject=1;
                comboBox.addItem(comboStudent);
            }
            else {
                comboBox.addItem(comboWorker);
                whichObject=2;
            }
        }
        panelSearch.add(comboBox);
        panelSearch.add(deleting);
        panelSearch.add(textField);
        panelSearch.add(buttonSearch);
        panelFound=new JPanel();
        changePanel(panelRightAdd);
    }
    private static void createPanelFound(){
        panelFound.removeAll();
        panelFound.setLayout(new GridLayout(0,1));
        if(Search.getFoundPersons()==null){
            panelFound.add(new JLabel("Nie istnieje taki Obiekt"));
        }
        else{
            labels=new ArrayList<>();
            switch (whichObject) {
                case 1 -> addStudentToPanelFound(Search.getFoundPersons(),MainGUI.getArray());
                case 2 -> addWorkerToPanelFound(Search.getFoundPersons(),MainGUI.getArray());
                case 3 -> addCourseToPanelFound(Search.getFoundPersons(),MainGUI.getArrayKursy());
            }
        }
        panelRightAdd.add(panelFound,BorderLayout.CENTER);
        changePanel(panelRightAdd);
    }
    private static void addCourseToPanelFound(ArrayList<Integer> found,ArrayList<Kursy> kursy){
        for(int i = found.size()-1; i>=0; i--) {
            labels.add(new JLabel("Nazwa: "+kursy.get(found.get(i)).getNazwa()));
            labels.add(new JLabel("Prowadzący: "+kursy.get(found.get(i)).getNazwisko_prowadzacy()+" "+kursy.get(found.get(i)).getImie_prowadzacy()));
            labels.add(new JLabel("Punkty ECTS: "+kursy.get(found.get(i)).getEcts()));
            labels.add(new JLabel(" "));
            if(deleting.isSelected()){
                deleteFound(found.get(i),kursy);
            }

        }
        for(int i=0;i<labels.size();i++) {
            panelFound.add(labels.get(i));
        }
    }
    private static void addStudentToPanelFound(ArrayList<Integer> found,ArrayList<Osoba> array){
        for(int i = found.size()-1; i>=0; i--) {
            labels.add(new JLabel("Imie: "+array.get(found.get(i)).getName()+" Nazwisko: "+array.get(found.get(i)).getSurname()));
            labels.add(new JLabel("Pesel: "+array.get(found.get(i)).getPesel()+" Wiek: "+array.get(found.get(i)).getAge()));
            labels.add(new JLabel("Płeć: "+array.get(found.get(i)).getGender()));
            labels.add(new JLabel("Indeks:"+((Student)array.get(found.get(i))).getIndeks()));
            labels.add(new JLabel("Kursy:"));
            if(((Student)array.get(found.get(i))).getKursy()!=null) {
                for (int j = 0; j < ((Student) array.get(found.get(i))).getKursy().size(); j++) {
                    labels.add(new JLabel(String.valueOf(((Student) array.get(found.get(i))).getKurs(j))));
                }
            }
            labels.add(new JLabel(" "));
            if(deleting.isSelected()){
                deleteFound(found.get(i), array);
            }

        }
        for(int i=0;i<labels.size();i++) {
            panelFound.add(labels.get(i));
        }
    }
    private static void addWorkerToPanelFound(ArrayList<Integer> found,ArrayList<Osoba> array){
        for(int i = found.size()-1; i>=0; i--) {
            labels.add(new JLabel("Imie: "+array.get(found.get(i)).getName()+" Nazwisko: "+array.get(found.get(i)).getSurname()));
            labels.add(new JLabel("Pesel: "+array.get(found.get(i)).getPesel()+" Wiek: "+array.get(found.get(i)).getAge()));
            labels.add(new JLabel("Płeć: "+array.get(found.get(i)).getGender()));
            labels.add(new JLabel("Stanowisko: "+((PracownikUczelni)array.get(found.get(i))).getPost()));
            labels.add(new JLabel("Pensja: "+((PracownikUczelni)array.get(found.get(i))).getSalary()));
            labels.add(new JLabel("Staż: "+((PracownikUczelni)array.get(found.get(i))).getSeniority()));
            if(array.get(found.get(i)) instanceof PracownikBadawczoDydaktycz){
                labels.add(new JLabel("Punkty Naukowe: "+((PracownikBadawczoDydaktycz)array.get(found.get(i))).getAcademic_achievment()));
            }
            else{
                labels.add(new JLabel("Nadgodziny: "+((PracownikAdministracyjny)array.get(found.get(i))).getOvertime()));
            }
            labels.add(new JLabel(" "));
            if(deleting.isSelected()){
                deleteFound(found.get(i), array);
            }

        }
        for(int i=0;i<labels.size();i++) {
            panelFound.add(labels.get(i));
        }
    }
    private static void deleteFound(int i,ArrayList array){
        array.remove(i);
        MenuMain.removeArrays();
        MenuMain.addArrays(MainGUI.getArray(),MainGUI.getArrayKursy());
    }
    static class ActionButtonSearchObject implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            Search.whichObject(whichObject,textField.getText(),comboBox.getSelectedIndex());
            createPanelFound();
            }
        }

    static class ActionMenuSearch implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            createRightPanel(e.getActionCommand());
        }

    }
}

