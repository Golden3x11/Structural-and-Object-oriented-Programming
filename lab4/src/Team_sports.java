public class Team_sports extends Sports {
    private String formation;
    private Player[] player = new Player[getTeam_size()];

    public Team_sports(String nationality, String sport, boolean trained,int team_size,String formation) {
        super(nationality, sport, trained,team_size);
        this.formation=formation;

        for (int i=0;i< player.length;i++){
            player[i]=new Player();
        }
    }
    public Team_sports(String nationality, String sport, boolean trained,int team_size,String formation,String[][] array_of_players) {
        super(nationality, sport, trained,team_size);
        this.formation=formation;
        for(int i=0;i< array_of_players.length;i++){
            player[i]=new Player(array_of_players[i][0],array_of_players[i][1]);
        }
    }


    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }
    public void getStan(){
        super.getStan();
        System.out.println("Formacja:"+"\t"+getFormation());
        getPlayer();
    }
    public void changePlayer(String imie,String nazwisko,int index){
        player[index-1].setImie(imie);
        player[index-1].setNazwisko(nazwisko);
    }
    public void changePlayer(String[][] players){
        for(int i=0;i< players.length;i++){
            player[i].setImie(players[i][0]);
            player[i].setNazwisko(players[i][1]);
        }
    }
    public void Training(){
        Coach.Train(this);
    }
    public void getPlayer(){
        System.out.println("Zawodnicy");
        for(int i=0;i< player.length;i++){
            System.out.println((i+1)+"."+"\t"+player[i].getImie()+" "+player[i].getNazwisko());
        }
    }

}
