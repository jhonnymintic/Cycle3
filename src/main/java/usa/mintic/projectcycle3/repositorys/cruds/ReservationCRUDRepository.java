package usa.mintic.projectcycle3.repositorys.cruds;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.projectcycle3.entities.Reservation;

import java.util.List;

public interface ReservationCRUDRepository extends CrudRepository<Reservation,Integer> {
}
