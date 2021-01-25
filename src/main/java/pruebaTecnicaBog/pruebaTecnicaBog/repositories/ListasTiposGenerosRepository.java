package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposGeneros;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla ListasTiposGeneros.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface ListasTiposGenerosRepository extends MongoRepository<ListasTiposGeneros, Integer> {

    ListasTiposGeneros findBy_id(String id);

    List<ListasTiposGeneros> findAllByIndicadorHabilitadoIsTrue();

}