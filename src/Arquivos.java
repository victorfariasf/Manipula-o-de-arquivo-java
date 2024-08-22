import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos {

    Scanner teclado = new Scanner(System.in);
    private List<Aluno> alunos;

    public Arquivos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public boolean encontrarArquivo(String nomeDoArquivo) {
        File arquivo = new File("src/files/" + nomeDoArquivo + ".txt");
        if (arquivo.exists()) {
            System.out.println("Arquivo existe");
            return true;
        } else {
            System.out.println("Arquivo não existe");
            return false;
        }
    }

    public void criarArquivo(String nomeDoArquivo) {
        System.out.println("*PRIMEIRO*");
        System.out.println("Crie o gabarito oficial da disciplina");
        System.out.println("Apenas uma linha com as letras V ou F corretas");
        String gabarito = teclado.nextLine();
        escreverNoArquivo(nomeDoArquivo + "GABARITO", gabarito);

        int continuar = 1;
        while (continuar == 1) {
            System.out.println("Insira o nome do aluno");
            String nomeAluno = teclado.nextLine();
            System.out.println("Insira a sequência de V ou F");
            String gabaritoAluno = teclado.nextLine();
            escreverNoArquivo(nomeDoArquivo, nomeAluno + "\t" + gabaritoAluno);
            System.out.println("1. Inserir mais um aluno\n2. Encerrar");
            continuar = teclado.nextInt();
            teclado.nextLine();
        }
        System.out.println("Arquivo: " + nomeDoArquivo + " preenchido com sucesso!");

    }

    public void lerArquivo(String nomeDoArquivo, List<Aluno> alunos) {

        System.out.println("Gabarito oficial");
        System.out.println("Gabarito oficial: " + leituraDosAlunos(nomeDoArquivo + "GABARITO", true).toUpperCase());

        boolean disciplinaNotasDecrescentesExiste = encontrarArquivo(nomeDoArquivo + "DECRESCENTE");
        boolean disciplinaAlfabeticaExiste = encontrarArquivo(nomeDoArquivo + "ALFABETICA");

        if (disciplinaAlfabeticaExiste && disciplinaNotasDecrescentesExiste) {
            System.out.println("=============================");
            System.out.println("ALUNOS POR ORDEM DE NOTAS DECRESCENTES");
            leituraDosAlunos(nomeDoArquivo + "DECRESCENTE");
            System.out.println("=================================");
            System.out.println("ALUNOS POR ORDEM ALFABÉTICA");
            leituraDosAlunos(nomeDoArquivo + "ALFABETICA");
            System.out.println("=================================");

        } else {
            System.out.println("=============================");
            System.out.println("CRIANDO ARQUIVOS DOS ALUNOS POR ORDEM DECRESCENTE E POR ORDEM ALFABÉTICA");
            // System.out.println("---lendo gabarito----");
            String gabaritoOficial = leituraDosAlunos(nomeDoArquivo + "GABARITO", true);
            String linha = new String();
            // System.out.println("---calculando notas----");

            lerEAdicionarAlunos(nomeDoArquivo, gabaritoOficial);

            System.out.println("ALUNOS DA DISCIPLINA (FORMA ORIGINAL)");
            for (Aluno x : alunos) {
                x.calcularNota();
                System.out.println(x.toString());
            }
            // ---------------salvando em uma lista os alunos na forma original
            List<Aluno> alunosOriginal = alunos;
            // System.out.println("---ordenando alunos----");

            alunos.sort((x, y) -> x.getNome().compareTo(y.getNome()));
            System.out.println("============================");
            for (Aluno x : alunos) {
                escreverNoArquivo(nomeDoArquivo + "ALFABETICA", x.toString());
            }
            // System.out.println("---ordenando alunos----");

            System.out.println("============================");
            alunos.sort((x, y) -> Integer.compare(y.getNota(), x.getNota()));
            for (Aluno x : alunos) {
                escreverNoArquivo(nomeDoArquivo + "DECRESCENTE", x.toString());
            }
            // System.out.println("---mostrando alunos----");

            escreverNoArquivo(nomeDoArquivo + "DECRESCENTE",
                    String.format("%.1f", calcularMediaGeral(nomeDoArquivo + "DECRESCENTE"))
                            + " essa é média geral da disciplina");
            escreverNoArquivo(nomeDoArquivo + "ALFABETICA",
                    String.format("%.1f", calcularMediaGeral(nomeDoArquivo + "ALFABETICA"))
                            + " essa é média geral da disciplina");

            System.out.println("ALUNOS POR ORDEM DE NOTAS DECRESCENTES");
            leituraDosAlunos(nomeDoArquivo + "DECRESCENTE");
            System.out.println("=================================");
            System.out.println("ALUNOS POR ORDEM ALFABÉTICA");
            leituraDosAlunos(nomeDoArquivo + "ALFABETICA");
            System.out.println("=================================");
        }

    }

    // --------------------- AUXILIARES -------------------------

    public void lerEAdicionarAlunos(String nomeDoArquivo, String gabaritoOficial) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                String[] dados = linha.split("\t");
                alunos.add(new Aluno(dados[0], dados[1], gabaritoOficial));
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void leituraDosAlunos(String nomeDoArquivo) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public String leituraDosAlunos(String nomeDoArquivo, boolean retornarComoString) {
        StringBuilder resultado = new StringBuilder();
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = buffReader.readLine();
            while (linha != null) {
                resultado.append(linha).append("\n");
                linha = buffReader.readLine();
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        return resultado.toString();
    }

    public void escreverNoArquivo(String nomeDoArquivo, String texto) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/" + nomeDoArquivo + ".txt", true));
            bw.write(texto);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public double calcularMediaGeral(String nomeDoArquivo) {
        double somaNotas = 0;
        double qntdAlunos = alunos.size();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/files/" + nomeDoArquivo + ".txt"));
            String linha = br.readLine();
            while (linha != null) {
                String dado[] = linha.split("\t");
                somaNotas += Double.parseDouble(dado[2]);
                linha = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return somaNotas / qntdAlunos;
    }
}
