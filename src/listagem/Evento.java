
package listagem;

import java.util.Date;

class Evento {
    private String latitude;
    private String longitude;
    private String descricao;
    private Date dataHora;

    public Evento() {
        this(null, null, null, null);
    }

    public Evento(String latitude, String longitude, String descricao, Date dataHora) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return latitude + ": " + longitude + ": " + descricao;
    }
    
    
}
