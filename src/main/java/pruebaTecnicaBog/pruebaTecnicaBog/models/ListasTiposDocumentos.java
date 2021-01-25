package pruebaTecnicaBog.pruebaTecnicaBog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * Tabla que almacena los valores configurados para los tipos de documentos que un tercero podria tener.
 * @author Manuel Fernando Barba Villamizar
 */

@Document(collection = "listastiposdocumentos")
public class ListasTiposDocumentos {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;
    private String nombre;
    private String codigo;
    private Boolean indicadorHabilitado;
    private Date fechaCreacion;

    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getIndicadorHabilitado() {
        return indicadorHabilitado;
    }

    public void setIndicadorHabilitado(Boolean indicadorHabilitado) {
        this.indicadorHabilitado = indicadorHabilitado;
    }

    public Date getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
