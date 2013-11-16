[Spock Framework](https://code.google.com/p/spock/ "Spock Framework Home Page") Labs
====================

These labs were put together for the purpose of helping people learn more about the 
[Spock Framework](https://code.google.com/p/spock/ "Spock Framework Home Page"). There are two labs
that users can build upon. One based on the [Grails](http://grails.org/ "Grails Home Page") framework and the other 
based on [Dropwizard](http://dropwizard.codahale.com/ "Dropwizard Home Page"). Both of the labs are built using the 
Groovy programming language. To get started, clone this Github repository, choose the lab that you would like to build
upon, and get started at the appropriate section below.

Grails Todo Application Lab
====================

To get started with the Grails Todo Application Lab, import the todo-grails-spock folder into your favorite IDE as a 
Grails project.

* For IntelliJ go to https://www.jetbrains.com/idea/webhelp/creating-grails-application-from-existing-code.html
* For Eclipse go to http://stackoverflow.com/questions/3107329/is-there-a-grails-command-to-regenerate-project-files-for-eclipse-or-sts

To run the Spock specifications, just run the normal Grails command from your IDE run menus. From a terminal you can
also execute the tests using the Grails wrapper from the todo-grails-spock directory like so:

```
./grailsw test-app
```

To add new Spock specifications, add a new Groovy class in the test/unit directory under an appropriate package name
and make sure that the class extends spock.lang.Specification. Then take a look at the other tests to see how you can
define your own scenarios.

Dropwizard Todo Application Lab
====================

Coming soon...
