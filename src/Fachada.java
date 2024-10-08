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

public class Fachada {

    Scanner teclado = new Scanner(System.in);
    List<Aluno> alunos = new ArrayList<>();
    Arquivos arquivo = new Arquivos(alunos);

    public void criacaoDeArquivo(String nomeDoArquivo) {
        arquivo.criarArquivo(nomeDoArquivo);
    }

    public void leituraDosArquivos(String nomeDoArquivo) {
        arquivo.leituraDosAlunos(nomeDoArquivo);
    }

    public boolean verificaExistenciaDeArquivo(String nomeDoArquivo) {
        return arquivo.encontrarArquivo(nomeDoArquivo);
    }

    public void lerDisciplina(String nomeDoArquivo) {
        arquivo.lerArquivo(nomeDoArquivo, alunos);
    }

    /*
     * public void criarArquivo(String nomeDoArquivo) {
     * System.out.println("*PRIMEIRO*");
     * System.out.println("Crie o gabarito oficial da disciplina");
     * System.out.println("Apenas uma linha com as letras V ou F corretas");
     * try {
     * BufferedWriter bf = new BufferedWriter(new FileWriter("src/files/" +
     * nomeDoArquivo + "GABARITO.txt"));
     * String gabarito = teclado.nextLine();
     * bf.write(gabarito);
     * 
     * bf.close();
     * 
     * System.out.println("Gabarito criado com sucesso");
     * } catch (IOException e) {
     * System.out.println("ERRO: " + e.getMessage());
     * }
     * 
     * try {
     * BufferedWriter bf = new BufferedWriter(new FileWriter("src/files/" +
     * nomeDoArquivo + ".txt"));
     * int continuar = 1;
     * while (continuar == 1) {
     * System.out.println("Insira o nome do aluno");
     * String nomeAluno = teclado.nextLine();
     * System.out.println("Insira a sequência de V ou F");
     * String gabaritoAluno = teclado.nextLine();
     * bf.write(nomeAluno + "\t" + gabaritoAluno);
     * bf.newLine();
     * System.out.println("1. Inserir mais um aluno\n2. Encerrar");
     * continuar = teclado.nextInt();
     * teclado.nextLine();
     * }
     * System.out.println("Arquivo: " + nomeDoArquivo + " preenchido com sucesso!");
     * bf.close();
     * } catch (IOException e) {
     * System.out.println("ERRO: " + e.getMessage());
     * }
     * 
     * }
     * 
     * 
     * 
     * public boolean encontrarArquivo(String nomeDoArquivo) {
     * File arquivo = new File("src/files/" + nomeDoArquivo + ".txt");
     * if (arquivo.exists()) {
     * System.out.println("Arquivo existe");
     * return true;
     * } else {
     * System.out.println("Arquivo não existe");
     * return false;
     * }
     * }
     * 
     * public void leituraDosAlunos(String nomeDoArquivo) {
     * try {
     * BufferedReader buffReader = new BufferedReader(new FileReader("src/files/" +
     * nomeDoArquivo + ".txt"));
     * String linha = buffReader.readLine();
     * while (linha != null) {
     * System.out.println(linha);
     * linha = buffReader.readLine();
     * }
     * buffReader.close();
     * } catch (IOException e) {
     * System.out.println("ERRO: " + e.getMessage());
     * }
     * }
     * 
     * public void escreverNoArquivo(String nomeDoArquivo, String texto) {
     * try {
     * BufferedWriter bw = new BufferedWriter(new FileWriter("src/files/" +
     * nomeDoArquivo + ".txt", true));
     * bw.write(texto);
     * bw.newLine();
     * bw.close();
     * } catch (IOException e) {
     * System.out.println("ERRO: " + e.getMessage());
     * }
     * }
     * 
     * public double calcularMediaGeral(String nomeDoArquivo) {
     * double somaNotas = 0;
     * double qntdAlunos = alunos.size();
     * try {
     * BufferedReader br = new BufferedReader(new FileReader("src/files/" +
     * nomeDoArquivo + ".txt"));
     * String linha = br.readLine();
     * while (linha != null) {
     * String dado[] = linha.split("\t");
     * somaNotas += Double.parseDouble(dado[2]);
     * linha = br.readLine();
     * }
     * br.close();
     * } catch (FileNotFoundException e) {
     * e.printStackTrace();
     * } catch (IOException e) {
     * e.printStackTrace();
     * }
     * 
     * return somaNotas / qntdAlunos;
     * }
     */
}
