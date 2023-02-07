package com.echo.restaurant.config.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class WhiteSpaceRemoverDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser arg0, DeserializationContext arg1)
            throws IOException {
        return arg0.getValueAsString().trim();
    }
}
