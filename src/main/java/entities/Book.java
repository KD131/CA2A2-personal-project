package entities;

import dtos.BookDTO;

import javax.persistence.*;
import java.util.Iterator;
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
    @JoinTable(name = "book_author")
    private List<Author> authors;

    public Book() {
    }

    public Book(BookDTO dto) {
        String isbn_10 = dto.getIsbn_10()[0];
        String isbn_13 = dto.getIsbn_13()[0];

        this.isbn = isbn_10 != null
                ? isbn_10
                : isbn_13;

        this.title = dto.getTitle();
        this.publish_date = dto.getPublish_date();
        this.first_sentence = dto.getFirst_sentence();
        this.number_of_pages = dto.getNumber_of_pages();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getFirst_sentence() {
        return first_sentence;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        removeAllAuthors();
        authors.forEach(this::addAuthor);
    }

    public void addAuthor(Author author) {
        if (author != null) {
            this.authors.add(author);
            author.getBooks().add(this);
        }
    }

    public void removeAuthor(Author author) {
        if (author != null) {
            this.authors.remove(author);
            author.getBooks().remove(this);
        }
    }

    public void removeAllAuthors() {
        Iterator<Author> iterator = authors.iterator();
        while (iterator.hasNext()) {
            Author author = iterator.next();
            if (author != null) {
                iterator.remove();
                author.getBooks().remove(this);
            }
        }
    }
}
