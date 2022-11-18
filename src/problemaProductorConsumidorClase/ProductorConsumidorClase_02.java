package problemaProductorConsumidorClase;

/**
 *
 * COPIA DE LA SOLUCION DADA POR UN ALUMNO AL PROBLEMA DEL PRODUCTOR CONSUMIDOR,
 * UTILIZANDO UN ARRAY Y OPTIMIZANDO LAS VARIABLES
 * 
 * VERSIÓN 2: SINCRONIZANDO (con monitores)
 * 
 */
public class ProductorConsumidorClase_02 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int DORMIR_PRODUCTOR = 1000, DORMIR_CONSUMIDOR = 2150;
        
        Buffer_Almac_02 almacen_02 = new Buffer_Almac_02();
        Productor_02 productor_02 = new Productor_02(almacen_02, DORMIR_PRODUCTOR);
        Consumidor_02 consumidor_02 = new Consumidor_02(almacen_02, DORMIR_CONSUMIDOR);
        
        productor_02.start();
        consumidor_02.start();
    }   
    
    public static class Buffer_Almac_02 {

        public int contenido = 0;

        // VERSIÓN SINCRONIZADA    
        /** 
         * DISMINUYE UN VALOR AL ALMACEN
         */
        public synchronized void get() {
            // MIENTRAS EL BUFFER ESTÉ A CERO ...
            while (contenido<1) {
                try {
                    // ESPERO A QUE AUMENTE EL ALMACEN
                    wait();
                } catch (InterruptedException e) {}
            }
            // CUANDO YA HAY ALGÚN CONTENIDO EN ALMACEN --> NOTIFICO QUE ESTÁ DISPONIBLE PARA TOMAR
            notify();
            // YA PUEDO TOMAR UNA
            contenido = contenido - 1;       
        }

        /**
         * AUMENTA UN VALOR AL ALMACEN
         */
        public synchronized void put()  {
            // MIENTRAS EL BUFFER TENGA AGÚN CONTENIDO ...
            while (contenido>0) {
                try {
                    // ESPERO A QUE SE CONSUMA EL ALMACEN
                    wait();
                } catch (InterruptedException e) {}
            }
            // CUANDO NO HAY NADA EN ALMACEN --> NOTIFICO QUE ESTÁ DISPONIBLE PARA PRODUCIR
            notify();
            // YA PUEDO PONER UNA
            contenido = contenido + 1;
        }    
    }

    public static class Consumidor_02 extends Thread {

        private Buffer_Almac_02 almacen;
        private int dormir;

        /**
         * Constructor del consumidor
         *
         * @param almacen Buffer de donde se obtendrán los recursos
         * @param dormir Tiempo que dormirá el consumidor
         */
        public Consumidor_02(Buffer_Almac_02 almacen, int dormir) {
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
    
    public static class Productor_02 extends Thread {

        private Buffer_Almac_02 almacen;
        private int dormir;

        /**
         * Constructor del productor
         * @param almacen Buffer donde se producirán los recursos
         * @param dormir Tiempo que dormirá el productor
         */
        public Productor_02(Buffer_Almac_02 almacen, int dormir) {        
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
