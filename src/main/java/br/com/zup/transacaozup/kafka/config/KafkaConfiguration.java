package br.com.zup.transacaozup.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class KafkaConfiguration {

    @Bean
    JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }
}
