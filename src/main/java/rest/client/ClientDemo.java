package rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) throws Exception {

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8090/rest/todo/demo").request(MediaType.APPLICATION_JSON).get();

        List list = new ArrayList<>();
        list.add("2");
        list.add("3");
        list.add(1, "2");
        System.out.println(list);
    }

}