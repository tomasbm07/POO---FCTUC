package uc.poo;

import java.lang.Math;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //ex1();
        //ex2();
        //ex3();
        //ex4(); //Semi-Feito, Minor Bugs
        //ex5();
        //ex9();
        //ex10();
        //ex11();
        //ex12();
        //ex13();
        //ex16();
        ex18();

    }

    public static void ex1() {
        for (int i = 0; i < 1000; i++) {
            int dia = ((int) (Math.random() * 30) + 1); // 1 < dia < 30
            int mes = ((int) (Math.random() * 12) + 1); // 1 < mes < 12
            int ano = ((int) (Math.random() * 2500) + 1000); // 1000 < ano < 2500
            while (mes == 2 && dia > 27) {
                dia = ((int) (Math.random() * 30) + 1);
            }
            Data data = new Data(dia, mes, ano);
            data.show_string();
        }
    }

    public static void ex2() {
        Angulo angulo1 = new Angulo();
        Angulo angulo2 = new Angulo();

        /*System.out.println("Angulo 1 em graus: " + angulo1.graus);
        System.out.println("Angulo 2 em graus: " + angulo2.graus);
        System.out.println("Angulo 1 em radianos: " + angulo1.toRadian());
        System.out.println("Angulo 2 em radianos: " + angulo2.toRadian());

        System.out.println(angulo1.graus + " == " + angulo2.graus + " -> " + angulo1.equals(angulo2.graus));

        System.out.printf("sin(%.2f) = %.2f\n", angulo1.graus, angulo1.sin());
        System.out.printf("cos(%.2f) = %.2f\n", angulo1.graus, angulo1.cos());
        System.out.printf("tan(%.2f) = %.2f\n", angulo1.graus, angulo1.tan());

        System.out.printf("sin(%.2f) = %.2f\n", angulo2.graus, angulo2.sin());
        System.out.printf("cos(%.2f) = %.2f\n", angulo2.graus, angulo2.cos());
        System.out.printf("tan(%.2f) = %.2f\n", angulo2.graus, angulo2.tan());*/
    }

    public static void ex3() {
        Disciplina POO = new Disciplina("POO", 2019232272);
        POO.set_normal(18);
        POO.set_recurso(16);
        POO.set_especial(16);
        POO.to_string();
    }

    public static void ex4() {
        Fracao fraction = new Fracao(26, 56, 34, 56);
        fraction.showResult(fraction.sub());
        //fraction.sub();
    }

    public static void ex5() {

    }

    public static void ex9() {
        String frase = "asdnasdknasdhsfnsddsfgsd";
        for (int i = 0; i < frase.length(); i++)
            System.out.println(frase.charAt(i));
    }

    public static void ex10() {
        int count = 0;
        String frase = "lsfbasuilrnw<asjkfnauibanskjfdnaiso<andfhsu";
        for (int i = 0; i < frase.length(); i++) {
            switch (frase.charAt(i)) {
                case 'a', 'e', 'i', 'o', 'u' -> count++;
            }
        }
        System.out.println(count);
    }

    public static void ex11() {
        String frase = "abba";
        boolean isPalindromo = true;

        for (int i = 0; true; i++) {
            if (frase.charAt(i) != frase.charAt(frase.length() - i - 1)) {
                isPalindromo = false;
                break;
            }
        }

        if (isPalindromo)
            System.out.println("A palavra é Palindromo");
        else
            System.out.println("A palavra não é Palindromo");

    }

    public static void ex12() {
        String palavra = "aeiou";
        String aux = "";

        for (int i = 0; i < palavra.length() - 1; i++) {
            char a = palavra.charAt(i);
            if (isVowel(palavra.charAt(i)) == isVowel(palavra.charAt(i + 1))) {
                aux = palavra.substring(0, i + 1);
                String[] arr = palavra.split(String.valueOf(a), 2);
                aux += 'p';
                aux += arr[1];
                palavra = aux;
            }
        }
        System.out.println(palavra);
    }

    public static boolean isVowel(char a) {
        switch (a) {
            case 'a', 'e', 'i', 'o', 'u' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public static void ex13() {
        String frase = "AA BB CC DD EE AA BB CC BB";
        String palavra = "BB";

        System.out.println(reps(frase, palavra));
    }

    public static int reps(String frase, String palavra) {
        int count = 0;
        while (frase.contains(palavra)) {
            count++;
            String[] arrofstr = frase.split(palavra, 2);
            frase = arrofstr[1];
        }
        return count;
    }

    public static void ex16() {
        String ISBN = "0 8 9 2 3 7 0 1 0 6";
        int[] s1 = new int[10];
        int[] s2 = new int[10];

        String[] arr = ISBN.split(" ");
        System.out.print("ISBN = ");
        for (String i : arr) {
            System.out.print(i + " ");
        }
        for (int i = 1; i < arr.length; i++) {
            s1[i] = s1[i - 1] + Integer.parseInt(arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            s2[i] = s2[i - 1] + s1[i];
        }

        System.out.print("\ns1 = ");
        for (int i : s1) {
            System.out.print(i + " ");
        }
        System.out.print("\ns2 = ");
        for (int i : s2) {
            System.out.print(i + " ");
        }

        if (s2[9] % 11 == 0)
            System.out.println("\nO ISBN é válido");
        else
            System.out.println("\nO ISBN não é válido");
    }

    public static void ex18() {
        ArrayList<String> Tags = new ArrayList<>();

        String HTML = """
                <BEGIN> Estou dentro da tag BEGIN </BEGIN>
                <START> Aqui vem mais um pedaço
                de texto. </START>
                Esta tag está vazia <>
                Aqui tudo bem <OKAY> e
                <GOOD> aqui também.
                </GOOD> </OKAY>
                Aqui há um erro <START> </STOP>
                Aqui falta qualquer coisa: <OK></OK></NOTOK><Z>""";

        for (int i = 0; i < HTML.length(); i++) {
            char aux = HTML.charAt(i);
            int j = i + 1;
            String tag = "";
            if (aux == '<') {
                while ((aux = HTML.charAt(j)) != '>') {
                    tag += aux;
                    j++;
                }
                i = j;
                Tags.add(tag);
            }
        }

        for (String i : Tags) {
            if (Tags.contains(String.format("/%s", i))) {
                System.out.printf("Tag correta: %s %s\n", i, String.format("/%s", i));
            } else if(!Tags.contains(String.format("/%s", i))){
                System.out.printf("Tag incorreta: %s\n", i);
            }
        }

        /*for (String i : Tags) {
            System.out.println(i);
        }*/
    }


}//End Class Main


class Data {
    int dia;
    int mes;
    int ano;

    public Data(int a, int b, int c) {
        dia = a;
        mes = b;
        ano = c;
    }

    public void show_string() {
        String idk = switch (mes) {
            case 1 -> "janeiro";
            case 2 -> "fevereiro";
            case 3 -> "março";
            case 4 -> "abril";
            case 5 -> "maio";
            case 6 -> "junho";
            case 7 -> "julho";
            case 8 -> "agosto";
            case 9 -> "setembro";
            case 10 -> "outubro";
            case 11 -> "novembro";
            case 12 -> "dezembro";
            default -> " ";
        };
        System.out.printf("%d de %s de %d\n", dia, idk, ano);
    }

}//End Class Data

class Angulo {
    private double ang;

    /*public Angulo(double angulo) {
        this.ang = angulo;
    }*/

    public double get() {
        return ang;
    }

    public void set(double angulo) {
        this.ang = angulo;
    }

    public String to_string() {
        return String.valueOf(ang);
    }

    public double sum(double angulo) {
        return ang + angulo;
    }

    public double sub(double angulo) {
        return ang - angulo;
    }

    public double toRadian() {
        return Math.toRadians(ang);
    }

    public boolean equals(double angulo) {
        return ang == angulo;
    }

    public double sin() {
        return Math.sin(Math.toRadians(ang));
    }

    public double cos() {
        return Math.cos(Math.toRadians(ang));
    }

    public double tan() {
        return Math.tan(Math.toRadians(ang));
    }

}//End Class Angulo

class Disciplina {
    public String nome;
    public int num_aluno;
    private int ep_normal;
    private int ep_recurso;
    private int ep_especial;

    public Disciplina(String nome, int num) {
        this.nome = nome;
        this.num_aluno = num;
    }

    public int get_normal() {
        return ep_normal;
    }

    public int get_recurso() {
        return ep_recurso;
    }

    public int get_especial() {
        return ep_especial;
    }

    public void set_normal(int nota) {
        this.ep_normal = nota;
    }

    public void set_recurso(int nota) {
        this.ep_recurso = nota;
    }

    public void set_especial(int nota) {
        this.ep_especial = nota;
    }

    public int melhorNota() {
        if (this.ep_normal > this.ep_recurso && this.ep_normal > this.ep_especial)
            return this.ep_normal;
        else if (this.ep_recurso > this.ep_normal && this.ep_recurso > this.ep_especial)
            return this.ep_recurso;
        else
            return this.ep_especial;
    }

    public void to_string() {
        System.out.printf("[%s] - Avaliação do aluno nº[%d]\n", this.nome, this.num_aluno);
        System.out.printf("Época Normal: [%d] Valores\n", this.ep_normal);
        System.out.printf("Época Recurso: [%d] Valores\n", this.ep_recurso);
        System.out.printf("Época Especial: [%d] Valores\n", this.ep_especial);
        System.out.printf("Melhor nota: [%d] Valores\n", melhorNota());
    }

}//End Class Disciplina

class Fracao {
    private int nume1;
    private int nume2;
    private int denom1;
    private int denom2;

    public Fracao(int upper1, int lower1, int upper2, int lower2) {
        this.nume1 = upper1;
        this.nume2 = upper2;
        this.denom1 = lower1;
        this.denom2 = lower2;
    }

    public int[] add() {
        if (denom1 != denom2) {
            int aux = denom1;
            denom1 *= denom2;
            nume1 *= denom2;
            nume2 *= aux;
            denom2 *= aux;
        }
        /*if (isNegative(nume1 + nume2))
            return simplify(new int[]{nume1 + nume2, denom1}, true);*/
        return simplify(new int[]{nume1 + nume2, denom1});
    }

    public int[] sub() {
        if (denom1 != denom2) {
            int aux = denom1;
            denom1 *= denom2;
            nume1 *= denom2;
            nume2 *= aux;
            denom2 *= aux;
        }
        /*if (isNegative(nume1 - nume2) || isNegative(denom1))
            return simplify(new int[]{Math.abs(nume1 - nume2), Math.abs(denom1)}, true);*/
        return simplify(new int[]{nume1 - nume2, denom1});
    }

    public int[] mult() {
        /*if (isNegative(nume1 * denom2) || isNegative(nume2 * denom1))
            return simplify(new int[]{Math.abs(nume1 * nume2), Math.abs(denom1 * denom2)}, true);*/
        return simplify(new int[]{nume1 * nume2, denom1 * denom2});

    }

    public int[] div() {
        /*if (isNegative(nume1 * denom2) || isNegative(nume2 * denom1))
            return simplify(new int[]{Math.abs(nume1 * denom2), Math.abs(nume2 * denom1)}, true);*/
        return simplify(new int[]{nume1 * denom2, nume2 * denom1});
    }

    private static int mdc(int a, int b) {
        if (a == 0)
            return b;

        return mdc(b % a, a);
    }

    private int[] simplify(int[] x) {

        int mdc = mdc(x[0], x[1]);
        x[0] = x[0] / mdc;
        x[1] = x[1] / mdc;
        return new int[]{x[0], x[1]};
    }

    public void showResult(int[] x) {
        switch (x[1]) {
            case 0 -> System.out.print("0\n");
            case 1 -> System.out.printf("%d\n", x[0]);
            default -> {
                /*if (isNegative(x[0]) || isNegative(x[1]))
                    System.out.printf(" %3d\n- ----\n %3d", x[0], x[1]);
                else*/
                System.out.printf("%3d\n----\n%3d", x[0], x[1]);
            }
        }
    }

    private static boolean isNegative(int n) {
        return n < 0;
    }


}//End Class Fracao


class Poligno {

    private int[][] a;
    private Angulo angle = new Angulo();

    public Poligno(int a[][]) {
        this.a = a;
    }

    private double vectorSize(int[] x, int[] y) {
        return (Math.sqrt(Math.pow(x[0] + x[1], 2) + Math.pow(y[0] + y[1], 2)));
    }

    private int vectorProduct(int[][] x, int[][] y) {
        return (x[0][0] * y[1][0] + x[0][1] * y[1][1]);
    }

    private double vectorMagnitude(int[][] x) {
        return Math.sqrt(Math.pow(x[0][0], 2) + Math.pow(x[0][1], 2));
    }

    private double vectorsAngle(int[][] x, int[][] y) { // x = {{0, 0}, {2, 1}} -> vector
        if (x.length > 2 || y.length > 2) {
            System.err.println("Vector must follow shape: x = {{0, 0}, {2, 1}}");
            return 0;
        }
        angle.set(vectorProduct(x, y) / (vectorMagnitude(x) * vectorMagnitude(y)));

        return angle.get();
    }

    public int dimension() { // numero de lados
        return a.length;
    }


}//End Class Poligno

