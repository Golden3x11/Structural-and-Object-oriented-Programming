public class Individual_Sports extends Sports {
    private boolean physicaly_prepared;
    private String last_achievment;
    private Player player = new Player();

    public Individual_Sports(String nationality, String sport, boolean trained,int team_size,boolean physicaly_prepared,String last_achievment,String imie,String nazwisko) {
        super(nationality, sport, trained,team_size);
        this.physicaly_prepared=physicaly_prepared;
        this.last_achievment=last_achievment;
        player = new Player(imie,nazwisko);
    }


    public boolean isPhysicaly_prepared() {
        return physicaly_prepared;
    }

    public void setPhysicaly_prepared(boolean physicaly_prepared) {
        this.physicaly_prepared = physicaly_prepared;
    }

    public String getLast_achievment() {
        return last_achievment;
    }

    public void setLast_achievment(String last_achievment) {
        this.last_achievment = last_achievment;
    }
    public void getStan(){
        super.getStan();
        System.out.println("Czy przygotowany fizycznie:"+"\t"+isPhysicaly_prepared()+"\n"+"Ostatnie indywidualne osiągniecie:"+"\t"+getLast_achievment());
        getPlayer();
    }

    public void changePlayer(String imie,String nazwisko){
        player.setImie(imie);
        player.setNazwisko(imie);

    }
    public void Training(){
        Coach.Train(this);
    }

    public void getPlayer(){
        System.out.println("Zawodnicy");
            System.out.println("Imie i Nazwisko"+"\t"+player.getImie()+" "+player.getNazwisko());
    }
}
