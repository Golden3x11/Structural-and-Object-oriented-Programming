package Main;

import Osoba.*;
import Pracownik.*;
import Student.*;
import Kursy.*;

import java.io.*;
import java.util.*;

public class Opcje {

    private static OsobyCompareNazwisko Comparator1;
    private static OsobyCompareNazwiskoImie Comparator2;
    private static OsobyCompareNazwiskoWiek Comparator3;
    private static KursyCompareEcts Comparator4;
    private static KursyCompareNazwiskoProwadzacy Comparator5;
    public static Integer tryParseInt() {
        Scanner sc= new Scanner(System.in);
        while(true)
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nie liczba");
            }
    }
    public static Double tryParseDouble() {
        Scanner sc= new Scanner(System.in);
        while(true)
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nie liczba");
            }
    }
    public static Boolean tryParseBoolean() {
        Scanner sc= new Scanner(System.in);
        while(true)
            try {
                return Boolean.parseBoolean(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nie boolean");
            }
    }

    public static void wyszukiwanie(ArrayList<Osoba> array, ArrayList<Kursy> array_kursy,boolean usuwanie) {
        Scanner scan = new Scanner(System.in);
        if(usuwanie)
            System.out.println("Usuwanie");
        else
            System.out.println("Wyszukiwanie");
        komunikatWyszukiwanie();
        String opcja = scan.nextLine();
        switch (opcja) {
            case "1": {
                wyszukiwaniePracownika();
                opcja = scan.nextLine();
                switch (opcja) {
                    case "1": {
                        System.out.println("Podaj imie");
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieImie(s, i, array,usuwanie);
                            }
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj nazwisko");
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieNazwisko(s, i, array,usuwanie);
                            }
                        }
                        break;
                    }
                    case "3": {
                        try{
                        System.out.println("Podaj staż");
                        int s = Integer.parseInt(scan.nextLine());
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieStaz(s, i, array,usuwanie);
                            }
                        }
                        }catch (NumberFormatException e){
                            System.out.println("Nie liczba");
                        }
                        break;
                    }
                    case "4": {
                        System.out.println("Podaj stanowisko");
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwanieStanowisko(s, i, array,usuwanie);
                            }
                        }
                        break;
                    }
                    case "5": {
                        try{
                        System.out.println("Podaj pensjie");
                        int s = Integer.parseInt(scan.nextLine());
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof PracownikUczelni) {
                                wyszukiwaniePensji(s, i, array,usuwanie);
                            }
                        }
                        }catch (NumberFormatException e){
                            System.out.println("Nie liczba");
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
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieImie(s, i, array,usuwanie);
                            }
                        }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj nazwisko");
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieNazwisko(s, i, array,usuwanie);
                            }
                        }
                        break;
                    }
                    case "3": {
                        System.out.println("Podaj indeks");
                        String s = scan.nextLine();
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) instanceof Student) {
                                wyszukiwanieIndeks(s, i, array,usuwanie);
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
                        String s = scan.nextLine();
                        for (int i = 0; i < array_kursy.size(); i++) {
                                wyszukiwanieNazwaKurs(s, i, array_kursy,usuwanie);
                            }
                        break;
                    }
                    case "2": {
                        System.out.println("Podaj imie prowadzącego");
                        String s1 = scan.nextLine();
                        System.out.println("Podaj nazwisko prowadzącego");
                        String s2 = scan.nextLine();
                        for (int i = 0; i < array_kursy.size(); i++) {
                                wyszukiwanieProwadzacyKurs(s1,s2,i,array_kursy,usuwanie);
                        }
                        break;
                    }
                    case "3": {
                        try{
                        System.out.println("Podaj Punkty ECTS");
                        int s = Integer.parseInt(scan.nextLine());
                        for (int i = 0; i < array_kursy.size(); i++) {
                                wyszukiwaniePunktyKurs(s,i,array_kursy,usuwanie);
                        }
                        }catch (NumberFormatException e){
                            System.out.println("Nie liczba");
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
    }
    public static void wyswietlanie(ArrayList<Osoba> array,ArrayList<Kursy> array_kursy){
        Scanner scan= new Scanner(System.in);
        System.out.println("Podaj opcje");
        int opcja;
        komunikatWyswietlanie();
        opcja=scan.nextInt();
        //scan.close();
        switch (opcja){
            case 1:{
                for (int i=0;i<array.size();i++){
                    array.get(i).getStan();
                    System.out.println("______________________________");
                }

                break;
            }
            case 2:{
                for (int i=0;i<array.size();i++){
                    if(array.get(i) instanceof Student) {
                        array.get(i).getStan();
                        System.out.println("______________________________");
                    }
                }


                break;

            }
            case 3:{
                for (int i=0;i<array.size();i++){
                    if(array.get(i) instanceof PracownikUczelni) {
                        array.get(i).getStan();
                        System.out.println("______________________________");
                    }
                }

                break;
            }
            case 4: {
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i) instanceof PracownikBadawczoDydaktycz) {
                        array.get(i).getStan();
                        System.out.println("______________________________");
                    }
                }

                break;
            }
            case 5: {
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i) instanceof PracownikAdministracyjny) {
                        array.get(i).getStan();
                        System.out.println("______________________________");
                    }
                }
                break;
            }
            case 6:{
                for (int i = 0; i < array_kursy.size(); i++) {
                    System.out.print(1+i+"\t");
                    array_kursy.get(i).getKurs();
                    System.out.println("______________________________");
                }
            }
            case 0:{
                break;
            }
            default:
            {
                System.out.println("Brak opcji");
                break;
            }
        }
    }
    public static void dodawanie(ArrayList<Osoba> array,ArrayList<Kursy> array_kursy){
        Scanner scan= new Scanner(System.in);
        System.out.println("Podaj opcje");
        int opcja;
        komunikatTworzenie();
        opcja=scan.nextInt();
        scan.nextLine();


        switch (opcja){
            case 1:{
                System.out.println("Podaj imię: ");
                String name= scan.nextLine();
                System.out.println("Podaj nazwisko: ");
                String surname= scan.nextLine();
                System.out.println("Podaj pesel: ");
                String pesel=scan.nextLine();
                System.out.println("Podaj wiek: ");
                int age = tryParseInt();
                System.out.println("Podaj płeć M-mężczyzna K-kobieta: ");
                String gender= scan.nextLine();
                System.out.println("Podaj indeks: ");
                String indeks= scan.nextLine();
                System.out.println("Czy erasmus wpisz true albo false: ");
                boolean erasmus= tryParseBoolean();
                System.out.println("Jest studentem I stopnia wpisz true albo false jesli II stopnia: ");
                boolean degree= tryParseBoolean();
                System.out.println("Jest studentem stacjonarnym wpisz true albo false jesli NIE stacjonarnym: ");
                boolean stationary= tryParseBoolean();
                array.add(new Student(name,surname,pesel,age,gender,indeks,erasmus,degree,!degree,stationary,!stationary));
                System.out.println("Zapis na kursy");
                System.out.println("Lista kursów dostępna");
                for (int i = 0; i < array_kursy.size(); i++) {
                    System.out.print(1+i+"\t");
                    array_kursy.get(i).getKurs();
                }
                int opcjaK=-5;
                while(opcjaK !=0) {
                    System.out.println("Podaj indeks kursu na który chcesz zapisać tworzonego studenta");
                    System.out.println("Po wcisnieciu 0 kończysz dodawanie");
                    int kurs = scan.nextInt();
                    opcjaK=kurs;
                    if(opcjaK !=0) {
                        ((Student) array.get(array.size() - 1)).zapisNaKurs(array_kursy.get(kurs-1));
                    }

                }
                break;
            }
            case 2,3:{
                int opcja2=opcja;
                System.out.println("Podaj imię: ");
                String name= scan.nextLine();
                System.out.println("Podaj nazwisko: ");
                String surname= scan.nextLine();
                System.out.println("Podaj pesel: ");
                String pesel=scan.nextLine();
                System.out.println("Podaj wiek: ");
                int age = tryParseInt();
                System.out.println("Podaj płeć M-mężczyzna K-kobieta: ");
                String gender= scan.nextLine();
                System.out.println("Podaj stanowisko: ");
                String post= scan.nextLine();
                System.out.println("Podaj ile lat pracuje: ");
                int seniority= tryParseInt();
                System.out.println("Podaj ile zarabia: ");
                int salary= tryParseInt();
                switch (opcja2) {
                    case 2 -> {
                        System.out.println("Podaj ilość nadgodzin pracownika: ");
                        int overtime = tryParseInt();
                        array.add(new PracownikAdministracyjny(name, surname, pesel, age, gender, post, seniority, salary, overtime));
                    }
                    case 3 -> {
                        System.out.println("Podaj wartość indeksu naukowego");
                        double academic_degree = tryParseDouble();
                        array.add(new PracownikBadawczoDydaktycz(name, surname, pesel, age, gender, post, seniority, salary, academic_degree));
                    }
                }

                break;

            }
            case 4:{
                System.out.println("Podaj nazwe: ");
                String nazwa= scan.nextLine();
                System.out.println("Podaj Imie prowadzącego: ");
                String imie_prowadzacy= scan.nextLine();
                System.out.println("Podaj Nazwisko prowdzącego: ");
                String nazwisko_prowadzacy= scan.nextLine();
                System.out.println("Podaj liczbe ects: ");
                int ects= tryParseInt();
                array_kursy.add(new Kursy(nazwa,imie_prowadzacy,nazwisko_prowadzacy,ects));

            }
            case 5:{
                System.out.println("Podaj indeks studenta do krórego chcesz dodać kursy");
                String indeks= scan.nextLine();
                int studentI =wyszukiwanieIndeksII(indeks,array);
                if(studentI>=0) {
                    System.out.println("Zapis na kursy");
                    System.out.println("Lista kursów dostępna");
                    for (int i = 0; i < array_kursy.size(); i++) {
                        System.out.print(1 + i + "\t");
                        array_kursy.get(i).getKurs();
                    }
                    int opcjaK = -5;
                    while (opcjaK != 0) {
                        System.out.println("Podaj indeks kursu na który chcesz zapisać tworzonego studenta");
                        System.out.println("Po wcisnieciu 0 kończysz dodawanie");
                        int kurs = scan.nextInt();
                        opcjaK = kurs;
                        if (opcjaK != 0) {
                            ((Student) array.get(studentI)).zapisNaKurs(array_kursy.get(kurs - 1));
                        }

                    }
                }
                else
                    System.out.println("Brak studenta o podanym indeksie");
            }
            case 0:{
                break;
            }
            default:
            {
                System.out.println("Brak opcji");
                break;
            }
        }
    }
    public static void sortowanie(ArrayList<Osoba> array,ArrayList<Kursy> array_kursy){
        Scanner scan= new Scanner(System.in);
        System.out.println("Podaj opcje");
        int opcja;
        komunikatSortowanie();
        opcja=scan.nextInt();
        Comparator1= new OsobyCompareNazwisko();
        Comparator2= new OsobyCompareNazwiskoImie();
        Comparator3= new OsobyCompareNazwiskoWiek();
        Comparator4= new KursyCompareEcts();
        Comparator5= new KursyCompareNazwiskoProwadzacy();


        switch (opcja){
            case 1:{
                Collections.sort(array,getComaprator1());
                break;
            }
            case 2:{
                Collections.sort(array,getComaprator2());
                break;

            }
            case 3:{
                /*for (int i=0;i<array.size();i++){
                    System.out.println(array.get(i).getSurname()+"\t"+array.get(i).getAge());
                }
                System.out.println("POOOOOOOOOOOOOOOO");
                System.out.println();
                */
                Collections.sort(array,getComaprator3());
                /*for (int i=0;i<array.size();i++){
                    System.out.println(array.get(i).getSurname()+"\t"+array.get(i).getAge());
                }
                */
                break;
            }
            case 4: {
                /*for (int i = 0; i < array_kursy.size(); i++) {
                    System.out.println(array_kursy.get(i).getNazwa()+"\t"+array_kursy.get(i).getEcts());
                }
                System.out.println("POOOOOOOOOOOOOOOO");
                System.out.println();

                 */
                Collections.sort(array_kursy,getComaprator4());
                /*for (int i = 0; i < array_kursy.size(); i++) {
                    System.out.println(array_kursy.get(i).getNazwa()+"\t"+array_kursy.get(i).getEcts());
                }

                 */
                break;
            }
            case 5: {
                Collections.sort(array_kursy,getComaprator5());
                break;
            }
            case 0:{
                break;
            }
            default:
            {
                System.out.println("Brak opcji");
                break;
            }
        }
    }

    static class OsobyCompareNazwisko implements Comparator<Osoba> {
        public int compare(Osoba o1, Osoba o2){
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    public static OsobyCompareNazwisko getComaprator1(){
        return Comparator1;
    }

    static class OsobyCompareNazwiskoImie implements Comparator<Osoba>{
        public int compare(Osoba o1, Osoba o2){
            if(o1.getSurname().equals(o2.getSurname())){
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    public static OsobyCompareNazwiskoImie getComaprator2(){
        return Comparator2;
    }

    static class OsobyCompareNazwiskoWiek implements Comparator<Osoba>{
        public int compare(Osoba o1, Osoba o2){
            if(o1.getSurname().equals(o2.getSurname())){
                if (o1.getAge()>o2.getAge()) return 1;
                if (o1.getAge()<o2.getAge()) return -1;
                return 0;

            }
            return o1.getSurname().compareTo(o2.getSurname());
        }
    }
    public static OsobyCompareNazwiskoWiek getComaprator3(){
        return Comparator3;
    }

    static class KursyCompareEcts implements Comparator<Kursy>{
        public int compare(Kursy k1, Kursy k2){
                if (k1.getEcts()<k2.getEcts()) return 1;
                if (k1.getEcts()>k2.getEcts()) return -1;
                return 0;
        }
    }
    public static KursyCompareEcts getComaprator4(){
        return Comparator4;
    }

    static class KursyCompareNazwiskoProwadzacy implements Comparator<Kursy>{
        public int compare(Kursy k1, Kursy k2){
            return k1.getNazwisko_prowadzacy().compareTo(k2.getNazwisko_prowadzacy());
        }
    }
    public static KursyCompareNazwiskoProwadzacy getComaprator5(){
        return Comparator5;
    }
    private static void komunikatSortowanie(){
        System.out.println("Sortowanie według");
        System.out.println("1 : Nazwiska");
        System.out.println("2 : Nazwiska i Imienia (imiona sortowane alfabetycznie dla tych samych nazwisk)");
        System.out.println("3 : Nazwiska i Wieku (wiek sortowany malejąco dla tych samych nazwisk)");
        System.out.println("4 : Listy Kursów wg. punktów ECTS");
        System.out.println("5 : Listy Kursów wg. Nazwiska Prowadzącego");
        System.out.println("0 : Wyjscie");
    }
    private static void komunikatTworzenie(){
        System.out.println("1 : Tworzenie Studenta");
        System.out.println("2 : Tworzenie Pracownika Administracyjnego");
        System.out.println("3 : Tworzenie Pracownika Dydaktycznego");
        System.out.println("4 : Tworzenie Kursu");
        System.out.println("0 : Wyjscie");

    }
    private static void komunikatWyswietlanie(){
        System.out.println("Wyswietlanie");
        System.out.println("1: Wszystkich");
        System.out.println("2: Studenta");
        System.out.println("3: Pracownika uczelni");
        System.out.println("3: Pracownika Badawczo Dydaktycznego");
        System.out.println("3: Pracownika Administacynego");
        System.out.println("6: Listy Kursów");
        System.out.println("0: Wyjscie");

    }
    private static void komunikatWyszukiwanie() {
        //System.out.println("Akcja wobec");
        System.out.println("1: Pracownika");
        System.out.println("2: Studenta");
        System.out.println("3: Kursu");
        System.out.println("0: Wyjscie");

    }
    private static void wyszukiwaniePracownika() {
        System.out.println("Po");
        System.out.println("1: Imieniu");
        System.out.println("2: Nazwisku");
        System.out.println("3: Stażu pracy");
        System.out.println("4: Stanowisku");
        System.out.println("5: Pensji");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieStudenta() {
        System.out.println("Po");
        System.out.println("1: Imieniu");
        System.out.println("2: Nazwisku");
        System.out.println("3: Indeksie");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieKursu() {
        System.out.println("Po");
        System.out.println("1: Nazwie");
        System.out.println("2: Prowadzacym");
        System.out.println("3: Punktach ECTS");
        System.out.println("0: Wyjscie");
    }
    private static void wyszukiwanieImie(String s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (array.get(i).getName().equals(s)) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static void wyszukiwanieNazwisko(String s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (array.get(i).getSurname().equals(s)) {
            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static void wyszukiwanieStaz(int s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (((PracownikUczelni) array.get(i)).getSeniority() == s) {
            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static void wyszukiwanieStanowisko(String s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (((PracownikUczelni) array.get(i)).getPost().equals(s)) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static void wyszukiwaniePensji(int s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (((PracownikUczelni) array.get(i)).getSeniority() == s) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static void wyszukiwanieIndeks(String s, int i, ArrayList<Osoba> array,boolean usuwanie) {
        if (((Student) array.get(i)).getIndeks().equals(s)) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getStan();
            }
        }
    }
    private static int wyszukiwanieIndeksII(String s, ArrayList<Osoba> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) instanceof Student) {
                if (((Student) array.get(i)).getIndeks().equals(s)) {
                    return i;
                }

            }
        }
        return -1;
    }
    private static void wyszukiwanieNazwaKurs(String s, int i, ArrayList<Kursy> array,boolean usuwanie) {
        if (array.get(i).getNazwa().equals(s)) {
            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getKurs();
            }
        }
    }
    private static void wyszukiwanieProwadzacyKurs(String s1,String s2, int i, ArrayList<Kursy> array,boolean usuwanie) {
        if ((array.get(i).getImie_prowadzacy().equals(s1))&&(array.get(i).getNazwisko_prowadzacy().equals(s2))) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getKurs();
            }
        }
    }
    private static void wyszukiwaniePunktyKurs(int s, int i, ArrayList<Kursy> array,boolean usuwanie) {
        if (array.get(i).getEcts()==s) {

            if (usuwanie) {
                usuwanie(i, array);
            }
            else{
                array.get(i).getKurs();
            }
        }
    }

    private static void usuwanie(int i, ArrayList array){
        array.remove(i);
    }


    public static void odczytaj(ArrayList array,ArrayList array_kursy){
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("Uczelnia.ser"))){
            Object object =is.readObject();
            ArrayList<Osoba> arrayO = (ArrayList) object;
            ArrayList<Kursy> arrayK = (ArrayList) object;

            array.clear();
            for(Osoba osoba : arrayO) {
                //osoba.getStan();
                array.add(osoba);
                //System.out.println("_____________________");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("ListaK.ser"))){
            Object object =is.readObject();
            ArrayList<Kursy> arrayK = (ArrayList) object;
            array_kursy.clear();
            for(Kursy kursy : arrayK) {
                //osoba.getStan();
                array_kursy.add(kursy);
                //System.out.println("_____________________");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void zapisz(ArrayList array,ArrayList array_kursy){
        try(ObjectOutputStream so= new ObjectOutputStream(new FileOutputStream("Uczelnia.ser"))) {
            so.writeObject(array);

        }catch(IOException e){
            e.printStackTrace();
        }
        try(ObjectOutputStream so= new ObjectOutputStream(new FileOutputStream("ListaK.ser"))) {
            so.writeObject(array_kursy);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}




