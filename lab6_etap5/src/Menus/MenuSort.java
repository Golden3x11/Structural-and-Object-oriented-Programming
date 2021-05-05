package Menus;

import GUI.MainGUI;
import Options.Sort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.MainGUI.sort;

public class MenuSort {
    private static JMenuItem surname,surnameName,surnameAge,coursesSurnameTeacher,coursesECTS;

    public static void createMenuSort(){
        surname= new JMenuItem("Po nazwisku");
        surname.addActionListener(new ActionMenuSort());
        surnameName= new JMenuItem("Po nazwisku i imieniu");
        surnameName.addActionListener(new ActionMenuSort());
        surnameAge= new JMenuItem("Po nazwisku i wieku");
        surnameAge.addActionListener(new ActionMenuSort());
        coursesSurnameTeacher=new JMenuItem("Po nazwisku prowadzącego");
        coursesSurnameTeacher.addActionListener(new ActionMenuSort());
        coursesECTS= new JMenuItem("Po punktach ECTS");
        coursesECTS.addActionListener(new ActionMenuSort());

        sort.add(surname);
        sort.add(surnameName);
        sort.add(surnameAge);
        sort.add(coursesSurnameTeacher);
        sort.add(coursesECTS);
    }
    static class ActionMenuSort implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Sort.sort(e.getActionCommand());
            MenuMain.removeArrays();
            MenuMain.addArrays(MainGUI.getArray(),MainGUI.getArrayKursy());
        }
    }
}
