package problemaCamareroCliente;

/**
 * Esta clase representa el productor
 * @author oscar
 */
public class CamareroNuevaBarra extends Thread {
    private BarraSincronizada barra;
    private int dormir;
    
    /**
     * Constructor del productor
     * @param barra Buffer donde se producirán los recursos
     * @param dormir Tiempo que dormirá el productor
     */
    public CamareroNuevaBarra(BarraSincronizada barraSincronizada, int dormir) 
    {
        this.barra = barraSincronizada;
        this.dormir = dormir;
    }
    @Override
    public void run() 
    {
        for (int i = 0; i < 10; i++) 
        {
            barra.put(i);
            System.out.println("El camarero pone la cerveza numero: " + i);
            try 
            {
                sleep(dormir);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Error en el camarero: " + e.toString());
            }
        }
    }
}
