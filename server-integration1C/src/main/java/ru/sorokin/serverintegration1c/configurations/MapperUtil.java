package ru.sorokin.serverintegration1c.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class MapperUtil {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;
    }

    public static <R, E> List<R> convertList(List<E> inputList, Function<E, R> converter) {
        return inputList.stream().map(e -> converter.apply(e)).collect(Collectors.toList());
    }
}
