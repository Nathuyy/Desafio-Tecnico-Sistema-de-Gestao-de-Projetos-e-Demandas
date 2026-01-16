package desafio.tecnico.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import desafio.tecnico.infrastructure.mapper.ProjectEntityMapper;
import desafio.tecnico.infrastructure.mapper.TaskEntityMapper;
import desafio.tecnico.web.mappers.ProjectMapper;
import desafio.tecnico.web.mappers.TaskMapper;

@Configuration
public class MapperConfig {
    
    @Bean
    public ProjectEntityMapper projectEntityMapper() {
        return new ProjectEntityMapper();
    }

    @Bean
    public TaskEntityMapper taskEntityMapper() {
        return new TaskEntityMapper();
    }

    @Bean
    public ProjectMapper projectMapper() {
        return new ProjectMapper();
    }

    @Bean
    public TaskMapper taskMapper() {
        return new TaskMapper();
    }
}
