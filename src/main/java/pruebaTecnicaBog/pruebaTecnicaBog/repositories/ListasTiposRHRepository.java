package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposRH;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla ListasTiposRH.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface ListasTiposRHRepository extends MongoRepository<ListasTiposRH, Integer> {

    ListasTiposRH findBy_id(String id);

    List<ListasTiposRH> findAllByIndicadorHabilitadoIsTrue();

}