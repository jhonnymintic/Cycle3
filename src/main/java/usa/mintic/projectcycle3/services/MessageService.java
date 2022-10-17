package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Client;
import usa.mintic.projectcycle3.entities.Message;
import usa.mintic.projectcycle3.repositorys.MessageRespository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRespository messageRespository;

    public List<Message> getAll(){
        return messageRespository.getAll();
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRespository.save(m);
        }else{
            Optional<Message> pa=messageRespository.getById(m.getIdMessage());
            if(!pa.isPresent()){
                return messageRespository.save(m);
            }
        }
        return m;
    }

    public Optional<Message> getById(int i){
        return messageRespository.getById(i);
    }

}
