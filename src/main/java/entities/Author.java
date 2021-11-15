package entities;

import dtos.AuthorDTO;

import javax.persistence.*;
import java.util.ArrayList;
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

    /*
    // The bio is too long
    @Column(name = "bio")
    private String bio;
    */

    @ManyToMany(mappedBy = "authors",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Book> books;

    public Author() {
    }

    public Author(AuthorDTO dto) {
        this.id = dto.getKey();
        this.name = dto.getName();
        this.birth_date = dto.getBirth_date();
//        this.bio = dto.getBio();

        this.books = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirth_date() {
        return birth_date;
    }

//    public String getBio() {
//        return bio;
//    }

    public List<Book> getBooks() {
        return books;
    }
}
