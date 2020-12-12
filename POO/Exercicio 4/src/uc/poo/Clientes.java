package uc.poo;

import java.util.ArrayList;

class Cliente {
    protected String nome;
    protected String email;
    protected ArrayList<Livro> compras = new ArrayList<>();

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    //Returns Nome
    public String getNome() {
        return nome;
    }

    //Adds a book to the list of a client
    public void addLivro(Livro l) {
        compras.add(l);
    }

    //Returns a list of all book bought by the client
    public ArrayList<Livro> getLivros() {
        return compras;
    }

    //Returns the price the client should pay, based on their rank
    public double precoCliente(Livro l) {
        return l.getPreco();
    }

}//Cliente


class Regular extends Cliente {

    public Regular(String nome, String email) {
        super(nome, email);
    }

}//Regular


class Frequente extends Cliente {

    public Frequente(String nome, String email) {
        super(nome, email);
    }

    //Returns the price the client should pay, based on their rank
    public double precoCliente(Livro l) {
        return l.getPreco() * 0.95;
    }

}//Frequente


class Premium extends Cliente {

    public Premium(String nome, String email) {
        super(nome, email);
    }

    //Returns the price the client should pay, based on their rank
    public double precoCliente(Livro l) {
        return l.getPreco() * 0.90;
    }

}//Premium