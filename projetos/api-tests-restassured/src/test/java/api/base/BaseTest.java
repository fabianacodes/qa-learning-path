package api.base;

import org.junit.jupiter.api.BeforeAll;

import api.config.RestConfig;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {

    protected static RequestSpecification spec;

    @BeforeAll
    static void setupBase() {
        spec = RestConfig.defaultSpec();
    }
}