package uc.poo;

import java.io.*;
import java.util.ArrayList;

/**
 *
 */
abstract class Investigador implements Serializable {
    protected String nome;
    protected String email;
    protected String grupo;
    protected ArrayList<Publicacao> repo;

    /**
     * @param nome  nome do investigador
     * @param email email do investigador
     * @param grupo grupo a que pertence
     */
    public Investigador(String nome, String email, String grupo) {
        this.nome = nome;
        this.email = email;
        this.grupo = grupo;
        repo = new ArrayList<>();
    }

    /**
     * Returns nome do Investigador
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Returns email do Investigador
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Returns Type - Estudante ou Efetivo
     * @return type
     */
    abstract String getType();

    /**
     * Returns acronimo do grupo do Investigador
     * @return grupo
     */
    public String getGrupo(){
        return grupo;
    }

    /**
     * Returns numero de telefone de um Investigador Efetivo
     * @return telefone
     */
    /*public String getTelefone(){
        return null;
    }*/

    /**
     * Returns gabinete de um Investigador Efetivo
     * @return gabinete
     */
    /*public String getGabinete(){
        return null;
    }*/

    /**
     * Returns o nome de publicacao de um Investigador
     * @return nome de Publicacao
     */
    abstract String getNomePublic();

    public void addPub(Publicacao p){
        repo.add(p);
    }

    public ArrayList<Publicacao> getPubs(){
        return repo;
    }


}//Investigador

class Efetivo extends Investigador {
    private final String gabinete;
    private final String telefone;

    /**
     * Cria um investigador efetivo
     *
     * @param nome     nome do investigador
     * @param email    email do investigador
     * @param grupo    grupo a que pertence
     * @param gabinete gabinete do investigador
     * @param telefone num de telefone do investigador
     */
    public Efetivo(String nome, String email, String grupo, String gabinete, String telefone) {
        super(nome, email, grupo);
        this.gabinete = gabinete;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Investigador Efetivo, Nome: %s, Email: %s, Grupo: %s, Gabinete: %s, Tel: %s".formatted(nome, email, grupo, gabinete, telefone);
    }

    @Override
    public String getType() {
        return "Efetivo";
    }

    //@Override
    public String getTelefone() {
        return telefone;
    }

    //@Override
    public String getGabinete() {
        return gabinete;
    }

    @Override
    public String getNomePublic() {
        String[] arr = nome.split(" ");
        return "Professor " + arr[0] + " " + arr[arr.length - 1];
    }

}//Efetivo

class Estudante extends Investigador {
    private final String tituloTese;
    private final String dataConclusao;
    private final String orientador;

    /**
     * Cria um investigador estudante
     *
     * @param nome          nome do investigador
     * @param email         email do investigador
     * @param grupo         grupo a que pertence
     * @param tituloTese    titulo da tese
     * @param dataConclusao data prevista de conclusao da tese de doutoramento
     * @param orientador    professor orientador
     */
    public Estudante(String nome, String email, String grupo, String tituloTese, String dataConclusao, String orientador) {
        super(nome, email, grupo);
        this.tituloTese = tituloTese;
        this.dataConclusao = dataConclusao;
        this.orientador = orientador;
    }

    @Override
    public String toString() {
        return "Investigador Estudante, Nome: %s, Email: %s, Grupo: %s, Titulo: %s, Data Conclusão: %s, Orientador: %s".formatted(nome, email, grupo, tituloTese, dataConclusao, orientador);
    }

    @Override
    public String getType() {
        return "Estudante";
    }

    @Override
    public String getNomePublic() {
        String[] arr = nome.split(" ");
        return arr[0].charAt(0) + ". " + arr[arr.length - 1];
    }

}//Estudante
