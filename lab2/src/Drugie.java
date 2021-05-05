import java.util.Scanner;

public class Drugie {
    public static void main(String[] args){
        int x;
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj x do policzenia silnia x!: ");
        x = scan.nextInt();
        while(x < 0){
            System.out.print("Podaj liczbe wieksza rowna 0: ");
            x = scan.nextInt();
        }
        System.out.println(silnia(x));
    }
    static long silnia(int x){
        if(x == 1)
            return x;
        else
            return x * silnia(x-1);
    }
}
