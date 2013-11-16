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
also execute the specifications using the Grails wrapper from the todo-grails-spock directory like so:

```
./grailsw test-app
```

To add new Spock specifications, add a new Groovy class in the test/unit directory under an appropriate package name
and make sure that the class extends spock.lang.Specification. Then take a look at the other tests to see how you can
define your own scenarios.

To run the Grails server and connect to the REST endpoints, you can run the Grails application as usual with:

```
./grailsw run-app
```

Dropwizard Todo Application Lab
====================

To get started with the Dropwizard Todo Application Lab, import todo-dropwizard-spock into your favorite IDE as a
Gradle project:

* For IntelliJ go to http://www.jetbrains.com/idea/webhelp/importing-project-from-gradle-model.html
* For Eclipse go to http://www.gradle.org/docs/current/userguide/eclipse_plugin.html

To run the Spock specification, just run the normal Gradle command for 'build' from your IDE run menus. From a terminal
you may also execute the specifications using the Gradle wrapper from the todo-dropwizard-spock directory like so:

```
./gradlew build
```

To run the Dropwizard server and connect to the REST endpoints, you can use the 'run' target using Gradle like so:

```
./gradlew run
```
