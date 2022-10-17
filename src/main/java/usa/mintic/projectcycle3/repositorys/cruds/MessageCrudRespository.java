package usa.mintic.projectcycle3.repositorys.cruds;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.projectcycle3.entities.Message;

public interface MessageCrudRespository extends CrudRepository<Message,Integer> {
}
