package Student;

import Kursy.*;
import Osoba.*;

import java.util.ArrayList;

public class Student extends Osoba {
    private String indeks;
    private boolean erasmus;
    private boolean first_degree;
    private boolean second_degree;
    private boolean non_stationary;
    private boolean stationary;
    private ArrayList<Kursy> kursy= new ArrayList<>();


    public Student(String name, String surname, String pesel, int age, String gender,String indeks,boolean erasmus,boolean first_degree,boolean second_degree,boolean stationary,boolean non_stationary) {
        super(name, surname, pesel, age, gender);
        this.indeks=indeks;
        this.erasmus=erasmus;
        this.first_degree=first_degree;
        this.second_degree=second_degree;
        this.non_stationary=non_stationary;
        this.stationary=stationary;

    }

    public void getStan(){
        super.getStan();
        System.out.println("Indeks"+"\t"+getIndeks()+"\n"+"Czy uczestniczy w erasumsie"+"\t"+isErasmus()+"\n"+"Studia pierwszego stopnia"+"\t"+isFirst_degree()+"Studia drugiego stopnia"+"\t"+isSecond_degree()+"\n"+"Studia stacionarne"+"\t"+isStationary()+"Studia niestacionarne"+"\t"+isNon_stationary());
        if(this.getKursy() == null) {
            System.out.println("Brak kusów");
        }
        else{
            for (int i=0;i< kursy.size();i++) {
                if(kursy.get(i) != null)
                    kursy.get(i).getKurs();
            }
        }
    }
    public ArrayList<Kursy> getKursy(){
        return kursy;
    }
    public Kursy getKurs(int i){
        return kursy.get(i);
    }
    public void zapisNaKurs(String[][] kurs){
        for(int i=0;i< kurs.length;i++){
            kursy.add(new Kursy(kurs[i][0], kurs[i][1],kurs[i][2],Integer.valueOf(kurs[i][3])));
        }
    }

    public void zapisNaKurs(String nazwa,String imie,String nazwisko,int ects){
        kursy.add(new Kursy(nazwa,imie,nazwisko,ects));
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public boolean isErasmus() {
        return erasmus;
    }

    public void setErasmus(boolean erasmus) {
        this.erasmus = erasmus;
    }

    public boolean isFirst_degree() {
        return first_degree;
    }

    public void setFirst_degree(boolean first_degree) {
        this.first_degree = first_degree;
    }

    public boolean isSecond_degree() {
        return second_degree;
    }

    public void setSecond_degree(boolean second_degree) {
        this.second_degree = second_degree;
    }

    public boolean isNon_stationary() {
        return non_stationary;
    }

    public void setNon_stationary(boolean non_stationary) {
        this.non_stationary = non_stationary;
    }

    public boolean isStationary() {
        return stationary;
    }

    public void setStationary(boolean stationary) {
        this.stationary = stationary;
    }
}
