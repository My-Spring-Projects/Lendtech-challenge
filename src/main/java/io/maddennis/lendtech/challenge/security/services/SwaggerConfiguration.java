package io.maddennis.lendtech.challenge.security.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.maddennis.lendtech.challenge"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Lendtech Challenge API")
                .description("")
                .version("")
                .license("Apache 2.0")
                .licenseUrl("")
                .contact(new Contact("Lendtech","lendtech.io","info@lendtech.io"))
                .build();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/lendtech-challenge/v2/lendtech-challenge-docs", "/v2/lendtech-challenge-docs");
        registry.addRedirectViewController("/lendtech-challenge/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/lendtech-challenge/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/lendtech-challenge/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/lendtech-challenge/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");

        registry.addResourceHandler("/lendtech-challenge/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
