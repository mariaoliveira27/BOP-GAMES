package codigo.model;

public abstract class Participante {
    private String nome;
    private int numero;
    private String cidadeOrigem;

    public Participante(String nome, int numero, String cidadeOrigem) {
        this.nome = nome;
        this.numero = numero;
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    @Override
    public String toString() {
        return nome + " (" + numero + ") - " + cidadeOrigem;
    }
}
