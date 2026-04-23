package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RestConfig {

    private RestConfig() {}

    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(EnvironmentConfig.baseUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                // ✅ loga apenas quando der erro (4xx/5xx)
                .addFilter(new ErrorLoggingFilter())
                .build();
    }
}