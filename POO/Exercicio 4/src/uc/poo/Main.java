package uc.poo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        ArrayList<Livro> lista;

        Livro l1 = new livroTecnico("H. Schildt", "Java: The Complete Reference", 80, "Informatica");
        livraria.addLivro(l1);
        Livro l2 = new livroTecnico("E. Gamma et al.", "Design Patterns", 80, "Informatica");
        livraria.addLivro(l2);
        Livro l3 = new livroTecnico("Bruce Alberts", "Molecular Biology of the Cell", 90, "Biologia");
        livraria.addLivro(l3);
        Livro l4 = new livroAventura("Ana Maria Magalhaes", "Uma Aventura em Lisboa", 8, 10);
        livraria.addLivro(l4);
        Livro l5 = new livroTecnico("Ernesto Costa", "Programação em Python", 35, "Informatica");
        livraria.addLivro(l5);

        Cliente c1 = new Premium("B. Antunes", "antunes@books.com");
        livraria.addCliente(c1);
        Cliente c2 = new Frequente("A. Oliveira", "oliveira@books.com");
        livraria.addCliente(c2);
        Cliente c3 = new Regular("C. Teodoro", "teodoro@books.com");
        livraria.addCliente(c3);

        System.out.println("--Stock Inicial--");
        lista = livraria.getLivros();
        for (Livro x : lista) {
            System.out.println(x);
        }

        System.out.println("\n--Compras--");
        System.out.println(livraria.venda(l1, c3));
        System.out.println(livraria.venda(l2, c2));
        System.out.println(livraria.venda(l3, c1));
        System.out.println(livraria.venda(l4, c1));

        System.out.printf("\nVolume de vendas: %.2f€\n", livraria.valorVendas());

        System.out.println("\n--Stock Final--");
        lista = livraria.getLivros();
        for (Livro x : lista) {
            System.out.println(x);
        }

        System.out.println("\n\n" + c1.getNome() + " comprou: ");
        for (Livro l : c1.getLivros()) {
            System.out.println(l);
        }
        System.out.println("\n" + c2.getNome() + " comprou: ");
        for (Livro l : c2.getLivros()) {
            System.out.println(l);
        }
        System.out.println("\n" + c3.getNome() + " comprou: ");
        for (Livro l : c3.getLivros()) {
            System.out.println(l);
        }

    }//main

}//Main
