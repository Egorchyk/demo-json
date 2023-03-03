package com.example.demojson.converter;

import com.example.demojson.util.JsonObject;
import com.google.gson.Gson;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class JsonToObjectConverter implements Converter<Json, JsonObject> {

    private final Gson gson;
    public JsonToObjectConverter(Gson mapper) {
        this.gson = mapper;
    }

    @Override
    public JsonObject convert(Json source) {
        try {
            JsonObject result = gson.fromJson(source.asString(), JsonObject.class);
            System.out.println("ReadingConverter working.. " + result);
            return result;
        } catch (Exception ex) {
            throw new RuntimeException("Error converting Json to object: " + ex.getMessage(), ex);
        }
    }
}
