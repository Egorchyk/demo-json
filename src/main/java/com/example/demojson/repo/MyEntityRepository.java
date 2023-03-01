package com.example.demojson.repo;

import com.example.demojson.model.SomeEntity;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MyEntityRepository extends ReactiveCrudRepository<SomeEntity, Long> {

//    @Query("INSERT INTO some_entity (name, json_object) VALUES ($1, $2)")
//    Mono<SomeEntity> save(String param, Json secondParam);
}
