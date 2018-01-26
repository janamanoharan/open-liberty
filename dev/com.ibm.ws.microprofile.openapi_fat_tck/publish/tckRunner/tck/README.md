# Instructions for Tck Runner


### Setup 
1. Create a Liberty server with the following features
    - mpOpenAPI-1.0
    - localConnector-1.0

So your server configurations should look like this:
```
    <featureManager>
    	<feature>localConnector-1.0</feature>
	<feature>mpOpenAPI-1.0</feature>
    </featureManager>
```

2. Clone this repository.
3. Navigate into the ``/mp-openapi-tck-runner/src/test/resources`` directory and open the ``arquillian.xml`` file 
4. Edit the ``wlpHome`` configuration property such that it points to the location of the WLP runtime in which your server will be running in 

```
    <container qualifier="websphere" default="true">
        <configuration>
            <property name="wlpHome">/Users/navid/Development/wlps/openLiberty/wlp</property>
            ...
        </configuration>
    </container>
```

### Running Tests

1. To run all the tests that you have written, use the following command:
```
$ mvn clean test
```
2. To run a specific test, use the ``-Dtest`` argument to specify the test class you would like to run. Suppose you have a class called ``ExampleTest.java``, then you would use the following commamnd:
```
$ mvn clean test -Dtest=ExampleTest
```
