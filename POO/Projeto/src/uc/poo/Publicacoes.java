package uc.poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

abstract class Publicacao implements Serializable{
    protected ArrayList<String> autores;
    protected String titulo;
    protected String keyword; // palavras chave
    protected int anoPub; //Ano de Publicação
    protected int views; //dimensão da audiência
    protected String resumo;

    public Publicacao(String autores, String titulo, String keyword, int anoPub, int views, String resumo) {
        this.autores = new ArrayList<>();
        addAutores(autores);
        this.titulo = titulo;
        this.keyword = keyword;
        this.anoPub = anoPub;
        this.views = views;
        this.resumo = resumo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getAno() {
        return anoPub;
    }

    public int getViews() {
        return views;
    }

    public String toString() {
        return "Autores: %s, Titulo: %s, Keywords: %s, AnoPublicacao: %s, Audiencia: %d".formatted(autoresToString(), titulo, keyword, anoPub, views);
    }

    public void addAutores(String s) {
        String[] autores = s.split(";");
        //Autor = Nome#Grupo
        this.autores.addAll(Arrays.asList(autores));
    }

    public void setAutores(ArrayList<String> autores){
        this.autores = autores;
    }

    /**
     * Returns uma String com o nome dos autores devidamente separados
     * @return String
     */
    private String autoresToString() {
        //Autor = Nome#Grupo
        String autores = "";
        for (int i = 0; i < this.autores.size(); i++) {
            String[] aux = this.autores.get(i).split("#");
            autores = autores.concat(aux[0]);
            if (i + 1  != this.autores.size())
                autores = autores.concat(" e ");
        }
        return autores;

    }

    abstract String getTipo();

    abstract char fatorImpacto();

}//Publicaçao


class artigoConferencia extends Publicacao { // Artigo de Conferência
    private String nome; //Onde foi feita a Conferência
    private String data; //Data da conferencia
    private String local; //Local da conferencia

    public artigoConferencia(String autores, String titulo, String keyword, int ano, int views, String resumo, String nome, String local, String data) {
        super(autores, titulo, keyword, ano, views, resumo);
        this.nome = nome;
        this.local = local;
        this.data = data;
    }

    public char fatorImpacto() {
        if (this.views < 200)
            return 'C';
        else if (this.views < 500 && this.views >= 200)
            return 'B';
        else
            return 'A';
    }

    public String getTipo() {
        return "artigoConferencia";
    }

    public String toString() {
        return "Artigo de Conferencia, " + super.toString() + ", NomeConf: %s, LocalConf: %s, DataConf: %s".formatted(nome, local, data);
    }

}//Conferência


class artigoRevista extends Publicacao {
    private String nome;
    private int num;
    private String data;

    public artigoRevista(String autores, String titulo, String keyword, int ano, int views, String resumo, String nome, int num, String data) {
        super(autores, titulo, keyword, ano, views, resumo);
        this.nome = nome;
        this.num = num;
        this.data = data;
    }

    public char fatorImpacto() {
        if (this.views < 500)
            return 'C';
        else if (this.views < 1000 && this.views >= 500)
            return 'B';
        else
            return 'A';
    }

    public String getTipo() {
        return "artigoRevista";
    }

    public String toString() {
        return "Artigo de Revista, " + super.toString() + ", NomeRevista: %s, NumRevista: %s, DataRevista: %s".formatted(nome, num, data);
    }

}//artigoRevista


class Livro extends Publicacao {
    protected String editora;
    protected String ISBN;

    public Livro(String autores, String titulo, String keyword, int ano, int views, String resumo, String editora, String ISBN) {
        super(autores, titulo, keyword, ano, views, resumo);
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public char fatorImpacto() {
        if (this.views < 5000)
            return 'C';
        else if (this.views < 10000 && this.views >= 5000)
            return 'B';
        else
            return 'A';
    }

    public String getTipo() {
        return "livro";
    }

    public String toString() {
        return "Livro, " + super.toString() + ", Editora: %s, ISBN: %s".formatted(editora, ISBN);
    }

}//Livro


class capituloLivro extends Livro {
    private String nome;
    private String paginas;

    public capituloLivro(String autores, String titulo, String keyword, int ano, int views, String resumo, String editora, String ISBN, String nome, String paginas) {
        super(autores, titulo, keyword, ano, views, resumo, editora, ISBN);
        this.nome = nome;
        this.paginas = paginas;
    }

    public char fatorImpacto() {
        if (this.views < 5000)
            return 'C';
        else if (this.views < 10000 && this.views >= 5000)
            return 'B';
        else
            return 'A';
    }

    public String getTipo() {
        return "capituloLivro";
    }

    public String toString() {
        return "Capitulo de " + super.toString() + ", NomeLivro: %s, Paginas: %s".formatted(nome, paginas);
    }

}//capLivro

class livroArtigos extends Livro {
    private String nomeConf;
    private int numArtigos;

    public livroArtigos(String autores, String titulo, String keyword, int ano, int views, String resumo, String editora, String ISBN, String nomeConf, int numArtigos) {
        super(autores, titulo, keyword, ano, views, resumo, editora, ISBN);
        this.nomeConf = nomeConf;
        this.numArtigos = numArtigos;
    }

    public char fatorImpacto() {
        if (this.views < 2500)
            return 'C';
        else if (this.views < 7500 && this.views >= 2500)
            return 'B';
        else
            return 'A';
    }

    public String getTipo() {
        return "livroArtigos";
    }

    public String toString() {
        return "Artigos de Conf - " + super.toString() + ", NomeConf: %s, NumArtigos: %d".formatted(nomeConf, numArtigos);
    }

}//livroArtigos