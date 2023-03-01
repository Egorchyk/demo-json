package com.example.demojson.converter;

import com.example.demojson.util.JsonObject;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.r2dbc.core.Parameter;

@WritingConverter
public class JsonWritingConverter implements Converter<JsonObject, OutboundRow> {

    @Override
    public OutboundRow convert(JsonObject source) {
        OutboundRow row = new OutboundRow();
        row.put("param", Parameter.from(source.getParam()));
        row.put("secondParam", Parameter.from(source.getSecondParam()));
        return row;
    }
}
