public class Coach {
    public static void Train(Team_sports t){
        t.setTrained(true);
    }
    public static void Train(Individual_Sports t){
        t.setTrained(true);
        t.setPhysicaly_prepared(true);
    }
}
