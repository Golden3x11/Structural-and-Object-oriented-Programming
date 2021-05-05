public class Macierz {
    public static void main(String[] args){
        double tab[][] = new double[3][3];
        tab[0][0] = 1;
        tab[0][1] = 2;
        tab[0][2] = 3;
        tab[1][0] = 4;
        tab[1][1] = 5;
        tab[1][2] = 6;
        tab[2][0] = 7;
        tab[2][1] = 8;
        tab[2][2] = 9;
        if (tab.length == tab[0].length) {
            Obliczanie tablica = new Obliczanie();
            tablica.suma(tab);
            System.out.println();
            tablica.iloczyn(tab);
        }
        else
            System.out.println("Macierz nie kwadratowa");
    }
}
