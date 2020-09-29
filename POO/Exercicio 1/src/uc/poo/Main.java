package uc.poo;

public class Main {

    public static void main(String[] args) {
        triangulo(12);
    }


    //returns n!
    public static int factorial(int n) {
        if (n == 0) return 1;
        int sum = 1;
        for (int i = 1; i <= n; i++)
            sum *= i;
        return sum;
    }

    //Draws the triangle
    public static int triangulo(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i - 1));
            for (int j = 0; j <= i; j++) {
                System.out.print((char)(('A' - 1 + combination(i, j) % 24)) + " ");
            }
            System.out.print("\n");
        }
        return 0;
    }


    //returns C(n, k)
    //returns 0 if arguments were wrong
    public static int combination(int n, int k) {
        if (k < 0 || n < 0)
            return 0;

        if (k > n)
            return 0;
        else
            return (factorial(n) / (factorial(k) * factorial(n - k)));
    }


}//End Class Main

