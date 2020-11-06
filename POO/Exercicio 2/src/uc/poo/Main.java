package uc.poo;

public class Main {

    public static void main(String[] args) {
        int[][] tabela = {
                {1, 2},
                {7, 7},
                {1, 1, 1},
                {1, 2, 3, 4},
                {2, 5},
                {4, 5, 6, 7, 8},
                {3},
                {3, 1},
                {1},
                {1, 0},
                {0},
                {1, 1, 1, 1},
                {12, -15},
                {-3},
                {12, -20},
                {20, -80},
                {10, 15},
                {8, 1},
                {3, 2, 1, 4}};

        int[][] tabela_ordenada = ordena_tabela(tabela);
        print_tabela(tabela_ordenada);
    }


    //Sort the matrix based on total sum of each line
    public static int[][] ordena_tabela(int[][] tabela) {
        int[] somas = new int[tabela.length];

        //Sum the lines
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                somas[i] += tabela[i][j];
            }
        }

        //Sort the matrix based on the sum
        int[] aux;
        int aux_sum;
        for (int i = 0; i < somas.length; i++) {
            for (int j = i + 1; j < somas.length; j++) {
                if (somas[i] > somas[j]) {
                    //swap the original matrix
                    aux = tabela[i];
                    tabela[i] = tabela[j];
                    tabela[j] = aux;

                    //swap the array with the sums
                    aux_sum = somas[i];
                    somas[i] = somas[j];
                    somas[j] = aux_sum;

                    //if sums are equal -> smaller line 1st
                } else if (somas[i] == somas[j] && tabela[i].length > tabela[j].length) {
                    aux = tabela[i];
                    tabela[i] = tabela[j];
                    tabela[j] = aux;

                    aux_sum = somas[i];
                    somas[i] = somas[j];
                    somas[j] = aux_sum;
                }
            }
        }
        return tabela;
    }


    //Prints any sized matrix(n x m)
    public static void print_tabela(int[][] x) {
        for (int[] i : x) {
            for (int j = 0; j < i.length; j++) {
                if (j != i.length - 1)
                    System.out.print(i[j] + " ");
                else
                    System.out.print(i[j] + "\n");
            }
        }
    }


}//End Class Main
