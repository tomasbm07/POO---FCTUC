package uc.poo;

import java.io.Serializable;


class Aluno implements Serializable {
    private String nome;
    private int num;

    public Aluno(String nome, int num){
        this.nome = nome;
        this.num = num;
    }

    /**
     * Returns num do aluno
     * @return num
     */
    public int getNum(){
        return num;
    }

    /**
     * Returns nome do aluno
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    public String toString(){
        return nome + ", " + num;
    }

}
