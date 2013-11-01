package com.gettingagile.grails.todo

/**
 * Created by csterling on 10/31/13.
 */
class TodoService {
    def transactional = false

    Todo create(Map<String, ?> args) {
        return new Todo(args).save()
    }
}
