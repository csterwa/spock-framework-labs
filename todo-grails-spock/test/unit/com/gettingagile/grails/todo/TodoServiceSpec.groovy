package com.gettingagile.grails.todo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TodoService)
@Mock(Todo)
class TodoServiceSpec extends Specification {

    void "should create todo"() {
        given: "a description"
        String description = "Feed the fish"

        when: "request to create a new todo"
        Todo todo = service.create(description)

        then: "should have a new todo with that description"
        todo.id
        todo.description == description
    }

}
