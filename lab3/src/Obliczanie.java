import java.util.Arrays;

public class Obliczanie {
    public void wyswietlanie(double[][] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }

    }
    public void suma(double[][] tab) {
        double[][] tab1 = new double[tab.length][];

        for (int i = 0; i < tab.length; i++) {
            tab1[i] = Arrays.copyOf(tab[i], tab[i].length);
        }

        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                tab1[i][j]+=tab1[i][j];
                //System.out.print(tab1[i][j] + " ");
            }
            //System.out.println();

        }
        wyswietlanie(tab1);
    }

    public void iloczyn(double[][] tab) {
        double[][] tab2 = new double[tab.length][tab.length];

        for (int i = 0; i < tab2.length; i++) {
            for (int j = 0; j < tab2[i].length; j++) {
                int i_2=0,j_2=0;
                while((i_2< tab2.length)&&(j_2<tab2[i].length)){
                    tab2[i][j]+=tab[i][j_2]*tab[i_2][j];
                    i_2++;
                    j_2++;
                }
                //System.out.print(tab2[i][j]+" ");
            }
            //System.out.println();

        }
        wyswietlanie(tab2);
    }

}

