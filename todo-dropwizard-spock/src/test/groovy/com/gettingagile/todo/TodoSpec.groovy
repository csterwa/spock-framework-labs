package com.gettingagile.todo

import org.joda.time.DateTime
import spock.lang.Specification

class TodoSpec extends Specification {

    def "should be able to instantiate a Todo"() {
        given: "a description and due date"
        String description = "Take out the garbage"
        Date dueDate = DateTime.now().plusDays(3).toDate()

        when: "a Todo is created"
        Todo todo = new Todo(id: 1, description: description, dueDate: dueDate)

        then: "it should be valid"
        todo
        todo.id == 1
        todo.description == description
        todo.dueDate == dueDate
    }

}
