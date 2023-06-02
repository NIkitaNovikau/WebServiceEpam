# WebServiceEpam
1.	Intro
1. Create and run a simple web/REST service locally using any open (for example, publicly available on the Internet) example using Java stack: Spring (Spring Boot)/maven/gradle/Jersey/Spring MVC. 2. Add a GET endpoint that accepts input parameters as queryParams in the URL and returns the result as JSON according to the option. 
2.	Error logging/handling
1. Add validation of input parameters with return of 400 errors, 2. Add processing of internal unchecked errors with return of 500 errors 3. Add logging of actions and errors 4. Write unit test 
3.	Collections intro, project structure 
1. Add the simplest cache in the form of an in-memory Map for the service. The map should be contained in a separate bin/class, which should be added to the main service using the dependency injection Spring mechanism
4.	Concurrency 
1. Add a service for counting calls to the main service. The counter must be implemented as a separate class, access to which must be synchronized. 2. Using jmeter/postman or any other means, configure the load test and make sure that the request counter works correctly under heavy load.
