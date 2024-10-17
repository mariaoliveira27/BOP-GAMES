package codigo.model;

public class Duracao {
    private Hora horaInicial;
    private int duracaoTotal;

    public Duracao(Hora horaInicial, int tempoEmSegundos){
        this.horaInicial = horaInicial;
        this.duracaoTotal = duracaoTotal;
    }
    public boolean MaiorQue(Duracao outraDuracao){
        return this.duracaoTotal > outraDuracao.duracaoTotal;

    }
    public int DuracaoEmSegundos(){
        return duracaoTotal;
    }
    public String Relatorio(){

        int totalHoras = duracaoTotal / 3600;
        int totalMinutos = (duracaoTotal % 3600)/60;
        int totalSegundos = duracaoTotal % 60;

        return String.format("Duração: %02d:%02d:%02d", totalHoras, totalMinutos, totalSegundos);
        
    }
    public Hora horaFinal(){
        return horaInicial.Incrementar(duracaoTotal);
    }
}
