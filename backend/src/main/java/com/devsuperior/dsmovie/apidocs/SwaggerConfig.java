package com.devsuperior.dsmovie.apidocs;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig{

    public SwaggerConfig() {
        super("com.devsuperior.dsmovie.endpoint");
    }
}
