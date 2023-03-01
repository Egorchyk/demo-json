package com.example.demojson.controller;

import com.example.demojson.model.SomeEntity;
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

    public TestController(MyEntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public Mono<String> helloWorld() {

        JsonObject jsonObject = new JsonObject("param1", "param2");

        SomeEntity someEntity = new SomeEntity();
        someEntity.setName("entity1");
        someEntity.setJsonObject(jsonObject);

        entityService.saveEntity(someEntity).subscribe(someEntity1 -> {
            System.out.println(someEntity1 + " - add to db");
        });

        entityService.getEntityById(1L).subscribe(someEntity1 -> {
            System.out.println("Entity id: " + someEntity1.getId() + " " +
                    someEntity1.getJsonObject() + " This is JsonObject from db");
        });

        return Mono.just("Hello World!");
    }
}
