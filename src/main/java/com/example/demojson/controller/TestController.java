package com.example.demojson.controller;

import com.example.demojson.model.SomeEntity;
import com.example.demojson.repo.MyEntityRepository;
import com.example.demojson.service.MyEntityService;
import com.example.demojson.util.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class TestController {

    private final MyEntityService entityService;
    private final MyEntityRepository myEntityRepository;

    public TestController(MyEntityService entityService, MyEntityRepository myEntityRepository) {
        this.entityService = entityService;
        this.myEntityRepository = myEntityRepository;
    }

    @GetMapping
    public Mono<String> helloWorld() {

        JsonObject jsonObject = new JsonObject("param1", "param2");
        SomeEntity someEntity = new SomeEntity();
        someEntity.setName("entity1");
        someEntity.setJsonObject(jsonObject);
        return myEntityRepository.save(someEntity).map(someEntity1 -> {
                    System.out.println(someEntity1 + " - add to db");
                    return someEntity1;
                })
                .flatMap(entity -> entityService.getEntityById(1L).doOnNext(entity1 ->
                        System.out.println("Entity id: " + entity1.getId() + " " +
                                entity1.getJsonObject() + " This is JsonObject from db"))).thenReturn("Hello World!");
    }
}
