package usa.mintic.projectcycle3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.mintic.projectcycle3.entities.Message;
import usa.mintic.projectcycle3.services.MessageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message c){
        return messageService.save(c);
    }
    @GetMapping("/{id}")
    public Optional<Message> getById(@PathVariable("id") int idMessage){
        return messageService.getById(idMessage);
    }


    /*@GetMapping("/cat/{idCat}")
    public List<Message> getByCatId(@PathVariable("idCat") int idCategory){
        return messageService.getByCat(idCategory);
    }
    @GetMapping("/desc/{desc}/{cap}")
    public List<Message> getByDesc(@PathVariable("cap") int cap, @PathVariable("desc") String descp){
        return messageService.getByDescAndCap(descp,cap);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message a){
        return messageService.update(a);
    }*/
}
