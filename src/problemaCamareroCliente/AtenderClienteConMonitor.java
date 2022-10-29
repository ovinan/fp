package problemaCamareroCliente;

/**
 *
 * @author oscar
 */
public class AtenderClienteConMonitor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final int DORMIR_CAMARERO = 1000, DORMIR_CLIENTE = 2000;
        
        BarraSincronizada barraSincronizada = new BarraSincronizada();
        CamareroNuevaBarra camarero = new CamareroNuevaBarra(barraSincronizada, DORMIR_CAMARERO);
        ClienteNuevaBarra cliente = new ClienteNuevaBarra(barraSincronizada, DORMIR_CLIENTE);
        
        camarero.start();
        cliente.start();
    }    
}
