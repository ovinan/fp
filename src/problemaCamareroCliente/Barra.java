package problemaCamareroCliente;

/**
 * Esta clase representa el almacén, es decir, el recurso que se produce y se consume (Versión no sincronizada)
 * @author oscar
 */
public class Barra {
    private int cervezas;
    
    /**
     * Obtiene el contenido del buffer
     * @return Contenido del buffer
     */
    public int get() 
    {
        return cervezas;
    }
    
    /**
     * Inserta un valor dentro del buffer
     * @param value Valor para insertar
     */
    public void put(int value) 
    {
        cervezas = value;
    }      
}
