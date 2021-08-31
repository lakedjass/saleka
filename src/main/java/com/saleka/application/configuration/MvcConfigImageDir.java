package com.saleka.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfigImageDir implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        exposeDirectory("/static/media/images" , registry);
        exposeDirectory("/static" , registry);
        exposeDirectory("/static/assets" , registry);
        exposeDirectory("/static/admin" , registry);

    }

    private void exposeFileDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("src/main/resources",dirName );
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler(  dirName + "/**")
                .addResourceLocations(uploadPath + "/")
                .setCachePeriod(60*2)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        registry.addResourceHandler(  dirName + "/**")
                .addResourceLocations("classpath:" + dirName + "/")
                .setCachePeriod(60*2)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
