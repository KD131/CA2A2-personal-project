package entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "book")
@Entity
public class Book {
    @Id
    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "publish_date", length = 40)
    private String publish_date;

    @Column(name = "first_sentence")
    private String first_sentence;

    @Column(name = "number_of_pages")
    private int number_of_pages;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Author> authors;



    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getTitle() {
        return title;
    }

    public String getFirst_sentence() {
        return first_sentence;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
