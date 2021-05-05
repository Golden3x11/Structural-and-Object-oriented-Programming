package Main;
import Kursy.Kursy;
import Osoba.*;
import Student.*;
import Pracownik.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Kursy> array_kursy= new ArrayList<>();
        array_kursy.add(new Kursy("Logika","Jan","Kowalski",5));
        array_kursy.add(new Kursy("Analiza","Marcin","Nowak",2));
        array_kursy.add(new Kursy("Psio","Stefan","Płatnerski",4));

        ArrayList<Osoba> array= new ArrayList<>();
        array.add(new PracownikAdministracyjny("Jan","Kowalski","03242342",51,"M","Referant",5,4000,2));
        array.add(new PracownikBadawczoDydaktycz("Agnieszka","Nowak","03242342",54,"K","Adiunkt",10,5000,4.23));
        array.add(new Student("Konrad","Kiełczyński","0123424322",19,"M","0324324",false,true,false,true,false));
        array.add(new PracownikBadawczoDydaktycz("Beata","Nowak","03242343",42,"K","Adiunkt",10,5000,4.23));
        array.add(new Student("Konrad","Kowalski","0123424322",19,"M","0324324",false,true,false,true,false));
        ((Student)array.get(2)).zapisNaKurs(array_kursy);
        Scanner scan= new Scanner(System.in);
        int opcja = -5;
        while(opcja !=0) {
            if(opcja !=-5){
                System.out.println("\nWciśnij Enter, aby kontynuować...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            menu();
            opcja = scan.nextInt();
            switch (opcja) {
                case 1: {
                    Opcje.wyszukiwanie(array, array_kursy, false);
                    break;
                }
                case 2: {
                    Opcje.dodawanie(array,array_kursy);
                    break;

                }
                case 3: {
                    Opcje.wyswietlanie(array, array_kursy);
                    break;
                }
                case 4: {
                    Opcje.zapisz(array,array_kursy);
                    System.out.println("Zapisano");
                    break;
                }
                case 5: {

                    Opcje.odczytaj(array,array_kursy);
                    System.out.println("Odczytano");
                    break;
                }
                case 6:{
                    Opcje.sortowanie(array, array_kursy);
                    break;
                }
                case 7: {
                    Opcje.wyszukiwanie(array, array_kursy, true);
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    System.out.println("Brak opcji");
                    break;
                }
            }


        }
        scan.close();


    }
    public static void menu() {
        System.out.println("Menu:");
        System.out.println("1 : Wyszukiwanie");
        System.out.println("2 : Dodawanie");
        System.out.println("3 : Wyswietlanie");
        System.out.println("4 : Zapis");
        System.out.println("5 : Odczyt");
        System.out.println("6 : Sortowanie");
        System.out.println("7 : Usuwanie");
        System.out.println("0 : Wyjscie");
    }

}
