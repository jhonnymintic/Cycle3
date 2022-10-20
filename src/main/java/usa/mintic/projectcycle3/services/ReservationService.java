package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Reservation;
import usa.mintic.projectcycle3.repositorys.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getById(int id){
        return reservationRepository.getById(id);
    }
    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){ return reservationRepository.save(c); }
        return c;
    }
    public boolean delete(int id){
        Optional<Reservation> cOp=reservationRepository.getById(id);
        if(cOp.isPresent()){ reservationRepository.delete(cOp.get()); return true; }
        return false;
    }
    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> old=reservationRepository.getById(c.getIdReservation());
            if(old.isPresent()){
                Reservation k= old.get();
                if(c.getStartDate()!=null){ k.setStartDate(c.getStartDate()); }
                if(c.getDevolutionDate()!=null){ k.setDevolutionDate(c.getDevolutionDate()); }
                return reservationRepository.save(k);
            }
        }
        return c;
    }
}
