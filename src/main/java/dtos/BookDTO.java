package dtos;

import entities.Book;

import java.util.List;

public class BookDTO {
    private String[] isbn_10;
    private String[] isbn_13;
    private String title;
    private String publish_date;
    private String first_sentence;
    private int number_of_pages;

    private List<AuthorDTO> authors;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.isbn_10 = new String[] { book.getIsbn() };
        this.isbn_13 = new String[] { book.getIsbn() };
        this.title = book.getTitle();
        this.publish_date = book.getPublish_date();
        this.first_sentence = book.getFirst_sentence();
        this.number_of_pages = book.getNumber_of_pages();
    }

    public String[] getIsbn_10() {
        return isbn_10;
    }

    public String[] getIsbn_13() {
        return isbn_13;
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

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }
}
