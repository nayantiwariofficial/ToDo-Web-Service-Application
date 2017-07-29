package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import rest.JacksonObjectMapperProvider;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest/*")
public class CustomApplication extends ResourceConfig {
    public CustomApplication() {
        System.out.println("Application Initialized");
    }
}
