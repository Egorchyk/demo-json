package com.example.demojson.model;

import com.example.demojson.util.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class SomeEntity {

    @Id
    private long id;

    private String name;

    private JsonObject jsonObject;
}
