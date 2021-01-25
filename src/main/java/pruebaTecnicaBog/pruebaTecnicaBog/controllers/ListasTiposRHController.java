package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposRH;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.ListasTiposRHAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRHRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de ListasTiposRH
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRHRepository
 */

@RestController
@RequestMapping("/api/listasTiposRH")
public class ListasTiposRHController {

    @Autowired
    private ListasTiposRHRepository repository;

    @Autowired
    private ListasTiposRHAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla ListasTiposRH
     * @return List<ListasTiposRH>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<ListasTiposRH> findAll(){
        List<ListasTiposRH> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposRH> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla ListasTiposRH
     * @param  id
     * @return ListasTiposRH
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private ListasTiposRH findById(@PathVariable String id){
        ListasTiposRH response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposRH> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para crear un registro en la tabla ListasTiposRH
     * @param  l
     * @return ListasTiposRH
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private ListasTiposRH create(@RequestBody ListasTiposRH l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        ListasTiposRH saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<ListasTiposRH> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
