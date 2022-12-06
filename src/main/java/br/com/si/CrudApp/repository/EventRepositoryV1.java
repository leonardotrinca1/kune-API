package br.com.si.CrudApp.repository;

import br.com.si.CrudApp.model.EventModelV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepositoryV1 extends JpaRepository<EventModelV1, Long> {

    public Optional<EventModelV1> findById(long id);

    List<EventModelV1> findByEventNameContainsIgnoreCaseOrderByEventName(String name);


}
