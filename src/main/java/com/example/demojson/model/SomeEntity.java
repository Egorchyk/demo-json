package com.example.demojson.model;

import com.example.demojson.util.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "some_entity")
public class SomeEntity {

    @Id
    private long id;

    private String name;

    @Column(value = "json_object")
    private JsonObject jsonObject;
}
