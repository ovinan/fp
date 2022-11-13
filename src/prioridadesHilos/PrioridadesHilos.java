package prioridadesHilos;

/**
 *
 * @author oscar
 */
public class PrioridadesHilos {
    public static void main(String[] args) {
 
        HiloMuestraNumero hilos[] = new HiloMuestraNumero[10];
 
        for (int i = 0; i < 10; i++) {
            int priority = (int) (Math.random() * 5+1);
 
            hilos[i] = new HiloMuestraNumero("hilo" + i, i, priority);
 
            //hilos[i].setPriority(priority);
        }
 
        for(int i = 0; i < 10; i++) {
            hilos[i].start();
 
            try {
                hilos[i].join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

