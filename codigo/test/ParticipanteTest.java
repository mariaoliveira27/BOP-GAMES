package codigo.test;

import codigo.model.Participante;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParticipanteTest {

    @Test
    public void testParticipante() {
        Participante participante = new Participante("Alice", 133, "Joao Molevade") {
            
        };

        String nomeResultado = participante.getNome();
        int numeroResultado = participante.getNumero();
        String cidadeResultado = participante.getCidadeOrigem();

        assertEquals("Alice", nomeResultado);
        assertEquals(133, numeroResultado);
        assertEquals("Joao Molevade", cidadeResultado);
    }

    @Test
    public void testToString() {
        Participante participante = new Participante("Laura", 155, "Pedro Leopoldo") {
        
        };

        String resultado = participante.toString();

        assertEquals("Laura (155) - Pedro Leopoldo", resultado);
    }
}
