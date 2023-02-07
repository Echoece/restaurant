package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    static final Logger logger = LoggerFactory.getLogger(LocalDateSerializer.class);

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

}
