package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposGeneros;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.ListasTiposGenerosAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposGenerosRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de ListasTiposGeneros
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposGenerosRepository
 */


@RestController
@RequestMapping("/api/listasTiposGeneros")
public class ListasTiposGenerosController {

    @Autowired
    private ListasTiposGenerosRepository repository;

    @Autowired
    private ListasTiposGenerosAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla ListasTiposGeneros
     * @return List<ListasTiposGeneros>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<ListasTiposGeneros> findAll(){
        List<ListasTiposGeneros> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposGeneros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla ListasTiposGeneros
     * @param  id
     * @return ListasTiposGeneros
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private ListasTiposGeneros findById(@PathVariable String id){
        ListasTiposGeneros response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<ListasTiposGeneros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para crear un registro en la tabla ListasTiposGeneros
     * @param  l
     * @return ListasTiposGeneros
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private ListasTiposGeneros create(@RequestBody ListasTiposGeneros l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        ListasTiposGeneros saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<ListasTiposGeneros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
