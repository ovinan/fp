package problemaCamareroCliente;

/**
 * Esta clase representa el productor
 * @author oscar
 */
public class Camarero extends Thread {
    private Barra barra;
    private int dormir;
    
    /**
     * Constructor del productor
     * @param barra Buffer donde se producirán los recursos
     * @param dormir Tiempo que dormirá el productor
     */
    public Camarero(Barra barra, int dormir) 
    {
        this.barra = barra;
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
