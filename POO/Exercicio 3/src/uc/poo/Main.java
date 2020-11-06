package uc.poo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean RUN = true;
        Scanner sc = new Scanner(System.in);
        Supermercado continente = new Supermercado();

        while (RUN) {
            showMenu();
            switch (sc.nextInt()) {
                case 1 -> {
                    Produto input = new Produto();
                    continente.addStock(input);
                }
                case 2 -> continente.vender();
                case 3 -> continente.showStock();
                case 4 -> {
                    double valor = continente.valorStock();
                    if (valor == -1)
                        System.out.println("Erro: Ainda não existem produtos em stock");
                    else
                        System.out.printf("Valor total dos produtos: %.2g€", valor);
                }
                case 5 -> RUN = false;
            }
        }
    }

    // Prints all the options
    public static void showMenu() {
        System.out.println("1 -> Adicionar produto");
        System.out.println("2 -> Comprar");
        System.out.println("3 -> Produtos disponiveis");
        System.out.println("4 -> Valor dos produtos em stock");
        System.out.println("5 -> Sair");
        System.out.print("Escolha -> ");
    }

}// End Class Main
