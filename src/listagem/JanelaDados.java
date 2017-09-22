
package listagem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


class JanelaDados extends JFrame {
    private final List<Dados> dados;
    private final JList<Dados> lstDados = new JList<>(new DefaultListModel<>());
    private final JList<Evento> lstEventos = new JList<>(new DefaultListModel<>());
    private final JButton criaDados = new JButton("Cria dados");
    private final JButton excluiDados = new JButton("Excluir dados");
    private final JButton criaEvento = new JButton("Cria evento");
    private final JButton excluiEvento = new JButton("Excluir evento");
    private final JanelaEvento janelaEvento = new JanelaEvento();
    
    public JanelaDados(List<Dados> sampleData) {
        super("Dados");
        setMinimumSize(new Dimension(500, 350));
        this.dados = sampleData;
        lstDados.setModel(new DadosListModel(dados));
        add(new JScrollPane(lstDados), BorderLayout.WEST);
        add(new JScrollPane(lstEventos), BorderLayout.CENTER);
        JPanel botoes = new JPanel(new GridLayout(1, 4));
        add(botoes,BorderLayout.SOUTH);
        botoes.add(criaDados);
        botoes.add(excluiDados);
        botoes.add(criaEvento);
        botoes.add(excluiEvento);
        
        lstDados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstDados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Dados selecionada = lstDados.getSelectedValue();
                if (selecionada != null) {
                    System.out.println(selecionada);
                    lstEventos.setModel(new EventosListModel(selecionada.getEventos()));
                } else {
                    lstEventos.setModel(new DefaultListModel<>());
                }
            }
        });
        criaDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Código novo");
                if(cod!= null && !cod.isEmpty()){
                    Dados t = new Dados(cod);
                    dados.add(t);
                    lstDados.updateUI();
                }
            }
        });
        excluiDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstDados.isSelectionEmpty()) return;
                dados.remove(lstDados.getSelectedValue());
                lstDados.clearSelection();
                lstDados.updateUI();
            }
        });
        janelaEvento.setJanelaDados(this);
        
        criaEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaEvento.setLocationRelativeTo(null);
                janelaEvento.setVisible(true);
                janelaEvento.solicitaNovoEvento();
            }
        });
    }
    
    public void adicionaEvento(Evento a){
        lstDados.getSelectedValue().getEventos().add(a);
        lstDados.updateUI();
        lstEventos.updateUI();
        janelaEvento.setVisible(false);
    }
    
    
}

  
   
