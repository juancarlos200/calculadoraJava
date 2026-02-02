import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculadoraPostfixTest {

    private CalculadoraPostfix calc = new CalculadoraPostfix();

    // ✅ Pruebas correctas (expresión, resultado esperado)
    @ParameterizedTest
    @CsvSource({
        "'5 2 +', 7",
        "'10 3 -', 7",
        "'4 3 *', 12",
        "'8 2 /', 4",
        "'10 3 %', 1",
        "'5 1 2 + 4 * + 3 -', 14"
    })
    void testExpresionesValidas(String expresion, int resultadoEsperado) {
        assertEquals(resultadoEsperado, calc.evaluar(expresion));
    }

    // ❌ División o módulo por cero
    @ParameterizedTest
    @ValueSource(strings = {"5 0 /", "8 0 %"})
    void testErroresMatematicos(String expresion) {
        assertThrows(ArithmeticException.class, () -> calc.evaluar(expresion));
    }

    // ❌ Faltan operandos
    @ParameterizedTest
    @ValueSource(strings = {"5 +", "3 *", "7 /"})
    void testFaltanOperandos(String expresion) {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluar(expresion));
    }

    // ❌ Expresiones mal formadas
    @ParameterizedTest
    @ValueSource(strings = {"5 5 5 +", "2 3 4 *"})
    void testExpresionMalFormada(String expresion) {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluar(expresion));
    }

    // ❌ Caracteres inválidos
    @ParameterizedTest
    @ValueSource(strings = {"5 a +", "hola mundo", "2 & 3 +"})
    void testCaracterInvalido(String expresion) {
        assertThrows(IllegalArgumentException.class, () -> calc.evaluar(expresion));
    }
}
