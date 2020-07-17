
package toten;

import java.net.Socket;
import javax.swing.Timer;


public class Toten {
    
    protected static Socket socket;
    
    public void Toten () {
             
        try {
            Thread intToten = new Thread();
            intToten.start(); 
            
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        try {
            Timer t = new Timer(1000, Cliente.atualizaRelogio);
            t.start();
        } catch (Exception e) {
            e.getStackTrace();
        }   
    }
            
    public static void main(String[] args) {
        // TODO code application logic here 
        TelaConexaoToten telaConxao = new TelaConexaoToten();
        telaConxao.setVisible(true);
            
    }
}