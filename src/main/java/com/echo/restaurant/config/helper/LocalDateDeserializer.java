
package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    static final Logger logger = LoggerFactory.getLogger(LocalDateDeserializer.class);

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDate.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
