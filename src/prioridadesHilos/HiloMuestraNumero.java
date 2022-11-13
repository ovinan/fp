package prioridadesHilos;

import static java.lang.Thread.sleep;

/**
 *
 * @author oscar
 */
public class HiloMuestraNumero extends Thread{
    String nombre;
    int numero;
    int prioridad;
    int tiempo;
 
    public HiloMuestraNumero(String nombre, int numero, int prioridad) {
        this.nombre = nombre;
        this.numero = numero;
        this.prioridad = prioridad;
    }
 
    @Override
    public void run() {
 
            //prioridad = (int) (Math.random() + 5 + 1);
            tiempo = (int) (Math.random() * 2000) + 1000;
 
            System.out.println("Soy el " + nombre + " mi numero es " + numero + " mi prioridad es " + prioridad + " y voy a dormir " + tiempo + " milisegundos");
 
            try{
                sleep(tiempo);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}