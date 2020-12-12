package uc.poo;

import java.util.ArrayList;


/**
 *
 */
abstract class Grupo {
    protected String nome;
    protected String acronimo;
    protected Investigador responsavel;
    protected ArrayList<Investigador> membros;

    /**
     * Cria um Grupo com os seguintes paramametros:
     *
     * @param nome     nome do grupo
     * @param acronimo acronimo do grupo
     */
    public Grupo(String nome, String acronimo /*Investigador responsavel*/) {
        this.nome = nome;
        this.acronimo = acronimo;
        //this.responsavel = responsavel;
        membros = new ArrayList<>();
    }

    public String toString() {
        return "Nome: %s, Acronimo: %s, Responsavel: %s, Membros %d".formatted(nome, acronimo, getResponsavel().getNome(), membros.size());
    }

    /**
     * Coloca um Investigador na lista de membros de um grupo
     *
     * @param i Investigador
     */
    public void addInvestigador(Investigador i) {
        for (Investigador x : membros) {
            if (x.getNome().equals(i.nome) && x.getEmail().equals(i.email)) { //mesmo nome e email, ja pertence ao grupo
                System.out.println("Membro já está no grupo!");
                return;
            }
        }
        membros.add(i);
    }

    /**
     * Returns nome do grupo
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Returns acronimo do grupo
     *
     * @return acronimo
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * Returns Ivestestigador responsavel pelo grupo
     *
     * @return Investigador
     */
    public Investigador getResponsavel() {
        return responsavel;
    }

    /**
     * Returns o ArrayList com os membros do grupo
     *
     * @return ArrayList
     */
    public ArrayList<Investigador> getMembros() {
        return membros;
    }

    /**
     * Imprime todos os membros do grupo
     */
    public void showMembers() {
        for (Investigador x : membros) {
            System.out.println(x);
        }
    }

    /**
     * Returns size do Array com os membros do grupo
     *
     * @return membros.size()
     */
    public int getSize() {
        return membros.size();
    }

    /**
     * Returns o numero de investigadores efetivos do grupo
     *
     * @return count
     */
    public int getNumEfetivos() {
        int count = 0;
        for (Investigador i : membros) {
            if (i.getType().equals("Efetivo"))
                count++;
        }
        return count;
    }

    /**
     * Returns o numero de investigadores estudantes do grupo
     *
     * @return count
     */
    public int getNumEstudantes() {
        int count = 0;
        for (Investigador i : membros) {
            if (i.getType().equals("Estudante"))
                count++;
        }
        return count;
    }

    /**
     * Sets um Investigador como responsavel do grupo. Tem de ser um membro do grupo
     *
     * @param i Investigador
     */
    public void setResponsavel(Investigador i) {
        if (!i.getGrupo().equals(acronimo)) {
            System.out.println("O Investigador tem de pertencer ao grupo!");
            return;
        }
        if (membros.size() == 0) {
            System.out.println("O grupo ainda nao tem membros!");
            return;
        }
        if (!i.getType().equals("Efetivo")) {
            System.out.println("O responsavel pelo grupo tem que ser um efetivo");
            return;
        }
        this.responsavel = i;
    }

    /**
     * @return Investigador Efetivo aleatorio
     */
    public Investigador getRandomEfetivo() {
        Investigador i = membros.get((int) (Math.random() * (membros.size())));
        while (i.getType().equals("Estudante")) { // Enquanto o membro nao for um efetivo
            i = membros.get((int) (Math.random() * (membros.size())));
        }
        return i;
    }

    public ArrayList<Publicacao> getPublicacoes() {
        ArrayList<Publicacao> pubs = new ArrayList<>();
        for (Investigador i : membros) {
            for (Publicacao p : i.getPubs()) {
                if (!pubs.contains(p)) //Se a publicacao ainda nao estiver na lista
                    pubs.add(p);
            }
        }
        return pubs;
    }

    public int getNumPubs(int n) {
        int count = 0;
        for (Publicacao p : getPublicacoes()) {
            int ano = p.getAno();
            if (ano > 2020 - n && ano < 2020) { // 2020-n < ano < 2020
                count++;
            }
        }
        return count;
    }


}//Grupo


class AC extends Grupo {

    /**
     * Cria um grupo do tipo AC e adiciona o membro responsavel pelo grupo
     */
    public AC() {
        super("Adaptive Computing", "AC");
        Investigador responsavel = new Efetivo("Jorge Henriques", "jh@dei.uc.pt", "AC", "D2.4", "236487936");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//AC


class CMS extends Grupo {

    /**
     * Cria um grupo do tipo CMS e adiciona o membro responsavel pelo grupo
     */
    public CMS() {
        super("Cognitive and Media Systems", "CMS");
        Investigador responsavel = new Efetivo("Penousal Machado", "machado@dei.uc.pt", "CMS", "D2.4", "278984156");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//CMS

class ECOS extends Grupo {

    /**
     * Cria um grupo do tipo ECOS e adiciona o membro responsavel pelo grupo
     */
    public ECOS() {
        super("Evolutionary and Complex Systems Group", "ECOS");
        Investigador responsavel = new Efetivo("Nuno Lourenço", "naml@dei.uc.pt", "ECOS", "D1.13", "239790000");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//ECOS

class IS extends Grupo {

    /**
     * Cria um grupo do tipo IS e adiciona o membro responsavel pelo grupo
     */
    public IS() {
        super("Information Systems", "IS");
        Investigador responsavel = new Efetivo("Licínio Roque", "lir@dei.uc.pt", "IS", "D2.4", "259148367");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//IS


class LCT extends Grupo {

    /**
     * Cria um grupo do tipo LCT e adiciona o membro responsavel pelo grupo
     */
    public LCT() {
        super("Communications and Telematics", "LCT");
        Investigador responsavel = new Efetivo("Paulo Simões", "psimoes@dei.uc.pt", "LCT", "D2.4", "235148259");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//LCT

class SSE extends Grupo {

    /**
     * Cria um grupo do tipo SSE e adiciona o membro responsavel pelo grupo
     */
    public SSE() {
        super("Software and Systems Engineering", "SSE");
        Investigador responsavel = new Efetivo("Henrique Madeira", "henrique@dei.uc.pt", "SSE", "D2.4", "278419657");
        membros.add(responsavel);
        setResponsavel(responsavel);
    }

}//SSE