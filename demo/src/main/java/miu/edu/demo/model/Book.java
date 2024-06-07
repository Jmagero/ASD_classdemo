package miu.edu.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @NotBlank(message = " book title cannot be blank")
    private String title;
    @Column(unique = true)
    @NotBlank(message = "ISBN cannot be empty")
    private String isbn;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "books_authors",
            //ownership class
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "bookId"),
            },
            //associated class
            inverseJoinColumns = {
                    @JoinColumn(name="author_id", referencedColumnName = "authorID")
            }
    )
    private List<Author> authors;
}
