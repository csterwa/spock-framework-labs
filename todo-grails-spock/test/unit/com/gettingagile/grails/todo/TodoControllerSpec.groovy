package com.gettingagile.grails.todo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.http.HttpStatus
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

@TestFor(TodoController)
@Mock(Todo)
class TodoControllerSpec extends Specification {

    def setup() {
        controller.todoService = Mock(TodoService)
    }

    void "should list todos"() {
        given: "existing list of todos"
        new Todo(description: "Take out garbage").save(flush: true, failOnError: true)
        new Todo(description: "Wash the dishes").save(flush: true, failOnError: true)
        new Todo(description: "Pick up dry cleaning").save(flush: true, failOnError: true)

        when: "we request a list of all todos"
        controller.index()

        then: "should get all of them back in response"
        response.status == HttpStatus.OK.value()
        response.json.size() == 3
    }

    void "should give back single todo by id"() {
        given: "existing list of todos"
        new Todo(description: "Take out garbage").save(flush: true, failOnError: true)
        Todo washDishes = new Todo(description: "Wash the dishes").save(flush: true, failOnError: true)
        new Todo(description: "Pick up dry cleaning").save(flush: true, failOnError: true)

        and: "a requested id"
        assert washDishes.id
        params.id = washDishes.id

        when: "we request the todo with the id"
        controller.index()

        then: "should get only the todo asked for"
        response.status == HttpStatus.OK.value()
        response.json.id == washDishes.id
        response.json.description == washDishes.description
    }

    void "should create a todo"() {
        given: "new todo description in params"
        params.description = "Change the tires"

        and: "a mock todo service"
        1 * controller.todoService.create(_ as Map) >> { return new Todo(description: params.description).save() }

        when: "we request to create a new todo"
        controller.create()

        then: "should have a new todo with the description given"
        response.status == HttpStatus.CREATED.value()
        response.json.id
        response.json.description == params.description
    }

}
