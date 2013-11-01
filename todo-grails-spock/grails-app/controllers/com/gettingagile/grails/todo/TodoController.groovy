package com.gettingagile.grails.todo

import grails.converters.JSON
import org.springframework.http.HttpStatus

class TodoController {

    TodoService todoService

    def index() {
        def todoResponse = (params.id) ? Todo.get(params.id) : Todo.findAll()

        render todoResponse as JSON
    }

    def create() {
        Todo todo = todoService.create(params.description)

        render status: HttpStatus.CREATED, text: todo as JSON
    }

}
