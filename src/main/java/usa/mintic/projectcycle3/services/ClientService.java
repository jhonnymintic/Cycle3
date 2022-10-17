package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Client;
import usa.mintic.projectcycle3.repositorys.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> pa=clientRepository.getById(c.getIdClient());
            if(!pa.isPresent()){
                return clientRepository.save(c);
            }
        }
        return c;
    }

    public Optional<Client> getById(int id){ return clientRepository.getById(id); }


    /*
    public List<Client> getByCat(int id){
        return clientRepository.getByCategoryId(id);
    }
    public List<Client>getByDescAndCap(String d,int c){
        return clientRepository.getByDesc(d, c);
    }
    public Client update(Client a){
        if(a.getId()!=null){
            Optional<Client> pa=clientRepository.getById(a.getId());
            if(pa.isPresent()){
                Client result=pa.get();
                if(a.getCapacity()!=null){
                    result.setCapacity(a.getCapacity());
                }
                if(a.getCategory()!=null){
                    result.setCategory(a.getCategory());
                }
                if(a.getDescription()!=null){
                    result.setDescription(a.getDescription());
                }
                if(a.getName()!=null){
                    result.setName(a.getName());
                }
                if(a.getOwner()!=null){
                    result.setOwner(a.getOwner());
                }
                return clientRepository.save(result);
            }
        }
        return a;
    }*/
}
