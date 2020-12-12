package uc.poo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //ex1();
        //ex2();
        ex3();
    }

    public static void ex1(){
        Aluno Xoao = new Aluno("Xoao", 2019784536);
        Docente Tobias = new Docente("Tobias", 2005968745);
        Pessoa idk = new Pessoa("idk");

        System.out.println(Xoao);
        System.out.println(Tobias);
    }

    public static void ex2(){
        Cafe cafe = new Cafe();
        Expresso exp = new Expresso("normal");
        Leite leite = new Leite();
        Espuma espuma = new Espuma();
        Galao galao = new Galao();
        Cappuccino cap = new Cappuccino();
        Macchiato macc = new Macchiato();
        //System.out.println(cafe);
        //System.out.println(exp);
        //System.out.println(leite);
        //System.out.println(espuma);
        //System.out.println(galao);
        //System.out.println(cap);
        System.out.println(macc);
    }

    public static void ex3(){
        ArrayList<Conta> array = new ArrayList<>();
        
        array.add(new contaOrdem("",0,1500));
        array.add(new contaOrdem("",0,1600));
        array.add(new contaOrdem("",0,1700));
        array.add(new contaPrazo("",0,1000));
        array.add(new contaPrazo("",0,1200));
        array.add(new contaPrazo("",0,1300));

        /*for (Conta i: array) {
            System.out.println(i);
        }*/

        Conta i = array.get(0);
        i.deposito(2000);
        i.levantamento(500);
        System.out.println(i.checkConta(1000));
        i.consulta();
        
    }

}//End Class Main



