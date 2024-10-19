package codigo.model;

public class Hora {
    private int hora;
    private int minutos;
    private int segundos;

    public boolean Validar() {
        return hora >= 0 && hora < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60;
    }

    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
        if (!Validar()) {
            throw new IllegalArgumentException("Hora inválida!");
        }
    }

    public void Ajustar(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minutos = minuto;
        this.segundos = segundo;
        if (!Validar()) {
            throw new IllegalArgumentException("Hora inválida!");
        }
    }

    public Hora Incrementar(int quantidadeSegundos) {
        int totalSegundos = this.segundos + quantidadeSegundos;
        int novoSegundos = totalSegundos % 60;
        int totalMinutos = this.minutos + totalSegundos / 60;
        int novoMinutos = totalMinutos % 60;
        int novoHora = (this.hora + totalMinutos / 60) % 24;

        return new Hora(novoHora, novoMinutos, novoSegundos);
    }

    public boolean EstaNaFrente(Hora outra) {
        if (this.hora != outra.hora) {
            return this.hora > outra.hora;
        }
        if (this.minutos != outra.minutos) {
            return this.minutos > outra.minutos;
        }
        return this.segundos > outra.segundos;
    }

    public String HoraFormatada() {
        return String.format("%02d:%02d:%02d", hora, minutos, segundos);
    }
}
