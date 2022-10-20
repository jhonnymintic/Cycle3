package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Score;
import usa.mintic.projectcycle3.repositorys.ScoreRespository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRespository scoreRespository;

    public List<Score> getAll(){
        return scoreRespository.getAll();
    }
    public Optional<Score> getById(int id){
        return scoreRespository.getById(id);
    }
    public Score save(Score c){
        if(c.getIdScore()==null){ return scoreRespository.save(c); }
        return c;
    }
    public boolean delete(int id){
        Optional<Score> cOp=scoreRespository.getById(id);
        if(cOp.isPresent()){ scoreRespository.delete(cOp.get()); return true; }
        return false;
    }
    public Score update(Score c){
        if(c.getIdScore()!=null){
            Optional<Score> old=scoreRespository.getById(c.getIdScore());
            if(old.isPresent()){
                Score k= old.get();
                if(c.getScore()!=null){ k.setScore(c.getScore()); }
                return scoreRespository.save(k);
            }
        }
        return c;
    }
}
