package Main;
import Osoba.*;
import Student.*;
import Pracownik.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Osoba> array= new ArrayList<>();
        String[][] kursy ={{"Logika","Jan","Kowalski","5"},
                {"Analiza","Marcin","Nowak","2"},
                {"Psio","Stefan","Nowak","4"}};
        array.add(new PracownikAdministracyjny("Jan","Kowalski","0234324422",51,"M","Referant",5,4000,2));
        array.add(new PracownikBadawczoDydaktycz("Agnieszka","Nowak","03242342",42,"K","Adiunkt",10,5000,4.23));
        array.add(new Student("Konrad","Kiełczyński","0123424322",19,"M","0324324",false,true,false,true,false));

        ((Student)array.get(2)).zapisNaKurs(kursy);

        for (int i=0;i<array.size();i++){
            array.get(i).getStan();
            System.out.println("__________");
        }
        Opcje.wyszukiwanie(array);


    }

}
