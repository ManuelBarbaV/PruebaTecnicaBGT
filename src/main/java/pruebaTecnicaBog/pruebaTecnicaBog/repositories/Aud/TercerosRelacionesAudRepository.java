package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.TercerosRelacionesAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de TercerosRelaciones.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.TercerosRelacionesRepository
 */

@Repository
public interface TercerosRelacionesAudRepository extends MongoRepository<TercerosRelacionesAud, Integer> {

}