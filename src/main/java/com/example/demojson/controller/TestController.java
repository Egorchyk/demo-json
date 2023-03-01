package com.example.demojson.controller;

import com.example.demojson.model.SomeEntity;
import com.example.demojson.repo.MyEntityRepository;
import com.example.demojson.util.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    private final MyEntityRepository myEntityRepository;

    public TestController(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @GetMapping
    public String helloWorld() {

        JsonObject jsonObject = new JsonObject("param1", "param2");
        SomeEntity someEntity = new SomeEntity();
        someEntity.setName("entity1");
        someEntity.setJsonObject(jsonObject);

        myEntityRepository.save(someEntity).subscribe();

        return "Hello World!";
    }
}
