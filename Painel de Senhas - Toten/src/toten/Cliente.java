package toten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente extends javax.swing.JFrame {

    private String senha;
    private String ip;
    private int porta;
    private Socket socket;
    
    public Cliente() {
        
        setVisible(true);
        initComponents();
    }
    
    public void Cliente (String ip, String porta){
        this.ip = ip;
        this.porta = Integer.parseInt(porta);        
    }

    //Recebe e escreve no buffeer
    public void sendMessage(String msgOut) {
        
        String msgIn = null;
        
        try {
            socket = new Socket(this.ip, this.porta);
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(msgOut);
            output.flush();
            
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            try {
                msgIn = (String) input.readObject();
                System.out.println("Servidor diz: "+msgIn);
                JOptionPane.showMessageDialog(null, "Senha gerada: "+msgIn);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException e) { 
            JOptionPane.showMessageDialog(null, "Não foi possível enviar a mensagem ao servidor\n"
                + "Contate o administrador do sistema");           
            System.exit(0);
            e.getStackTrace();
        }
    }

    public void getSenha (String tipo) {
        
        System.out.println(tipo);
        sendMessage(tipo);
  
    }  
    static ActionListener atualizaRelogio = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a custom component
            //jLabel1.setText(String.valueOf(System.currentTimeMillis()));
            // OR
            // Assumes clock is a JLabel
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
           Date date = new Date();
           hora.setText(dateFormat.format(date));
        }
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        Toten = new javax.swing.JInternalFrame();
        senhaNormal = new javax.swing.JButton();
        senhaPref = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Toten.setForeground(new java.awt.Color(255, 142, 0));
        Toten.setTitle("JAVN Tecnologia em Atendimento");
        Toten.setFrameIcon(null);
        Toten.setVisible(true);

        senhaNormal.setText("Atendimento Normal");
        senhaNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaNormalActionPerformed(evt);
            }
        });

        senhaPref.setText("Atendimento Preferencial");
        senhaPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaPrefActionPerformed(evt);
            }
        });

        jLabel1.setText("Escolha a opção de atendimento e aguarde a impressão da senha");

        javax.swing.GroupLayout TotenLayout = new javax.swing.GroupLayout(Toten.getContentPane());
        Toten.getContentPane().setLayout(TotenLayout);
        TotenLayout.setHorizontalGroup(
            TotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TotenLayout.createSequentialGroup()
                .addGroup(TotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TotenLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(TotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(senhaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaPref, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TotenLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        TotenLayout.setVerticalGroup(
            TotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TotenLayout.createSequentialGroup()
                .addGroup(TotenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TotenLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TotenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addComponent(senhaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(senhaPref, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Toten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Toten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void senhaNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaNormalActionPerformed
        // TODO add your handling code here:
        getSenha("2001");
    }//GEN-LAST:event_senhaNormalActionPerformed

    private void senhaPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaPrefActionPerformed
        // TODO add your handling code here:
        getSenha("2002");
    }//GEN-LAST:event_senhaPrefActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Toten;
    private static javax.swing.JLabel hora;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton senhaNormal;
    private javax.swing.JButton senhaPref;
    // End of variables declaration//GEN-END:variables
}
