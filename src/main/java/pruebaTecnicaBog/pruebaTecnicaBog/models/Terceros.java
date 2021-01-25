package pruebaTecnicaBog.pruebaTecnicaBog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

/**
 * Tabla que almacena toda la informacion basica de un tercero.
 * @author Manuel Fernando Barba Villamizar
 */

@Document(collection = "terceros")
public class Terceros {
    @Id
    @MongoId(value = FieldType.OBJECT_ID)
    private String _id;
    private Integer idTipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String idGenero;
    private String idRH;
    private String idEstadoCivil;
    private Boolean indicadorHabilitado;
    private Date fechaCreacion;

    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public Integer getIdTipoDocumento() { return idTipoDocumento; }

    public void setIdTipoDocumento(Integer idTipoDocumento) { this.idTipoDocumento = idTipoDocumento; }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getIdGenero() { return idGenero; }

    public void setIdGenero(String idGenero) { this.idGenero = idGenero; }

    public String getIdRH() { return idRH; }

    public void setIdRH(String idRH) { this.idRH = idRH; }

    public String getIdEstadoCivil() { return idEstadoCivil; }

    public void setIdEstadoCivil(String idEstadoCivil) { this.idEstadoCivil = idEstadoCivil; }

    public Boolean getIndicadorHabilitado() {
        return indicadorHabilitado;
    }

    public void setIndicadorHabilitado(Boolean indicadorHabilitado) {
        this.indicadorHabilitado = indicadorHabilitado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
