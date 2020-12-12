package uc.poo;

import java.io.*;
import java.util.ArrayList;

class Permutations {
    String s;
    String filename;

    public Permutations(String filename) {
        try {
            FileReader f = new FileReader(new File(filename));
            BufferedReader br = new BufferedReader(f);

            this.filename = br.readLine();
            this.filename = this.filename + ".txt";

            FileWriter fw = new FileWriter(new File(filename));
            BufferedWriter bw = new BufferedWriter(fw);

            this.s = br.readLine();

            f.close();
            br.close();
            fw.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doIt() {
        try {
            FileWriter fw = new FileWriter(this.filename);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    //System.out.println(s.charAt(i) + s.charAt(j));
                    bw.write(s.charAt(i) + s.charAt(j) + "\n");
                }
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}