package uc.poo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //ex1();
        //ex2();
        ex3();
    }

    public static void ex1(){
        ArrayList<Animal> array = new ArrayList<>(5);
        Mamifero mamifero = new Mamifero("", "");
        Reptil reptil = new Reptil("", "");
        Ave ave = new Ave("", "");
        Peixe peixe = new Peixe("", "");

        array.add(mamifero);
        array.add(reptil);
        array.add(ave);
        array.add(peixe);

        for (Animal x: array) {
            System.out.println(x.desloca());
        }
    }

    public static void ex2(){
        Carteira idk = new Carteira();
        idk.showAll();
        System.out.print("Best team: " + idk.bestTeam());
    }

    public static void ex3(){
        Biblioteca teste = new Biblioteca(50);
        teste.showAll();
        teste.consultar();
    }



}//End Main
