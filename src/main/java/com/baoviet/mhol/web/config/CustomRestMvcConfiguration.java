package com.baoviet.mhol.web.config;

import com.baoviet.mhol.persistence.model.Person;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import java.util.Set;

@Configuration
class CustomRestMvcConfiguration {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.setBasePath("/api");

                Reflections reflections = new Reflections("com.baoviet.mhol.persistence.model");

                /*Set<Class<? extends Object>> allClasses =
                        reflections.getSubTypesOf(Object.class);
                for (Class<?> clazz:
                     allClasses) {
                    config.exposeIdsFor(clazz);
                }*/
                config.exposeIdsFor(Person.class);
            }
        };
    }
}
