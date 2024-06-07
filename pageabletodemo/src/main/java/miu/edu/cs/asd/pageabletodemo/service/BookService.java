package miu.edu.cs.asd.pageabletodemo.service;

import miu.edu.cs.asd.pageabletodemo.dto.BookRequestDto;
import miu.edu.cs.asd.pageabletodemo.dto.BookResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<List<BookResponseDto>> addAllBooks(List<BookRequestDto> bookRequestDtoList);
    Page<BookResponseDto> findAllBooks(int pageNumber, int pageSize, String direction, String sortBy );
}
