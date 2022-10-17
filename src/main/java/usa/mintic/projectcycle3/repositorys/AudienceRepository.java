package usa.mintic.projectcycle3.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.projectcycle3.entities.Audience;
import usa.mintic.projectcycle3.repositorys.cruds.AudienceCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {
    @Autowired
    private AudienceCRUDRepository audienceCRUDRepository;

    public List<Audience> getAll(){
        return (List<Audience>) audienceCRUDRepository.findAll();
    }
    public Audience save(Audience c){
        return audienceCRUDRepository.save(c);
    }
    public Optional<Audience> getById(int idAud){ return  audienceCRUDRepository.findById(idAud); }



    public  List<Audience> getByCategoryId(int idCat){
        return  audienceCRUDRepository.findByCapacityGreaterThanEqual(idCat);
    }
    public  List<Audience> getByDesc(String desc,int cap){
        return audienceCRUDRepository.findByDescriptionContainsAndAndCapacityGreaterThan(desc, cap);
    }
}
