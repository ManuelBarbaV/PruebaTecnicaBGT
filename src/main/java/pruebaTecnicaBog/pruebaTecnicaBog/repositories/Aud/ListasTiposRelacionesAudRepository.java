package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.ListasTiposRelacionesAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de ListasTiposRelaciones.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRelacionesRepository
 */

@Repository
public interface ListasTiposRelacionesAudRepository extends MongoRepository<ListasTiposRelacionesAud, Integer> {

}