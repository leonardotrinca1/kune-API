package br.com.si.CrudApp.service;

import br.com.si.CrudApp.model.EventModelV1;
import br.com.si.CrudApp.repository.EventRepositoryV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceV1 {

    @Autowired
    private EventRepositoryV1 repository;

    public Optional<EventModelV1> findById(long id){
        return repository.findById(id);
    }

    public List<EventModelV1> findAll(){
        return repository.findAll();
    }

    public EventModelV1 save(EventModelV1 model){
        return repository.save(model);
    }

    public EventModelV1 update(EventModelV1 model){
        Optional<EventModelV1> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setEventName(model.getEventName());
            p.get().setAddress(model.getAddress());
            p.get().setDescription(model.getDescription());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<EventModelV1> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }

    public List<EventModelV1> findByName(String name){
        return repository.findByEventNameContainsIgnoreCaseOrderByEventName(name);
    }

}
