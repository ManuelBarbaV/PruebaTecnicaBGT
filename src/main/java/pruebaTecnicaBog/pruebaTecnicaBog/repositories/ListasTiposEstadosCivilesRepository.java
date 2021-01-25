package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposEstadosCiviles;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla ListasTiposEstadosCiviles.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface ListasTiposEstadosCivilesRepository extends MongoRepository<ListasTiposEstadosCiviles, Integer> {

    ListasTiposEstadosCiviles findBy_id(String id);

    List<ListasTiposEstadosCiviles> findAllByIndicadorHabilitadoIsTrue();

}