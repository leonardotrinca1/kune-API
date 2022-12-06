package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.EventModelV2;
import br.com.si.CrudApp.repository.EventRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceV2 {

    @Autowired
    private EventRepositoryV2 repository;

    public Optional<EventModelV2> findById(long id){
        return repository.findById(id);
    }

    public Page<EventModelV2> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public EventModelV2 save(EventModelV2 model){
        return repository.save(model);
    }

    public EventModelV2 update(EventModelV2 model){
        Optional<EventModelV2> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setEventName(model.getEventName());
            p.get().setEventDate(model.getEventDate());
            p.get().setAddress(model.getAddress());
            p.get().setDescription(model.getDescription());
            p.get().setCategories(model.getCategories());

             return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<EventModelV2> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<EventModelV2> findByName(String name){
        return repository.findByEventNameContainsIgnoreCaseOrderByEventName(name);
    }


}
