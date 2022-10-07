package lanzaCmd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ovinan
 */
public class LanzaCmd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try 
        {
            // Creamos el proceso hijo
            ProcessBuilder builder_echo = new ProcessBuilder("CMD");
            Process proceso_echo = builder_echo.start();
            
            // Indicamos cuál es la salida del proceso hijo que ejecuta el bash
            final Scanner in = new Scanner(proceso_echo.getInputStream());
            new Thread() {
                @Override
                public void run() {
                    while (in.hasNextLine()) {
                        System.out.println(in.nextLine());
                    }
                }
            }.start();
            
            // Obtenemos la salida del proceso hijo
            PrintWriter salida = new PrintWriter(proceso_echo.getOutputStream());
            
            // Hacemos 10 llamadas al proceso hijo con el comando echo
            for (int i = 0; i < 10; i++) 
            {
                salida.println("echo Iteracion " + i);
                salida.flush();
            }
            
            // Cerramos los flujos
            salida.close();
        } 
        catch (IOException ex) 
        {
            System.err.println("Excepción de E/S!!: " + ex.toString());
        }
    }

}
