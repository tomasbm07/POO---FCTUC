package uc.poo;

import java.util.ArrayList;
import java.util.Scanner;

class Supermercado {
    private final int TAMANHO = 5; //Limite max dos produtos em stock
    private ArrayList<Produto> stock = new ArrayList<>();

    public Supermercado(){}

    //Adds an item to stock
    public void addStock(Produto produto) {
        if (stockAmount() < TAMANHO && !inStock(produto.getNome())) {
            stock.add(produto);
            System.out.println("Produto adicionado com sucesso");
        } else
            System.out.println("Erro: Não foi possivel adicionar o produto!");

    }

    // Removes an item from the List
    public void removeStock(Produto produto) {
        stock.remove(produto);
    }

    // Prints the description of all itens in stock
    public void showStock() {
        if (stockAmount() == 0) {
            System.out.println("Erro: Ainda não exitem produtos em stock");
            return;
        }

        System.out.print("--Produtos Disponiveis--\n");
        for (Produto i : stock) {
            i.description();
        }
        System.out.print("------------------------\n");
    }

    // Returns the total amount of stock(total number of items)
    private int stockAmount() {
        return stock.size();
    }

    //returns if an item is in stock or not
    private boolean inStock(String name) {
        for (Produto i : stock) {
            if (i.getNome().equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public void vender() {
        if (stockAmount() == 0) {
            System.out.println("Erro: Ainda não exitem produtos em stock");
            return;
        }

        System.out.print("Produtos disponiveis: ");
        for (Produto i: stock) {
            System.out.printf("%s ", i.getNome());
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Produto: ");
        String productName = sc.nextLine();
        System.out.print("Quantidade: ");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("Erro: Quantidade tem de ser >= 0");
            return;
        }

        Produto produto = getProduto(productName);
        if (produto == null) {
            System.out.println("Erro: Produto não está em Stock");
            return;
        }

        boolean inStock = inStock(productName);
        int stockAmount = produto.getStock();

        if (inStock && stockAmount >= amount) {
            System.out.printf("Vendido: %s - %d unidades no valor de %.2g€\n", produto.getNome(), amount, produto.getPrice() * amount);
            produto.setStock(produto.getStock() - amount);
            System.out.printf("Restam %d unidades de %s\n", produto.getStock(), productName);
            if (produto.getStock() == 0)
                removeStock(produto);
        } else if (!inStock) System.out.println("Erro: Produto inexistente!");
        else System.out.println("Erro: Stock insuficiente!");

    }

    //returns the product that matches the name
    private Produto getProduto(String name) {
        Produto aux = null;
        for (Produto i : stock) {
            if (i.getNome().equalsIgnoreCase(name)){
                aux = i;
                break;
            }
        }
        return aux;
    }

    //returns o Valor total dos produtos em stock
    public double valorStock() {
        double sum = 0;

        if (stockAmount() == 0)
            return -1;

        for (Produto i : stock) {
            sum += (i.getStock() * i.getPrice());
        }
        return sum;
    }


} //End Class Supermercado
