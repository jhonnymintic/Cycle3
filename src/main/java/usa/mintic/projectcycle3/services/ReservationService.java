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
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> pa=reservationRepository.getById(r.getIdReservation());
            if(!pa.isPresent()){
                return reservationRepository.save(r);
            }
        }
        return r;
    }
    public Optional<Reservation> getById(int id){
        return reservationRepository.getById(id);
    }

}
