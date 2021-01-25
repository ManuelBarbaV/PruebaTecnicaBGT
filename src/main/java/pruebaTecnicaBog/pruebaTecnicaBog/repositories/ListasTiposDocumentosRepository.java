package pruebaTecnicaBog.pruebaTecnicaBog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.ListasTiposDocumentos;

import java.util.List;

/**
 * Repositorio encargado de las consultas a la BD de la tabla ListasTiposDocumentos.
 * @author Manuel Fernando Barba Villamizar
 */

@Repository
public interface ListasTiposDocumentosRepository extends MongoRepository<ListasTiposDocumentos, Integer> {

    ListasTiposDocumentos findBy_id(String id);

    List<ListasTiposDocumentos> findAllByIndicadorHabilitadoIsTrue();

}
