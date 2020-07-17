package painel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class TelaPainel extends javax.swing.JFrame {

    private Socket socket;
    public String senha;
    public String guiche;

    
    public TelaPainel(){
        
        Timer t = new Timer(1000, TelaPainel.atualizaRelogio);
        t.start();
        initComponents();
    }
    
    public TelaPainel(Socket socket) {
        this.socket = socket;        
    }

    public String atualizaPainel(String senha, String guiche) {
        
        senha5.setText(senha4.getText());
        guiche5.setText(guiche4.getText());
        
        senha4.setText(senha3.getText());
        guiche4.setText(guiche3.getText());
        
        senha3.setText(senha2.getText());
        guiche3.setText(guiche2.getText());
        
        senha2.setText(proxSenha.getText());
        guiche2.setText(proxGuiche.getText());

        proxSenha.setText(senha);
        proxGuiche.setText(guiche);
        return "ack";
    }
      
    public void recebeEnvia() {   
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        PainelAtendimento = new javax.swing.JInternalFrame();
        hora = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        senha2 = new javax.swing.JLabel();
        guiche2 = new javax.swing.JLabel();
        senha3 = new javax.swing.JLabel();
        guiche3 = new javax.swing.JLabel();
        senha4 = new javax.swing.JLabel();
        guiche4 = new javax.swing.JLabel();
        senha5 = new javax.swing.JLabel();
        guiche5 = new javax.swing.JLabel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        proxSenha = new javax.swing.JLabel();
        proxGuiche = new javax.swing.JLabel();

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

        PainelAtendimento.setBackground(new java.awt.Color(255, 255, 255));
        PainelAtendimento.setForeground(new java.awt.Color(255, 142, 0));
        PainelAtendimento.setTitle("JAVN Tecnologia em Atendimento");
        PainelAtendimento.setFrameIcon(null);
        PainelAtendimento.setName(""); // NOI18N
        PainelAtendimento.setVisible(true);

        hora.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hora.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jInternalFrame1.setTitle("Ultimas Senhas Chamadas\n");
        jInternalFrame1.setVisible(true);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("SENHA:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("GUICHÊ:");

        senha2.setBackground(new java.awt.Color(255, 255, 204));
        senha2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guiche2.setBackground(new java.awt.Color(255, 255, 204));
        guiche2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        senha3.setBackground(new java.awt.Color(255, 255, 204));
        senha3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guiche3.setBackground(new java.awt.Color(255, 255, 204));
        guiche3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        senha4.setBackground(new java.awt.Color(255, 255, 204));
        senha4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guiche4.setBackground(new java.awt.Color(255, 255, 204));
        guiche4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        senha5.setBackground(new java.awt.Color(255, 255, 204));
        senha5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        guiche5.setBackground(new java.awt.Color(255, 255, 204));
        guiche5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(senha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senha3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senha4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(senha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guiche5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(guiche4, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(guiche3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guiche2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guiche2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(guiche3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guiche4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(senha3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(senha4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(senha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guiche5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jInternalFrame3.setTitle("PRÓXIMA SENHA");
        jInternalFrame3.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("SENHA:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("GUICHÊ");

        proxSenha.setBackground(new java.awt.Color(255, 255, 204));
        proxSenha.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        proxSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        proxGuiche.setBackground(new java.awt.Color(255, 255, 204));
        proxGuiche.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        proxGuiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(21, 21, 21))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(proxSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proxGuiche, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                .addContainerGap())
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(proxGuiche, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelAtendimentoLayout = new javax.swing.GroupLayout(PainelAtendimento.getContentPane());
        PainelAtendimento.getContentPane().setLayout(PainelAtendimentoLayout);
        PainelAtendimentoLayout.setHorizontalGroup(
            PainelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelAtendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PainelAtendimentoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelAtendimentoLayout.createSequentialGroup()
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jInternalFrame3)))
                .addContainerGap())
        );
        PainelAtendimentoLayout.setVerticalGroup(
            PainelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelAtendimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(PainelAtendimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelAtendimento)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelAtendimento)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
static ActionListener atualizaRelogio = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            // Assumes clock is a custom component
            //jLabel1.setText(String.valueOf(System.currentTimeMillis()));
            // OR
            // Assumes clock is a JLabel
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
           Date date = new Date();
           hora.setText(dateFormat.format(date)); 
        }
    };


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame PainelAtendimento;
    private javax.swing.JLabel guiche2;
    private javax.swing.JLabel guiche3;
    private javax.swing.JLabel guiche4;
    private javax.swing.JLabel guiche5;
    private static javax.swing.JLabel hora;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel proxGuiche;
    private javax.swing.JLabel proxSenha;
    private javax.swing.JLabel senha2;
    private javax.swing.JLabel senha3;
    private javax.swing.JLabel senha4;
    private javax.swing.JLabel senha5;
    // End of variables declaration//GEN-END:variables
}
