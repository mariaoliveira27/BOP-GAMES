package codigo.test;

import codigo.model.Ciclista;
import codigo.model.Participante;
import codigo.model.Etapa; 
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CiclistaTest {

    @Test
    public void testRegistrarEtapa() {
        Ciclista ciclista = new Ciclista("Alice", 133, "Joao Molevade");
        Etapa etapa1 = new Etapa(1, 120); 
        ciclista.registrarEtapa(etapa1);

        assertEquals(120, ciclista.calcularTempoTotal()); 
    }

    @Test
    public void testCalcularTempoTotal() {
        Ciclista ciclista = new Ciclista("Laura", 155, "Pedro Leopoldo");
        
        ciclista.registrarEtapa(new Etapa(1, 180)); 
        ciclista.registrarEtapa(new Etapa(2, 160)); 

        int tempoTotal = ciclista.calcularTempoTotal();
        
        assertEquals(340, tempoTotal); 
    }

    @Test
    public void testVencedorDaEtapa() {
        Ciclista ciclista1 = new Ciclista("Alice", 133, "Joao Molevade");
        Ciclista ciclista2 = new Ciclista("Laura", 155, "Pedro Leopoldo");

        ciclista1.registrarEtapa(new Etapa(1, 180)); 
        ciclista2.registrarEtapa(new Etapa(1, 240)); 

        Ciclista vencedor = ciclista1.vencedorDaEtapa(ciclista2, 1);
        assertEquals(ciclista1, vencedor); 
    }

    @Test
    public void testTempoEntreCiclistas() {
        Ciclista ciclista1 = new Ciclista("Alice", 133, "Joao Molevade");
        Ciclista ciclista2 = new Ciclista("Laura", 155, "Pedro Leopoldo");

        ciclista1.registrarEtapa(new Etapa(1, 180)); 
        ciclista2.registrarEtapa(new Etapa(1, 260)); 

        String resultado = ciclista1.tempoEntreCiclistas(ciclista2);
        
        
        assertEquals("Diferença: 1min 20seg", resultado);
    }

    @Test
    public void testToString() {
        Ciclista ciclista = new Ciclista("Alice", 133, "Joao Molevade");
        ciclista.registrarEtapa(new Etapa(1, 240)); 

        String resultado = ciclista.toString();
        assertEquals("Alice (133) - Joao Molevade - Tempo Total: 240s", resultado);
    }
}
