package com.congregation.config;

import com.congregation.filter.CustomRandomHeaderFilter;
import com.congregation.model.RandomStringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import javax.servlet.Filter;

@Configuration
class WebFilterConfig {

    @Autowired
    private RandomStringRepository randomStringRepository;

    @Bean
    Filter customRandomHeaderFilter() throws IOException {
        return new CustomRandomHeaderFilter("Chuck-Norris-Fact", randomStringRepository);
    }
}
