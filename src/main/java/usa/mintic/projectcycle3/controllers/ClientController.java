package usa.mintic.projectcycle3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.mintic.projectcycle3.entities.Client;
import usa.mintic.projectcycle3.services.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int id){
        return clientService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){
        return clientService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Client update(@RequestBody Client c){ return clientService.update(c);}
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }
}
