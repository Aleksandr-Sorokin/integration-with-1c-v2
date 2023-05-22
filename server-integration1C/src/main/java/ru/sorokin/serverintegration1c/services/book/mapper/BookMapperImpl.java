package ru.sorokin.serverintegration1c.services.book.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.sorokin.serverintegration1c.exceptions.ValidationException;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {

    private String emptyData = "Отсутствуют данные";
    private final ModelMapper mapper;

    @Override
    public <T> T toBookTargetState(Object bookSource, Class<T> classBookTarget) {
        if (bookSource != null) {
            return mapper.map(bookSource, classBookTarget);
        } else {
            throw new ValidationException(emptyData);
        }
    }
}
