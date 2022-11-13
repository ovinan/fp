package problemaProductorConsumidorCajero;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class ProductorConsumidorCajero {
    public static void main(String args[]) {
       System.out.println("Ejecucion NO sincronizada");        
       SaldoNoSincro saldoNoSincro = new SaldoNoSincro();
       AhorradorNoSincro ahorradorNoSincro = new AhorradorNoSincro(saldoNoSincro);
       DespilfarradorNoSincro despilfarradorNoSincro = new DespilfarradorNoSincro(saldoNoSincro);       
      
//       System.out.println("Ejecucion sincronizada");
//       SaldoSincro saldoSincro = new SaldoSincro();
//       new Ahorrador(saldoSincro);
//       new Despilfarrador(saldoSincro);

    }    

    public static class SaldoNoSincro {
       int importe;      
       
       int gasto(int n) {
          if(this.importe > n){
            this.importe = this.importe - n;
            System.out.println("Saco : " + n + " y quedan " + importe);
          }
          return importe;
       }

       void ingreso(int n) {
          this.importe = this.importe + n;
          System.out.println("Ingreso: " + n + " y quedan " + importe);
       }
       
       void cargaInicial(int n) {
          this.importe = n;
          System.out.println("Ingreso inicial: " + n);
       }       
    }
    public static class AhorradorNoSincro implements Runnable {
       SaldoNoSincro saldo;
       AhorradorNoSincro(SaldoNoSincro saldo) {
          this.saldo = saldo;
          new Thread(this, "Productor").start();
       }

       public void run() {
          saldo.cargaInicial(50);
          for (int i = 0; i < 10; i++) {
             saldo.ingreso((int) (Math.random() * 50));
             try {
                // Esperamos entre 0 y 4 segundos
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }
          }
       }
    }

    public static class DespilfarradorNoSincro implements Runnable {
        SaldoNoSincro saldo;
        DespilfarradorNoSincro(SaldoNoSincro q) {
           this.saldo = q;
           new Thread(this, "Consumidor").start();
        }
        public void run() {
        for (int i = 0; i < 10; i++) {
           saldo.gasto((int) (Math.random() * 50));
            try {
                // Esperamos entre 0 y 4 segundos
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }           
        }
      }
    }     
    // AQUI EMPIEZAN LAS CLASES SINCRONIZADAS (MONITOR)
    public static class SaldoSincro {
       int importe;      
       boolean disponible = false; // Disponible es el boolean que nos indica si el cajero esta bloqueado
       
       synchronized int gasto(int n) {
          if(!disponible)
            try {
               wait();
            } catch(InterruptedException e) {
               System.out.println("Error! "+e );
            }
          if(this.importe > n){
              this.importe = this.importe - n;
              System.out.println("(Sincronizado) Saco : " + n + " y quedan " + importe);
          }
          disponible = false;
          notify();
          return importe;
       }

       synchronized void ingreso(int n) {
          if(disponible)
            try {
               wait();
            } catch(InterruptedException e) {
               System.out.println("Error! "+e );
            }
          this.importe = this.importe + n;
          disponible = true;
          System.out.println("(Sincronizado) Ingreso: " + n + " y quedan " + importe);
          notify();
       }
       
       synchronized void cargaInicial(int n) {
          if(disponible)
            try {
               wait();
            } catch(InterruptedException e) {
               System.out.println("Error! "+e );
            }
          this.importe = n;
          disponible = true;
          System.out.println("(Sincronizado) Ingreso inicial: " + n);
          notify();
       }       
    }

    public static class Ahorrador implements Runnable {
       SaldoSincro saldo;
       Ahorrador(SaldoSincro saldo) {
          this.saldo = saldo;
          new Thread(this, "Productor").start();
       }

       public void run() {
          saldo.cargaInicial(50);
          for (int i = 0; i < 10; i++) {
             saldo.ingreso((int) (Math.random() * 50));
             try {
                // Esperamos entre 0 y 4 segundos
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }
          }
       }
    }

    public static class Despilfarrador implements Runnable {
        SaldoSincro saldo;
        Despilfarrador(SaldoSincro q) {
           this.saldo = q;
           new Thread(this, "Consumidor").start();
        }
        public void run() {
        for (int i = 0; i < 10; i++) {
           saldo.gasto((int) (Math.random() * 50));
            try {
                // Esperamos entre 0 y 4 segundos
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { }           
        }
      }
    }  
}
