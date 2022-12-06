package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    //..a optional return
    Optional<CategoryModel> findById(long id);

    //..JPA derived query to retrive a list by name
    List<CategoryModel> findByNameContainsIgnoreCase(String name);

}
