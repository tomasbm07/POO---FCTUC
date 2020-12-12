package uc.poo;

import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private final String titulo;
    private final String[] autores;
    private final int cota;
    private final String area;

    public Livro(String titulo, String[] autores, int cota, String area) {
        this.titulo = titulo;
        this.autores = autores;
        this.cota = cota;
        this.area = area;
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getAutores() {
        return autores;
    }

    public int getCota() {
        return cota;
    }

    public String getArea() {
        return area;
    }

    public String toString() {
        return "Título: %s,  Autores: %s, Cota: %d, Area: %s".formatted(titulo, autores[0], cota, area);
    }
}

class Biblioteca {
    private ArrayList<Livro> biblioteca = new ArrayList<>();
    String letras = "ABCDEFGHIJKLMNOP";
    String aut = "abcdefghijklmnopqrstuvwxyz";
    String[] areas = {"Matematica", "Informatica", "Medicina", "Geometria", "Fisica", "Biologia"};

    public Biblioteca(int tamanho) {
        String titulo = "";
        for (int i = 0; i < tamanho; i++) {
            /*while(titulo != biblioteca){ Loop por garantir titulo diferente(por acabar)
                titulo = "%c%c".formatted(letras.charAt((int) (Math.random() * (letras.length()))), letras.charAt((int) (Math.random() * (letras.length()))));
            }*/
            titulo = "%c%c".formatted(letras.charAt((int) (Math.random() * (letras.length()))), letras.charAt((int) (Math.random() * (letras.length()))));
            String[] autores = {"%c".formatted(aut.charAt((int) (Math.random() * (aut.length()))))};
            int cota = (int) (Math.random() * (100)) + 1;
            String area = areas[(int) (Math.random() * (areas.length))];

            Livro livro = new Livro(titulo, autores, cota, area);
            biblioteca.add(livro);
        }
    }

    public void showAll() {
        for (Livro x : biblioteca) {
            System.out.println(x);
        }
    }

    public void consultar() {
        Scanner r = new Scanner(System.in);
        Scanner r2 = new Scanner(System.in);
        System.out.println("\n1->Area\n2->Autor");
        System.out.print("Escolha: ");
        int choice = r.nextInt();
        if (choice == 1) {
            System.out.print("Area: ");
            String area = r2.nextLine();
            for (Livro x : biblioteca) {
                if (x.getArea().equals(area)) {
                    System.out.println(x);
                }
            }
        } else {
            System.out.print("Autor: ");
            String autor = r2.nextLine();
            for (Livro x : biblioteca) {
                if (x.getAutores()[0].equals(autor)) {
                    System.out.println(x);
                }
            }

        }
    }

    public void requisitar(){

    }


}//End Biblioteca

class Leitor {
    private String nome;
    private String morada;
    private int idade;
    private int telefone;
    private String email;
    private String[] livorsRequsitados;
}

class Aluno extends Leitor {
    private int num;
    private static String tipo;
}