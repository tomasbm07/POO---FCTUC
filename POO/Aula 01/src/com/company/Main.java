package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*int num;
        int soma = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Escreva um numero: ");
        num = sc.nextInt();

        while(num > 0) {

            soma = soma + (num % 10);
            num = num / 10;
        }
        System.out.printf("Soma dos digitos = %d", soma);*/

        //ex6(28);
        //ex7();
        ex5(220, 284);
    }

    public static void ex6(int num) {
        int soma = 0;
        Scanner sc = new Scanner(System.in);
        if (num > 3) {
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    soma = soma + i;
                }
            }
            if (soma == num) {
                System.out.printf("%d e um numero perfeito\n", num);
                System.out.printf("Fatores: ");
                for (int i = 1; i < num; i++) {
                    if (num % i == 0) {
                        System.out.printf("%d ", i);
                    }
                }
            } else {
                System.out.printf("%d nao e um numero perfeito\n", num);
            }

        } else {
            System.out.print("Numero tem que ser > 3");
        }

    }

    public static void ex7() {
        System.out.print("Os numeros com estas caracteristicas sao:\n");

        for (int i = 100; i < 999; i++) {
            int n = i;
            int num1 = n % 10;
            n = n / 10;
            int num2 = n % 10;
            n = n / 10;
            int num3 = n % 10;

            if (num1 * num1 * num1 + num2 * num2 * num2 + num3 * num3 * num3 == i) {
                System.out.printf("%d\n", i);
            }
        }
    }

    public static void ex5(int m, int n) {
        int soma1 = 0;
        int soma2 = 0;

        soma1 = soma_divisores(m);
        soma2 = soma_divisores(n);

        if (soma1 == n & soma2 == m) {
            System.out.print("Os numeros sao amigos!\n");
        } else {
            System.out.print("Os numeros nao sao amigos!\n");
        }
    }

    public static int soma_divisores(int n) {
        int soma = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                soma = soma + i;
            }
        }
        return soma;
    }


}//End Class Main()


