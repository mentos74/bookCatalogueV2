package com.mentos74.catalogue.util;

import com.mentos74.catalogue.dto.ResultPageResponseDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public class PaginationUtil {

    public static <T> ResultPageResponseDTO<T> createResultDTO(List<T> dtos, Long totalElement, Integer pages) {

        ResultPageResponseDTO <T> result = new ResultPageResponseDTO<T>();
        result.setElements(totalElement);
        result.setPages(pages);
        result.setResult(dtos);
        return result;
    }

    public static Sort.Direction getSortBy(String sortBy) {
        if (sortBy.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;

        } else {
            return Sort.Direction.DESC;
        }
    }
}
