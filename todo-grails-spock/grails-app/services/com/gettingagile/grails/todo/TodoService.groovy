package com.gettingagile.grails.todo

/**
 * Created by csterling on 10/31/13.
 */
class TodoService {
    def transactional = false

    Todo create(String description) {
        return new Todo(description: description).save()
    }
}
