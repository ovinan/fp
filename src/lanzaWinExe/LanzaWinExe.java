package lanzaWinExe;

import java.io.IOException;
import java.util.Scanner;

public class LanzaWinExe {   
    public static void main(String[] args) {
            // Segun la doc de Java para la clase Process, hay determinados programas para los
            // que para que la invocacion funcione correctamente y no deje los programas
            // colgados, hay que tener en cuenta las entradas y salidas estándar y de errores.
            //String ruta_Proceso = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            //String ruta_Proceso = "calc.exe";
            String ruta_Proceso = "notepad.exe";
            ProcessBuilder pb = new ProcessBuilder(ruta_Proceso);
            Scanner teclado = new Scanner(System.in);
            try {
                // LANZAMOS EL PROCESO
                Process process = pb.start();
                System.out.println("¿Terminar el proceso? (S/N) ");
                if(teclado.nextLine().charAt(0) =='S'){
                            process.destroy();
                            //process.destroyForcibly();
                }
                int retorno = process.waitFor();
                System.out.println("La ejecución devuelve " + retorno);
            } catch (IOException ex) {        
                System.out.println("Error: " + ex.toString());
                System.exit(-1);
            } catch (InterruptedException ex) {
                System.out.println("El proceso hijo finalizó de forma incorrecta. " + ex.toString());
                System.exit(-1);
            }     
        }    
    }    
