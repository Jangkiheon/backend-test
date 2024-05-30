package kr.co.polycube.backendtest.config;

import kr.co.polycube.backendtest.filter.SpecialCharacterFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;


@Configuration
public class Webconfig implements WebMvcConfigurer {

    @Bean
    public Filter filter() {
        return new SpecialCharacterFilter();
    }
}
