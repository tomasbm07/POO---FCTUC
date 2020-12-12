package uc.poo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Curso Informatica = new Curso();
        menu(Informatica);
    }

    private static void menu(Curso c) {
        Scanner sc = new Scanner(System.in);
        int choice;

        boolean run = true;

        while (run) {
            info();
            try{
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O input apenas pode ser um Numero!");
                choice = 0;
                run = false;
            }

            switch (choice) {
                case 1 -> c.printAll();
                case 2 -> c.userInput();
                case 3 -> c.userRemove();
                case 4 -> c.forceInputFromTxt();
                case 0 -> {
                    System.out.println("Guardando as Altereacoes");
                    c.saveChanges();
                    System.out.println("Fechando a aplicacao");
                    run = false;

                }
                default -> System.out.println("Valor Invalido!");
            }
        }
    }

    private static void info() {
        System.out.println("-----------Exercicio 5-----------");
        System.out.println("| 1 -> Print                    |");
        System.out.println("| 2 -> Adicionar aluno          |");
        System.out.println("| 3 -> Remover Aluno            |");
        System.out.println("| 4 -> Force Input .txt         |");
        System.out.println("| 0 -> Sair                     |");
        System.out.println("---------------------------------");
        System.out.print("| Escolha -> ");
    }

}
