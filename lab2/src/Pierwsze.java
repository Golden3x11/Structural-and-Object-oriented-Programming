import java.util.Scanner;

public class Pierwsze {
    public static void main(String[] args){
        double x;
        int k;
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj x: ");
        x = scan.nextDouble();
        System.out.println("Podaj potege: ");
        k = scan.nextInt();
        while(k < 0){
            System.out.println("Podaj potege wieksza rowna 0: ");
            k = scan.nextInt();
        }
        System.out.println(potega(x, k));

    }
    static double potega(double x,int k){
        if(k == 0)
            return 1;
        //if(k%2 == 0){
           // return potega(x,k/2) * potega(x,k/2);
        //}
        else
            return x * potega(x,k-1);

    }
}
