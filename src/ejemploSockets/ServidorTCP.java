package ejemploSockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author oscar
 */
public class ServidorTCP {
    
    private static final int PUERTO = 6000;
    private static final int MAX_CLIENTES = 3;
    
    public ServidorTCP(){
        try {
            // Creo el socket servidor que escucha
            // en el puerto 6000
            ServerSocket skServidor = new ServerSocket (PUERTO);
            System.out.println("Escucho el puerto "+PUERTO);
            for (int numCli = 0; numCli < MAX_CLIENTES; numCli++){
                // Escucho a los clientes
                Socket skCliente = skServidor.accept();
                // Cuando escucha a un cliente da un aviso
                System.out.println("Sirvo al cliente "+numCli);
                // Preparo un flujo de salida para el cliente
                // (Mensajes que envia al cliente)
                OutputStream aux = skCliente.getOutputStream();
                DataOutputStream flujoenviar = new DataOutputStream (aux);
                // Manda un mensaje al cliente
                flujoenviar.writeUTF ("Hola cliente "+numCli);
                // Cierro el socket servidor
                skCliente.close();                
            }
            System.out.println("Demasiados clientes por hoy.");
        } catch (IOException e) {
            System.out.println("Error en el servidor: "+ e.getMessage());
        }           
    }
    
    public static void main(String[] args){
        new ServidorTCP();
    }
}