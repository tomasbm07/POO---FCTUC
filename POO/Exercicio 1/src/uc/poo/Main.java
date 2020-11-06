package uc.poo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows(1-12): ");
        num = sc.nextInt();
        if (num < 1 || num > 12)
            System.err.print("Erro: 1 < rows < 12");
        else
            triangulo(num);
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
    public static void triangulo(int n) {
        for (int i = 0; i < n; i++) {
            //System.out.printf("%2d: ", i);
            System.out.print(" ".repeat(n - i - 1));
            for (int j = 0; j <= i; j++)
                System.out.print((char) ('A' - 1 + (combination(i, j) % 26)) + " ");
            System.out.print("\n");
        }
    }


    //returns C(n, k)
    public static int combination(int n, int k) {
        return (factorial(n) / (factorial(k) * factorial(n - k)));
    }


}//End Class Main

