package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.ListasTiposGenerosAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de ListasTiposGeneros.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposGenerosRepository
 */

@Repository
public interface ListasTiposGenerosAudRepository extends MongoRepository<ListasTiposGenerosAud, Integer> {

}