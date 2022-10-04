package com.rasysbox.jwt.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Component
public class SpringFoxConfig {

    @Value("/api/v1/products")
    private String uriBasePattern;

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket api() {
        String regexUri = this.uriBasePattern + ".*";

        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(regexUri))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {

        return new ApiInfo(
                this.swaggerProperties.getProjectName(),
                this.swaggerProperties.getProjectShortDescription(),
                this.swaggerProperties.getProjectTosMsg(),
                this.swaggerProperties.getProjectTosLink(),
                new Contact(
                        this.swaggerProperties.getDeveloperName(),
                        this.swaggerProperties.getOrganizationUrl(),
                        this.swaggerProperties.getDeveloperMail()),
                this.swaggerProperties.getProjectLicenceMsg(),
                this.swaggerProperties.getProjectLicenceLink(),
                Collections.emptyList()
        );
    }
}
