import java.util.Scanner;

public class Trzecie {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m, n;
        System.out.print("Podaj M: ");
        m = scan.nextInt();

        System.out.print("Podaj N: ");
        n = scan.nextInt();
        while (m != n){
            if( m > n){
                m -= n;
            }
            else{
                n -= m;
            }
        }
            System.out.println("NWD = "+ m );
    }
}
