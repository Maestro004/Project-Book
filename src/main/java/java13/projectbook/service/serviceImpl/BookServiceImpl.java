package java13.projectbook.service.serviceImpl;


import jakarta.transaction.Transactional;
import java13.projectbook.dto.BookRequest;
import java13.projectbook.dto.BookResponse;
import java13.projectbook.dto.SimpleResponse;
import java13.projectbook.entity.Book;
import java13.projectbook.mapper.BookMapper;
import java13.projectbook.repository.BookRepository;
import java13.projectbook.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;
    private final RestTemplateAutoConfiguration restTemplateAutoConfiguration;

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponse getBooksById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toResponse)
                .orElse(null);

    }

    @Override
    public SimpleResponse createBook(BookRequest bookRequest) {
        Book book = bookMapper.toEntity(bookRequest);
        bookRepository.save(book);
        return new SimpleResponse(HttpStatus.OK,"Successfully");
    }

    @Override
    public SimpleResponse updateBook(Long id, BookRequest bookRequest) {
        Book existingBook = bookRepository.findById(id).orElseThrow();
        existingBook.setTitle(bookRequest.title());
        existingBook.setTitle(bookRequest.author());

        return new SimpleResponse(HttpStatus.OK,"Successfully");
    }

    @Override
    public SimpleResponse deleteBook(Long id) {
        bookRepository.deleteById(id);

        return new SimpleResponse(HttpStatus.OK,"Successfully");
    }
}
