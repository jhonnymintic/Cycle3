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
    private ClientService categoryService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){
        return categoryService.save(c);
    }
    @GetMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int i){
        return categoryService.getById(i);
    }
}
