package com.gettingagile.grails.todo

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Todo)
class TodoSpec extends Specification {

    def setup() {

    }

    void "should create simple todo"() {
        given: "a valid todo"
        Todo todo = new Todo(description: "Watch TV")

        expect:
        todo.validate()
    }

    void "should have a description"() {
        given: "a todo without description"
        Todo todo = new Todo()

        expect:
        !todo.validate()
    }

    void "should not allow a blank description"() {
        given: "a todo with blank description"
        Todo todo = new Todo(description: "")

        expect:
        !todo.validate()
    }

}
