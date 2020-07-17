package Sistema;

import java.awt.HeadlessException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Relatorio {
    
    private static String banco_dados[][] = new String [4000][5];
    
    private String getDateTime() {
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }

    public synchronized void inicia_Atend(Sistema atendimento, int num_atend ) { 
        
        banco_dados[num_atend][0] = ("| Nº: "+num_atend);
        banco_dados[num_atend][1] = (" | Senha: "+atendimento.senha);
        banco_dados[num_atend][2] = (" | Guiche: "+atendimento.guiche);
        banco_dados[num_atend][3] = (" | Inicio Atendimento: "+getDateTime()+"\n");        
    }
    
    public synchronized void encerra_Atend(String senhaAnt, int num_Atend) {
        
        for (int i = 0; i <= num_Atend; i++) {
            if (banco_dados[i][1].equals(senhaAnt)){
                banco_dados[i][4] = (" | Fim do atendimento: "+getDateTime()+" |\n");
                System.out.println("Atendimento encerrado: "+banco_dados[i][0]+banco_dados[i][1]+banco_dados[i][2]+banco_dados[i][3]
                    +banco_dados[i][4]);
            }
        }        
    }

    public synchronized void gerar_Relatorio(int num_atend) {
        try {
            // o true significa q o arquivo será constante
            FileWriter x = new FileWriter("C:\\Users\\USER\\Desktop\\relatorio.txt", true);
            for (int i = 0; i <= num_atend; i++) {
                    x.write(banco_dados[i][0]+banco_dados[i][1]+banco_dados[i][2]+banco_dados[i][3]
                    +banco_dados[i][4]+"\n"); // armazena o texto no objeto x, que aponta para o arquivo                                                 
            }
            x.close(); // cria o arquivo 
            System.out.println(x);        
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        } // em caso de erro apreenta mensagem abaixo
        catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
}