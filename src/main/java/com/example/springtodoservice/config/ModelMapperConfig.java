package com.example.springtodoservice.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//ModelMapperConfig는 기존의 MapperUtil 클래스를 스프링으로 변경한 버전이라고 생각하면 된다.
//@Configuration을 이용하여 스프링 컨테이너 빈으로 등록하여 사용할 것이다.
//@Configuration는 해당 클래스가 스프링 빈에 대한 설정을 하는 클래스임을 명시해준다.
@Configuration
public class ModelMapperConfig {

    //getMapper()는 ModelMapper 반환하도록 설계
    //@Bean은 getMapper()의 실행 결과로 반환된 객체를 스프링의 빈(Bean)으로 등록시키는 역할을 수행한다.
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
