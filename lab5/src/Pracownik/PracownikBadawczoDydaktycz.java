package Pracownik;

public class PracownikBadawczoDydaktycz extends PracownikUczelni {
    private double academic_achievment;

    public PracownikBadawczoDydaktycz(String name, String surname, String pesel, int age, String gender, String post, int seniority, int salary,double academy_achievment) {
        super(name, surname, pesel, age, gender, post, seniority, salary);
        this.academic_achievment=academy_achievment;

    }
    public void getStan(){
        super.getStan();
        System.out.println("Punktacja z dorobku naukowego"+"\t"+getAcademic_achievment());
    }

    public double getAcademic_achievment() {
        return academic_achievment;
    }

    public void setAcademic_achievment(double academic_achievment) {
        this.academic_achievment = academic_achievment;
    }
}
