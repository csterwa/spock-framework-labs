package com.gettingagile.grails.todo

import grails.test.spock.IntegrationSpec
import org.joda.time.DateTime
import org.springframework.http.HttpStatus

class TodoIntegrationSpec extends IntegrationSpec {

    TodoController controller

    def setup() {
        controller = new TodoController()
    }

    void "should send back list of all todos"() {
        given: "existing todos"
        new Todo(description: "A", dueDate: DateTime.now().plusDays(3).toDate()).save(flush: true, failOnError: true)
        new Todo(description: "B", dueDate: DateTime.now().plusDays(2).toDate()).save(flush: true, failOnError: true)

        when:
        controller.index()

        then:
        controller.response.status == HttpStatus.OK.value()
        controller.response.json.size() == 2
    }

}