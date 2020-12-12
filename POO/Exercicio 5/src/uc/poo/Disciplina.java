package uc.poo;

import java.io.*;
import java.util.ArrayList;

class Disciplina implements Serializable{
    private String nome;
    private String acronimo;
    private int ects;
    private ArrayList<Aluno> alunos;

    public Disciplina(String nome, String acronimo, int ects) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.ects = ects;
        this.alunos = new ArrayList<>();
    }

    /**
     * Adiciona um aluno ao array de alunos da Disciplina
     * @param a Aluno
     */
    public void addAluno(Aluno a) {
        this.alunos.add(a);
    }

    /**
     * Remove 'a' da Disciplina
     * @param a Aluno
     */
    public void removeAluno(Aluno a) {
        for (Aluno b: this.alunos) {
            if(b.getNome().equals(a.getNome()) && b.getNum() == a.getNum()){
                if(this.alunos.remove(b))
                    System.out.println("Removido com sucesso");
                break;
            }
        }
    }

    public String toString() {
        return "Nome: " + nome + " - " + acronimo + " - " + ects + " ECTS";
    }

    /**
     * Returns nome da disciplina
     * @return nome da Disciplina
     */
    public String getNome() {
        return nome;
    }

    /**
     * Returns ArrayList com alunos inscritos
     * @return ArrayList com os alunos inscritos na disciplina
     */
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * Returns Acronimo da diciplina
     * @return acronimo
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * Returns ECTS da disciplina
     * @return ECTS
     */
    public int getECTS() {
        return ects;
    }


}
