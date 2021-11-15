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

    @ManyToMany(mappedBy = "authors",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Book> books;



    public String getBirth_date() {
        return birth_date;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
