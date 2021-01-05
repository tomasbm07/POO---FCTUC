package uc.poo;


import java.io.*;
import java.util.ArrayList;

/**
 * Classe com todos os metodos relacionados com ficheiros
 */
class fileHandler {

    public static void readFiles(Equipa equipa) {
        try {
            File objMembros = new File("Membros.obj");
            File objPublications = new File("Publications.obj");

            boolean filePublicationsExists = !objPublications.createNewFile();
            boolean fileMembrosExists = !objMembros.createNewFile();// Se o ficheiro ja existe, n faz nada. return true se criou o ficheiro
            //Se criou o ficheiro, fileDisciplinasExists = false

            if (filePublicationsExists && fileMembrosExists) {// se os ficheiros ja existiam, ler dos ficheiros de objetos
                System.out.println(">>Dados lidos dos Ficheiros de Objetos<<");
                readFromObjFiles(equipa);
                return;
            }

            // Ler dos ficheiros de texto
            System.out.println(">>Criando os Ficheiros de Objetos<<");
            addMembersToObjFile(objMembros, equipa);
            addPubToObjFile(objPublications);
            readFromObjFiles(equipa);
            System.out.println(">>Done<<");
            System.out.println(">>Dados lidos dos Ficheiros de Objetos<<");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromObjFiles(Equipa equipa) {
        Investigador i;
        Publicacao p;
        ArrayList<String> autores;

        try {
            FileInputStream fi = new FileInputStream("Membros.obj");
            ObjectInputStream oi = new ObjectInputStream(fi);

            FileInputStream fa = new FileInputStream("Publications.obj");
            ObjectInputStream oa = new ObjectInputStream(fa);

            //Ler o membros do ficheiro de objetos
            while (fi.available() > 0) {
                while (fi.available() > 0) {
                    i = (Investigador) oi.readObject();
                    switch (i.getGrupo()) {
                        case "AC" -> equipa.AC().addInvestigador(i);
                        case "CMS" -> equipa.CMS().addInvestigador(i);
                        case "ECOS" -> equipa.ECOS().addInvestigador(i);
                        case "IS" -> equipa.IS().addInvestigador(i);
                        case "LCT" -> equipa.LCT().addInvestigador(i);
                        case "SSE" -> equipa.SSE().addInvestigador(i);
                    }
                    //System.out.println(i);
                }
            }

            //Ler as publicacaoes do ficheiro de objetos
            while (fa.available() > 0) {
                p = (Publicacao) oa.readObject();
                autores = p.getAutores(); // Autor = Nome#Grupo
                for (String s : autores) {
                    String aux[] = s.split("#");
                    getInvestigador(aux[0], aux[1], equipa).addPub(p); // Add Publicacao aos Investigadores
                }
            }

            oi.close();
            fi.close();
            oa.close();
            fa.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //TODO add read protection, make sure, efetivou ou estudante, nome (sem numeros),etc
    private static void addMembersToObjFile(File filename, Equipa equipa) {
        String data;
        Investigador investigador;
        int linha = 1;
        boolean readingEfetivo = true;

        try {
            FileReader f = new FileReader("Input.txt");
            BufferedReader br = new BufferedReader(f);

            FileOutputStream fi = new FileOutputStream(filename);
            ObjectOutputStream oi = new ObjectOutputStream(fi);

            while ((data = br.readLine()) != null) {

                if (data.equals("#ESTUDANTES")) {
                    readingEfetivo = false;
                    continue;
                }

                if (data.equals("#EFETIVOS"))
                    continue;

                if (data.equals("#ESTUDANTES") && readingEfetivo == true) {
                    System.out.println("Erro -> Formato incorreto do ficheiro de input dos membros");
                    continue;
                }

                if (data.contains("//") || data.isBlank())
                    continue;

                String[] arrStr = data.split(",");

                if (readingEfetivo && arrStr.length != 6) {
                    System.out.println("Linha -> " + linha + " Erro -> Formato incorreto do ficheiro de input dos membros");
                    continue;
                }

                if (!readingEfetivo && arrStr.length != 7) {
                    System.out.println("Linha -> " + linha + " Erro -> Formato incorreto do ficheiro de input das publicaçoes");
                    continue;
                }

                if (readingEfetivo){
                    if (!arrStr[0].equals("Efetivo"))
                        System.out.println("Linha -> " + linha + " Erro -> Formato incorreto do ficheiro dos membros");
                    investigador = new Efetivo(arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]);
                }
                else{
                    if (!arrStr[0].equals("Estudante"))
                        System.out.println("Linha -> " + linha + " Erro -> Formato incorreto do ficheiro dos membros");
                    investigador = new Estudante(arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5], arrStr[6]);
                }

                oi.writeObject(investigador);

                linha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPubToObjFile(File filename) {
        Publicacao pub;
        String line;

        try {
            FileReader f = new FileReader(new File("Publications.txt"));
            BufferedReader br = new BufferedReader(f);

            FileOutputStream fi = new FileOutputStream(filename);
            ObjectOutputStream oi = new ObjectOutputStream(fi);

            while ((line = br.readLine()) != null) {
                String[] arrStr = line.split(",");
                switch (arrStr[2]) {
                    //Livro -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN
                    //Livro(String autores, String titulo, String keyword, String ano, int views, String resumo, String editora, String ISBN)
                    case "Livro" -> pub = new Livro(arrStr[0], arrStr[1], arrStr[4], Integer.parseInt(arrStr[5]), Integer.parseInt(arrStr[6]), arrStr[3], arrStr[7], arrStr[8]);
                    //ArtigoRevista -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Nome Revista, Num Revista, Data Publicacao
                    //artigoRevista(String autores,String titulo, String keyword, int ano, int views, String resumo, String nome,int num,String data)
                    case "Artigo de Revista" -> pub = new artigoRevista(arrStr[0], arrStr[1], arrStr[4], Integer.parseInt(arrStr[5]), Integer.parseInt(arrStr[6]), arrStr[3], arrStr[7], Integer.parseInt(arrStr[8]), arrStr[9]);
                    //LivroArtigos -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN, Num Revista
                    //livroArtigos(String autores, String titulo, String keyword, int ano, int views, String resumo, String editora, String ISBN, String nomeConf, int numArtigos)
                    case "Livro de Artigos de Conferencia" -> pub = new livroArtigos(arrStr[0], arrStr[1], arrStr[4], Integer.parseInt(arrStr[5]), Integer.parseInt(arrStr[6]), arrStr[3], arrStr[7], arrStr[8], arrStr[9], Integer.parseInt(arrStr[10]));
                    //ArtigoConferencia -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Nome Conferencia, Lugar Conferencia, Data Conferencia
                    //artigoConferencia(String autores,String titulo, String keyword, int ano, int views, String resumo, String nome, String local, String data)
                    case "Artigo de Conferencia" -> pub = new artigoConferencia(arrStr[0], arrStr[1], arrStr[4], Integer.parseInt(arrStr[5]), Integer.parseInt(arrStr[6]), arrStr[3], arrStr[7], arrStr[8], arrStr[9]);
                    //CapituloLivro -> Autores, Titulo, Tipo, Resumo, Keywords, Ano, Audiencia, Editora, ISBN, Nome Capitulo, Pag. Inicial, Pag. Final
                    //capituloLivro(String autores,String titulo, String keyword, int ano, int views, String resumo, String editora, String ISBN, String nome, String paginas)
                    case "Capitulo de Livro" -> pub = new capituloLivro(arrStr[0], arrStr[1], arrStr[4], Integer.parseInt(arrStr[5]), Integer.parseInt(arrStr[6]), arrStr[3], arrStr[7], arrStr[8], arrStr[9], arrStr[10]);
                    default -> pub = null;
                }
                oi.writeObject(pub);
            }

            br.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Investigador getInvestigador(String nome, String grupo, Equipa equipa) {
        switch (grupo) {
            case "AC" -> {
                for (Investigador i : equipa.AC().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
            case "CMS" -> {
                for (Investigador i : equipa.CMS().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
            case "ECOS" -> {
                for (Investigador i : equipa.ECOS().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
            case "IS" -> {
                for (Investigador i : equipa.IS().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
            case "LCT" -> {
                for (Investigador i : equipa.LCT().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
            case "SSE" -> {
                for (Investigador i : equipa.SSE().getMembros())
                    if (i.getNome().equals(nome))
                        return i;
            }
        }
        return null;
    }

}//fileHandler
