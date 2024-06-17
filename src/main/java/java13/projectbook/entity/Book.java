package java13.projectbook.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Id_gen")
    @SequenceGenerator(name = "id_gen",sequenceName = "seq_name",allocationSize = 1)
    private Long id;
    private String title;
    private String author;

}
