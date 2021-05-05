package Pracownik;

public class PracownikAdministracyjny extends PracownikUczelni {
    private int overtime;
    private static final long serialVersionUID = 5567566049324461550L;

    public String toString(){

        return super.toString()+ "\n"+"Nadgodziny "+this.getOvertime();
    }
    public PracownikAdministracyjny(String name, String surname, String pesel, int age, String gender, String post, int seniority, int salary,int overtime) {
        super(name, surname, pesel, age, gender, post, seniority, salary);
        this.overtime=overtime;
    }

    public void getStan(){
        super.getStan();
        System.out.println("Nadgodziny"+"\t"+getOvertime());
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}
