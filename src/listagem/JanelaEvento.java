
package listagem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JanelaEvento extends JFrame {
    private final JLabel lblLatitude = new JLabel("Latitude");
    private final JLabel lblLongitude = new JLabel("Longitude");
    private final JLabel lblDescricao = new JLabel("Descrição");
    private final JLabel lblDataHora = new JLabel("Data - Hora");
    private final JTextField txtLatitude = new JTextField(30);
    private final JTextField txtLongitude = new JTextField(30);
    private final JTextField txtDescricao = new JTextField(30);
    private final JTextField txtHoraData = new JTextField(30);
    private final JButton ok = new JButton("OK");
    private JanelaDados janelaDados;

    public JanelaEvento() throws HeadlessException {
        super("Cria novo evento");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(2,2));
        principal.add(lblLatitude);
        principal.add(txtLatitude);
        principal.add(lblLongitude);
        principal.add(txtLongitude);
        principal.add(lblDescricao);
        principal.add(txtDescricao);
        principal.add(lblDataHora);
        principal.add(txtHoraData);
        add(principal, BorderLayout.CENTER);
        add(ok, BorderLayout.SOUTH);
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                if (!txtLatitude.getText().isEmpty() && !txtLongitude.getText().isEmpty()
                        && !txtDescricao.getText().isEmpty() && !txtHoraData.getText().isEmpty()) {
                    Evento e = new Evento();
                    e.setLatitude(txtLatitude.getText());
                    e.setLongitude(txtLongitude.getText());
                    e.setDescricao(txtDescricao.getText());
                    DateFormat df = new SimpleDateFormat("dd/mm/yyyy kk:mm");
                    try {
                        e.setDataHora(df.parse(txtHoraData.getText()));
                    } catch (ParseException ex) {
                        Logger.getLogger(JanelaEvento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    janelaDados.adicionaEvento(e);                   
                
                }
            }
        });
    }
    public void setJanelaDados(JanelaDados janela){
        this.janelaDados = janela;
    }
    
    void solicitaNovoEvento(){
            setLocationRelativeTo(null);
            setVisible(true);
            txtLatitude.setText("");
            txtLatitude.requestFocus();
            txtLongitude.setText("");
            txtDescricao.setText("");
            txtHoraData.setText("");
            
    }
    
    public void editaEvento(){
        
    }
    
}
