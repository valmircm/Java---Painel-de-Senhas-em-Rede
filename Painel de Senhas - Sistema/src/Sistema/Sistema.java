package Sistema;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sistema extends Thread{

    protected Date data;
    protected static int num_atend = 0;
    protected String senha, senhaAnt, guiche;
    protected static int id_p = 0;
    protected static int id_n = 0;
    protected static int novaSN = 0, novaSP, proxN = 0, proxP = 0, prefAtivo = 0;
    protected static String bancoSN[] = new String[4000];
    protected static String bancoSP[] = new String[4000];
    
    public void Systema (){}

    public synchronized String gera_SenhaPref() {
        String n = "SP";
        Integer ID = id_p++;
        Integer.toString(ID);
        if (id_p < 10) {
            senha = n + "000" + ID;
        } else if (id_p < 100) {
            senha = n + "00" + ID;
        } else if (id_p < 1000) {
            senha = n + "0" + ID;
        } else {
            senha = n + ID;
            if (id_p > 9999) {
                id_p = 0;
            }
        }
        bancoSP[novaSP] = senha;
        prefAtivo++;
        System.out.println("Senha Preferencial gerada: " +senha); // Ir para arquivo ou uma lista
        return senha;
    }

    public synchronized String gera_SenhaNormal() {
        String n = "SN";
        Integer ID = id_n++;
        Integer.toString(ID);
        if (id_n < 10) {
            senha = n + "000" + ID;
        } else if (id_n < 100) {
            senha = n + "00" + ID;
        } else if (id_n < 1000) {
            senha = n + "0" + ID;
        } else {
            senha = n + ID;
            if (id_n > 9999) {
                id_n = 0;
            }
        }
        bancoSN[novaSN] = senha;
        System.out.println("Senha Normal gerada: " +senha); // ir para arquivo ou uma lista
        return senha;
    }
    
    public synchronized String getNewSenha (String guiche) {
        String newSenha = null;

        if (prefAtivo == 0) {
            if (bancoSN[proxN] != null) {
                newSenha = bancoSN[proxN];
                proxN++;
                enviaSenhaPainel(newSenha, guiche);
                return newSenha;
            } else {
                return (newSenha = "Sem senhas");
            }
        } else {
            if (bancoSP[proxP] != null ) {
                newSenha = bancoSP[proxP];
                proxP++;
                prefAtivo--;
                enviaSenhaPainel(newSenha, guiche);
                return newSenha;
            }
        }
        return newSenha = "Sem senhas";
    }
    
    public synchronized void enviaSenhaPainel(String senha, String guiche) {
        
        String msgIn = null;
        String msgOut = senha;
        
        msgOut = msgOut +";";
        msgOut = msgOut + guiche;
        
        Socket sPainel;
        
        try {
            sPainel = new Socket("127.0.0.1", 8087);
            
            ObjectOutputStream output = new ObjectOutputStream(sPainel.getOutputStream());
            output.writeObject(msgOut);
            System.out.println("Enviado ao Painel: "+msgOut);
            output.flush();           
            
            ObjectInputStream input = new ObjectInputStream(sPainel.getInputStream());

            try {
                msgIn = (String) input.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("Painel diz: "+msgIn);

            
        } catch (IOException e) { 
            JOptionPane.showMessageDialog(null, "Não foi possível enviar a mensagem ao Paineldor\n"
                + "Contate o administrador do sistema");           
            System.exit(0);
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
                
//        Runnable clienteToten = new GerenciaToten();
        new GerenciaToten().start();
        
//        Runnable clienteGuiche = new GerenciaGuiche();
        new GerenciaGuiche().start();
        
    }

}

class GerenciaToten extends Sistema implements Runnable{

    public GerenciaToten() {} 
    
    private ServerSocket ssToten;
    private Socket sToten;
    private String codigo;
        
    @Override
    public void run() {
        String msgIn = null;
        String msgOut = null;

        try {
            ssToten = new ServerSocket(8085);
        } catch (IOException ex) {
            Logger.getLogger(GerenciaToten.class.getName()).log(Level.SEVERE, null, ex);
        }            
        while (true) {        
            try {
                sToten = ssToten.accept();           
                System.out.println("Cliente conectado, socket: "+sToten);
                
                ObjectInputStream input = new ObjectInputStream(sToten.getInputStream());
                try {
                    msgIn = (String) input.readObject();
                    System.out.println("Toten diz: "+msgIn);

                    GerenciaToten toten = new GerenciaToten();                   
                    toten.codigo = msgIn;

                    switch (toten.codigo) {
                        case "2001":
                            msgOut = gera_SenhaNormal();
                            novaSN++;
                            break;
                        case "2002":
                            msgOut = gera_SenhaPref();
                            novaSP++;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Código recebido invalido: "+toten.codigo);
                    }

                    ObjectOutputStream output = new ObjectOutputStream(sToten.getOutputStream());
                    output.writeObject(msgOut);
                    System.out.println("Enviado ao toten: "+msgOut);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Cliente toten não conectado.\nContate o administrador do sistema.");
                System.exit(0);
                e.getStackTrace();
            }
        }        
    }    
}

class GerenciaGuiche extends Sistema implements Runnable {
   
    private ServerSocket ssGuiche;
    private Socket sGuiche;
    private String codigo;

    public GerenciaGuiche() {}
        
    @Override
    public void run() {
        String msgIn = null;
        String msgOut = null;
        
        try {
            ssGuiche = new ServerSocket(8086);
        } catch (IOException ex) {
            Logger.getLogger(GerenciaGuiche.class.getName()).log(Level.SEVERE, null, ex);
        }

        while (true) {        
            try {
                sGuiche = ssGuiche.accept();           
                System.out.println("Cliente conectado, socket: "+sGuiche);
                
                ObjectInputStream input = new ObjectInputStream(sGuiche.getInputStream());
                try {
                    msgIn = (String) input.readObject();
                    System.out.println("Guiche diz: "+msgIn);
                    
                    String texto = "valor1;valor2;valor3";
                    String array[] = new String[3];
                    array = msgIn.split(";");

                    GerenciaGuiche gGuiche = new GerenciaGuiche();
                    
                    gGuiche.codigo = array[0];
                    gGuiche.guiche = array[1];
                    gGuiche.senhaAnt  = array[2];
                    
                    Relatorio relatorio = new Relatorio();
                    
                    switch (gGuiche.codigo) {
                        case "1001":
                            msgOut = getNewSenha(gGuiche.guiche);
                            gGuiche.senha = msgOut;
                            System.out.println("N atend: "+num_atend);
                            relatorio.inicia_Atend(gGuiche, num_atend);
                            if (gGuiche.senhaAnt != "Aguardando Senha") {
                                relatorio.encerra_Atend(gGuiche.senhaAnt, num_atend);
                            }
                            num_atend++;                           
                            break;
                        case "1002":                                                       
                            relatorio.encerra_Atend(gGuiche.senhaAnt, num_atend);                           
                            break;
                        case "1003":                           
                            Relatorio r = new Relatorio();
                            r.gerar_Relatorio(num_atend);
                            
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Código recebido invalido: "+gGuiche.codigo);
                    }

                    ObjectOutputStream output = new ObjectOutputStream(sGuiche.getOutputStream());
                    output.writeObject(msgOut);
                    System.out.println("Enviado ao Guiche: "+msgOut);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Cliente Guiche não conectado.\nContate o administrador do sistema.");
                System.exit(0);
                e.getStackTrace();
            }
        }       
    }   
}