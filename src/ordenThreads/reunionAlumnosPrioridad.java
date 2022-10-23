package ordenThreads;

/**
 * Ejemplo sencillo para ilustrar diferentes resultados de ejecucion.
 * @author oscar
 */
public class reunionAlumnosPrioridad {
    public static void main(String args[]) throws InterruptedException{

        Thread juan = new Thread (new Alumno("Juan"));
        Thread luis = new Thread (new Alumno("Luis"));
        Thread rosa = new Thread (new Alumno("Rosa"));

        juan.setPriority(Thread.MIN_PRIORITY);
        luis.setPriority(Thread.MAX_PRIORITY);
        rosa.setPriority(Thread.NORM_PRIORITY);
        
        juan.start();
        luis.start();
        rosa.start();
    }  
}
/**
 * Clase Alumno, implementando Runnable para poder hacer Threads
 */
class Alumno implements Runnable{
    String mensaje;

    public Alumno(String nombre){
        mensaje = "Hola, soy " + nombre + " y este es mi mensaje numero: ";
    }

    @Override
    public void run(){
        for (int i=1; i<6;i++){
            String msj = mensaje + i;
            System.out.println(msj);
        }    
    }
}
