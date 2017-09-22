
package listagem;

import java.util.List;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

public class Listagem {

    
    public static void main(String[] args) {
        JanelaDados janela = new JanelaDados(getSampleData());
        janela.setSize(500, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    private static List<Dados> getSampleData() {
        Date data = new Date(2017, 9, 03);
        Evento e1 = new Evento("123123", "3132312", "descrição 1", data);
        Evento e2 = new Evento("231561", "4984", "descrição 2", data);
        
        Dados d1 = new Dados("dados 1");
        Dados d2 = new Dados("dados 2");
        
        d1.getEventos().add(e1);
        d1.getEventos().add(e2);
        d2.getEventos().add(e2);
        List<Dados> dados = new ArrayList<>();
        dados.add(d1);
        dados.add(d2);
        return dados;
    }
    
   
}

