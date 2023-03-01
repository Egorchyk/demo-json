package com.example.demojson.converter;

import com.example.demojson.util.JsonObject;
import com.google.gson.Gson;
import io.r2dbc.postgresql.codec.Json;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class JsonObjectConverter implements AttributeConverter<JsonObject, Json> {

    private final Gson gson;

    public JsonObjectConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Json convertToDatabaseColumn(JsonObject attribute) {
        return Json.of(gson.toJson(attribute));
    }

    @Override
    public JsonObject convertToEntityAttribute(Json dbData) {
        return gson.fromJson(dbData.asString(), JsonObject.class);
    }
}
