public class CalculadoraPostfix implements Calculadora {

//Guardar Numeros en una pila
    private Pila<Integer> pila;
//Constructor que cuando se crea calculadora se crea una pila de 0
    public CalculadoraPostfix() {
        pila = new VPila<>();
    }
// Verifica si el componente leido es un operador o no y si es valido 
    private boolean Operador(String componente) {
        return componente.equals("+") || componente.equals("-") ||
                componente.equals("*") || componente.equals("/") ||
                componente.equals("%");
    }
//Transformacion de texto a numero = string a int
    private boolean Numero(String componente) {
        try {
            Integer.parseInt(componente);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
// realiza la opreacion segun el operador
    private int operar(int a, int b, String operador) {
        if (operador.equals("+")) {
            return a + b;
        } else if (operador.equals("-")) {
            return a - b;
        } else if (operador.equals("*")) {
            return a * b;
        } else if (operador.equals("/")) {
            if (b == 0) {
                throw new IllegalArgumentException("No es posible realizar divisiones entre cero");
            }
            return a / b;
        } else if (operador.equals("%")) {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede hacer un reciduo por cero");
            }
            return a % b;
        } else {
            throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }

    @Override
    public int evaluar(String expresion) {
        String[] componentes = expresion.split(" ");

        for (String componente : componentes) {
            if (Numero(componente)) {
                pila.push(Integer.parseInt(componente));
            } else if (Operador(componente)) {
                if (pila.size() < 2) {
                    throw new IllegalArgumentException("numeros insuficientes");
                }
                int b = pila.pop();
                int a = pila.pop();
                int resultado = operar(a, b, componente);
                pila.push(resultado);
            } else {
                throw new IllegalArgumentException(
                        "elemento no es numero ni operador en la expresión: " + componente);
            }
        }

        if (pila.size() != 1) {
            throw new IllegalArgumentException(
                    "Expresión mal formada");
        }

        return pila.pop();
    }
}
