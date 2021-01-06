package uc.poo;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Equipa CISUC = new Equipa();
        fileHandler.readFiles(CISUC);
        menu(CISUC);
    }//main


    /**
     * Apresenta o menu da aplicacao
     * @param equipa Equipa
     */
    private static void menu(Equipa equipa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                -------------------------------
                |         Projeto POO:        |
                | Gestor de Publicaçoes CISUC |
                |         Tomás Mendes        |
                -------------------------------
                """);
        int choice = 1;
        while (choice != 0) {
            showOptions();
            choice = sc.nextInt();
            switch (choice) {
                case 0 -> System.out.println("Fechando Aplicaçao");
                case 1 -> parte1(equipa);
                case 2 -> parte2(equipa);
                case 3 -> parte3(equipa);
                case 4 -> parte4(equipa);
                case 5 -> parte5(equipa);
                default -> System.out.println("Erro: Valor Invalido");
            }
        }
    }

    /**
     * Mostra as opcoes para o menu
     */
    private static void showOptions() {
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("| 1 -> Parte 1                    |");
        System.out.println("| 2 -> Parte 2                    |");
        System.out.println("| 3 -> Parte 3                    |");
        System.out.println("| 4 -> Parte 4                    |");
        System.out.println("| 5 -> Parte 5                    |");
        System.out.println("| 0 -> Sair                       |");
        System.out.println("-----------------------------------");
        System.out.print("| Escolha -> ");
    }

    /**
     * Apresenta os parametos gerais da CISUC:
     *                    -Total de membros
     *                    -Numero de membros de cada categoria
     *                    -Total de publicacoes dos ultimos 5 anos
     *                    -Numero de publicacoes de cada tipo
     * @param equipa equipa
     */
    private static void parte1(Equipa equipa) {
        System.out.println("---------------------------------");
        equipa.showMembersStats();
        System.out.println("---------------------------------");
        System.out.println("Publicacoes dos ultimos 5 anos -> " + equipa.getNumPubs(5));
        System.out.println("---------------------------------");
        equipa.showPubStats();
        System.out.println("---------------------------------");
    }

    /**
     * Lista as publicacoes de um grupo, organizadas por ano, tipo, e fator de impacto
     * @param equipa Equipa
     */
    private static void parte2(Equipa equipa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Grupos -> AC, CMS, ECOS, IS, LCT, SSE");
        System.out.print("Escolha um Grupo -> ");
        String grupo = sc.nextLine();
        equipa.showPubsGroupStats(equipa, grupo);
    }

    /**
     * Lista os membros de um grupo de investigacao agrupados por categoria
     * @param equipa Equipa
     */
    private static void parte3(Equipa equipa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Grupos -> AC, CMS, ECOS, IS, LCT, SSE");
        System.out.print("Escolha um Grupo -> ");
        String grupo = sc.nextLine();
        equipa.printGroupMembers(equipa, grupo);
    }

    /**
     * ista as publicacoes de um investigador, agrupadas por ano, tipo e fator de impacto
     * @param equipa Equipa
     */
    private static void parte4(Equipa equipa) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        equipa.showMembers();
        System.out.print("Escolha um Grupo -> ");
        String grupo = sc.nextLine();
        System.out.print("Insira o nome do Investigador -> ");
        String nome = sc2.nextLine();
        equipa.getPubsInvestigador(equipa, grupo, nome);
    }

    /**
     * Lista, de todos os grupos de investigacao,
     *                     -Total de Membros
     *                     -Numero de membros de cada categoria
     *                     -Total de publicacoes dos ultimos 5 anos
     *                     -Numero de publicacoes, dos ultimos 5 anos, agrupadas por ano, tipo e fator de impacto
     * @param equipa Equipa
     */
    private static void parte5(Equipa equipa) {
        equipa.showMembersStats();
        System.out.println("---------------------------------");
        System.out.println("Publicacoes dos ultimos 5 anos -> " + equipa.getNumPubs(5));
        System.out.println("---------------------------------");
        equipa.showAllGroupsPubStats(equipa);
        System.out.println("---------------------------------");
        equipa.showGroupedPubs();
    }


}//Main
