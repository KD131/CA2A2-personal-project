package facades;

import dtos.AuthorDTO;
import dtos.BookDTO;
import entities.Author;
import entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class BookFacade {
    private static EntityManagerFactory emf;
    private static BookFacade instance;

    private BookFacade() {
    }

    public static BookFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookFacade();
        }
        return instance;
    }

    public BookDTO addBookToUser(String userName, BookDTO bookDTO) {
        // check if book exists in db
        // if not, create
        return null;
    }

    public BookDTO createBook(BookDTO bookDTO) {
        EntityManager em = emf.createEntityManager();
        Book newBook = new Book(bookDTO);
        newBook.setAuthors(getAuthorsOrCreateNew(em, bookDTO.getAuthors()));
        try {
            em.getTransaction().begin();
            em.persist(newBook);
            em.getTransaction().commit();
            return new BookDTO(newBook);
        }
        finally {
            em.close();
        }
    }

    private List<Author> getAuthorsOrCreateNew(EntityManager em, List<AuthorDTO> dtos) {
        List<Author> entities = new ArrayList<>();
        for (AuthorDTO dto : dtos) {
            Author newEntity = null;
            newEntity = em.find(Author.class, dto.getKey());
            if (newEntity == null) {
                newEntity = new Author(dto);
            }
            entities.add(newEntity);
        }
        return entities;
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        EntityManager em = emf.createEntityManager();
        Author newAuthor = new Author(authorDTO);
        try {
            em.getTransaction().begin();
            em.persist(newAuthor);
            em.getTransaction().commit();
            return new AuthorDTO(newAuthor);
        }
        finally {
            em.close();
        }
    }
}
