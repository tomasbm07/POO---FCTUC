package uc.poo;

import java.util.*;

/**
 *
 */
class Equipa {
    private final ArrayList<Grupo> grupos;

    /**
     * Adiciona todos os grupos de investigacao a um array
     */
    public Equipa() {
        grupos = new ArrayList<>();
        grupos.add(new AC());
        grupos.add(new CMS());
        grupos.add(new ECOS());
        grupos.add(new IS());
        grupos.add(new LCT());
        grupos.add(new SSE());
    }

    /**
     * Returns o grupo AC do array de grupos
     *
     * @return Grupo AC do array de grupos
     */
    public Grupo AC() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("AC"))
                return x;
        }
        return null;
    }

    /**
     * Returns o grupo CMS do array de grupos
     *
     * @return Grupo CMS do array de grupos
     */
    public Grupo CMS() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("CMS"))
                return x;
        }
        return null;
    }

    /**
     * Returns o grupo ECOS do array de grupos
     *
     * @return Grupo ECOS do array de grupos
     */
    public Grupo ECOS() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("ECOS"))
                return x;
        }
        return null;
    }

    /**
     * Returns o grupo IS do array de grupos
     *
     * @return Grupo IS do array de grupos
     */
    public Grupo IS() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("IS"))
                return x;
        }
        return null;
    }

    /**
     * Returns o grupo LCT do array de grupos
     *
     * @return Grupo LCT do array de grupos
     */
    public Grupo LCT() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("LCT"))
                return x;
        }
        return null;
    }

    /**
     * Returns o grupo SSE do array de grupos
     *
     * @return Grupo SSE do array de grupos
     */
    public Grupo SSE() {
        for (Grupo x : grupos) {
            if (x.getAcronimo().equals("SSE"))
                return x;
        }
        return null;
    }

    /**
     * Imprime:
     * membros em cada grupo,
     * total de membros,
     * n de publicaçoes,
     * n de cada tipo de publicação.
     */
    public void showMembersStats() {
        for (Grupo x : grupos)
            System.out.println(x.getAcronimo() + " -> Efetivos: " + x.getNumEfetivos() + ", Estudantes: " + x.getNumEstudantes() + ", Total: " + x.getSize());
        System.out.println("Total de Membros: " + numMembros() + " -> Efetivos: " + numEfetivos() + ", Estudantes: " + numEstudantes());
    }

    /**
     * @return numero total de membros
     */
    private int numMembros() {
        int count = 0;
        for (Grupo x : grupos) {
            count += x.getSize();
        }
        return count;
    }

    /**
     * @return num total de investigadores efetivos
     */
    private int numEfetivos() {
        int count = 0;

        for (Grupo x : grupos)
            count += x.getNumEfetivos();

        return count;
    }

    /**
     * @return num total de investigadores estudantes
     */
    private int numEstudantes() {
        int count = 0;

        for (Grupo x : grupos)
            count += x.getNumEstudantes();

        return count;
    }

    /**
     * Imprime todos os membros da Equipa
     */
    public void showMembers() {
        for (Grupo x : grupos)
            x.showMembers();
    }

    /**
     * Returns //TODO
     *
     * @return ArrayList com os grupos da Equipa
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    //Publicacoes dos ultimos n anos
    public int getNumPubs(int n) {
        int count = 0;
        for (Publicacao p : getPublicacoes()) {
            int ano = p.getAno();
            if (ano >= 2020 - n && ano <= 2020) { // 2020-n < ano < 2020
                //System.out.println(p);
                count++;
            }
        }
        return count;
    }

    public void showPubStats() {
        int artigoConf = 0, artigoRev = 0, capLivro = 0, livro = 0, livroArtigos = 0;
        for (Publicacao p : getPublicacoes()) {
            switch (p.getTipo()) {
                case "artigoConferencia" -> artigoConf++;
                case "artigoRevista" -> artigoRev++;
                case "capituloLivro" -> capLivro++;
                case "livro" -> livro++;
                case "livroArtigos" -> livroArtigos++;
            }
        }
        System.out.println("Artigos de Conferencia -> " + artigoConf);
        System.out.println("Artigos de Revista -> " + artigoRev);
        System.out.println("Capitulos de Livro -> " + capLivro);
        System.out.println("Livros -> " + livro);
        System.out.println("Livro de Artigos de Conferencia -> " + livroArtigos);
        System.out.println("Total de Publicacoes -> " + (artigoConf + artigoRev + capLivro + livro + livroArtigos));
    }

    private ArrayList<Publicacao> getPublicacoes() {
        ArrayList<Publicacao> pubs = new ArrayList<>();
        for (Grupo x : grupos) {
            for (Investigador i : x.getMembros()) {
                for (Publicacao p : i.getPubs()) {
                    if (!pubs.contains(p)) //Se a publicacao ainda nao estiver na lista
                        pubs.add(p);
                }
            }
        }
        return pubs;
    }

    public void showPubsGroupStats(Equipa equipa, String grupo) {
        ArrayList<Publicacao> pubs = new ArrayList<>();
        ArrayList<Publicacao> pubs5Anos = new ArrayList<>();

        switch (grupo) {
            case "AC" -> pubs = equipa.AC().getPublicacoes();
            case "CMS" -> pubs = equipa.CMS().getPublicacoes();
            case "ECOS" -> pubs = equipa.ECOS().getPublicacoes();
            case "IS" -> pubs = equipa.IS().getPublicacoes();
            case "LCT" -> pubs = equipa.LCT().getPublicacoes();
            case "SSE" -> pubs = equipa.SSE().getPublicacoes();
            default -> System.out.println("Erro: Grupo Invalido!");
        }
        for (Publicacao p : pubs) {
            int ano = p.getAno();
            if (ano >= 2020 - 5 && ano <= 2020) { // 2020-5 <= ano < 2020
                pubs5Anos.add(p);
                //2015 - 2015
            }
        }

        for (Publicacao p : organizarPubs(pubs5Anos)) {
            System.out.println(p);
        }
    }

    public void printGroupMembers(Equipa equipa, String grupo) {
        ArrayList<Investigador> membros;
        membros = getMembros(equipa, grupo);
        membros.sort((a, b) -> a.getType().compareTo(b.getType())); // Efetivos then Estudantes
        for (Investigador i : membros) {
            System.out.println(i);
        }
    }

    public void getPubsInvestigador(Equipa equipa, String grupo, String nome) {
        ArrayList<Investigador> membros;
        ArrayList<Publicacao> pubs = new ArrayList<>();
        membros = getMembros(equipa, grupo);

        for (Investigador i : membros) {
            if (i.getNome().equals(nome)) {
                pubs = i.getPubs();
                break;
            }
        }

        for (Publicacao p : organizarPubs(pubs)) {
            System.out.println(p);
        }

    }

    private ArrayList<Investigador> getMembros(Equipa equipa, String grupo) {
        return switch (grupo) {
            case "AC" -> equipa.AC().getMembros();
            case "CMS" -> equipa.CMS().getMembros();
            case "ECOS" -> equipa.ECOS().getMembros();
            case "IS" -> equipa.IS().getMembros();
            case "LCT" -> equipa.LCT().getMembros();
            case "SSE" -> equipa.SSE().getMembros();
            default -> null;
        };
    }

    private ArrayList<Publicacao> organizarPubs(ArrayList<Publicacao> pubs) {
        //pubs.sort(new comparador()); // == Colections.sort(pubs, new comparador());
        return pubs;
    }

    //TODO acabar esta parte
    public void showAllGroupsPubStats(Equipa equipa) {
        for (Grupo g : grupos) {
            System.out.println(g.getAcronimo() + " -> " + g.getNumPubs(5));
        }
    }

    public void showGroupedPubs() {
        ArrayList<Publicacao> aux;
        for (Grupo g : grupos) {
            aux = organizarPubs(g.getPublicacoes());
            System.out.println(g.getAcronimo());
            for (Publicacao p : aux) {

            }
            System.out.println();
        }
    }

}//Equipa
