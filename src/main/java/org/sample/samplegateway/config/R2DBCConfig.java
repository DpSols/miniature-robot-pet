package org.sample.samplegateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2DBCConfig {

//    @Bean
//    public R2dbcCustomConversions r2dbcCustomConversions() {
//        List<Converter<?, ?>> converters = new ArrayList<>();
//        converters.add(new JsonToMapConverter());
//        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, converters);
//    }
}
