package usa.mintic.projectcycle3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.projectcycle3.services.CategoryService;
import usa.mintic.projectcycle3.entities.Category;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }
    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable("id") int idCat){
        return categoryService.getById(idCat);
    }
}
