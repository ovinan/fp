/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaCamareroCliente;

/**
 * Esta clase representa el consumidor
 * @author oscar
 */
public class Cliente extends Thread 
{
    private Barra barra;
    private int dormir;
    
    /**
     * Constructor del consumidor
     * @param barra Buffer de donde se obtendrán los recursos
     * @param dormir Tiempo que dormirá el consumidor
     */
    public Cliente(Barra barra, int dormir) 
    {
        this.barra = barra;
        this.dormir = dormir;
    }
    @Override 
    public void run() 
    {
        int valor = 0;
        for (int i = 0; i < 10; i++) 
        {
            valor = barra.get();
            System.out.println("Cliente se toma la cerveza numero: "+ valor);
            try 
            {
                sleep(dormir);
            }
            catch (InterruptedException e) 
            {
                System.err.println("Error en el cliente: " + e.toString());
            }
        }
    }
}
