package miu.edu.cs.asd.pageabletodemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.pageabletodemo.dto.BookRequestDto;
import miu.edu.cs.asd.pageabletodemo.dto.BookResponseDto;
import miu.edu.cs.asd.pageabletodemo.model.Book;
import miu.edu.cs.asd.pageabletodemo.repository.BookRepository;
import miu.edu.cs.asd.pageabletodemo.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    @Override
    public Optional<List<BookResponseDto>> addAllBooks(List<BookRequestDto> bookRequestDtoList) {
        //map from list of BookRequestDto to list of books
        List<Book> books = modelMapper.map(bookRequestDtoList, new TypeToken<List<Book>>() {}.getType());
        List<Book> savedBooks = bookRepository.saveAll(books);
        //map from list of Book to list of BookResponseDto
        List<BookResponseDto> bookResponseDtoList = modelMapper.map(savedBooks, new TypeToken<List<BookResponseDto>>() {}.getType());
        return Optional.of(bookResponseDtoList);
    }

    @Override
    public Page<BookResponseDto> findAllBooks(int pageNumber, int pageSize, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(direction),
                sortBy);
        //Returns a page of book entities
        Page<Book> bookPage = bookRepository.findAll(pageable);
        List<BookResponseDto> bookResponseDtoList = bookPage.stream().map(book -> modelMapper.map(book, BookResponseDto.class))
                .toList();
        System.out.println("Intermediate result: " + bookResponseDtoList);
        //return modelMapper.map(page, new TypeToken<Page<BookResponseDto>>() {}.getType());
        return new PageImpl<>(bookResponseDtoList, pageable, bookPage.getTotalElements());
    }
}
