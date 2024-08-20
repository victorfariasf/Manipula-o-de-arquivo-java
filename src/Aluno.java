public class Aluno {
    private String nome;
    private String sequenciaAcertos;
    private String gabaritoOficial;
    private int nota = 0;

    public Aluno(String nome, String sequenciaAcertos, String gabaritoOficial) {
        this.nome = nome;
        this.sequenciaAcertos = sequenciaAcertos;
        this.gabaritoOficial = gabaritoOficial;
    }

    public void calcularNota() {
        if (sequenciaAcertos.equals("VVVVVVVVVV") || sequenciaAcertos.equals("vvvvvvvv")
                || sequenciaAcertos.equals("FFFFFFFFFF") || sequenciaAcertos.equals("ffffffff")) {
            nota = 0;
        } else {
            for (int i = 0; i < sequenciaAcertos.length(); i++) {
                if (sequenciaAcertos.charAt(i) == gabaritoOficial.charAt(i)) {
                    nota++;
                }
            }
        }

    }

    public String toString() {
        return nome + "\t" + sequenciaAcertos + "\t" + nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSequenciaAcertos() {
        return sequenciaAcertos;
    }

    public void setSequenciaAcertos(String sequenciaAcertos) {
        this.sequenciaAcertos = sequenciaAcertos;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

}
