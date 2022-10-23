package introThreads;

/**
 * La unica diferencia con la clase Caja.java es que en lugar del metodo procesarCompra, se hace en el run.
 * El run de la clase sobreescribe al de la clase, que viene heredado de Thread.
 * 
 * @author oscar
 */
public class CajaThread extends Thread {
    private String nombre;

    private Cliente cliente;

    private long initialTime;


    public CajaThread() {
    }

    public CajaThread(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " 
            + this.cliente.getNombre() + " EN EL TIEMPO: " 
            + (System.currentTimeMillis() - this.initialTime) / 1000 
            + "seg");

        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            // Se procesa el pedido en X segundos
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println(this.nombre + " ha procesado el producto " + (i + 1) 
                + " del cliente " + this.cliente.getNombre() + "->Tiempo: " 
                + (System.currentTimeMillis() - this.initialTime) / 1000 
                + "seg");
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " 
            + this.cliente.getNombre() + " EN EL TIEMPO: " 
            + (System.currentTimeMillis() - this.initialTime) / 1000 
            + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
