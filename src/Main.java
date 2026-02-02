import java.util.Scanner;              
import java.io.File;                   
import java.io.FileNotFoundException;  
public class Main {
    public static void main(String[] args) {

        Calculadora calculadora = new CalculadoraPostfix();

        try {
           
            // Scanner permitirá leerlo línea por línea
            Scanner documento = new Scanner(new File("datos.txt"));

            // Contador para numerar las expresiones que se van leyendo
            int LineaCodigo = 1;


            

            // Este ciclo se ejecuta mientras existan líneas en el documento
            while (documento.hasNextLine()) {

                // Lee una línea completa y elimina s al inicio y final
                String espacio = documento.nextLine().trim();

                
                if (espacio.isEmpty()) {
                    continue;
                }

                // Muestra la expresión que se va a evaluar
                System.out.print("Expresión " + LineaCodigo + ": " + espacio + " = ");

                try {
                    // Se envía la línea a la calculadora postfix para evaluarla
                    int resultado = calculadora.evaluar(espacio);

                  
                    System.out.println(resultado);
                // Si ocurre un error, se captura la excepción y se muestra el mensaje  
                } catch (IllegalArgumentException e) {

                    System.out.println(e.getMessage());
                }

                // Aumenta el contador de número de expresión
                LineaCodigo++;
            }

            // Se cierra el documento 
            documento.close();

        } catch (FileNotFoundException e) {
            // Este error ocurre si no se encuentra el documento txt
            System.err.println("No se a logro identificar el documento 'datos.txt'"+e);
        }
    }
}
