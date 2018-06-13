package de.roamingthings.fn;

import com.fnproject.fn.testing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class HelloFunctionTest {

    @Rule
    public final FnTestingRule testing = FnTestingRule.createDefault();

    @Test
    public void shouldReturnWithInput() {
        testing.givenEvent().withBody("{\"name\": \"Bob\"}").enqueue();
        testing.thenRun(HelloFunction.class, "handleRequest");

        FnResult result = testing.getOnlyResult();
        assertEquals( "{\"salutation\":\"Hello, Bob! Have a nice day!\"}", result.getBodyAsString());
    }
}