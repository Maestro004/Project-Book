package java13.projectbook.mapper;


import java13.projectbook.dto.BookRequest;
import java13.projectbook.dto.BookResponse;
import java13.projectbook.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookResponse toResponse(Book book);


    Book toEntity(BookRequest bookRequest);

}
