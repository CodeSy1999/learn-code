package com.codeashuai.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/22 20:07
 */
public class MyNullStringJsonSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (value == null) {
            System.out.println("-----------null------------");
            jsonGenerator.writeString("");
        } else {
            jsonGenerator.writeObject(value);
        }
    }
}
