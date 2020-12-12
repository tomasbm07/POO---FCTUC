package uc.poo;

import java.io.*;
import java.util.ArrayList;

class Teste {
    private ArrayList<Aluno> alunos;


    public Teste() {

    }

    private void readTesteFile() {
        try {
            FileReader f = new FileReader(new File("teste.txt"));
            BufferedReader br = new BufferedReader(f);

            String line;

            while ((line = br.readLine()) != null) {
                String[] teste = line.split(",");
                Aluno a = new Aluno(teste[0]);
                for (String s: teste) {

                }
                a.sumPontos();


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Aluno{
    String nome;
    int pontos;

    public Aluno(String nome){
        this.nome = nome;
        this.pontos = 0;
    }

    public void sumPontos(){
        this.pontos++;
    }
}
