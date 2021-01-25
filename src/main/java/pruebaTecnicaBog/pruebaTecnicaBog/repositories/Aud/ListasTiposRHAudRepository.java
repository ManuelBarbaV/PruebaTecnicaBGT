package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.ListasTiposRHAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de ListasTiposRH.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposRHRepository
 */

@Repository
public interface ListasTiposRHAudRepository extends MongoRepository<ListasTiposRHAud, Integer> {

}