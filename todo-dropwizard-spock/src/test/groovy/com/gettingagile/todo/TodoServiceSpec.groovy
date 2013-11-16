package com.gettingagile.todo

import com.yammer.dropwizard.config.Bootstrap
import com.yammer.dropwizard.config.Environment
import spock.lang.Specification

class TodoServiceSpec extends Specification {

    def "can bootstrap a todo service"() {
        given: "a todo service that has not been bootstrapped"
        TodoService todoService = new TodoService()

        and: "a mock bootstrap configuration"
        Bootstrap<TodoConfigurationSpec> bootstrap = new Bootstrap<TodoConfigurationSpec>(todoService)
        todoService.initialize(bootstrap)

        and: "a mock Environment"
        Environment environment = Mock(Environment, constructorArgs: ["Env", null, null, null])

        when: "service is run"
        todoService.run(new TodoConfiguration(), environment)

        then: "it has been initialized with bootstrap configuration"
        bootstrap.getName() == "todo-dropwizard"

        and: "environment adds Todo resource endpoint"
        1 * environment.addResource(_ as TodoResource)
    }

}
