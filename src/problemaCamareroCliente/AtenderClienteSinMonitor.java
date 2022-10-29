package problemaCamareroCliente;

/**
 *
 * @author oscar
 */
public class AtenderClienteSinMonitor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        final int DORMIR_CAMARERO = 1000, DORMIR_CLIENTE = 2000;
        
        Barra barra = new Barra();
        Camarero camarero = new Camarero(barra, DORMIR_CAMARERO);
        Cliente cliente = new Cliente(barra, DORMIR_CLIENTE);
        
        camarero.start();
        cliente.start();
    }    
}
