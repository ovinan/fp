/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaCamareroCliente;

/**
 * Esta clase representa el consumidor
 * @author oscar
 */
public class ClienteNuevaBarra extends Thread 
{
    private BarraSincronizada barra;
    private int dormir;
    
    /**
     * Constructor del consumidor
     * @param barra Buffer de donde se obtendrán los recursos
     * @param dormir Tiempo que dormirá el consumidor
     */
    public ClienteNuevaBarra(BarraSincronizada barraSincronizada, int dormir) 
    {
        this.barra = barraSincronizada;
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
