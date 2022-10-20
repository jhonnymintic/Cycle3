package usa.mintic.projectcycle3.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.projectcycle3.entities.Score;
import usa.mintic.projectcycle3.repositorys.cruds.ScoreCrudRespository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRespository {
    @Autowired
    private ScoreCrudRespository scoreCrudRespository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRespository.findAll();
    }
    public Optional<Score> getById(int id){ return scoreCrudRespository.findById(id); }
    public Score save(Score c){ return scoreCrudRespository.save(c); }
    public void delete(Score c){ scoreCrudRespository.delete(c); }
}
