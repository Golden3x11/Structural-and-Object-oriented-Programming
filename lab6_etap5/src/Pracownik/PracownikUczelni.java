package Pracownik;
import  Osoba.*;

import java.util.Objects;


public abstract class PracownikUczelni extends Osoba {
    private String post;
    private int seniority;
    private int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PracownikUczelni)) return false;
        PracownikUczelni that = (PracownikUczelni) o;
        return Objects.equals(getPesel(), that.getPesel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPesel());
    }
    public PracownikUczelni(String name, String surname, String pesel, int age, String gender, String post, int seniority, int salary) {
        super(name, surname, pesel, age, gender);
        this.post=post;
        this.seniority=seniority;
        this.salary=salary;
    }
    public String toString(){

        return super.toString()+"\t"+"Stanowisko "+this.getPost()+"\t"+"Staż "+this.getSeniority()+"\t"+"Pensja "+this.getSalary();
    }
    public void getStan(){
        super.getStan();
        System.out.println("Stanowisko"+"\t"+getPost()+"\n"+"Staż pracy"+"\t"+getSeniority()+"\n"+"Pensja"+"\t"+getSalary());
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
