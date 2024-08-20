import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Sistema de alunos e notas");

        boolean finalizarApp = false;
        Scanner teclado = new Scanner(System.in);
        Fachada fachada = new Fachada();
        String opcaoString = new String();
        boolean eInputValido = false;

        while (finalizarApp != true) {
            System.out.println("Insira o nome da disciplina");
            String nomeDoArquivo = teclado.nextLine();
            boolean existeArquivo = fachada.encontrarArquivo(nomeDoArquivo);

            if (existeArquivo == false) {
                System.out.println("Esse arquivo não foi encontrado!");

                System.out.println("Deseja criar um novo arquivo?(S/N)");
                opcaoString = teclado.nextLine();
                if (opcaoString.equals("s") || opcaoString.equals("S")) {
                    fachada.criarArquivo(nomeDoArquivo);
                } else if (opcaoString.equals("n") || opcaoString.equals("N")) {
                    finalizarApp = true;
                } else {
                    System.out.println("Opção inválida");
                }

            } else {
                fachada.lerArquivo(nomeDoArquivo);
            }

            System.out.println("Deseja encerrar o programa?(S/N)");
            opcaoString = teclado.nextLine();
            if (opcaoString.equals("s") || opcaoString.equals("S")) {
                finalizarApp = true;
            } else if (opcaoString.equals("n") || opcaoString.equals("N")) {
                finalizarApp = false;
            } else {
                System.out.println("Opção inválida");
            }

        }

    }

    public static boolean inputValido(String input) {
        if (input != "S" || input != "s" || input != "N" || input != "n") {
            return true;
        } else {
            return false;
        }
    }
}
