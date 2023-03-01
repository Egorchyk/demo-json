package com.example.demojson.converter;

import com.example.demojson.util.JsonObject;
import com.google.gson.Gson;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class ObjectToJsonConverter implements Converter<JsonObject, Json> {

    private final Gson gson;

    public ObjectToJsonConverter(Gson mapper) {
        this.gson = mapper;
    }

    @Override
    public Json convert(JsonObject source) {
        try {
            String json = gson.toJson(source);
            System.out.println("WritingConverter working..");
            return Json.of(json);
        } catch (Exception ex) {
            throw new RuntimeException("Error converting object to Json: " + ex.getMessage(), ex);
        }
    }
}