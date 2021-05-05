package Kursy;

import java.io.Serializable;

public class Kursy implements Serializable {
    private String nazwa;
    private String imie_prowadzacy;
    private String nazwisko_prowadzacy;
    private int ects ;
    private static final long serialVersionUID = 5567566049324461550L;



    public Kursy(String nazwa,String imie,String nazwisko,int ects){
        this.nazwa=nazwa;
        this.imie_prowadzacy=imie;
        this.nazwisko_prowadzacy=nazwisko;
        this.ects=ects;
    }
    public String toString(){
        return "\n"+"Prowadzący "+this.getImie_prowadzacy()+" "+this.getNazwisko_prowadzacy()+"\n"+"Przedmoit "+this.getNazwa()+"\t"+"ECTS "+getEcts();
    }
    public void getKurs(){
        System.out.println(this.getNazwa() +"\t"+ "Prowadzacy" +"\t"+ this.getImie_prowadzacy()+" "+this.getNazwisko_prowadzacy()+"\t"+"ECTS"+"\t"+this.getEcts());
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getImie_prowadzacy() {
        return imie_prowadzacy;
    }

    public void setImie_prowadzacy(String imie_prowadzacy) {
        this.imie_prowadzacy = imie_prowadzacy;
    }

    public String getNazwisko_prowadzacy() {
        return nazwisko_prowadzacy;
    }

    public void setNazwisko_prowadzacy(String nazwisko_prowadzacy) {
        this.nazwisko_prowadzacy = nazwisko_prowadzacy;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
}
