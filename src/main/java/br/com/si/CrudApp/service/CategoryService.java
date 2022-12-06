package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.CategoryModel;
import br.com.si.CrudApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Optional<CategoryModel> findById(long id){
        return repository.findById(id);
    }

    public List<CategoryModel> findAll(){
        return repository.findAll();
    }

    public List<CategoryModel> findByName(String name){
        return repository.findByNameContainsIgnoreCase(name);
    }

    public CategoryModel save(CategoryModel model){
        return repository.save(model);
    }

    public CategoryModel update(CategoryModel model){
        var found = repository.findById(model.getId());
        if(found.isPresent()){
            found.get().setName(model.getName());
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);
        if(found.isPresent()){
            repository.delete(found.get());
        }
    }


}
