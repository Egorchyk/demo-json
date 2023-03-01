package com.example.demojson.config;

import com.example.demojson.converter.JsonToObjectConverter;
import com.example.demojson.converter.ObjectToJsonConverter;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2dbcConfig {
    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions(Gson gson) {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new JsonToObjectConverter(gson));
        converters.add(new ObjectToJsonConverter(gson));
        return new R2dbcCustomConversions(R2dbcCustomConversions.STORE_CONVERSIONS, converters);
    }
}
