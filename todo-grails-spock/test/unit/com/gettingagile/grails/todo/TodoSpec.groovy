package com.gettingagile.grails.todo

import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Todo)
class TodoSpec extends Specification {

    void "should create simple todo"() {
        given: "a valid todo"
        Todo todo = getTodo("Watch TV", 3)

        expect:
        todo.validate()
    }

    void "should have a description"() {
        given: "a todo without description"
        Todo todo = getTodo(null, 1)

        expect:
        !todo.validate()
    }

    void "should not allow a blank description"() {
        given: "a todo with blank description"
        Todo todo = getTodo("", 1)

        expect:
        !todo.validate()
    }

    void "should allow todo to not have due date"() {
        given: "a todo without due date"
        Todo todo = new Todo(description: "Whenever I want to do it")

        expect:
        todo.validate()
    }

    @Unroll
    void "should supply how many days until todo is due"() {
        expect:
        todo.daysUntilDue() == days

        where:
        [todo,days] << [
                [getTodo("A", 2), 2],
                [getTodo("B", 1), 1],
                [getTodo("C", 0), 0],
                [getTodo("D", 5), 5],
                [getTodo("E", -2), -2]
        ]
    }

    void "should supply how many days until todo is due using table data"() {
        expect:
        todo.daysUntilDue() == days

        where:
        todo                | days
        getTodo("Z", -3)    | -3
        getTodo("Y", 0)     | 0
        getTodo("X", 5)     | 5
        getTodo("W", 33)    | 33
    }

    private Todo getTodo(String description, int daysUntilDue) {
        return new Todo(description: description, dueDate: getDateByDaysPastToday(daysUntilDue))
    }

    private static Date getDateByDaysPastToday(int days) {
        return DateTime.now().plusDays(days).toDate()
    }

}
