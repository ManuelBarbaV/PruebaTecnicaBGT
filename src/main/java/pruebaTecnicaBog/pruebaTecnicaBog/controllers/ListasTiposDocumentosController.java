package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposDocumentos;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.ListasTiposDocumentosAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposDocumentosRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de ListasTiposDocumentos
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposDocumentosRepository
 */

@RestController
@RequestMapping("/api/listasTiposDocumentos")
public class ListasTiposDocumentosController {

    @Autowired
    private ListasTiposDocumentosRepository repository;

    @Autowired
    private ListasTiposDocumentosAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();


    /**
     * Servicio para encontrar todos los registros de la tabla ListasTiposDocumentos
     * @return List<ListasTiposDocumentos>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<ListasTiposDocumentos> findAll(){
        List<ListasTiposDocumentos> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposDocumentos> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest("ALL");
        auditoryObject.setGsonResponse(response);
        auditoryUtilities.CreateRecord(
                response.stream().findAny().isPresent() ? response.stream().findAny().get() : null,
                auditoryObject.getAction(),
                auditoryObject.getGsonRequest().toString(),
                auditoryObject.getGsonResponse().toString()
        );

        return response;
    }

    /**
     * Servicio para encontrar un registro especifico de la tabla ListasTiposDocumentos
     * @param  id
     * @return ListasTiposDocumentos
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private ListasTiposDocumentos findById(@PathVariable String id){
        ListasTiposDocumentos response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposDocumentos> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(id);
        auditoryObject.setGsonResponse(response);
        auditoryUtilities.CreateRecord(
                response,
                auditoryObject.getAction(),
                auditoryObject.getGsonRequest().toString(),
                auditoryObject.getGsonResponse().toString()
        );

        return response;
    }

    /**
     * Servicio para crear un registro en la tabla ListasTiposDocumentos
     * @param l
     * @return ListasTiposDocumentos
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private ListasTiposDocumentos create(@RequestBody ListasTiposDocumentos l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        ListasTiposDocumentos saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<ListasTiposDocumentos> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }

}
