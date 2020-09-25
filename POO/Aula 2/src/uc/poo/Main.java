package uc.poo;

public class Main {

    public static void main(String[] args) {
        //ex2(5);
        //System.out.print(factorial(3));
        //ex1(3, 2);
        //ex3(10110);
        //System.out.print(1/10);
        //ex4(25);
        //ex8(2);
        //ex9(20);
        //System.out.printf("%d", inverte(25));
        ex10(121);
    }

    public static void ex2(int n) {
        int sum = 0;
        int i = 1;
        while (sum <= n) {
            sum += i;
            i++;
        }
        System.out.printf("Soma = %d\nParou no %d", sum, i);
    }

    //3! = 3*2*1
    //4! = 4*3*2*1*
    // 3! / 4! = 4
    public static void ex1(int n, int k) {
        if (n > k) return;
        int result = (factorial(n)) / (factorial(k) * (factorial(n - k)));
        System.out.printf("C(%d, %d) = %d", n, k, result);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        int sum = n;
        for (int i = n; i > 1; i--) {
            sum = sum * (i - 1);
        }
        return sum;
    }

    public static void ex3(int b) {
        int n_0 = 0;
        int n_1 = 0;
        int sum = 0;
        int i = 1;
        int iter = 1;
        System.out.print(b + "\n");
        while (b > 0) {
            if (b % 10 == 0)
                n_0++;
            else {
                n_1++;
                sum += iter; //2^i
            }
            b = b / 10;
            i++;
            iter = iter * 2;
        }
        System.out.printf("'0' = %d\n'1' = %d\nDecimal = %d", n_0, n_1, sum);
    }

    public static void ex4(int n) {
        System.out.printf("n = %d\nMultiplos = ", n);
        if (n < 0 || n > 100) return;
        for (int i = 0; i <= 3; i++) {
            System.out.printf("%d ", n * i);
        }
    }

    public static void ex8(int n) {
        boolean init_run = true;
        int num = 0;
        int check = 0;
        int num_aux = 0;
        int i_aux = 0;
        System.out.printf("n = %d\n", n);
        for (int i = n; i < n * 1000; i++) { //
            num = i * i;
            check = 0;

            for (int k = 1; k <= n; k++) {
                if (init_run) {
                    num_aux = num;
                    i_aux = i;
                    init_run = false;
                }
                if ((num_aux % 10) == (i_aux % 10)) {
                    num_aux = num_aux / 10;
                    i_aux = i_aux / 10;
                    check++;
                }
                if (check == n) {
                    System.out.printf("%d (%d*%d=%d)\n", i, i, i, num);
                    check = 0;
                }
            }
            init_run = true;
        }
    }

    public static void ex9(int n) {
        System.out.printf("Primos até %d: \n", n);
        for (int i = 1; i <= n; i++) {
            if (ePrimo(i) == 1) {
                System.out.printf("%d ", i);
            }
        }
    }

    public static int ePrimo(int num) {
        int idk = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                idk = 0;
                break;
            }
        }
        return idk;
    }

    public static void ex10(int n) {
        if (inverte(n) == n) System.out.print("O numero e Capicua");
        else System.out.print("O numero nao e Capicua");
    }

    public static int inverte(int n) {
        boolean init_run = true;
        int num = 0;
        while ((n % 10) != 0) {
            if (init_run) {
                num = n % 10;
                n = n / 10;
                init_run = false;
            } else {
                num = num * 10;
                num += (n % 10);
                n = n / 10;
            }
        }
        return num;
    }


}// End Class Main
