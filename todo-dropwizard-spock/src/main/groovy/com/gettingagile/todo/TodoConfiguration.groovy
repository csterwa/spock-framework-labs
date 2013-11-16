package com.gettingagile.todo

import com.fasterxml.jackson.annotation.JsonProperty
import com.yammer.dropwizard.config.Configuration
import org.hibernate.validator.constraints.NotEmpty

class TodoConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String defaultName = "Todo Application";

}
