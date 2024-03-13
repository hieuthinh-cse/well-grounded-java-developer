package config;

import aspect.LoggingAspect;
import entity.Homelander;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "service")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public Homelander homelander() {
        return new Homelander();
    }

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
