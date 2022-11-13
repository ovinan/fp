package problemaProductorConsumidorArray;

/**
 *
 * @author oscar
 */
public class Consumidor extends Thread {
 
    private Buffer buffer;
 
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
 
    public void run() {
 
        while (true) {
            // Consume el valor si es posible
            char valor = buffer.consumir();
            System.out.println("Recogido el caracter " + valor + " del buffer");
            try {
                // Esperamos entre 0 y 4 segundos
                sleep((int) (Math.random() * 4000));
            } catch (InterruptedException e) { }
        }
    }
}