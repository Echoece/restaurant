package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

    static final Logger logger = LoggerFactory.getLogger(LocalTimeSerializer.class);

    @Override
    public void serialize(LocalTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

}
