package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Terceros;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla Terceros.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface TercerosRepository extends MongoRepository<Terceros, Integer> {

    Terceros findBy_id(String id);

    List<Terceros> findAllByIndicadorHabilitadoIsTrue();

    Terceros findByNumeroDocumentoLikeAndIndicadorHabilitadoIsTrue(String numeroDoc);

    List<Terceros> findAllByIdRHAndIndicadorHabilitadoIsTrue(String id);

    List<Terceros> findAllByIdEstadoCivilAndIndicadorHabilitadoIsTrue(String id);
}
