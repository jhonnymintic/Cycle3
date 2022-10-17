package usa.mintic.projectcycle3.repositorys.cruds;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.projectcycle3.entities.Client;

import java.util.List;

public interface ClientCRUDRepository extends CrudRepository<Client,Integer> {
}
