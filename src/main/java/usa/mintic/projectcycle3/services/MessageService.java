package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Optional<Message> getById(int id){
        return messageRespository.getById(id);
    }
    public Message save(Message c){
        if(c.getIdMessage()==null){ return messageRespository.save(c); }
        return c;
    }
    public boolean delete(int id){
        Optional<Message> cOp=messageRespository.getById(id);
        if(cOp.isPresent()){ messageRespository.delete(cOp.get()); return true; }
        return false;
    }
    public Message update(Message c){
        if(c.getIdMessage()!=null){
            Optional<Message> old=messageRespository.getById(c.getIdMessage());
            if(old.isPresent()){
                Message k= old.get();
                if(c.getMessageText()!=null){ k.setMessageText(c.getMessageText()); }
                return messageRespository.save(k);
            }
        }
        return c;
    }
}
