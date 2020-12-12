package uc.poo;

import java.util.ArrayList;

class Carteira {
    private ArrayList<Jogador> carteira = new ArrayList<>(20);
    private ArrayList<Character> teamNames = new ArrayList<>();

    public Carteira() {
        String teams = "ABCD";
        for (int i = 0; i < 6; i++) {
            Defesa x = new Defesa("", "", (int) (Math.random() * (100)) + 1, teams.charAt((int) (Math.random() * (teams.length()))));
            carteira.add(x);
        }
        for (int i = 0; i < 6; i++) {
            guardaRedes x = new guardaRedes("", "", (int) (Math.random() * (100)) + 1, teams.charAt((int) (Math.random() * (teams.length()))));
            carteira.add(x);
        }
        for (int i = 0; i < 6; i++) {
            Avancado x = new Avancado("", "", (int) (Math.random() * (100)) + 1, teams.charAt((int) (Math.random() * (teams.length()))));
            carteira.add(x);
        }
        for (int i = 0; i < 6; i++) {
            Medio x = new Medio("", "", (int) (Math.random() * (100)) + 1, teams.charAt((int) (Math.random() * (teams.length()))));
            carteira.add(x);
        }
    }

    public void showAll() {
        for (Jogador x : carteira) {
            System.out.println(x);
        }
    }

    public char bestTeam() {
        getTeams();
        int count = 0;
        int count_anteriror = -10000;
        char bestTeam = 0;
        for (char team: teamNames) {
            for (Jogador x: carteira) {
                if (x.getTeam() == team){
                    count += x.getPontos();
                }
            }
            if(count > count_anteriror){
                count_anteriror = count;
                count = 0;
                bestTeam = team;
            }
        }
        return bestTeam;
    }

    private void getTeams() {
        for (Jogador x : carteira) {
            char team = x.getTeam();
            if (teamNames.contains(team)) {
            } else teamNames.add(x.getTeam());
        }
    }

}//End Carteira

class Jogador {
    private String nome;
    private String bdate;
    private int valor;
    private char equipa;

    public Jogador(String nome, String bdate, int valor, char equipa) {
        this.nome = nome;
        this.bdate = bdate;
        this.valor = valor;
        this.equipa = equipa;
    }

    public String toString() {
        return "nome: " + nome + ", equipa: " + equipa + ", valor: " + valor + ", Pontos: " + getPontos();
    }

    protected int pontos() {
        return 0;
    }

    protected int getPontos() {
        return pontos();
    }

    protected char getTeam(){
         return equipa;
    }

}

class guardaRedes extends Jogador {
    int defesas;
    int golosSofridos;

    public guardaRedes(String nome, String bdate, int valor, char equipa) {
        super(nome, bdate, valor, equipa);
        this.defesas = (int) (Math.random() * (100));
        this.golosSofridos = (int) (Math.random() * (100));
    }

    protected int pontos() {
        return defesas - 10 * golosSofridos;
    }
}

class Defesa extends Jogador {
    int recuperacoes;
    int faltas;

    public Defesa(String nome, String bdate, int valor, char equipa) {
        super(nome, bdate, valor, equipa);
        this.recuperacoes = (int) (Math.random() * (100));
        this.faltas = (int) (Math.random() * (100));
    }

    protected int pontos() {
        if (faltas != 0)
            return 2 * recuperacoes / faltas;
        return 4 * recuperacoes;
    }

}

class Medio extends Jogador {
    int golos;
    int assists;
    int faltas;

    public Medio(String nome, String bdate, int valor, char equipa) {
        super(nome, bdate, valor, equipa);
        this.golos = (int) (Math.random() * (100));
        this.assists = (int) (Math.random() * (100));
        this.faltas = (int) (Math.random() * (100));
    }

    protected int pontos() {
        return (int) (1.5 * golos + assists - 2 * faltas);
    }
}

class Avancado extends Jogador {
    int golos;
    int noGolos;

    public Avancado(String nome, String bdate, int valor, char equipa) {
        super(nome, bdate, valor, equipa);
        this.golos = (int) (Math.random() * (100));
        this.noGolos = (int) (Math.random() * (100));
    }

    protected int pontos() {
        return golos - 2 * noGolos;
    }
}
