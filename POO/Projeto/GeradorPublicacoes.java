package POO;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] Args) {
        GeradorPublicacoes gerador = new GeradorPublicacoes();
        gerador.geraTudo();
    }
}

class GeradorPublicacoes {
    private final List<String> efetivos = listaEfetivos();
    private final String[] gruposInvest = {"AC", "CMS", "ECOS", "IS", "LCT", "SSE"};

    public void geraTudo() {
        File f = new File("Publications.txt");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String grupo = "";
            int pagInicial;
            for (int i = 0; i < 18; i++) {
                pagInicial = geraNumRevista();
                if (i % 3 == 0) grupo = gruposInvest[i / 3];
                //Livro -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN
                bw.write(String.format("%s,Um Titulo,Livro,Um Resumo Estruturado,palavras;chave;importantes,%d,%d,Uma Editora Que Pague Bem,%s\n", geraAutores(efetivos), geraAno(), geraAudiencia(), geraISBN()));
                //ArtigoRevista -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Nome Revista, Num Revista, Data Publicacao
                bw.write(String.format("%s,Um Titulo,Artigo de Revista,Um Resumo Estruturado,palavras;chave;importantes,%d,%d,Revista Maravilha,%d,%s\n", geraAutores(efetivos), geraAno(), geraAudiencia(), geraNumRevista(), geraData()));
                //LivroArtigos -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN, Nome Conferencia, Num Revista
                bw.write(String.format("%s,Um Titulo,Livro de Artigos de Conferencia,Um Resumo Estruturado,palavras;chave;importantes,%d,%d,Uma Editora de Gratis,%s,Conferencia dos Informaticos,%d\n", geraAutores(efetivos), geraAno(), geraAudiencia(), geraISBN(), geraNumRevista()));
                //ArtigoConferencia -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Nome Conferencia, Lugar Conferencia, Data Conferencia
                bw.write(String.format("%s,Um Titulo,Artigo de Conferencia,Um Resumo Estruturado,palavras;chave;importantes,%d,%d,Conferencia Nao Aborrecida,Lugar Magnifico,%s\n", geraAutores(efetivos), geraAno(), geraAudiencia(), geraData()));
                //CapituloLivro -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN, Nome Capitulo, Pag. Inicial, Pag. Final
                bw.write(String.format("%s,Um Titulo,Capitulo de Livro,Um Resumo Estruturado,palavras;chave;importantes,%d,%d,Editora XPTO,%s,Capitulo Muito Serio,%d-%d\n", geraAutores(efetivos), geraAno(), geraAudiencia(), geraISBN(), pagInicial, pagInicial + (int) (Math.random() * 30)));
            }
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> listaEfetivos() {
        List<String> Efetivos = new ArrayList<>(5);
        String[] aux;
        try {
            FileReader fr = new FileReader(new File("Membros.txt"));
            BufferedReader br = new BufferedReader(fr);
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                aux = line.split(",");
                //Nome, Grupo
                Efetivos.add(aux[1] + "," + aux[2]);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Efetivos;
    }


    private String geraISBN() {
        int x13 = 0, num;
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            num = rand.nextInt(10);
            sb.append(num);
            if (i % 2 == 0) x13 += num;
            else x13 += num * 3;
        }
        sb.append("-");
        sb.append(10 - ((x13 % 10) + 1));
        return sb.toString();
    }

    private int geraAudiencia() {
        Random rand = new Random();
        return rand.nextInt(15000);
    }

    private int geraAno() {
        Random rand = new Random();
        return rand.nextInt(35) + 1985;
    }

    private String geraAutores(List<String> autores) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int numAut = rand.nextInt(3) + 1;
        for (int i = 0; i < numAut; i++) {
            int num = rand.nextInt(autores.size());
            String[] aux = autores.get(num).split(",");
            sb.append(aux[0] + "#" + aux[1]);
            if (i != numAut - 1)
                sb.append(";");
        }
        return sb.toString();
    }

    private int geraNumRevista() {
        Random rand = new Random();
        return rand.nextInt(100) + 1;
    }

    private String geraData() {
        Random rand = new Random();
        return String.format("%d/%d/%d", rand.nextInt(28) + 1, rand.nextInt(12) + 1, geraAno());
    }

}
