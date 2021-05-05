

public class Main {
    public static void main(String[] args){
        int k=10,n=7;
        if(n<k) {
            Integer tab[] = new Integer[n];
            Tablica_jednowymiarowa tablica = new Tablica_jednowymiarowa();

            tablica.losowanie(tab, k);

            tablica.wyswietlaniePoprawne(tab,n);
            System.out.println();

            tablica.wyswietlanieOdwrotne(tab);
            System.out.println();

            tablica.parzysteNieparzyste(tab);
            System.out.println();

            System.out.println("Najwieksza wartosc: " + tablica.najwieksza(tab));

            System.out.println("Najmniejsza wartosc: " + tablica.najmniejsza(tab));
        }
        else
            System.out.println("Złe dane");
    }
}
