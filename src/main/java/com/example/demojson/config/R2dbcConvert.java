package com.example.demojson.config;

import com.example.demojson.converter.JsonReadConverter;
import com.example.demojson.converter.JsonWritingConverter;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;

import java.util.List;

@Configuration
public class R2dbcConvert extends AbstractR2dbcConfiguration {
    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return null;
    }

    @Override
    protected List<Object> getCustomConverters() {
        return List.of(new JsonReadConverter(), new JsonWritingConverter());
    }
}
