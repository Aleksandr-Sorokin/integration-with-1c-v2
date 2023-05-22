package ru.sorokin.serverintegration1c.services.book.mapper;

public interface BookMapper {
    <T> T toBookTargetState(Object bookSource, Class<T> classBookTarget);
}
