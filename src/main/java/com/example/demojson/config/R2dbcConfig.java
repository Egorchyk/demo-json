package com.example.demojson.config;

import com.example.demojson.converter.JsonToObjectConverter;
import com.example.demojson.converter.ObjectToJsonConverter;
import com.google.gson.Gson;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    private final Gson gson;

    public R2dbcConfig(Gson gson) {
        this.gson = gson;
    }

    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:postgresql://postgres:password@localhost:5432/postgres");
    }

    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new JsonToObjectConverter(gson));
        converters.add(new ObjectToJsonConverter(gson));
        return new R2dbcCustomConversions(getStoreConversions(), converters);
    }
}
