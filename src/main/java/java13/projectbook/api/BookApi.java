package java13.projectbook.api;


import java13.projectbook.dto.BookRequest;
import java13.projectbook.dto.BookResponse;
import java13.projectbook.dto.SimpleResponse;
import java13.projectbook.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor

public class BookApi {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        BookResponse bookResponse = bookService.getBooksById(id);
        return bookResponse != null? ResponseEntity.ok(bookResponse) : ResponseEntity.notFound().build();


    }

    @PostMapping
    public ResponseEntity<SimpleResponse> createBook(@RequestBody BookRequest bookRequest) {
        SimpleResponse createdBook = bookService.createBook(bookRequest);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateBook(@PathVariable Long id, @RequestBody BookRequest bookDTO) {
        try {
            return bookService.updateBook(id, bookDTO);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .httpStatus(OK)
                    .message("Success")
                    .build();

        }
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteBook(@PathVariable Long id) {

        return bookService.deleteBook(id);

    }
}
