package com.gettingagile.todo

import com.yammer.dropwizard.config.Configuration
import spock.lang.Specification


class TodoConfigurationSpec extends Specification {

    def "create valid Todo configuration for service"() {
        given: "a Todo configuration"
        TodoConfiguration todoConfiguration = new TodoConfiguration()

        expect: "valid configuration"
        todoConfiguration instanceof Configuration
    }

}