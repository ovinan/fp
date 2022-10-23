package introThreads;

/**
 * atencionColaConThreads simula la atencion por una clase Caja, a otra clase Cliente, usando threads:
 * - La clase Cliente lleva una serie de productos, cada uno de los cuales su atencion demora un numero de segundos.
 * - Ahora se llamara a la clase CajaThread, que atiende cada producto el numero de segundos especificado, y lo muestra en pantalla.
 * En este caso, al usar threads, la atencion se hace en paralelo.
 * NOTA: La clase Cliente es la misma, la unica que ha cambiado es la Caja (y que dentro de la caja se llama a su run).
 * 
 * @author oscar
 */
public class atencionColaConThread {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
        Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajaThread caja1 = new CajaThread("Caja 1", cliente1, initialTime);
        CajaThread caja2 = new CajaThread("Caja 2", cliente2, initialTime);

        caja1.start();
        caja2.start();
    }    
}
