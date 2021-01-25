package pruebaTecnicaBog.pruebaTecnicaBog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryObject;
import pruebaTecnicaBog.pruebaTecnicaBog.Utilities.AuditoryUtilities;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Terceros;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud.TercerosAudRepository;
import pruebaTecnicaBog.pruebaTecnicaBog.repositories.TercerosRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Controlador que lanza todos los servicio configurados en el repositorio de Terceros
 * dada una URI y un parametro de entrada
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.TercerosRepository
 */

@RestController
@RequestMapping("/api/terceros")
public class TercerosController {

    @Autowired
    TercerosRepository repository;

    @Autowired
    private TercerosAudRepository AudRepository;

    //Objetos de auditoria
    AuditoryObject auditoryObject = new AuditoryObject();

    /**
     * Servicio para encontrar todos los registros de la tabla Terceros
     * @return List<Terceros>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/enabled")
    private List<Terceros> findAll(){
        List<Terceros> response = repository.findAllByIndicadorHabilitadoIsTrue();
        //seteo parametros de auditoria
        AuditoryUtilities<Terceros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla Terceros
     * @param  id
     * @return Terceros
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/{id}")
    private Terceros findById(@PathVariable String id){
        Terceros response = repository.findBy_id(id);
        //seteo parametros de auditoria
        AuditoryUtilities<Terceros> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
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
     * Servicio para encontrar un registro especifico de la tabla Terceros
     * basado en el numero de documento del tercero
     * @param  numDoc
     * @return Terceros
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/numeroDocumento/{numDoc}/enabled")
    private Terceros findByNumeroDoc(@PathVariable String numDoc){
        Terceros response = repository.findByNumeroDocumentoLikeAndIndicadorHabilitadoIsTrue(numDoc);
        //seteo parametros de auditoria
        AuditoryUtilities<Terceros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(numDoc);
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
     * Servicio para encontrar multiples registros de la tabla Terceros
     * basado en el tipo de sangre elegido a consultar
     * @param  idRH
     * @return List<Terceros>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/RH/{idRH}/enabled")
    private List<Terceros> findByIdRH(@PathVariable String idRH){
        List<Terceros> response = repository.findAllByIdRHAndIndicadorHabilitadoIsTrue(idRH);
        //seteo parametros de auditoria
        AuditoryUtilities<Terceros> auditoryUtilities = new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(idRH);
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
     * Servicio para encontrar multiples registros de la tabla Terceros
     * basado en el estado civil elegido a consultar
     * @param  idEstadoCivil
     * @return List<Terceros>
     * @author Manuel Fernando Barba Villamizar
     */
    @GetMapping(path = "/estadoCivil/{idEstadoCivil}/enabled")
    private List<Terceros> findByIdEstadoCivil(@PathVariable String idEstadoCivil){
        List<Terceros> response = repository.findAllByIdEstadoCivilAndIndicadorHabilitadoIsTrue(idEstadoCivil);
        //seteo parametros de auditoria
        AuditoryUtilities<Terceros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryObject.setAction("CONSULTA");
        auditoryObject.setGsonRequest(idEstadoCivil);
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
     * Servicio para crear un registro en la tabla Terceros
     * @param  l
     * @return Terceros
     * @author Manuel Fernando Barba Villamizar
     */
    @PostMapping
    private Terceros create(@RequestBody Terceros l){
        auditoryObject.setAction(l.get_id() != null ? "ACTUALIZAR" : "CREAR");
        l.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        l.setIndicadorHabilitado(l.getIndicadorHabilitado() != null ? l.getIndicadorHabilitado() : true);
        Terceros saved = repository.save(l);
        auditoryObject.setGsonRequest(l);
        auditoryObject.setGsonResponse(saved);
        AuditoryUtilities<Terceros> auditoryUtilities =new  AuditoryUtilities<>(AudRepository);
        auditoryUtilities.CreateRecord(saved, auditoryObject.getAction(), auditoryObject.getGsonRequest().toString(), auditoryObject.getGsonResponse().toString());
        return saved;
    }
}
