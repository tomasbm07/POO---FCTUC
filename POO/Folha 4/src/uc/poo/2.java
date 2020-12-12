package uc.poo;

class Bebida{

    protected String nome;
    protected int temperatura;
    protected int quantidade;

    public Bebida(){

    }

    public Bebida(String nome, int temperatura, int quantidade){
        this.nome = nome;
        this.temperatura = temperatura;
        this.quantidade = quantidade;
    }

    public String toString(){
        return nome + " - " + temperatura + "ºC - " + quantidade + "mL";
    }

}//End Bebida

class Cafe extends Bebida{

    public Cafe() {
        super("Café", 60, 100);
    }

    public Cafe(int quantidade){
        super("Café ".concat("Expresso"), 70, quantidade);
    }

}//End Cafe

class Expresso extends Cafe{

    public Expresso(String tipo){
        super(25);
        super.quantidade = expType(tipo);

    }

    private int expType(String tipo){
        return switch (tipo){
            case "curto" -> 25;
            case "normal" -> 35;
            case "cheio" -> 50;
            default -> 0;
        };
    }
}//End Expresso

class Leite extends Bebida{

    public Leite() {
        super("Leite", 55, 155);
    }
}

class Espuma extends Leite{

    public Espuma(){
        super.nome = "Espuma de Leite";
        super.temperatura = 60;
        super.quantidade = 80;
    }
}

class cafeLeite extends Bebida{

    public cafeLeite() {
        Cafe cafe = new Cafe();
        Leite leite = new Leite();
    }
}

class Galao extends cafeLeite{
    Cafe cafe = new Cafe();
    Leite leite = new Leite();

    public Galao(){

    }

    public String toString(){
        return "Galão:\n" + cafe + "\n" + leite;
    }

}

class Cappuccino extends cafeLeite{
    Expresso cafe = new Expresso("cheio");
    Espuma leite = new Espuma();

    public Cappuccino(){}

    public String toString(){
        return "Cappuccino:\n" + cafe + "\n" + leite;
    }
}

class Macchiato extends cafeLeite{
    Cappuccino cap = new Cappuccino();
    Leite leite = new Leite();

    public Macchiato(){}

    public String toString(){
        return "Macchiato:\n" + cap + "\n" + leite;
    }
}

