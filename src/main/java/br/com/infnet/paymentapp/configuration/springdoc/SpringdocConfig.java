package br.com.infnet.paymentapp.configuration.springdoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring doc configuration.
 */
@Configuration
@OpenAPIDefinition(servers = @Server(url = "/", description = "Default Server URL"))
public class SpringdocConfig {

    @Value("${spring.application.formatted-name}")
    private String appName;

    /**
     * Define Swagger Api Definition.
     *
     * @return OpenAPI definition.
     */
    @Bean
    public OpenAPI openApiDefinition() {
        return new OpenAPI()
                .info(new Info().title(appName)
                        .description("Application manager.")
                        .version("v1.0.0"));
    }

}