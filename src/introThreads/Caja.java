package introThreads;

/**
 * Incluye el metodo procesarCompra, que recibe al Cliente (con sus productos) y en que momento del tiempo inicia su atencion.
 * El metododo mostrara en pantalla cuando empieza a procesar el cliente, y cada uno de sus productos.
 * Internamente tambien tiene un metodo para esperar (con sleep) los segundos necesarios.
 * 
 * @author oscar
 */
public class Caja {
    private String nombre;
    // Constructor, getters y setters
    public Caja() {
    }

    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Procesado de la compra en la caja
    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La caja " + this.nombre + 
            " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + 
            " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
            "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println(this.nombre + " ha procesado el producto " + (i + 1) + 
                " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
                "seg");
        }

        System.out.println("La caja " + this.nombre + " HA TERMINADO DE PROCESAR " + 
            cliente.getNombre() + " EN EL TIEMPO: " + 
            (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
