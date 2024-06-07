package miu.edu.cs.asd.pageabletodemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String ISBN;
    private LocalDate publishedDate;
    private BigDecimal price;

    public Book(String title, String isbn, LocalDate  publishedDate, BigDecimal price) {
        this.title = title;
        this.ISBN = isbn;
        this. publishedDate =  publishedDate;
        this.price = price;
    }
}
