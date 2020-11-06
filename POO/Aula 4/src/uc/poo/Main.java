package uc.poo;

import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        //ex1();
        //ex2(new int[]{1, 2, 3, 4}, new int[]{4, 5, 6, 7});
        /*int[][] idk = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ex3(idk, idk);*/
        ex4(500);
        //ex5(3);
        //ex6();
    }

    public static void ex1() {
        int sum = 0;
        int[] tabela = new int[10];
        for (int i = 0; i < 10; i++) {
            tabela[i] = ((int) (Math.random() * 100) + 1);
        }

        for (int i = 0; i < tabela.length; i++) {
            System.out.printf("%d -> %d\n", i, tabela[i]);
            sum += tabela[i];
        }
        System.out.print("Mean = " + sum / tabela.length);
    }

    /*public static int[] ex2(int[] x, int[] y) {
        int[] array = new int[x.length + y.length];
        if (x.length != y.length)
            return array;
        array = x;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++){
                if(array[i] != y[j]){

                }
            }
        }
        return array;

    }*/

    public static void ex3(int[][] x, int[][] y) {
        if (x.length != y.length || x.length != x[0].length)
            System.err.print("Erro: As matrizes nao so do mesmo tipo\n");

        int[][] result = new int[x.length][x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < x.length; k++) {
                    result[i][j] += x[i][k] * y[k][j];
                }
                System.out.printf("%3d ", result[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void ex4(int n) {
        int[] primos;
        primos = peneiraEratosthenes(n);
        for (int i : primos) {
            if (i != 0)
                System.out.print(i + "\n");
        }
    }

    public static int[] peneiraEratosthenes(int n) {
        int[] primos = new int[n - 1];
        int[] peneira = new int[n - 1];

        for (int i = 0; i < n - 1; i++) peneira[i] = 2 + i;//Preencher o array

        for (int i = 0; i <= n - 2; i++) {
            int aux = peneira[i];
            if (aux != 0) {
                for (int j = i + 1; j <= n - 2; j++) {
                    if (peneira[j] % aux == 0) peneira[j] = 0;
                }
            }
        }

        for (int i = 0, j = 0; i < peneira.length; i++, j++) {
            if (peneira[i] != 0) {
                primos[j] = peneira[i];
            }
        }
        return primos;
    }

    public static void ex5(int n) {
        int[][] matrix = new int[5][10];
        switch (n) {
            case 1:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = ((int) (Math.random() * 100));//0-99
                    }
                }
                break;

            case 2:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = j + (i * 10);
                    }
                }
                break;

            case 3:
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = i + (j * 5);
                    }
                }
                break;
        }
        show_matrix(matrix);
    }

    public static void show_matrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j != matrix[i].length - 1)
                    System.out.printf("%3d", matrix[i][j]);
                else
                    System.out.printf("%3d\n", matrix[i][j]);
            }
        }
    }


    public static void ex6() {
        int[][] matrix = generate_matrix();
        show_matrix(matrix);
        ex6b(1, 1, matrix);
    }

    public static int[][] generate_matrix() {
        int[][] matrix = new int[9][9];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int aux = ((int) (Math.random() * 10));
                if (!check_row_col(i, j, aux, matrix))
                    matrix[i][j] = aux;
                else {
                    while (check_row_col(i, j, aux, matrix)) {
                        aux = ((int) (Math.random() * 10));
                    }
                    matrix[i][j] = aux;
                }
            }
        }
        return matrix;
    }

    public static boolean check_row_col(int row, int col, int num, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            if ((num == matrix[row][i] || num == matrix[i][col]) && num != 0)
                return true;

        return false;
    }

    public static void ex6b(int x, int y, int[][] matrix) {
        matrix[x][y] = 0;
        for (int i = 1; i <= matrix.length; i++) {
            if (!check_row_col(x, y, i, matrix)) {
                System.out.printf("%d \n", i);
            }
        }
    }

    public static void ex7(){
        int[][] matrix = {
                {'E', 'b', 'a', 'u', 'l', 'q'},
                {'L', 'e', 'r', 'r', 's', 's'},
                {'u', 'w', 'u', 'q', 'g', 'r'},
                {'a', 'a', 'l', 'l', 'u', 'a'},
                {'p', 'm', 'h', 'u', 'd', 'j'}
                };

        int[] word = {'l', 'u', 'a'};
        word_search(word, matrix);
    }

    public static void word_search(int[] word, int[][]matrix){

    }


}//End Class Main
