package br.com.si.CrudApp.repository;


import br.com.si.CrudApp.model.EventModelV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepositoryV2 extends JpaRepository<EventModelV2, Long> {

    public Optional<EventModelV2> findById(long id);

    List<EventModelV2> findByEventNameContainsIgnoreCaseOrderByEventName(String name);

    //..new method - V2 ------------------------------------
    List<EventModelV2> findByEventDateBetween(Date date1,
                                               Date date2);

    Page<EventModelV2> findAll(Pageable pageable);

    List<EventModelV2> findAll();


}
