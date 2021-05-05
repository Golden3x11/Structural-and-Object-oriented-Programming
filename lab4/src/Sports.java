public abstract class Sports {
    private String nationality;
    private String sport;
    private boolean trained;
    private int team_size;

    public Sports(String nationality,String sport,boolean trained,int team_size){
        this.nationality=nationality;
        this.sport=sport;
        this.trained=trained;
        this.team_size=team_size;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }
    public void getStan(){
        System.out.println("\n"+"Dyscyplina:"+"\t"+getSport()+"\n"+"Narodowość:"+"\t"+getNationality()+"\n"+"Czy przygotowani taktycznie:"+"\t"+isTrained()+"\n"+"Rozmiar drużyny:"+"\t"+getTeam_size());
    }

    public int getTeam_size() {
        return team_size;
    }

    public void setTeam_size(int team_size) {
        this.team_size = team_size;
    }
}
