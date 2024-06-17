package java13.projectbook.service;


import java13.projectbook.dto.BookRequest;
import java13.projectbook.dto.BookResponse;
import java13.projectbook.dto.SimpleResponse;

import java.util.List;

public interface BookService {

    List<BookResponse>getAllBooks();

    BookResponse getBooksById(Long id);

    SimpleResponse createBook(BookRequest bookRequest);

    SimpleResponse updateBook(Long id , BookRequest bookRequest);

    SimpleResponse deleteBook(Long id);

}
