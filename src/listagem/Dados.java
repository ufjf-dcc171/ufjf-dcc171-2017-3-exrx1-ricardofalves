
package listagem;

import java.util.ArrayList;
import java.util.List;

class Dados {
    private String codigo;
    private List<Evento> eventos;

    public Dados() {
        this(null, null);
    }

    public Dados(String codigo, List<Evento> eventos) {
        this.codigo = codigo;
        this.eventos = eventos;
    }

    Dados(String cod) {
        this.codigo = cod;
        this.eventos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @Override
    public String toString() {
        return this.codigo+" ("+this.eventos.size()+" eventos)";
    }
    
    
    
    
}
