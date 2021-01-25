package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposRelaciones;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.ListasTiposRelacionesAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRelacionesRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de ListasTiposRelaciones
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRelacionesRepository
 */

@RestController
@RequestMapping("/api/listasTiposRelaciones")
public class ListasTiposRelacionesController {

    @Autowired
    private ListasTiposRelacionesRepository repository;

    @Autowired
    private ListasTiposRelacionesAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla ListasTiposRelaciones
     * @return List<ListasTiposRelaciones>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<ListasTiposRelaciones> findAll(){
        List<ListasTiposRelaciones> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla ListasTiposRelaciones
     * @param  id
     * @return ListasTiposRelaciones
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private ListasTiposRelaciones findById(@PathVariable String id){
        ListasTiposRelaciones response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para crear un registro en la tabla ListasTiposRelaciones
     * @param  l
     * @return ListasTiposRelaciones
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private ListasTiposRelaciones create(@RequestBody ListasTiposRelaciones l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        ListasTiposRelaciones saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<ListasTiposRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
