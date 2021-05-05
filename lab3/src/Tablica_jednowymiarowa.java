import java.util.Random;

public class Tablica_jednowymiarowa {
    Random rnd = new Random();

    void losowanie(Integer[] tab, int k) {
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rnd.nextInt(k) + 1;
        }

    }

    void wyswietlaniePoprawne(Integer[] tab,int n) {
        for (int i = 0; i < n; i++)
            System.out.println((1 + i) + ". " + tab[i]);
    }

    void wyswietlanieOdwrotne(Integer[] tab) {
        for (int i = (tab.length - 1); i >= 0; i--)
            System.out.println((tab.length-i) + ". " + tab[i]);
    }

    public void parzysteNieparzyste(Integer[] tab) {
        int liczbaParzystych = 0, liczbaNieparzystych = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0)
                liczbaParzystych++;
            else
                liczbaNieparzystych++;
        }
        Integer tabP[] = new Integer[liczbaParzystych];
        Integer tabNp[] = new Integer[liczbaNieparzystych];
        liczbaNieparzystych = 0;
        liczbaParzystych = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] % 2 == 0) {
                tabP[liczbaParzystych] = tab[i];
                liczbaParzystych++;
            } else {
                tabNp[liczbaNieparzystych] = tab[i];
                liczbaNieparzystych++;
            }
        }
        System.out.println("Tablica Parzysta");
        wyswietlaniePoprawne(tabP, liczbaParzystych);
        System.out.println("Tablica Nieparzysta");
        wyswietlaniePoprawne(tabNp, liczbaNieparzystych);

    }

    public Integer najwieksza(Integer[] tab) {
        int maks=tab[0];
        for (int i = 1; i < tab.length; i++){
            if(maks < tab[i])
                maks=tab[i];
        }
        return maks;
    }

    public Integer najmniejsza(Integer[] tab) {
        int min=tab[0];
        for (int i = 1; i < tab.length; i++){
            if(min > tab[i])
                min=tab[i];
        }
        return min;
    }
}
