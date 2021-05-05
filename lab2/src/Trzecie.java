import java.util.Scanner;

public class Trzecie {
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
        double suma = 1, tmp = 1;
        int k = 1;
        while (k <=  n) {
            tmp *= x / k;
            suma += tmp;
            k++;
        }
        return suma;
    }

    static double sin(double x, int n) {
        double suma = x, licznik = x, silnia = 1, k = 1;
        while (k <= n) {
            licznik *= x * x;
            silnia *= ((2 * k) + 1) * (2 * k);
            if (k % 2 == 0)
                suma += (licznik) / (silnia);
            else
                suma -= (licznik) / (silnia);
            k++;
        }
        return suma;
    }

    static double cos(double x, int n) {
        double suma = 1, licznik = 1, silnia = 1, k = 1;
        while (k <= n) {
            licznik *= x * x;
            silnia *= ((2 * k) - 1) * (2 * k);
            if (k % 2 == 0)
                suma += (licznik) / (silnia);
            else
                suma -= (licznik) / (silnia);
            k++;
        }
        return suma;
    }
}

