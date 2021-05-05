package Menus;

import GUI.MainGUI;
import Options.Adding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static GUI.MainGUI.add;
import static GUI.MainGUI.changePanel;
import static Menus.MenuMain.panelU;

public class MenuAdding {
    private static JPanel panelRightAdd;
    private static JMenuItem studentAdd,workerAdd,teacherAdd,courseAdd;
    private static ArrayList<JTextField> textFields;
    private static ArrayList<JLabel> labels;
    private static int whichObject=0;

    public static void createAdding(){
        studentAdd= new JMenuItem("Studenta");
        studentAdd.addActionListener(new ActionMenuAdding());
        teacherAdd=new JMenuItem("Pracownika Dydaktycznego");
        teacherAdd.addActionListener(new ActionMenuAdding());
        workerAdd=new JMenuItem("Pracownika Administracyjnego");
        workerAdd.addActionListener(new ActionMenuAdding());
        courseAdd=new JMenuItem("Kursu");
        courseAdd.addActionListener(new ActionMenuAdding());

        add.add(studentAdd);
        add.add(teacherAdd);
        add.add(workerAdd);
        add.add(courseAdd);
    }
    private static void createRightPanel(String s){
        panelRightAdd= new JPanel();
        panelRightAdd.setLayout(new BoxLayout(panelRightAdd,BoxLayout.Y_AXIS));
        labels =new ArrayList<>();
        textFields =new ArrayList<>();

        JButton save=new JButton();

        if(s.equals("Kursu")){
            whichObject=4;
            labels.add(new JLabel("Wpisz nazwe:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz imie prowadzącego:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz nazwisko prowadzącego:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz liczbe punktów ECTS:"));
            textFields.add(new JTextField(30));
        }
        else{
            labels.add(new JLabel("Wpisz imie:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz nazwisko:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz pesel:"));
            textFields.add(new JTextField(30));

            labels.add(new JLabel("Wpisz wiek:"));
            textFields.add(new JTextField(30));

            if(s.equals("Studenta")){
                whichObject=1;
                labels.add(new JLabel("Wpisz Indeks:"));
                textFields.add(new JTextField(30));

            }
            else{
                labels.add(new JLabel("Wpisz zawód:"));
                textFields.add(new JTextField(30));

                labels.add(new JLabel("Wpisz Staż:"));
                textFields.add(new JTextField(30));

                labels.add(new JLabel("Wpisz Pensje:"));
                textFields.add(new JTextField(30));
                if(s.equals("Pracownika Dydaktycznego")){
                    whichObject=2;
                    labels.add(new JLabel("Wpisz Punkty Naukowe:"));
                    textFields.add(new JTextField(30));
                }
                else{
                    whichObject=3;
                }
            }
        }
        save.setText("Dodaj");
        addToPanel(labels,textFields);

        panelRightAdd.add(save);
        save.addActionListener(new ActionButtonAddObject());
        MainGUI.changePanel(panelRightAdd);
    }
    private static void addToPanel(ArrayList<JLabel> labels, ArrayList<JTextField> textFields){
        for(int i=0;i<labels.size();i++){
            JPanel panelHelp= new JPanel();
            panelHelp.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelRightAdd.add(panelHelp);
            panelHelp.add(labels.get(i));
            panelHelp.add(textFields.get(i));
        }
    }
    static class ActionButtonAddObject implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> str= new ArrayList<>();
            for(int i=0;i<textFields.size();i++) {
                str.add(textFields.get(i).getText());
            }
            Adding.witchObject(whichObject,str);
            MenuMain.removeArrays();
            MenuMain.addArrays(MainGUI.getArray(),MainGUI.getArrayKursy());
            changePanel(panelU);
        }


    }
    static class ActionMenuAdding implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            createRightPanel(e.getActionCommand());
        }

    }
}
