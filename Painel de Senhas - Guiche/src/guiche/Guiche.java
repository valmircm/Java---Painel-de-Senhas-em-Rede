package painel.de.senhas.guiche;

import java.net.Socket;
import java.util.Date;
import javax.swing.Timer;

public class Guiche extends Thread {

    protected int num;
    protected Date data;
    protected static Socket socket;
    
    public void Guiche () {
        
        try {
            Thread intGuiche = new Thread();
            intGuiche.start(); 
            
        } catch (Exception e) {
            e.getStackTrace();
        } 
        
        try {
            Timer t = new Timer(1000, Interface_Guiche.atualizaRelogio);
            t.start();
        } catch (Exception e) {
            e.getStackTrace();
        }               
    }

    public static void main(String[] args) {
        
        TelaConexaoGuiche telaConxao = new TelaConexaoGuiche();
        telaConxao.setVisible(true);
    }
}