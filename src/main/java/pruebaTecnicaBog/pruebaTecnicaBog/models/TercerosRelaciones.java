package pruebaTecnicaBog.pruebaTecnicaBog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * Tabla que almacena la relacion de un tercero con otro.
 * @author Manuel Fernando Barba Villamizar
 */

@Document(collection = "tercerosrelaciones")
public class TercerosRelaciones {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;
    private String idTercero;
    private String idTerceroRelacionado;
    private Integer idRelacion;
    private Boolean indicadorHabilitado;
    private Date fechaCreacion;

    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getIdTercero() { return idTercero; }

    public void setIdTercero(String idTercero) { this.idTercero = idTercero; }

    public String getIdTerceroRelacionado() { return idTerceroRelacionado; }

    public void setIdTerceroRelacionado(String idTerceroRelacionado) { this.idTerceroRelacionado = idTerceroRelacionado; }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Boolean getIndicadorHabilitado() {
        return indicadorHabilitado;
    }

    public void setIndicadorHabilitado(Boolean indicadorHabilitado) {
        this.indicadorHabilitado = indicadorHabilitado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
