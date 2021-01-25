package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposRelaciones;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla ListasTiposRelaciones.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface ListasTiposRelacionesRepository extends MongoRepository<ListasTiposRelaciones, Integer> {

    ListasTiposRelaciones findBy_id(String id);

    List<ListasTiposRelaciones> findAllByIndicadorHabilitadoIsTrue();

}