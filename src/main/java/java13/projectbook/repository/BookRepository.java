package java13.projectbook.repository;

import java13.projectbook.dto.BookResponse;
import java13.projectbook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("select new java13.projectbook.dto.BookResponse(b.id,b.title,b.author) from Book  b")
    List<BookResponse> getAllBook();


}
