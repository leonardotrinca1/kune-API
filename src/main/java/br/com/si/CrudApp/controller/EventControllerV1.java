package br.com.si.CrudApp.controller;

import br.com.si.CrudApp.model.EventModelV1;
import br.com.si.CrudApp.service.EventServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event/v1")
public class EventControllerV1 {

    @Autowired
    private EventServiceV1 service;

    @GetMapping("/{id}")
    public Optional<EventModelV1> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public EventModelV1 save(@RequestBody EventModelV1 model){
        return service.save(model);
    }

    @GetMapping
    public List<EventModelV1> findAll(){
        return service.findAll();
    }

    @PutMapping
    public EventModelV1 update(@RequestBody EventModelV1 model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/name/{name}")
    public List<EventModelV1> findByName(@PathVariable("name") String name){
        return service.findByName(name);
    }

}
