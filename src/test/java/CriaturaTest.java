import com.parcial.composicion.Arma;
import com.parcial.criaturas.Dragon;
import com.parcial.criaturas.Guerrero;
import com.parcial.criaturas.Mago;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CriaturaTest {
    
    private Dragon dragon;
    private Mago mago;
    private Guerrero guerrero;
    private Arma espada;

    @BeforeEach
    public void setUp() {
        dragon = new Dragon("Copperfield", 150, 40, "Escamas de Hierro");
        mago = new Mago("Gandalf", 100, 30, "Bola de Fuego");
        guerrero = new Guerrero("Guts", 120, 35, "Matadragones");
        espada = new Arma("Espada Legendaria", 15);
    }

    @Test
    public void testDragonEstaVivo() {
        assertTrue(dragon.estaViva());
    }

    @Test
    public void testDefenderReduceSalud() {
        guerrero.defender(20);
        assertEquals(100, guerrero.getSalud());
    }

    @Test
    public void testSaludNoNegativa() {
        guerrero.defender(200);
        assertEquals(0, guerrero.getSalud());
    }

    @Test
    public void testCriaturaNoVivaConSaludCero() {
        guerrero.defender(120);
        assertFalse(guerrero.estaViva());
    }

    @Test
    public void testEquiparArma() {
        guerrero.equiparArma(espada);
        assertNotNull(espada);
        assertEquals(15, espada.getDañoAdicional());
    }

    @Test
    public void testDragonAtaqueDoble() {
        int saludAntes = mago.getSalud();
        dragon.atacar(mago);
        assertTrue(mago.getSalud() < saludAntes);
    }
}