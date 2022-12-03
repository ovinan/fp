package ejemploSockets;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author oscar
 */
public class ClienteTCP {
    
    private static final String HOST = "localhost";    
    private static final int PUERTO = 6000;

    public ClienteTCP() {
        try {
            // Creo el socket cliente que se conecta a la 
            // maquina localhost en su puerto 6000
            Socket skCliente = new Socket (HOST, PUERTO);
            // Obtengo el flujo de entrada del cliente creado 
            // (Mensajes que recibe el cliente del servidor) 
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream (aux);
            // Saco por pantalla el mensaje recibido del servidor
            System.out.print("Mensaje recibido del servidor: ");
            System.out.println(flujo.readUTF());
            // Cierro el socket
            skCliente.close();
        } catch (IOException ex) {
            System.out.println("Error->"+ex.toString());
        }
    }
    public static void main(String[] args){
        new ClienteTCP();
    }        
}
