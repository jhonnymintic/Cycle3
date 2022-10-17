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

    public Category save(Category c){
        return categoryRespository.save(c);
    }

    public List<Category> getAll(){
        return categoryRespository.getAll();
    }

    public Optional<Category> getById(int i){
        return categoryRespository.getById(i);
    }

}
