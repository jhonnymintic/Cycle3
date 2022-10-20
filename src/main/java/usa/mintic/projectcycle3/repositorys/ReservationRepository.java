package usa.mintic.projectcycle3.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.projectcycle3.entities.Reservation;
import usa.mintic.projectcycle3.repositorys.cruds.ReservationCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }
    public Optional<Reservation> getById(int id){ return  reservationCRUDRepository.findById(id); }
    public Reservation save(Reservation r){
        return reservationCRUDRepository.save(r);
    }
    public void delete(Reservation r){ reservationCRUDRepository.delete(r);}
}
