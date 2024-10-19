package codigo.model;

import java.util.ArrayList;
import java.util.List;

public class Ciclista extends Participante {
    private static int ETAPAS = 21;
    private int dadosRegistrados;
    private List<Etapa> etapas;

    public Ciclista(String nome, int numero, String cidadeOrigem) {
        super(nome, numero, cidadeOrigem);
        this.etapas = new ArrayList<>();
        this.dadosRegistrados = 0;
    }

    public void registrarEtapa(Etapa etapa) {
        if (etapas.size() < ETAPAS) {
            etapas.add(etapa);
            dadosRegistrados++;
        }
    }

    public int calcularTempoTotal() {
        int tempoTotal = 0;
        for (Etapa etapa : etapas) {
            tempoTotal += etapa.getDuracao().getTotalSegundos();
        }
        return tempoTotal; // Retorna em segundos
    }

    public Ciclista vencedorDaEtapa(Ciclista outro, int numeroEtapa) {
        Etapa minhaEtapa = encontrarEtapa(numeroEtapa);
        Etapa outraEtapa = outro.encontrarEtapa(numeroEtapa);

        if (minhaEtapa != null && outraEtapa != null) {
            if (minhaEtapa.getDuracao().getTotalSegundos() < outraEtapa.getDuracao().getTotalSegundos()) {
                return this;
            } else {
                return outro;
            }
        }
        return null; // Caso um dos ciclistas não tenha completado a etapa
    }

    private Etapa encontrarEtapa(int numeroEtapa) {
        for (Etapa etapa : etapas) {
            if (etapa.getNumero() == numeroEtapa) {
                return etapa;
            }
        }
        return null;
    }

    public String tempoEntreCiclistas(Ciclista outroCiclista) {
        int diferencaTempo = Math.abs(this.calcularTempoTotal() - outroCiclista.calcularTempoTotal());
        int minutos = diferencaTempo / 60;
        int segundos = diferencaTempo % 60;
        
        return String.format("Diferença: %dmin %dseg", minutos, segundos); // Usando "min" e "seg" na formatação
    }
    

    @Override
    public String toString() {
        return super.toString() + " - Tempo Total: " + calcularTempoTotal() + "s";
    }
}
