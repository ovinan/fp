package problemaCamareroCliente;

/**
 * Esta clase representa el almacén, es decir, el recurso que se produce y se consume (Versión sincronizada)
 * @author oscar
 */
public class BarraSincronizada {
    private int cervezas;
    private boolean disponible = false;
    
    /**
     * Obtiene el contenido del buffer
     * En este caso, al estar sincronizada, 
     * comprobamos el boolean antes de
     * devolver el valor.
     * Además actualizamos el boolean y
     * notificamos al resto.
     * @return Contenido del buffer
     */
    public synchronized int get() 
    {
        // Mientras el buffer no esté disponible
        while (disponible == false) 
        {
            try 
            {
                // me espero a que produzcan
                wait();
            } 
            catch (InterruptedException e) {}
        }
        // Cuando vuelve a estar disponible, notifico que está disponible
        disponible = false;
        notify();
        return cervezas;
    }
    
    /**
     * Inserta un valor dentro del buffer
     * En este caso, al estar sincronizada, 
     * comprobamos el boolean antes de
     * establecer el valor.
     * Además actualizamos el boolean y
     * notificamos al resto.
     * @param value Valor para insertar
     */
    public synchronized void put(int value) 
    {
        // Mientras el buffer esté disponible
        while (disponible == true) 
        {
            try 
            {
                // me espero a que consuman
                wait();
            } 
            catch (InterruptedException e) {}
        }
        // Cuando vuelve a estar disponible, notifico que está disponible
        cervezas = value;
        disponible = true;
        notify();
    }      
}
