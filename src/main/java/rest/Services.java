package rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dao.ToDoDao;
import dto.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Path("/todo")
public class Services {

    private Logger logger = LoggerFactory.getLogger(Services.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTodo(ToDo toDo) {
        ToDoDao toDoDao = new ToDoDao();
        try {
            toDoDao.addTodo(toDo);
        } catch (Exception e) {
            logger.error("Unable to create Todo! ", e);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity(toDoDao).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> getToDo() {
        ToDoDao toDoDao = new ToDoDao();
        List<ToDo> todoList = toDoDao.getToDos();
        return todoList;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo getById(@PathParam("id") Long id) {
        ToDoDao toDoDao = new ToDoDao();
        ToDo toDo = toDoDao.getToDo(id);
        return toDo;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTodo(@PathParam("id") Long id, ToDo toDo) {
        ToDoDao toDoDao = new ToDoDao();
        try {
            toDoDao.updateTodo(toDo);
        } catch (Exception e) {
            logger.error("Unable to update Todo! id: {}", id, e);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(toDoDao).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteTodo(@PathParam("id") Long id) {
        ToDoDao dao = new ToDoDao();
        try {
            dao.deleteTodo(id);
        } catch (Exception e) {
            logger.error("Error while deleting id: {}", id, e);
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().build();
    }
}