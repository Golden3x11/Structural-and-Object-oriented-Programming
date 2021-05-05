package Menus;

import GUI.MainGUI;
import Options.Serialization;
import Options.Sort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static GUI.MainGUI.*;

public class MenuSerialization {
    private static JMenuItem save,read;

    public static void createMenuSerialization(){
        save= new JMenuItem("Zapisz");
        save.addActionListener(new ActionMenuSave());
        read= new JMenuItem("Odczytaj");
        read.addActionListener(new ActionMenuRead());


        serialization.add(save);
        serialization.add(read);
    }
    static class ActionMenuSave implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Serialization.save(getArray(),getArrayKursy());
        }
    }
    static class ActionMenuRead implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

            Serialization.read(getArray(),getArrayKursy());
            MenuMain.removeArrays();
            MenuMain.addArrays(MainGUI.getArray(),MainGUI.getArrayKursy());
        }
    }
}
