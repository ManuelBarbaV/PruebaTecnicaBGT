package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.ListasTiposEstadosCivilesAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de ListasTiposEstadosCiviles.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposEstadosCivilesRepository
 */

@Repository
public interface ListasTiposEstadosCivilesAudRepository extends MongoRepository<ListasTiposEstadosCivilesAud, Integer> {

}