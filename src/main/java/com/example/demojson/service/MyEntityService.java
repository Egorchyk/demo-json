package com.example.demojson.service;

import com.example.demojson.model.SomeEntity;
import com.example.demojson.repo.MyEntityRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MyEntityService {

    private final MyEntityRepository entityRepository;

    public MyEntityService(MyEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public Mono<SomeEntity> saveEntity(SomeEntity someEntity) {
        return entityRepository.save(someEntity);
    }

    public Mono<SomeEntity> getEntityById(Long id) {
        return entityRepository.findById(id);
    }
}
