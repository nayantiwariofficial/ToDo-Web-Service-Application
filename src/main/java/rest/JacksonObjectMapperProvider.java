package rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {
    final ObjectMapper defaultObjectMapper;

    public JacksonObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {return defaultObjectMapper;}

    public static ObjectMapper createDefaultMapper() {
        final ObjectMapper jackson = new ObjectMapper();
        // any changes to the ObjectMapper is up to you. Do what you like.
        // The ParameterNamesModule is optional,
        // it enables you to have immutable POJOs in java8
//        jackson.registerModule(new ParameterNamesModule());
        jackson.enable(SerializationFeature.INDENT_OUTPUT);
//        jackson.enable(SerializationFeature.WRAP_ROOT_VALUE);
//        jackson.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        jackson.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return jackson;
    }
}