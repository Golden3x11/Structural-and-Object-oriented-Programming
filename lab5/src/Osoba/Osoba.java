package Osoba;

public abstract class Osoba {
    private String name;
    private String surname;
    private String pesel;
    private int age;
    private String gender;

    public Osoba(String name,String surname,String pesel,int age,String gender){
        this.name=name;
        this.surname=surname;
        this.pesel=pesel;
        this.age=age;
        this.gender=gender;

    }
    public void getStan(){
        System.out.println("Imie:"+"\t"+getName()+"\n"+"Nazwisko:"+"\t"+getSurname()+"\n"+"Pesel"+"\t"+getPesel()+"\n"+"Wiek"+"\t"+getAge()+"\n"+"Płeć"+"\t"+getGender());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
