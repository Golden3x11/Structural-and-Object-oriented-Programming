package Main;

import Osoba.*;
import Pracownik.*;
import Student.*;
import Kursy.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Opcje {
    public static void wyszukiwanie(ArrayList<Osoba> array) {
        Scanner scan = new Scanner(System.in);
        komunikatWyszukiwanie();
        String opcja = scan.nextLine();
        switch (opcja) {
            case "1": {
                wyszukiwaniePracownika();
                opcja = scan.nextLine();
                switch (opcja) {
                    case "1": {
                        System.out.println("Podaj imie");
                        //String s = scan.nextLine();
                        String s= "Jan";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieImie(s, i, array);
                            }
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj nazwisko");
                        //String s = scan.nextLine();
                        String s= "Kowalski";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieNazwisko(s, i, array);
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Podaj staż");
                        //String s = scan.nextLine();
                        String s= "5";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieStaz(s, i, array);
                            }
                        }
                        break;
                    }
                    case "4": {
                        System.out.println("Podaj stanowisko");
                        //String s = scan.nextLine();
                        String s= "Referant";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieStanowisko(s, i, array);
                            }
                        }
                        break;
                    }
                    case "5": {
                        System.out.println("Podaj pensjie");
                        //String s = scan.nextLine();
                        String s= "4000";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwaniePensji(s, i, array);
                            }
                        }
                        break;
                    }
                    case "0": {
                        break;
                    }
                    default: {
                        System.out.println("Brak opcji");
                        break;
                    }
                }
                break;
            }
            case "2": {
                wyszukiwanieStudenta();
                opcja = scan.nextLine();
                switch (opcja) {
                    case "1": {
                        System.out.println("Podaj imie");
                        //String s = scan.nextLine();
                        String s= "Konrad";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieImie(s, i, array);
                            }
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj nazwisko");
                        //String s = scan.nextLine();
                        String s= "Kiełczyński";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieNazwisko(s, i, array);
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Podaj indeks");
                        //String s = scan.nextLine();
                        String s= "0324324";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieIndeks(s, i, array);
                            }
                        }
                        break;
                    }
                    case "0": {
                        break;
                    }
                    default: {
                        System.out.println("Brak opcji");
                        break;
                    }
                }

                break;
            }
            case "3": {
                wyszukiwanieKursu();
                opcja = scan.nextLine();
                switch (opcja) {
                    case "1": {
                        System.out.println("Podaj nazwe");
                        //String s = scan.nextLine();
                        String s= "Analiza";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieNazwaKurs(s, i, array);
                            }
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj imie prowadzącego");
                        //String s1 = scan.nextLine();
                        String s1= "Jan";
                        System.out.println(s1);
                        System.out.println("Podaj nazwisko prowadzącego");
                        //String s2 = scan.nextLine();
                        String s2= "Kowalski";
                        System.out.println(s2);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieProwadzacyKurs(s1,s2,i,array);
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Podaj Punkty ECTS");
                        //String s = scan.nextLine();
                        String s= "4";
                        System.out.println(s);
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwaniePunktyKurs(s,i,array);
                            }
                        }
                        break;
                    }
                    case "0": {
                        break;
                    }
                    default: {
                        System.out.println("Brak opcji");
                        break;
                    }
                }

                break;
            }
            case "0": {
                break;
            }
            default: {
                System.out.println("Brak opcji");
                break;
            }
        }
        scan.close();
    }


    private static void komunikatWyszukiwanie() {
        System.out.println("Wyszukiwanie");
        System.out.println("1: Pracownika");
        System.out.println("2: Studenta");
        System.out.println("3: Kursu");
        System.out.println("0: Wyjscie");

    }
    private static void wyszukiwaniePracownika() {
        System.out.println("Wyszukiwanie po");
        System.out.println("1: Imieniu");
        System.out.println("2: Nazwisku");
        System.out.println("3: Stażu pracy");
        System.out.println("4: Stanowisku");
        System.out.println("5: Pensji");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieStudenta() {
        System.out.println("Wyszukiwanie po");
        System.out.println("1: Imieniu");
        System.out.println("2: Nazwisku");
        System.out.println("3: Indeksie");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieKursu() {
        System.out.println("Wyszukiwanie po");
        System.out.println("1: Nazwie");
        System.out.println("2: Prowadzacym");
        System.out.println("3: Punktach ECTS");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieImie(String s, int i, ArrayList<Osoba> array) {
        if (array.get(i).getName().equals(s))
            array.get(i).getStan();

    }
    private static void wyszukiwanieNazwisko(String s, int i, ArrayList<Osoba> array) {
        if (array.get(i).getSurname().equals(s))
            array.get(i).getStan();

    }
    private static void wyszukiwanieStaz(String s, int i, ArrayList<Osoba> array) {
        if (((PracownikUczelni) array.get(i)).getSeniority() == Integer.valueOf(s))
            array.get(i).getStan();

    }
    private static void wyszukiwanieStanowisko(String s, int i, ArrayList<Osoba> array) {
        if (((PracownikUczelni) array.get(i)).getPost().equals(s))
            array.get(i).getStan();

    }
    private static void wyszukiwaniePensji(String s, int i, ArrayList<Osoba> array) {
        if (((PracownikUczelni) array.get(i)).getSeniority() == Integer.valueOf(s))
            array.get(i).getStan();

    }
    private static void wyszukiwanieIndeks(String s, int i, ArrayList<Osoba> array) {
        if (((Student) array.get(i)).getIndeks().equals(s))
            array.get(i).getStan();

    }
    private static void wyszukiwanieNazwaKurs(String s, int i, ArrayList<Osoba> array) {
        if(((Student) array.get(i)).getKursy() != null) {
            for (int j = 0; j < ((Student) array.get(i)).getKursy().size(); j++) {
                if (((Student) array.get(i)).getKurs(j).getNazwa().equals(s)) {
                    ((Student) array.get(i)).getKurs(j).getKurs();
                }
            }
        }
    }
    private static void wyszukiwanieProwadzacyKurs(String s1,String s2, int i, ArrayList<Osoba> array) {
        if(((Student) array.get(i)).getKursy() != null) {
            for (int j = 0; j < ((Student) array.get(i)).getKursy().size(); j++) {
                if ((((Student) array.get(i)).getKurs(j).getImie_prowadzacy().equals(s1))&&(((Student) array.get(i)).getKurs(j).getNazwisko_prowadzacy().equals(s2))) {
                    ((Student) array.get(i)).getKurs(j).getKurs();
                }
            }
        }
    }
    private static void wyszukiwaniePunktyKurs(String s, int i, ArrayList<Osoba> array) {
        if(((Student) array.get(i)).getKursy() != null) {
            for (int j = 0; j < ((Student) array.get(i)).getKursy().size(); j++) {
                if (((Student) array.get(i)).getKurs(j).getEcts()==Integer.valueOf(s)) {
                    ((Student) array.get(i)).getKurs(j).getKurs();
                }
            }
        }
    }



}




