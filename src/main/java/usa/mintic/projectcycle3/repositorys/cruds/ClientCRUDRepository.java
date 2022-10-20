package usa.mintic.projectcycle3.repositorys.cruds;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.projectcycle3.entities.Client;

public interface ClientCRUDRepository extends CrudRepository<Client,Integer> {
}
