package uc.poo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Curso {
    private ArrayList<Disciplina> cadeiras;
    private ArrayList<Aluno> alunos;
    //private boolean firstRun = true;

    public Curso() {
        cadeiras = new ArrayList<>();
        alunos = new ArrayList<>();
        readFile();
    }

    /**
     * Carrega as estruturas de dados na leitura dos ficheiros de entrada.
     * Se for a primeira vez a correr a aplicacao, le dos ficheiros de texto.
     * Se nao for a 1ª vez, abre os ficheiros de objetos correspondentes
     */
    private void readFile() {

        try {
            FileReader f = new FileReader("Disciplinas.txt");
            BufferedReader br = new BufferedReader(f);

            File objDisciplinas = new File("Disciplinas.ser");
            File objAlunos = new File("Alunos.ser");

            boolean fileAlunosExists = !objAlunos.createNewFile();
            boolean fileDisciplinasExists = !objDisciplinas.createNewFile();// Se o ficheiro ja existe, n faz nada. return true se criou o ficheiro
            //Se criou o ficheito, fileDisciplinasExists = false
            if (fileDisciplinasExists && fileAlunosExists) { // se os ficheiros ja existiam, sair
                readFromObjFile();
                return;
            }

            this.alunos = getAlunos();
            this.cadeiras = getDisciplinas();

            f.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(">>Dados lidos dos Ficheiros de Texto<<");
    }

    /**
     * Leitura e carregamento das estruturas de dados, dos ficheiros binarios
     */
    private void readFromObjFile() {
        Disciplina d;
        Aluno a;

        try {
            FileInputStream fi = new FileInputStream("Disciplinas.ser");
            ObjectInputStream oi = new ObjectInputStream(fi);

            FileInputStream fa = new FileInputStream("Alunos.ser");
            ObjectInputStream oa = new ObjectInputStream(fa);

            while (fi.available() > 0) {
                d = (Disciplina) oi.readObject();
                cadeiras.add(d);
            }

            while (fa.available() > 0) {
                a = (Aluno) oa.readObject();
                alunos.add(a);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(">>Dados lidos dos Ficheiros de Objetos<<");
    }

    /**
     * @param s String do numero a converter para inteiro
     * @return num inteiro
     */
    private int convertToInt(String s) {
        int num = 0;
        try {
            num = Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Erro na Conversao!");
        }
        return num;
    }

    /**
     * Le as Diciplinas do ficheiro "Alunos.txt" e carrega as estruturas de dados
     * @return ArrayList de Alunos
     */
    private ArrayList<Aluno> getAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String line;
        try {
            FileReader f = new FileReader(new File("Alunos.txt"));
            BufferedReader br = new BufferedReader(f);

            while ((line = br.readLine()) != null) {
                String[] aux = line.split(",");
                Aluno a = new Aluno(aux[0], convertToInt(aux[1]));
                alunos.add(a);
            }

            f.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alunos;
    }


    /**
     * Le as Diciplinas do ficheiro "Disciplinas.txt" e carrega as estruturas de dados
     * @return ArrayList de Disciplinas
     */
    private ArrayList<Disciplina> getDisciplinas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        int linha = 1;
        String line;
        Disciplina d = null;
        try {
            FileReader f = new FileReader("Disciplinas.txt");
            BufferedReader br = new BufferedReader(f);

            while ((line = br.readLine()) != null) {
                String[] aux = line.split(",");

                if (linha % 2 != 0) { // linha Disciplina
                    d = new Disciplina(aux[0], aux[1], convertToInt(aux[2]));
                    linha++;
                } else { // Linha dos alunos
                    for (int i = 0; i < aux.length; i++) {
                        for (Aluno a : alunos) {
                            if (a.getNum() == convertToInt(aux[i])) {
                                d.addAluno(a);
                            }
                        }
                    }
                    disciplinas.add(d);
                    linha++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    /**
     * Prints as disciplinas e os alunos nelas inscritos
     */
    public void printAll() {
        for (Disciplina d : this.cadeiras) {
            System.out.println(d);
            for (Aluno a : d.getAlunos()) {
                System.out.println(a);
            }
            System.out.println();
        }
    }

    /**
     * Fucçao que gere o input de um aluno, numa disciplina
     */
    public void userInput() {
        int i = 0;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);

        for (Disciplina d : cadeiras) {
            System.out.println(d);
        }

        System.out.print("Disciplina(Acronimo) -> ");
        String acronimo = s1.nextLine();

        for (Disciplina d : cadeiras) {
            i++;
            if (d.getAcronimo().equals(acronimo)) {
                System.out.print("Nome -> ");
                String nome = s2.nextLine();
                System.out.print("Numero de estudante -> ");
                int num = s3.nextInt();
                Aluno a = new Aluno(nome, num);
                if (!isAlunoInCurso(a))// Se o aluno ainda n estiver na lista de alunos-> coloca
                    alunos.add(a);
                if (!isAlunoInDisciplina(d, a)) {
                    d.addAluno(a); //Adiciona se ainda n estiver inscrito nessa disciplina
                    System.out.println("Aluno Adicionado");
                } else
                    System.out.println("Aluno ja esta inscrito nesta disciplina");
                break;
            } else {
                if (i == cadeiras.size())
                    System.out.println("Acronimo Invalido!");
            }
        }
    }

    /**
     * Funçao que gere o 'remove' de um aluno de uma disciplina ou curso
     * caso nao esteja inscrito em nehuma disciplina
     */
    public void userRemove() {
        int i = 0;
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);

        for (Disciplina d : cadeiras) {
            System.out.println(d);
        }

        System.out.print("Disciplina(Acronimo) -> ");
        String acronimo = s1.nextLine();

        for (Disciplina d : cadeiras) {
            i++;
            if (d.getAcronimo().equals(acronimo)) {
                System.out.print("Nome -> ");
                String nome = s2.nextLine();
                System.out.print("Numero de estudante -> ");
                int num = s3.nextInt();
                Aluno a = new Aluno(nome, num);
                if (isAlunoInDisciplina(d, a)) { //Check se o aluno estava inscrito na cadeira antes de remover
                    d.removeAluno(a);
                } else
                    System.out.println("Aluno nao esta inscrito nesta cadeira!");
                if (!isAlunoInscritoDisciplinas(a) && isAlunoInCurso(a)) {// Se o aluno nao estiver inscrito em nehuma disciplina -> remover dos ALunos
                    alunos.removeIf(b -> b.getNome().equals(a.getNome()) && b.getNum() == a.getNum());
                    System.out.println("Aluno nao esta inscrito em nehuma disciplina");
                    System.out.println("Aluno removido da lista de alunos do Curso");
                }
                break;
            } else {
                if (i == cadeiras.size())
                    System.out.println("Acronimo Invalido!");
            }
        }
    }


    /**
     * Returns a boolean. true -> Aluno inscrito numa disciplina(incrito no Curso)
     * @param a ALuno
     * @return Boolean
     */
    private boolean isAlunoInCurso(Aluno a) {
        for (Aluno b : alunos) {
            if (b.getNome().equals(a.getNome()) && b.getNum() == a.getNum())
                return true;
        }
        return false;
    }

    /**
     * Return true se 'a' esta inscrito em 'd'
     * @param d Disciplina
     * @param a Aluno
     * @return Boolean
     */
    private boolean isAlunoInDisciplina(Disciplina d, Aluno a) {
        for (Aluno b : d.getAlunos()) {
            if (b.getNome().equals(a.getNome()) && b.getNum() == a.getNum())
                return true;
        }
        return false;
    }

    /**
     * Returns true se o aluno estiver inscrito em mais alguma disciplina
     * @param a Aluno
     * @return Boolean
     */
    private boolean isAlunoInscritoDisciplinas(Aluno a) {
        for (Disciplina d : cadeiras) {
            for (Aluno b : d.getAlunos()) {
                if (b.getNome().equals(a.getNome()) && b.getNum() == a.getNum())
                    return true;
            }
        }
        return false;
    }

    /**
     * Funçao que guarda as alteraçoes feitas durante o programa, nos ficheiros de texto e de objetos
     */
    public void saveChanges() {
        int i = 0;
        try {
            FileWriter fw = new FileWriter(new File("Disciplinas.txt"), false);
            BufferedWriter bw = new BufferedWriter(fw);

            FileWriter fw2 = new FileWriter(new File("Alunos.txt"), false);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            FileOutputStream fd = new FileOutputStream(new File("Disciplinas.ser"), false);
            ObjectOutputStream od = new ObjectOutputStream(fd);

            new FileOutputStream("Alunos.ser").close();
            FileOutputStream fa = new FileOutputStream(new File("Alunos.ser"), false);
            ObjectOutputStream oa = new ObjectOutputStream(fa);


            for (Disciplina d : cadeiras) {
                bw.write(d.getNome() + "," + d.getAcronimo() + "," + d.getECTS() + "\n");
                for (Aluno a : d.getAlunos()) {
                    if (i != d.getAlunos().size() - 1)
                        bw.write(a.getNum() + ",");
                    else
                        bw.write(a.getNum() + "\n");
                    i++;
                }
                i = 0;
                od.writeObject(d);
            }
            //fw.close();
            bw.close();
            fd.close();
            od.close();

            for (Aluno a : alunos) {
                bw2.write(a.getNome() + "," + a.getNum() + "\n");
                oa.writeObject(a);
            }

            bw2.close();
            fw2.close();
            fa.close();
            oa.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Forçar a leitura dos ficheiros de texto, e carregar as estruturas de dados com esses valores
     */
    public void forceInputFromTxt() {
        this.alunos = getAlunos();
        this.cadeiras = getDisciplinas();
        System.out.println("Estruturas de dados atualizadas!");
    }

}
