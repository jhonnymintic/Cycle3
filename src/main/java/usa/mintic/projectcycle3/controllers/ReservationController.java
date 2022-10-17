package usa.mintic.projectcycle3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.mintic.projectcycle3.entities.Reservation;
import usa.mintic.projectcycle3.services.ReservationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable("id") int idReservation){
        return reservationService.getById(idReservation);
    }


    /*@GetMapping("/cat/{idCat}")
    public List<Reservation> getByCatId(@PathVariable("idCat") int idCategory){
        return reservationService.getByCat(idCategory);
    }
    @GetMapping("/desc/{desc}/{cap}")
    public List<Reservation> getByDesc(@PathVariable("cap") int cap, @PathVariable("desc") String descp){
        return reservationService.getByDescAndCap(descp,cap);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation a){
        return reservationService.update(a);
    }*/
}
