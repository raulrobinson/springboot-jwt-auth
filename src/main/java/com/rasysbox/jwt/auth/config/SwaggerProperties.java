package com.rasysbox.jwt.auth.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor()
@Configuration
@ConfigurationProperties(prefix = "swagger.properties")
public class SwaggerProperties {
    private String projectName;
    private String projectShortDescription;
    private String developerName;
    private String developerMail;
    private String projectTosMsg;
    private String projectTosLink;
    private String projectLicenceMsg;
    private String projectLicenceLink;
    private String organizationUrl;
}
