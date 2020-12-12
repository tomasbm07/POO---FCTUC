package uc.poo;

class Poligno{

    public Poligno(){

    }

}

class Ponto{
    double x;
    double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }

}

class Quadrado extends Poligno {
    Ponto[] pontos;

    public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4){
        pontos = new Ponto[]{p1, p2, p3, p4};
    }

}