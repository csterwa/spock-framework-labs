package com.gettingagile.grails.todo
/**
 * Created by csterling on 10/31/13.
 */
class Todo {

    String description
    Date dueDate

    static constraints = {
        dueDate nullable: true
    }

    int daysUntilDue() {
        return dueDate - new Date()
    }
}
