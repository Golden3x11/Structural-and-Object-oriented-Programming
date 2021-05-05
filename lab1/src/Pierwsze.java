import java.util.Scanner;

public class Pierwsze {
    public static void main(String[] args) {

            double a, b, c, delta;
            Scanner scan = new Scanner(System.in);
            System.out.print("Podaj a: ");
            a = scan.nextInt();
            if (a != 0) {

                System.out.print("Podaj b: ");
                b = scan.nextInt();

                System.out.print("Podaj c: ");
                c = scan.nextInt();

                delta = b * b - 4 * a * c;
                System.out.println(delta);
                if (delta >= 0) {
                    if (delta == 0)
                        System.out.println("x_0= " + (-b) / (2 * a));
                    else {
                        System.out.println("x_1= " + (-b + Math.sqrt(delta)) / (2 * a) + "x_2= " + (-b - Math.sqrt(delta)) / (2 * a));
                    }
                }
                else
                    System.out.println("nie ma rozwiazan");
            }
            else
                System.out.println("a ma byc inne niz 0");

    }
}
