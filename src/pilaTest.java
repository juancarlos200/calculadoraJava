
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

public class pilaTest {
// pila que va a tener numeros enteros
    private Pila<Integer> pila;
// Se crea una pila nueva cada vez q se prueba para que no se interrumpan los procesos de prueba
    @BeforeEach
    void setUp() {
        pila = new VectorPila<>();
    }
// prueba q se usara con los valores que hay en la lista de ints
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, -3, 99})
    void testPushYPopConDiferentesValores(int numero) {
        // se pone el numero en la pila 
        pila.push(numero);
        assertEquals(numero, pila.peek()); // El tope debe ser el mismo número
        assertEquals(numero, pila.pop());  // Debe salir el mismo número q se inserto y este lo elimina de la pila
        assertTrue(pila.isEmpty());        // Después de sacar, queda vacía la pila
    }
}