
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

public class pilaTest {

    private Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new VectorPila<>();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, -3, 99})
    void testPushYPopConDiferentesValores(int numero) {
        pila.push(numero);
        assertEquals(numero, pila.peek()); // El tope debe ser el mismo número
        assertEquals(numero, pila.pop());  // Debe salir el mismo número
        assertTrue(pila.isEmpty());        // Después de sacar, queda vacía
    }
}