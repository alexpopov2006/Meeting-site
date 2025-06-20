package com.meetingsite.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

@Schema(description = "Страница")
public record PageDto<T>(
        @Schema(description = "Контент")
        List<T> content,
        @Schema(description = "Номер страницы")
        Integer pageNumber,
        @Schema(description = "Количество элементов на странице")
        Integer elementsOnPage,
        @Schema(description = "Всего страниц")
        Integer totalPages,
        @Schema(description = "Всего элементов")
        Long totalElements
) {
    public <E> PageDto(Page<E> page, Function<E, T> mappingFunction) {
        this(page.getContent().stream().map(mappingFunction).toList(),
                page.getNumber(), page.getNumberOfElements(), page.getTotalPages(), page.getTotalElements());
    }
}