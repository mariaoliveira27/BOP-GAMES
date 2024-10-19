package codigo.model;

public class Duracao {
    private Hora horaInicial;
    private int duracaoTotal; // em segundos

    // Construtor
    public Duracao(Hora horaInicial, int tempoEmSegundos){
        this.horaInicial = horaInicial;
        this.duracaoTotal = tempoEmSegundos; // Armazena a duração total em segundos
    }

    // Compara se esta duração é maior que outra
    public boolean maiorQue(Duracao outraDuracao) {
        return this.duracaoTotal > outraDuracao.duracaoTotal;
    }

    // Retorna a duração total em segundos
    public int getTotalSegundos() {
        return duracaoTotal;
    }

    // Gera um relatório formatado da duração (hh:mm:ss)
    public String relatorio() {
        int totalHoras = duracaoTotal / 3600;
        int totalMinutos = (duracaoTotal % 3600) / 60;
        int totalSegundos = duracaoTotal % 60;

        return String.format("Duração: %02d:%02d:%02d", totalHoras, totalMinutos, totalSegundos);
    }

    // Retorna a hora final ao adicionar a duração à hora inicial
    public Hora horaFinal() {
        return horaInicial.Incrementar(duracaoTotal); // Supondo que Hora tenha o método incrementar
    }
}
