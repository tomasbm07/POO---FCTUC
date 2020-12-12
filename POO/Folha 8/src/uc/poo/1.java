package uc.poo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Temperaturas {
    ArrayList<Integer> temps;

    public Temperaturas(String filename) {
        temps = new ArrayList<Integer>();

        try {
            FileReader f = new FileReader(new File(filename));
            BufferedReader br = new BufferedReader(f);
            String s = br.readLine();
            while (s != null) {
                temps.add(Integer.parseInt(s));
                s = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        for (int x : temps) {
            System.out.println(x);
        }
    }

    public void amplitude() {
        Collections.sort(temps);
        int amplitude = temps.get(temps.size() - 1) - temps.get(0);
        System.out.println("Amplitude: " + amplitude);
    }

}
