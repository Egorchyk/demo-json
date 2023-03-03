package com.example.demojson.converter;

import com.example.demojson.model.SomeEntity;
import com.google.gson.Gson;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

@WritingConverter
public class SomeEntityToRow implements Converter<SomeEntity, OutboundRow> {

    private final Gson gson;

    public SomeEntityToRow(Gson gson) {
        this.gson = gson;
    }

    @Override
    public OutboundRow convert(SomeEntity source) {
        try {
            OutboundRow outboundRow = new OutboundRow();
            outboundRow.put("name", Parameter.from(source.getName()));
            outboundRow.put("json_object", Parameter.from(Json.of(gson.toJson(source.getJsonObject()))));
            System.out.println("WritingConverter working.. " + outboundRow);

            return outboundRow;

        } catch (Exception ex) {
            throw new RuntimeException("Error converting object to Json: " + ex.getMessage(), ex);
        }
    }
}