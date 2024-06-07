package br.com.fiap.inovacao.azul.api.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sea Clean Reporter")
                        .version("1.0.0")
                        .description("API implementada para a Global Solution FIAP do Primeiro Semestre 2024"));
    }
}
