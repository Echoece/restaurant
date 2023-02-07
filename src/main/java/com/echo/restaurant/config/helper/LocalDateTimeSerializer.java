package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    static final Logger logger = LoggerFactory.getLogger(LocalDateTimeSerializer.class);

    /*@Override
    public void serialize(LocalDateTime dateTime, JsonGenerator jg,
                          SerializerProvider sp) throws IOException, JsonProcessingException {

        logger.debug("Serializing DateTime " + dateTime);
        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
        jg.writeString(DateTimeFormatter.ISO_INSTANT.format(instant));

    }*/
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

}
