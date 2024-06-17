package java13.projectbook.dto;

import lombok.Data;


public record BookRequest(
        String title,
        String author
) {


}
