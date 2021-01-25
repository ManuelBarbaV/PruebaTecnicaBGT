package pruebaTecnicaBog.pruebaTecnicaBog.models.Aud;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Tabla que almacena la auditoria de listastiposdocumentos.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposDocumentos
 */

@Document(collection = "listastiposdocumentosAUD")
public class ListasTiposDocumentosAud {
    @Id
    private String _id;
    private String action;
    private String request;
    private String response;
    private Date auditoryDate;


    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }

    public String getRequest() { return request; }

    public void setRequest(String request) { this.request = request; }

    public String getResponse() { return response; }

    public void setResponse(String response) { this.response = response; }

    public Date getAuditoryDate() { return auditoryDate; }

    public void setAuditoryDate(Date auditoryDate) { this.auditoryDate = auditoryDate; }
}
