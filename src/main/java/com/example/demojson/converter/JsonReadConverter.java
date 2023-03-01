package com.example.demojson.converter;

import com.example.demojson.util.JsonObject;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class JsonReadConverter implements Converter<Row, JsonObject> {

    @Override
    public JsonObject convert(Row source) {
        JsonObject jsonObject = new JsonObject(
                source.get("param", String.class),
                source.get("secondParam", String.class));
        return jsonObject;
    }
}
