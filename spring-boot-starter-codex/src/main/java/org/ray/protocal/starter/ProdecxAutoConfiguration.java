package org.ray.protocal.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ray.build.CodexBuilder;

@Configuration
public class ProdecxAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public CodexBuilder codexBuilder(){
        return new CodexBuilder();
    }
}
