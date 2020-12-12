package uc.poo;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        //ex1();
        ex2();
        //teste();
    }

    public static void ex1() {
        Temperaturas temps = new Temperaturas("1.txt");
        temps.amplitude();
    }

    public static void ex2() {
        Permutations idk = new Permutations("2.txt");
        idk.doIt();
    }

    public static void teste() {
        Person p = new Person("OLA123", 25);
        writeObj(p);
    }

    public static void writeObj(Person p) {
        try {
        FileOutputStream f = new FileOutputStream(new File("myObjects.ser"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(p);

        o.close();
        f.close();

        FileInputStream fi = new FileInputStream(new File("myObjects.ser"));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
        Person pr1 = (Person) oi.readObject();

        System.out.println(pr1.toString());

        oi.close();
        fi.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
