package uc.poo;

class Pessoa{
    protected String nome;

    protected Pessoa(String nome){
        this.nome = nome;
    }

    protected String getNome(){
        return nome;
    }

    public String comunica(){
        return getNome() + " a comunicar.\n";
    }

}//End Class Pessoa

class Aluno extends Pessoa{
    private int n_estudante;

    Aluno(String nome, int num) {
        super(nome);
        this.n_estudante = num;
    }

    private String missao(){
        return "aprender";
    }

    private int getNum(){
        return n_estudante;
    }

    public String toString(){
        return super.nome + " com o Nº de aluno " + getNum() + " tem a missao de " + missao();
    }
}//End Class Aluno

class Docente extends Pessoa{
    private int n_mecanografico;

    Docente(String nome, int num) {
        super(nome);
        this.n_mecanografico = num;
    }

    private int getNum(){
        return n_mecanografico;
    }

    private String missao(){
        return "ensinar";
    }

    public String toString(){
        return super.nome + " com o Nº de mecanografico " + getNum() + " tem a missao de " + missao();
    }
}//End Class Docente
