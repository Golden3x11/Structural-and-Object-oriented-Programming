import java.util.Scanner;

public class Drugie {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        double a, b, c, i = 0;
        System.out.print("Podaj A: ");
        a = scan.nextDouble();

        System.out.print("Podaj B: ");
        b = scan.nextDouble();

        System.out.print("Podaj C: ");
        c = scan.nextDouble();

        if( a <= b && a <= c && i == 0) {
            System.out.println(a);
            if(b > c) {
                System.out.println(c);
                System.out.println(b);
                i++;
            }
            else {
                System.out.println(b);
                System.out.println(c);
                i++;
            }
        }
        if( b <= a && b <= c && i == 0) {
            System.out.println(b);
            if(a > c) {
                System.out.println(c);
                System.out.println(a);
                i++;
            }
            else {
                System.out.println(a);
                System.out.println(c);
                i++;
            }
        }
        if( c <= a && c <= b && i == 0) {
            System.out.println(c);
            if(b > a) {
                System.out.println(a);
                System.out.println(b);
                i++;
            }
            else {
                System.out.println(b);
                System.out.println(a);
                i++;
            }
        }

    }
}
