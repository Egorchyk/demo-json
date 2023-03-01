package com.example.demojson.model;

import com.example.demojson.util.JsonObject;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "some_entity")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class SomeEntity {

    @Id
    private long id;

    private String name;

    @Type(type = "jsonb")
    private JsonObject jsonObject;
}
