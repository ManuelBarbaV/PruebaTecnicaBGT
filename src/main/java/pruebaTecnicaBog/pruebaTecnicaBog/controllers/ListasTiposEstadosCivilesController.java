package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposEstadosCiviles;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.ListasTiposEstadosCivilesAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposEstadosCivilesRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de ListasTiposEstadosCiviles
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposEstadosCivilesRepository
 */

@RestController
@RequestMapping("/api/listasTiposEstadosCiviles")
public class ListasTiposEstadosCivilesController {

    @Autowired
    private ListasTiposEstadosCivilesRepository repository;

    @Autowired
    private ListasTiposEstadosCivilesAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla ListasTiposEstadosCiviles
     * @return List<ListasTiposEstadosCiviles>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<ListasTiposEstadosCiviles> findAll(){
        List<ListasTiposEstadosCiviles> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposEstadosCiviles> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla ListasTiposEstadosCiviles
     * @param  id
     * @return ListasTiposEstadosCiviles
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private ListasTiposEstadosCiviles findById(@PathVariable String id){
        ListasTiposEstadosCiviles response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposEstadosCiviles> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para crear un registro en la tabla ListasTiposEstadosCiviles
     * @param  l
     * @return ListasTiposEstadosCiviles
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private ListasTiposEstadosCiviles create(@RequestBody ListasTiposEstadosCiviles l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        ListasTiposEstadosCiviles saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<ListasTiposEstadosCiviles> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
