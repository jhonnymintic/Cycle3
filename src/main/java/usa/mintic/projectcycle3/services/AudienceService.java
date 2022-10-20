package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Audience;
import usa.mintic.projectcycle3.repositorys.AudienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }
    public Optional<Audience> getById(int id){
        return audienceRepository.getById(id);
    }
    public Audience save(Audience c){
        if(c.getId()==null){ return audienceRepository.save(c); }
        return c;
    }
    public boolean delete(int id){
        Optional<Audience> cOp=audienceRepository.getById(id);
        if(cOp.isPresent()){ audienceRepository.delete(cOp.get()); return true; }
        return false;
    }
    public Audience update(Audience c){
        if(c.getId()!=null){
            Optional<Audience> old=audienceRepository.getById(c.getId());
            if(old.isPresent()){
                Audience k= old.get();
                if(c.getName()!=null){ k.setName(c.getName()); }
                if(c.getOwner()!=null){ k.setOwner(c.getOwner()); }
                if(c.getCapacity()!=null){ k.setCapacity(c.getCapacity()); }
                if(c.getDescription()!=null){ k.setDescription(c.getDescription()); }
                return audienceRepository.save(k);
            }
        }
        return c;
    }
}
