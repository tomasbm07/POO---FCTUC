package uc.poo;

public class Main {

    public static void main(String[] args) {
        //System.out.print(recursive_sum(555));
        //primeFactor(32);
        //System.out.print(recursive_invert(12345));
        Histograma(5);
    }


    public static int recursive_sum(int n) {
        if (n == 0)
            return 0;
        else
            return (n % 10 + recursive_sum(n / 10));
    }


    public static void primeFactor(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.printf("%d\n", i);
                n /= i;
            }
        }
    }


    public static int recursive_invert(int n) {
        if (n < 10)
            return n;
        else {
            System.out.print(n % 10);
            return (recursive_invert(n / 10));
        }
    }


    public static void Histograma(int n) {

    }

}//End Class Main
