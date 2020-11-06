package uc.poo;

import java.util.Scanner;

class Produto {
    private String name;
    private double price;
    private Date date;
    private int stock;


    public Produto() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("------Adicionar novo Produto------");
        System.out.print("Nome: ");
        this.name = sc.nextLine();
        System.out.print("Preço: ");
        this.price = sc.nextDouble();
        if (price < 0) {
            System.out.println("Erro: Preço tem de ser >=0");
            return;
        }
        System.out.print("Data de Validade(DD/MM/AAAA): ");
        this.date = new Date(sc2.nextLine());
        System.out.print("Stock: ");
        this.stock = sc.nextInt();
        if (stock <= 0) {
            System.out.println("Erro: Stock tem de ser >0");
            return;
        }
        System.out.println("----------------------------------");
    }

    // Prints all product's variables
    public void description() {
        System.out.printf("Produto: %s\n", name);
        System.out.printf("Validade: %s\n", date.inString());
        System.out.printf("Preço: %.2g€\n", price);
        System.out.printf("Stock: %d\n", stock);
        System.out.println();
    }

    // returns product name
    public String getNome() {
        return name;
    }

    // returns product price
    public double getPrice() {
        return price;
    }

    // returns the stock of an item
    public int getStock() {
        return stock;
    }

    public void setStock(int amount) {
        this.stock = amount;
    }

}//End Class Produto
