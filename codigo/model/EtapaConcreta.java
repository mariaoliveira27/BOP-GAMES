package codigo.model;

public class EtapaConcreta extends Etapa {
    public EtapaConcreta(int numero, Duracao duracao) {
        super(numero, new Data(), new Hora(), duracao); 
    }
}
