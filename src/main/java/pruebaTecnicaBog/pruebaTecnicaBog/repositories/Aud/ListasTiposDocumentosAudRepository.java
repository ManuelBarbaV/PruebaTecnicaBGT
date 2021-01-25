package pruebaTecnicaBog.pruebaTecnicaBog.repositories.Aud;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pruebaTecnicaBog.pruebaTecnicaBog.models.Aud.ListasTiposDocumentosAud;

/**
 * Repositorio encargado de guardar un registro de auditoria
 * cada vez que se lance un servicio en el repositorio de ListasTiposDocumentos.
 * @author Manuel Fernando Barba Villamizar
 * @see pruebaTecnicaBog.pruebaTecnicaBog.repositories.ListasTiposDocumentosRepository
 */

@Repository
public interface ListasTiposDocumentosAudRepository extends MongoRepository<ListasTiposDocumentosAud, Integer> {

}