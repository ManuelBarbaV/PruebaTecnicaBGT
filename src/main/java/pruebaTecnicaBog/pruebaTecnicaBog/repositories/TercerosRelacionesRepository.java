package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.TercerosRelaciones;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla TercerosRelaciones.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface TercerosRelacionesRepository extends MongoRepository<TercerosRelaciones, Integer> {

    TercerosRelaciones findBy_id(String id);

    List<TercerosRelaciones> findAllByIndicadorHabilitadoIsTrue();

    List<TercerosRelaciones> findAllByIdTerceroAndIndicadorHabilitadoIsTrue(String id);

}
