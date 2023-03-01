package com.example.demojson.repo;

import com.example.demojson.model.SomeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends ReactiveCrudRepository<SomeEntity, Long> {
}
