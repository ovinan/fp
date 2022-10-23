package introThreads;

/**
 * atencionColaSinThreads simula la atencion por una clase Caja, a otra clase Cliente, sin usar threads:
 * - La clase Cliente lleva una serie de productos, cada uno de los cuales su atencion demora un numero de segundos.
 * - La clase Caja atiende cada producto el numero de segundos especificado, y lo muestra en pantalla.
 * 
 * @author oscar
 */
public class atencionColaSinThreads {
    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        Caja caja1 = new Caja("Caja 1");
        Caja caja2 = new Caja("Caja 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        caja1.procesarCompra(cliente1, initialTime);
        caja2.procesarCompra(cliente2, initialTime);
    }    
}
