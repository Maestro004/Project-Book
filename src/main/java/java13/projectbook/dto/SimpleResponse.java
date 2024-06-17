package java13.projectbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Builder
public class SimpleResponse {
    private HttpStatus httpStatus;
    private String message;
}
