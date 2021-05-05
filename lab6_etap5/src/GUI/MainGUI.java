package GUI;


import Kursy.Kursy;
import Menus.*;
import Options.Serialization;
import Osoba.Osoba;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Menus.MenuMain.*;

public class MainGUI{
    private static JFrame border;
    private static JPanel panel2;
    public static ArrayList<Osoba> array= null;
    public static ArrayList<Kursy> array_kursy= null;
    public static MainGUI menugui=new MainGUI();
    public static JMenu uni,serialization,sort,add,search,hashset;
    private static JMenuBar mb;



    public static void create(){
        array= new ArrayList<>();
        array_kursy= new ArrayList<>();
        Serialization.read(array,array_kursy);

        border= new JFrame();

        uni= new JMenu("Uczelnia");
        serialization= new JMenu("Serializacja");
        sort= new JMenu("Sortowanie");
        add= new JMenu("Dodawanie");
        search= new JMenu("Wyszukiwanie");
        hashset=new JMenu("Usuwanie Duplikatów");
        mb= new JMenuBar();


        uni.addMenuListener(new ActionMenuUniversity());
        MenuSort.createMenuSort();
        MenuSerialization.createMenuSerialization();
        MenuAdding.createAdding();
        MenuSearch.createSearch();

        mb.add(uni);mb.add(serialization);mb.add(sort);mb.add(add);mb.add(search);mb.add(hashset);
        border.setJMenuBar(mb);

        panel2=new JPanel();


        border.getContentPane().add(BorderLayout.CENTER,panel2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel2.add(panelU);
        createUniversity(array,array_kursy);

        border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        border.pack();
        border.setSize(600,400);
        border.setVisible(true);
        //border.setResizable(false);
    }
    public static void changePanel(JPanel PanelX){
        panel2.removeAll();
        panel2.add(BorderLayout.CENTER,PanelX);
        border.pack();
        border.setSize(600,400);

    }

    public static void main(String[] args) {
        Serialization.read(array,array_kursy);
        create();
    }
    public static ArrayList<Osoba> getArray(){
        return array;
    }
    public static ArrayList<Kursy> getArrayKursy(){
        return array_kursy;
    }

    static class ActionMenuUniversity implements MenuListener
    {
        @Override
        public void menuSelected(MenuEvent e) {
            menugui.changePanel(panelU);
        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    }

}