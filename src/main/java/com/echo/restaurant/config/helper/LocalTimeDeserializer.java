
package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    static final Logger logger = LoggerFactory.getLogger(LocalTimeDeserializer.class);

    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalTime.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
