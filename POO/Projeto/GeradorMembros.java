package uc.poo.gerador;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Gerador.generateInput("Membros.txt", "Input.txt");
    }
}

/**
 * Class com métodos que geram alguns atributos para o ficheiro membros.txt
 */
abstract class Gerador {
    private static final ArrayList<String> emails = new ArrayList<>();
    private static final ArrayList<String> telefones = new ArrayList<>();
    private static final ArrayList<String> gabinetes = new ArrayList<>();
    private static final ArrayList<String> AC = new ArrayList<>();
    private static final ArrayList<String> CMS = new ArrayList<>();
    private static final ArrayList<String> ECOS = new ArrayList<>();
    private static final ArrayList<String> IS = new ArrayList<>();
    private static final ArrayList<String> LCT = new ArrayList<>();
    private static final ArrayList<String> SSE = new ArrayList<>();

    public static void generateInput(String inputFile, String outputFile) {
        try {
            FileReader f = new FileReader(new File(inputFile));
            BufferedReader br = new BufferedReader(f);

            FileWriter fw = new FileWriter(new File(outputFile));
            BufferedWriter bw = new BufferedWriter(fw);

            String line;
            //Efetivos
            bw.write("#EFETIVOS\n");
            while ((line = br.readLine()) != null) {
                String[] arrStr = line.split(",");
                // efetivo -> TIPO, NOME, EMAIL, GRUPO, GABINETE, TELEFONE
                if (arrStr[0].equals("Efetivo")) {
                    bw.write("%s,%s,%s,%s,%s,%s\n".formatted(arrStr[0], arrStr[1], generateEmail(arrStr[0], arrStr[1]), arrStr[2], generateGabinete(), generatePhoneNumber()));
                    switch (arrStr[2]) {
                        case "AC" -> AC.add(arrStr[1]);
                        case "CMS" -> CMS.add(arrStr[1]);
                        case "ECOS" -> ECOS.add(arrStr[1]);
                        case "IS" -> IS.add(arrStr[1]);
                        case "LCT" -> LCT.add(arrStr[1]);
                        case "SSE" -> SSE.add(arrStr[1]);
                    }
                }
            }
            //Estudantes
            f.close();
            f = new FileReader(new File(inputFile));
            br = new BufferedReader(f);
            bw.write("#ESTUDANTES\n");
            while ((line = br.readLine()) != null) {
                String[] arrStr = line.split(",");
                // estudante -> TIPO, NOME, EMAIL, GRUPO, TITULO, DATA CONCLUSAO, ORIENTADOR
                if (arrStr[0].equals("Estudante")) {
                    bw.write("%s,%s,%s,%s,%s,%s,%s\n".formatted(arrStr[0], arrStr[1], generateEmail(arrStr[0], arrStr[1]), arrStr[2], arrStr[3], generateDataConclusao(), getRandomEfetivo(arrStr[2])));
                }
            }

            bw.close();
            br.close();
            f.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gera um numero de telefone unico para cada investigador efetivo
     *
     * @return numero de telefone unico
     */
    private static String generatePhoneNumber() {
        String number = "23";
        for (int j = 0; j < 7; j++)
            number = number.concat(String.valueOf((int) (Math.random() * 10)));

        while (telefones.contains(number)) { //Enquanto o num gerado for igual a um da lista, continuar a gerar numeros
            number = "23";
            for (int j = 0; j < 7; j++)
                number = number.concat(String.valueOf((int) (Math.random() * 10)));
        }

        telefones.add(number);
        return number;
    }

    /**
     * Gera um gabinete unico para cada investigador efetivo
     *
     * @return String com gabinete
     */
    //TODO aumentar possibilidades de gabintes. de momento limite -> 10 x 10 = 100 efetivos
    private static String generateGabinete() {
        String gabinete = "D";
        gabinete = gabinete.concat(String.valueOf((int) (Math.random() * 10) + 1));
        gabinete = gabinete.concat(".");
        gabinete = gabinete.concat(String.valueOf((int) (Math.random() * 10) + 1));

        while (gabinetes.contains(gabinete)) { //Enquanto o num gerado for igual a um da lista, continuar a gerar numeros
            gabinete = "D";
            gabinete = gabinete.concat(String.valueOf((int) (Math.random() * 10) + 1));
            gabinete = gabinete.concat(".");
            gabinete = gabinete.concat(String.valueOf((int) (Math.random() * 10) + 1));
        }
        gabinetes.add(gabinete);
        return gabinete;
    }

    /**
     * Gera um email unico para cada investigador, com o dominio dei.uc.pt no caso de ser efetivo e gmail.com no caso de ser estudante
     *
     * @param tipo Efetivo ou Estudante
     * @param nome nome do investigador
     * @return email unico do investigador
     */
    private static String generateEmail(String tipo, String nome) {
        String iniciais = "";
        String[] arr = nome.split(" ");
        for (String s : arr) {
            iniciais = iniciais.concat(String.valueOf(s.charAt(0)).toLowerCase());
        }

        while (emails.contains(iniciais + "@dei.uc.pt") || emails.contains(iniciais + "@gmail.com")) {
            //Acrescentar numeros enquanto o email nao for unico
            iniciais = iniciais.concat(String.valueOf((int) (Math.random() * 10)));
        }

        if (tipo.equals("Efetivo")) {
            emails.add(iniciais + "@dei.uc.pt");
            return iniciais + "@dei.uc.pt";
        }

        emails.add(iniciais + "@gmail.com");
        return iniciais + "@gmail.com";
    }

    /**
     * Gera uma data de conclusao entre 2021-2026
     *
     * @return data prevista de conclusao da tese de doutoramento
     */
    private static String generateDataConclusao() {
        String data = "202";
        data = data.concat(String.valueOf((int) (Math.random() * 6) + 1));
        return data;
    }

    private static String getRandomEfetivo(String grupo) {
        Random r = new Random();
        return switch (grupo) {
            case "AC" -> AC.get(r.nextInt(AC.size()));
            case "CMS" -> CMS.get(r.nextInt(CMS.size()));
            case "ECOS" -> ECOS.get(r.nextInt(ECOS.size()));
            case "IS" -> IS.get(r.nextInt(IS.size()));
            case "LCT" -> LCT.get(r.nextInt(LCT.size()));
            case "SSE" -> SSE.get(r.nextInt(SSE.size()));
            default -> "";
        };
    }

}//Gerador
