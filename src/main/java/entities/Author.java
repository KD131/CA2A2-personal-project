package entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "author")
@Entity
public class Author {
    @Id
    @Column(name = "id", nullable = false, length = 16)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private String birth_date;

    @Column(name = "bio")
    private String bio;

    @ManyToMany(mappedBy = "authors",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Book> books;


}
