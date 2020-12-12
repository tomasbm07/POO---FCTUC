package uc.poo;

class CestoFruta{

}

abstract class Fruta {
    protected String nome;
    protected double price;

    public Fruta(String nome){
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    abstract public double getValue();

}

class FrutaUnidade extends Fruta{
    int quantidade;

    public FrutaUnidade(String nome) {
        super(nome);
    }

    public double getValue() {
        return getPrice() * quantidade;
    }
}

class FrutaPeso extends Fruta{
    double peso;

    public FrutaPeso(String nome) {
        super(nome);
    }

    public double getValue() {
        return getPrice() * peso;
    }
}

class FrutaVolume extends Fruta{
    double volume;

    public FrutaVolume(String nome) {
        super(nome);
    }

    public double getValue() {
        return getPrice() * volume;
    }

}
