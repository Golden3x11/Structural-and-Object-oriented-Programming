package Pracownik;
import  Osoba.*;


public abstract class PracownikUczelni extends Osoba {
    private String post;
    private int seniority;
    private int salary;

    public PracownikUczelni(String name, String surname, String pesel, int age, String gender,String post,int seniority,int salary) {
        super(name, surname, pesel, age, gender);
        this.post=post;
        this.seniority=seniority;
        this.salary=salary;
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
