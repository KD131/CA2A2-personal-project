package dtos;

import java.util.List;

public class BookDTO {
    private String[] isbn_10;
    private String[] isbn_13;
    private String title;
    private String publish_date;
    private String first_sentence;
    private int number_of_pages;

    private List<Author> authors;

    private class Author {
        private String key;
    }
}
