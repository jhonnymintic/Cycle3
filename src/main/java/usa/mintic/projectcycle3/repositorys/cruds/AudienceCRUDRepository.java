package usa.mintic.projectcycle3.repositorys.cruds;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.projectcycle3.entities.Audience;

import java.util.List;

public interface AudienceCRUDRepository extends CrudRepository<Audience,Integer> {
    public List<Audience> findByCategoryIdOrderByNameAsc(int categoryId);
    public List<Audience> findByCapacityGreaterThanEqual(int capacity);
    public List<Audience> findByDescriptionContainsAndAndCapacityGreaterThan(String description,int capacity);
}
