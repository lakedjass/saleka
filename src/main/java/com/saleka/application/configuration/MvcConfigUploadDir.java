/*
package com.saleka.application.configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfigUploadDir implements WebMvcConfigurer {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();

        factory.setMaxFileSize( DataSize.parse("124MB") );
        factory.setMaxRequestSize(DataSize.parse("124MB"));
        factory.setFileSizeThreshold(DataSize.parse("2KB"));
        return factory.createMultipartConfig();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //exposeFileDirectory("media/images", registry);
        //exposeFileDirectory("media/videos", registry);
        exposeFileDirectory("/images" , registry);
        exposeDirectory("/admin", registry);
        exposeDirectory("/assets", registry);
        //exposeFileDirectory("/images", registry);

    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("src/main/resources/static",dirName );
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");

        registry.addResourceHandler("src/main/resources/static" + dirName + "/**").addResourceLocations(uploadPath);
    }

    private void exposeFileDirectory(String dirName, ResourceHandlerRegistry registry) {
        registry.addResourceHandler("src/main/resources" + dirName + "/**")
                .addResourceLocations("classpath:" + dirName + "/")
                .setCachePeriod(60);
    }

}*/
