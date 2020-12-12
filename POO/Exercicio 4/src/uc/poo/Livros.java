package uc.poo;

class Livro {
    protected String autor;
    protected String titulo;
    protected int preco;

    public Livro(String autor, String titulo, int preco) {
        this.autor = autor;
        this.titulo = titulo;
        this.preco = preco;
    }

    public String toString() {
        return "Autor: %s, Titulo: %s, Preço: %d€".formatted(autor, titulo, preco);
    }

    //Returns the price
    public int getPreco() {
        return preco;
    }

    //Returns the title
    public String getTitulo() {
        return titulo;
    }

    //Returns the type of book
    public String getType() {
        return "";
    }

    //Returns the area the book is related to
    public String getArea() {
        return "";
    }

}//Livro


class livroTecnico extends Livro {
    private String area;

    public livroTecnico(String autor, String titulo, int preco, String area) {
        super(autor, titulo, preco);
        this.area = area;
    }

    //Returns the area the book is related to
    public String getArea() {
        return area;
    }

    //Returns the type of book
    public String getType() {
        return "Técnico";
    }

    public String toString() {
        return "Autor: %s, Titulo: %s, Area: %s, Preço: %d€".formatted(autor, titulo, area, preco);
    }

}//Tecnico


class livroAventura extends Livro {
    private int idadeMin;

    public livroAventura(String autor, String titulo, int preco, int idadeMin) {
        super(autor, titulo, preco);
        this.idadeMin = idadeMin;
    }

    //Returns the minium recommend age for the book
    public int getIdadeMin() {
        return idadeMin;
    }

    //Returns the type of book
    public String getType() {
        return "de Aventura";
    }

    public String toString() {
        return "Autor: %s, Titulo: %s, IdadeMin: %s, Preço: %d€".formatted(autor, titulo, idadeMin, preco);
    }

}//Aventura
