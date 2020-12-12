package uc.poo;

import java.util.ArrayList;

class Livraria {
    private ArrayList<Livro> listaLivros = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private double totalVendas = 0;


    public Livraria() {
    }

    //Adds a book to the list
    public void addLivro(Livro l) {
        listaLivros.add(l);
    }

    //Adds a client to the list
    public void addCliente(Cliente c) {
        listaClientes.add(c);
    }

    //Returns the list with all the books
    public ArrayList<Livro> getLivros() {
        return listaLivros;
    }

    //Removes a book from the list
    private void remove(Livro l) {
        listaLivros.remove(l);
    }

    //Removes a client from the list
    private void remove(Cliente c) {
        listaClientes.remove(c);
    }

    //Makes the sale of a book
    public String venda(Livro l, Cliente c) {
        if (!listaClientes.contains(c)) {
            return "O Cliente nao esta registado";
        }

        c.addLivro(l);
        double price = c.precoCliente(l);
        totalVendas += price;
        remove(l);
        return "%s comprou %s, Livro %s de %s por %.2g€".formatted(c.getNome(), l.getTitulo(), l.getType(), l.getArea(), price);
    }

    //Returns the value of sales
    public double valorVendas() {
        return totalVendas;
    }

}//Livraria
