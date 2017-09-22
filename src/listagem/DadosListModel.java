
package listagem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class DadosListModel implements ListModel<Dados> {
    private final List<Dados> dados;
    private final List<ListDataListener> dataListener;
    
    public DadosListModel(List<Dados> dados) {
        this.dados = dados;
        this.dataListener = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return dados.size();
    }

    @Override
    public Dados getElementAt(int index) {
        return dados.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListener.remove(l);
    }
    
}
