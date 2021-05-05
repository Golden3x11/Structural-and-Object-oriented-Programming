public class Main {
    public static void main(String[] args){
        Sports[] array = new Sports[4];
        String[][] array_football = {{"Wojciech","Szczęsny"},
                {"Bartosz","Bereszyński"},
                {"Jan","Bednarek"},
                {"Kamil","Glik"},
                {"Michał","Karbownik"},
                {"Piotr","Zieliński"},
                {"Krystian","Bielik"},
                {"Jakub","Moder"},
                {"Kamil","Józwiak"},
                {"Arek","Milik"},
                {"Robert","Lewandowski"}};

        array[0]=new Team_sports("Poland","Piłka nożna",false,11,"4-4-2",array_football);
        array[1]=new Team_sports("USA","Koszykówka",false,5,"1-3-1");
        array[2]=new Individual_Sports("Poland","Tenis",false,1,false,"Wygranie US open","Agnieszka","Radwańska");
        array[3]=new Individual_Sports("USA","Pływanie",false,1,false,"Wygranana na olimpioadzie na 100m","Michael","Phelps");

        for (int i=0;i<array.length;i++){
            array[i].getStan();
        }
        String[][] array_basketball = {{"Lebron","James"},
                {"Harrison","Barnes"},
                {"Kemba","Walker"},
                {"Brook","Lopez"},
                {"Kyle","Kuzuma"}};
        ((Team_sports)array[1]).changePlayer(array_basketball);
        ((Team_sports)array[1]).changePlayer("Jayson","Tatum",5);
        for (int i=0;i<array.length;i++){
            if(array[i] instanceof Team_sports)
                ((Team_sports)array[i]).Training();
            else
                ((Individual_Sports)array[i]).Training();
        }
        ((Team_sports)array[0]).Training();

        System.out.println("PO ZMIANACH");

        for (int i=0;i<array.length;i++){
            array[i].getStan();
        }
    }
}
