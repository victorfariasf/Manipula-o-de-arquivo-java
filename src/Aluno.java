public class Aluno {
    private String nome;
    private String respostas;
    private String gabarito;
    private int nota = 0;

    public Aluno(String nome, String respostas, String gabarito) {
        this.nome = nome;
        this.respostas = respostas.toLowerCase();
        this.gabarito = gabarito.toLowerCase();
    }

    public void calcularNota() {
        // System.out.println("calculando nota do aluno: " + getNome());
        if (respostas.matches("(?i)V+") || respostas.matches("(?i)F+")) {
            this.setNota(0);
        } else {
            for (int i = 0; i < respostas.length(); i++) {
                if (respostas.charAt(i) == gabarito.charAt(i)) {
                    this.incrementarNota();
                }
            }
        }
    }

    public String toString() {
        return this.getNome() + "\t" + this.getRespostas().toUpperCase() + "\t" + this.getNota();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void incrementarNota() {
        this.nota++;
    }

}
