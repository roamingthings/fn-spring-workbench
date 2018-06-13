package de.roamingthings.fn;

import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class HelloService {
    public String sayHello(String name) {
        return format("Hello, %s! Have a nice day!", name);
    }
}
