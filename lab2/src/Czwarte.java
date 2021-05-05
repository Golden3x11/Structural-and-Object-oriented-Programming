import java.util.Scanner;

public class Czwarte {
    public static void main(String[] args) {
        int wybor, n;
        double x;
        Scanner scan = new Scanner(System.in);
        menu();
        System.out.print("Ktory ?: ");
        wybor = scan.nextInt();
        System.out.print("Podaj x: ");
        x = scan.nextDouble();
        System.out.print("Podaj dokładnosc n: ");
        n = scan.nextInt();
        while (n < 0) {
            System.out.print("Podaj liczbe wieksza rowna 0: ");
            n = scan.nextInt();
        }


        switch (wybor) {
            case 1:
                System.out.println(e(x, n));
                break;
            case 2:
                System.out.println(sin(x, n));
                break;
            case 3:
                System.out.println(cos(x, n));
                break;
            default:
                System.out.println("Nie ma takiej opcji");


        }
    }

    static void menu() {
        System.out.println("1. e^x");
        System.out.println("2. sin(x)");
        System.out.println("3. cos(x)");
    }

    static double e(double x, int n) {
        double suma = 1;int k = 1;
        while (k <= n){
            suma += (potega(x, k)) / (silnia(k));
            k++;
        }
        return suma;
    }

    static double sin(double x, int n) {
        double suma = x;int k = 1;
        while (k <= n) {
                suma += potega(-1,k)*potega(x,2*k+1) / silnia((2*k+1));
            k++;
        }
        return suma;
    }

    static double cos(double x, int n) {
        double suma = 1; int k = 1;
        while (k <= n) {
            suma += potega(-1,k)*potega(x,2*k) / silnia((2*k));
            k++;
        }
        return suma;
    }
    static double potega(double x,int k){
        if(k == 0)
            return 1;
        if(k%2 == 0){
            return potega(x,k/2) * potega(x,k/2);
        }
        else
            return x * potega(x,k-1);

    }
    static long silnia(int x){
        if(x == 1)
            return x;
        else
            return x * silnia(x-1);
    }
}


