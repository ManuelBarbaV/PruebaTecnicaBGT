package pruebaTecnicaBog.pruebaTecnicaBog.Utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pruebaTecnicaBog.pruebaTecnicaBog.models.*;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.*;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.*;

import java.sql.Timestamp;

public class AuditoryUtilities<T> {

    private ListasTiposDocumentosAudRepository listasTiposDocumentosAudRepository;
    private ListasTiposEstadosCivilesAudRepository listasTiposEstadosCivilesAudRepository;
    private ListasTiposGenerosAudRepository listasTiposGenerosAudRepository;
    private ListasTiposRelacionesAudRepository listasTiposRelacionesAudRepository;
    private ListasTiposRHAudRepository listasTiposRHAudRepository;
    private TercerosAudRepository tercerosAudRepository;
    private TercerosRelacionesAudRepository tercerosRelacionesAudRepository;

    public AuditoryUtilities(ListasTiposDocumentosAudRepository listasTiposDocumentosAudRepository) {
        this.listasTiposDocumentosAudRepository = listasTiposDocumentosAudRepository;
    }

    public AuditoryUtilities(ListasTiposEstadosCivilesAudRepository listasTiposEstadosCivilesAudRepository) {
        this.listasTiposEstadosCivilesAudRepository = listasTiposEstadosCivilesAudRepository;
    }

    public AuditoryUtilities(ListasTiposGenerosAudRepository listasTiposGenerosAudRepository) {
        this.listasTiposGenerosAudRepository = listasTiposGenerosAudRepository;
    }

    public AuditoryUtilities(ListasTiposRelacionesAudRepository listasTiposRelacionesAudRepository) {
        this.listasTiposRelacionesAudRepository = listasTiposRelacionesAudRepository;
    }

    public AuditoryUtilities(ListasTiposRHAudRepository listasTiposRHAudRepository) {
        this.listasTiposRHAudRepository = listasTiposRHAudRepository;
    }

    public AuditoryUtilities(TercerosAudRepository tercerosAudRepository) {
        this.tercerosAudRepository = tercerosAudRepository;
    }

    public AuditoryUtilities(TercerosRelacionesAudRepository tercerosRelacionesAudRepository) {
        this.tercerosRelacionesAudRepository = tercerosRelacionesAudRepository;
    }


    public void CreateRecord(T dataTemplate, String action, String request, String response) {
        ObjectMapper mapper = new ObjectMapper();

        try {

            if (dataTemplate instanceof ListasTiposDocumentos) {
                ListasTiposDocumentosAud listasTiposDocumentosAud = new ListasTiposDocumentosAud();
                listasTiposDocumentosAud.setAction(action);
                listasTiposDocumentosAud.setRequest(request);
                listasTiposDocumentosAud.setResponse(response);
                listasTiposDocumentosAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                listasTiposDocumentosAudRepository.save(listasTiposDocumentosAud);
            }

            if (dataTemplate instanceof ListasTiposEstadosCiviles) {
                ListasTiposEstadosCivilesAud listasTiposEstadosCivilesAud = new ListasTiposEstadosCivilesAud();
                listasTiposEstadosCivilesAud.setAction(action);
                listasTiposEstadosCivilesAud.setRequest(request);
                listasTiposEstadosCivilesAud.setResponse(response);
                listasTiposEstadosCivilesAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                listasTiposEstadosCivilesAudRepository.save(listasTiposEstadosCivilesAud);
            }

            if (dataTemplate instanceof ListasTiposGeneros) {
                ListasTiposGenerosAud listasTiposGenerosAud = new ListasTiposGenerosAud();
                listasTiposGenerosAud.setAction(action);
                listasTiposGenerosAud.setRequest(request);
                listasTiposGenerosAud.setResponse(response);
                listasTiposGenerosAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                listasTiposGenerosAudRepository.save(listasTiposGenerosAud);
            }

            if (dataTemplate instanceof ListasTiposRelaciones) {
                ListasTiposRelacionesAud listasTiposRelacionesAud = new ListasTiposRelacionesAud();
                listasTiposRelacionesAud.setAction(action);
                listasTiposRelacionesAud.setRequest(request);
                listasTiposRelacionesAud.setResponse(response);
                listasTiposRelacionesAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                listasTiposRelacionesAudRepository.save(listasTiposRelacionesAud);
            }

            if (dataTemplate instanceof ListasTiposRH) {
                ListasTiposRHAud listasTiposRHAud = new ListasTiposRHAud();
                listasTiposRHAud.setAction(action);
                listasTiposRHAud.setRequest(request);
                listasTiposRHAud.setResponse(response);
                listasTiposRHAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                listasTiposRHAudRepository.save(listasTiposRHAud);
            }

            if (dataTemplate instanceof Terceros) {
                TercerosAud tercerosAud = new TercerosAud();
                tercerosAud.setAction(action);
                tercerosAud.setRequest(request);
                tercerosAud.setResponse(response);
                tercerosAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                tercerosAudRepository.save(tercerosAud);
            }

            if (dataTemplate instanceof TercerosRelaciones) {
                TercerosRelacionesAud tercerosRelacionesAud = new TercerosRelacionesAud();
                tercerosRelacionesAud.setAction(action);
                tercerosRelacionesAud.setRequest(request);
                tercerosRelacionesAud.setResponse(response);
                tercerosRelacionesAud.setAuditoryDate(new Timestamp(System.currentTimeMillis()));
                tercerosRelacionesAudRepository.save(tercerosRelacionesAud);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    }
