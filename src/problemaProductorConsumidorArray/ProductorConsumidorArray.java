
package problemaProductorConsumidorArray;

/**
 *
 * @author oscar
 */
public class ProductorConsumidorArray {
    public static void main(String[] args) {
        Buffer b = new Buffer(3);
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);
        p.start();
        c.start();
    }   
}
