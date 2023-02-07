/**
 * Imtiaz Mirza imz.mrz@gmail.com
 * sb2.ca
 */
package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    static final Logger logger = LoggerFactory.getLogger(LocalDateTimeDeserializer.class);

    /*@Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        ObjectCodec codec = jp.getCodec();
        TextNode textNode = codec.readTree(jp);
        String dateString = textNode.textValue();
        Instant instant = Instant.parse(dateString);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(String.valueOf(ZoneOffset.UTC)));
        logger.debug("Deserilizing DateTime :" + localDateTime);
        return localDateTime;
    }*/
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(p.getValueAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
