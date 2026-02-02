import java.util.Scanner;              
import java.io.File;                   
import java.io.FileNotFoundException;  
public class Main {
    public static void main(String[] args) {

        Calculadora calculadora = new CalculadoraPostfix();

        try {
           
            // Scanner permitirá leerlo línea por línea
            Scanner archivo = new Scanner(new File("datos.txt"));

            // Contador para numerar las expresiones que se van leyendo
            int numeroLinea = 1;


            System.out.println("--- Calculadora ---\n");

            // Este ciclo se ejecuta mientras existan líneas en el archivo
            while (archivo.hasNextLine()) {

                // Lee una línea completa y elimina espacios al inicio y final
                String linea = archivo.nextLine().trim();

                
                if (linea.isEmpty()) {
                    continue;
                }

                // Muestra la expresión que se va a evaluar
                System.out.print("Expresión " + numeroLinea + ": " + linea + " = ");

                try {
                    // Se envía la línea a la calculadora postfix para evaluarla
                    int resultado = calculadora.evaluar(linea);

                  
                    System.out.println(resultado);
                // Si ocurre un error, se captura la excepción y se muestra el mensaje  
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());
                }

                // Aumenta el contador de número de expresión
                numeroLinea++;
            }

            // Se cierra el archivo 
            archivo.close();

        } catch (FileNotFoundException e) {
            // Este error ocurre si no se encuentra el archivo txt
            System.err.println("No se logro identificar el archivo 'datos.txt'");
        }
    }
}
