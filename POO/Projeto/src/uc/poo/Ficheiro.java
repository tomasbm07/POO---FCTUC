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


        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    /*public static void addMembersFromObjFile(String filename, Equipa equipa) {
    }*/

    //Metodo inicial: text file -> object file (1st run only)
    //TODO add check para ver se ja exite um ficheiro de objetos, se n usar este metodo
    private static void addMembersToObjFile(File filename, Equipa equipa) {
        String data;
        Investigador investigador;
        int linha = 1;
        boolean isEfetivo = true;

        try {
            FileReader f = new FileReader("Input.txt");
            BufferedReader br = new BufferedReader(f);

            FileOutputStream fi = new FileOutputStream(filename);
            ObjectOutputStream oi = new ObjectOutputStream(fi);

            while ((data = br.readLine()) != null) {

                if (data.equals("#ESTUDANTES")) {
                    isEfetivo = false;
                    continue;
                }

                if (data.equals("#EFETIVOS"))
                    continue;

                if (data.equals("#ESTUDANTES") && isEfetivo == true) {
                    System.out.println("Erro->Formato incorreto do ficheiro de input dos membros");
                    continue;
                }

                if(data.contains("//") || data.isBlank())
                    continue;

                String[] arrStr = data.split(",");

                if (isEfetivo)
                    investigador = new Efetivo(arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]);
                else
                    investigador = new Estudante(arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5], arrStr[6]);
                oi.writeObject(investigador);

                //TODO acabar a funçao de check dos membros
                /*if (checkMember(arrStr, linha) == -1){
                    continue;
                }*/

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


    //TODO acabar e ver pq é q n da erros em alguns sitios
    private static int checkMember(String[] line, int linha) {
        //Chech empty Strings
        if (!line[0].isBlank()) {
            if (line[1].isBlank() || line[2].isBlank() || line[3].isBlank() || line[4].isBlank() || line[5].isBlank()) {
                System.err.print("Linha: " + linha + " -> Nehum dos parametros pode ser vazio\n");
                return -1;
            }
        } else {
            System.err.print("Linha: " + linha + " -> Nehum dos parametros pode ser vazio\n");
            return -1;
        }

        //Check nums no Tipo
        if (!isAplha(line[0])) {
            System.err.print("Linha: " + linha + " -> Tipo apenas pode conter letras!\n");
            return -1;
        }

        //Check Nome //TODO handle spaces in name
        if (!isAplha(line[1])) {
            System.err.print("Linha: " + linha + " -> Nome apenas pode conter letras!\n");
            return -1;
        }

        //Check Grupo
        if (!isGroupValid(line[3])) {
            System.err.print("Linha: " + linha + " -> Grupo nao pertence a lista de grupos\n");
            return -1;
        }

        //Check Gabinete???

        //Check Telefone
        if (line[0].equals("Efetivo")) {
            if (line[5].length() != 9) {
                System.err.print("Linha: " + linha + " -> Telefone tem de ter 9 digitos\n");
                return -1;
            }
            if (!isPhoneValid(line[5])) {
                System.err.print("Linha: " + linha + " -> Telefone apenas pode conter numeros\n");
                return -1;
            }
        }
        return 0;
    }

    private static boolean isAplha(String s) {
        return s.matches("[a-zA-Z]+");
    }

    private static boolean isPhoneValid(String s) {
        return s.matches("[0-9]+");
    }

    private static boolean isNumber(String s) {
        try {
            Double num = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isGroupValid(String s) {
        return s.equals("AC") || s.equals("CMS") || s.equals("ECOS") || s.equals("IS") || s.equals("LCT") || s.equals("SSE");
    }

}//fileHandler
