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

    public Reservation save(Reservation c){
        return reservationCRUDRepository.save(c);
    }

    public Optional<Reservation> getById(int idRes){ return  reservationCRUDRepository.findById(idRes); }


    /*public  List<Reservation> getByCategoryId(int idCat){
        return  reservationCRUDRepository.findByCapacityGreaterThanEqual(idCat);
    }
    public  List<Reservation> getByDesc(String desc,int cap){
        return reservationCRUDRepository.findByDescriptionContainsAndAndCapacityGreaterThan(desc, cap);
    }*/
}
