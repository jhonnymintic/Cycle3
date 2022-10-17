package usa.mintic.projectcycle3.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.projectcycle3.entities.Message;
import usa.mintic.projectcycle3.repositorys.cruds.MessageCrudRespository;

import java.util.List;
import java.util.Optional;

@Repository

public class MessageRespository {

    @Autowired
    private MessageCrudRespository messageCrudRespository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRespository.findAll();
    }

    public Message save(Message c){
        return messageCrudRespository.save(c);
    }

    public Optional<Message> getById( int idMes){
        return messageCrudRespository.findById(idMes);
    }


}
