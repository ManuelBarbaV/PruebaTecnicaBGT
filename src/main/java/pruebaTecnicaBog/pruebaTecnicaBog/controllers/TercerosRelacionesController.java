package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.TercerosRelaciones;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.TercerosRelacionesAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.TercerosRelacionesRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de TercerosRelaciones
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.TercerosRelacionesRepository
 */

@RestController
@RequestMapping("/api/tercerosRelaciones")
public class TercerosRelacionesController {

    @Autowired
    TercerosRelacionesRepository repository;

    @Autowired
    TercerosRelacionesAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla TercerosRelaciones
     * @return List<TercerosRelaciones>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<TercerosRelaciones> findAll(){
        List<TercerosRelaciones> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<TercerosRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla TercerosRelaciones
     * @param  id
     * @return TercerosRelaciones
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private TercerosRelaciones findById(@PathVariable String id){
        TercerosRelaciones response = repository.findBy_id(id);
        //seteo parametros de auditoria
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(id);
        auditoryObject.setGsonResponse(response);
        AuditoryUtilities<TercerosRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(
                response,
                auditoryObject.getAction(),
                auditoryObject.getGsonRequest().toString(),
                auditoryObject.getGsonResponse().toString()
        );
        return response;
    }

    /**
     * Servicio para encontrar un registro especifico de la tabla TercerosRelaciones
     * basado en el id de un tercero especifico
     * @param  id
     * @return List<TercerosRelaciones>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/tercero/{id}/enabled")
    private List<TercerosRelaciones> findByIdTercero(@PathVariable String id){
        List<TercerosRelaciones> response = repository.findAllByIdTerceroAndIndicadorHabilitadoIsTrue(id);
        //seteo parametros de auditoria
        AuditoryUtilities<TercerosRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(id);
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
     * Servicio para crear un registro en la tabla TercerosRelaciones
     * @param  l
     * @return TercerosRelaciones
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private TercerosRelaciones create(@RequestBody TercerosRelaciones l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        TercerosRelaciones saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<TercerosRelaciones> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
