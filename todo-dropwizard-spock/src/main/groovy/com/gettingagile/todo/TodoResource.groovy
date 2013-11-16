package com.gettingagile.todo

import com.yammer.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import java.util.concurrent.atomic.AtomicInteger

@Path("/todo")
@Produces(MediaType.APPLICATION_JSON)
class TodoResource {

    List<Todo> todos = new ArrayList<Todo>()
    private AtomicInteger atomicInteger = new AtomicInteger(0)

    @GET
    @Path("/{id}")
    @Timed
    Todo getTodo(@PathParam("id")Integer id) {
        return todos.find { it.id == id }
    }

    @POST
    @Timed
    Todo create(String description, Date dueDate) {
        Todo todo = new Todo(id: atomicInteger.incrementAndGet(), description: description, dueDate: dueDate)
        todos.add(todo)
        return todo
    }

    @GET
    List<Todo> list() {
        return todos
    }
}
