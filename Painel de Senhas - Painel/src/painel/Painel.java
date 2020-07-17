
package painel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Painel{
    
    private static ServerSocket serverSocket;
    private static Socket socket;
    private String lista[][] = new String[4][2];
    
      
    public static void main(String[] args) throws IOException {
        
        String msgIn = null;
        String msgOut = null;
        
        serverSocket = new ServerSocket(8087);
        TelaPainel tPainel = new TelaPainel();
        tPainel.setVisible(true);
        
        while (true) {
        
            try {
                socket = serverSocket.accept();           
                System.out.println("Cliente conectado, socket: "+socket);
                
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                try {
                    msgIn = (String) input.readObject();
                    System.out.println("Servidor diz: "+msgIn);

                    String texto = "valor1;valor2";
                    String array[] = new String[2];
                    array = msgIn.split(";");

                    tPainel.senha = array[0];
                    tPainel.guiche = array[1];

                    msgOut = tPainel.atualizaPainel(tPainel.senha, tPainel.guiche);

                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(msgOut);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Cliente não conectado.\nContate o administrador do sistema.");
                System.exit(0);
                e.getStackTrace();
            }

        }
    }
    
}
