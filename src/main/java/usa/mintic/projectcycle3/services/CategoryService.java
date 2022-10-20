package usa.mintic.projectcycle3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.projectcycle3.entities.Category;
import usa.mintic.projectcycle3.repositorys.CategoryRespository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> getAll(){
        return categoryRespository.getAll();
    }
    public Optional<Category> getById(int id){
        return categoryRespository.getById(id);
    }
    public Category save(Category c){
        if(c.getId()==null){ return categoryRespository.save(c); }
        return c;
    }
    public boolean delete(int id){
        Optional<Category> cOp=categoryRespository.getById(id);
        if(cOp.isPresent()){ categoryRespository.delete(cOp.get()); return true; }
        return false;
    }
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> old=categoryRespository.getById(c.getId());
            if(old.isPresent()){
                Category k= old.get();
                if(c.getName()!=null){ k.setName(c.getName()); }
                if(c.getDescription()!=null){ k.setDescription(c.getDescription()); }
                return categoryRespository.save(k);
            }
        }
        return c;
    }
}
