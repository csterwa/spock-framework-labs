package com.gettingagile.todo

import org.joda.time.DateTime
import spock.lang.Specification

class TodoResourceSpec extends Specification {

    def "should get todo by ID"() {
        given: "a Todo resource given the default name"
        Todo mockTodo = new Todo(id: 1, description: "Dust the furniture", dueDate: DateTime.now().toDate())
        TodoResource todoResource = new TodoResource(todos: [mockTodo])

        when: "requesting a specific Todo"
        Todo todo = todoResource.getTodo(1)

        then: "todo is valid"
        todo
        todo.id == mockTodo.id
        todo.dueDate == mockTodo.dueDate
        todo.description == mockTodo.description
    }

    def "should be able to create a Todo with description and due date"() {
        given: "a description and due date"
        String description = "Clean the fish tank"
        Date dueDate = DateTime.now().plusDays(2).toDate()

        and: "a Todo resource"
        TodoResource todoResource = new TodoResource()

        when: "request to create a Todo"
        Todo todo = todoResource.create(description, dueDate)

        then: "returns a valid Todo"
        todo
        todo.id
        todo.description == description
        todo.dueDate == dueDate
        todoResource.todos.size() == 1
    }

    def "should return all Todo"() {
        given: "a Todo resource with some Todos"
        Todo todo1 = new Todo(id: 1, description: "Garbage", dueDate: DateTime.now().plusDays(1).toDate())
        Todo todo2 = new Todo(id: 2, description: "Vacuum", dueDate: DateTime.now().plusDays(3).toDate())
        TodoResource todoResource = new TodoResource(todos: [todo1, todo2])

        when: "request all Todos"
        List<Todo> todos = todoResource.list()

        then: "it should return all Todos"
        todos
        todos.size() == 2
        todos.contains(todo1)
        todos.contains(todo2)
    }

}
