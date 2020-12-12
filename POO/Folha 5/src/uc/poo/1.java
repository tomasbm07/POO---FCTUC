package uc.poo;

class Animal{
    String tipo;
    String id;

    public Animal(String tipo, String id){
        this.tipo = tipo;
        this.id = id;
    }

    public String desloca(){
        return "Animal a deslocar-se";
    }

}

class Mamifero extends Animal{

    public Mamifero(String tipo, String id) {
        super(tipo, id);
    }

    public String desloca(){
        return "Mamifero a deslocar-se";
    }

}

class Ave extends Animal{

    public Ave(String tipo, String id) {
        super(tipo, id);
    }

    public String desloca(){
        return "Ave a voar";
    }

}

class Reptil extends Animal{

    public Reptil(String tipo, String id) {
        super(tipo, id);
    }

    public String desloca(){
        return "Reptil a rastejar";
    }

}

class Peixe extends Animal{

    public Peixe(String tipo, String id) {
        super(tipo, id);
    }

    public String desloca(){
        return "Peixe a nadar";
    }

}