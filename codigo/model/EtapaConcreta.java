package codigo.model;

public class EtapaConcreta extends Etapa {
    
    public EtapaConcreta(int numero, Data data, Hora horaInicial, Duracao duracao) {
        super(numero, data, horaInicial, duracao);
    }

    @Override
    public int getDuracaoEmSegundos() {
        return getDuracao().DuracaoEmSegundos();
    }
}
