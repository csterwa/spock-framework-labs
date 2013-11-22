package com.gettingagile.grails.todo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

@TestFor(TodoService)
@Mock(Todo)
class TodoServiceSpec extends Specification {

    void "should create todo"() {
        given: "a description"
        String description = "Feed the fish"

        and: "number of days from today when its due"
        Date threeDaysFromToday = DateTime.now().plusDays(3).toDate()

        when: "request to create a new todo"
        Todo todo = service.create(description: description, dueDate: threeDaysFromToday)

        then: "should have a new todo with that description"
        todo.id
        todo.description == description
        todo.dueDate == threeDaysFromToday
    }

}
