package de.roamingthings.fn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloFunction {

    public static class Input {
        public String name;
    }

    public static class Result {
        public String salutation;
    }

    private HelloService helloService() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.fn");

        return context.getBean("helloService", HelloService.class);
    }

    public Result handleRequest(Input input) {
        Result result = new Result();
        result.salutation = helloService().sayHello(input.name);

        return result;
    }

}