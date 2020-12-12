package uc.poo;

class Banco {

}


class Conta {
    String nome;
    int id;
    int saldo;

    public Conta(String nome, int id, int saldo) {
        this.nome = nome;
        this.id = id;
        this.saldo = saldo;
    }

    public void levantamento(int valor) {
        if (saldo < valor) {
            System.out.println("Nao tem saldo suficiente!\n");
            return;
        }
        saldo -= valor;
    }

    public void deposito(int valor){
        saldo += valor;
    }

    public void consulta(){
        System.out.println("Saldo: " + saldo + "€\n");
    }

    public boolean checkConta(int valor){
        return saldo >= valor;
    }

}

class contaOrdem extends Conta {

    public contaOrdem(String nome, int id, int saldo) {
        super(nome, id, saldo);
    }

    public String toString() {
        return "Cliente: " + nome + "\nid: " + id + "\nsaldo: " + saldo + "\nConta à Ordem\n";
    }

}

class contaPrazo extends Conta {

    public contaPrazo(String nome, int id, int saldo) {
        super(nome, id, saldo);
    }

    public String toString() {
        return "Cliente: " + nome + "\nid: " + id + "\nsaldo: " + saldo + "\nConta a Prazo\n";
    }

}

