package com.practise.config;

import com.practise.service.ContentStrategy;
import com.practise.service.ImageContentStrategy;
import com.practise.service.VideoContentStategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {
    @Bean("videoContentStrategy")
    public ContentStrategy videoContentStrategy(){
        return  new VideoContentStategy();
    }

    @Bean("imageContentStrategy")
    @Primary
    public ContentStrategy imageContentStrategy(){
        return  new ImageContentStrategy();
    }
}
