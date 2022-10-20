package usa.mintic.projectcycle3.repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.projectcycle3.entities.Category;
import usa.mintic.projectcycle3.repositorys.cruds.CategoryCrudRespository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRespository {
    @Autowired
    private CategoryCrudRespository categoryCrudRespository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRespository.findAll();
    }
    public Optional<Category> getById(int id){ return categoryCrudRespository.findById(id); }
    public Category save(Category c){ return categoryCrudRespository.save(c); }
    public void delete(Category c){ categoryCrudRespository.delete(c); }
}
