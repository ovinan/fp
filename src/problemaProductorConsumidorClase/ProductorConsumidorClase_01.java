package problemaProductorConsumidorClase;

/**
 *
 * COPIA DE LA SOLUCION DADA POR UN ALUMNO AL PROBLEMA DEL PRODUCTOR CONSUMIDOR,
 * UTILIZANDO UN ARRAY Y OPTIMIZANDO LAS VARIABLES
 * 
 * VERSIÓN 1: SIN SINCRONIZAR (sin monitores)
 * 
 */

public class ProductorConsumidorClase_01 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int DORMIR_PRODUCTOR = 1000, DORMIR_CONSUMIDOR = 2150;
        
        Buffer_Almac_01 almacen_01 = new Buffer_Almac_01();
        Productor_01 productor_01 = new Productor_01(almacen_01, DORMIR_PRODUCTOR);
        Consumidor_01 consumidor_01 = new Consumidor_01(almacen_01, DORMIR_CONSUMIDOR);
        
        productor_01.start();
        consumidor_01.start();
    } 


    public static class Buffer_Almac_01 {

        public int contenido = 0;

        // VERSIÓN NO SINCRONIZADA

        /**
         * DISMINUYE UN VALOR AL ALMACEN
         */
        public void get() {
            contenido = contenido - 1;

        }

        /**
         * AUMENTA UN VALOR AL ALMACEN
         */
        public void put() {
            contenido = contenido + 1;
        } 
    }

    public static class Consumidor_01 extends Thread 
    {
        private Buffer_Almac_01 almacen;
        private int dormir;

        /**
         * Constructor del consumidor
         * @param almacen Buffer de donde se obtendrán los recursos
         * @param dormir Tiempo que dormirá el consumidor
         */
        public Consumidor_01(Buffer_Almac_01 almacen, int dormir) {        
            this.almacen = almacen;
            this.dormir = dormir;
        }

        public void run() {      

            for (int i = 0; i < 10; i++) {
                almacen.get();
                System.out.println("Turno: " + i + " Consumidor toma Una. En Almacen hay:" + almacen.contenido);
                try {
                    sleep(dormir);
                } catch (InterruptedException e) {
                    System.err.println("Error en el consumidor: " + e.toString());
                }
            }            
        }
    }

    public static class Productor_01 extends Thread {

        private Buffer_Almac_01 almacen;
        private int dormir;

        /**
         * Constructor del productor
         * @param almacen Buffer donde se producirán los recursos
         * @param dormir Tiempo que dormirá el productor
         */
        public Productor_01(Buffer_Almac_01 almacen, int dormir) {        
            this.almacen = almacen;
            this.dormir = dormir;
        }

        public void run() {        

            for (int i = 0; i < 10; i++) {
                almacen.put();
                System.out.println("Turno: " + i + " Productor  pone Una. En Almacen hay:" + almacen.contenido);
                try {
                    sleep(dormir);
                } catch (InterruptedException e) {
                    System.err.println("Error en el productor: " + e.toString());
                }
            }            
        }
    }
}