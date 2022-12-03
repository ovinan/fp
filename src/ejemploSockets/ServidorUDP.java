package ejemploSockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author oscar
 */
public class ServidorUDP {
    private static final int PUERTO = 6789;   

    public ServidorUDP() {
        try {
            DatagramSocket socketUDP = new DatagramSocket (PUERTO);
            byte[] bufer = new byte[1000];
            System.out.println("Escucho el puerto "+ PUERTO);
            while (true) {      
                // Construimos el DatagramPacket para recibir peticiones 
                DatagramPacket peticion = new DatagramPacket (bufer, bufer.length); 
                // Leemos una petición del DatagramSocket
                socketUDP.receive (peticion);
                // Obtengo el mensaje del cliente
                String mensajerecibido = new String (peticion.getData());
                System.out.print("Datagrama recibido del host: " + peticion.getAddress());
                System.out.print(" desde el puerto remoto: " + peticion.getPort());
                System.out.println(" con el mensaje: " + mensajerecibido);
                // Construimos el DatagramPacket para enviar la respuesta 
                String mensajerespuesta = "Hola cliente "+mensajerecibido; 
                DatagramPacket respuesta = new DatagramPacket (mensajerespuesta.getBytes(),
                    mensajerespuesta.length(),
                    peticion.getAddress(), 
                    peticion.getPort());
                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
            }
        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args){
        new ServidorUDP();
    }    
}
