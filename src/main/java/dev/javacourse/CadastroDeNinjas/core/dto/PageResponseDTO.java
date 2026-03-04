package dev.javacourse.CadastroDeNinjas.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@NoArgsConstructor
public class PageResponseDTO<T> {

    private List<T> content;      // A lista de ninjas em si
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;


    public PageResponseDTO(Page<T> pageResult) {
        this.content = pageResult.getContent();
        this.page = pageResult.getNumber();
        this.size = pageResult.getSize();
        this.totalElements = pageResult.getTotalElements();
        this.totalPages = pageResult.getTotalPages();
    }
}
