package com.gettingagile.todo

import com.yammer.dropwizard.Service
import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment

class TodoService extends Service<TodoConfiguration> {

    public static void main(String[] args) throws Exception {
        new TodoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TodoConfiguration> bootstrap) {
        bootstrap.setName("todo-dropwizard");
    }

    @Override
    public void run(TodoConfiguration configuration, Environment environment) {
        environment.addResource(new TodoResource())
    }

}
