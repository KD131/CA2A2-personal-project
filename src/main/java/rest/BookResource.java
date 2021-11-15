package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.AuthorDTO;
import dtos.BookDTO;
import facades.BookFacade;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
public class BookResource {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final BookFacade BOOK_FACADE = BookFacade.getBookFacade(EMF);

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    private BookDTO getBookFromISBN(String isbn) throws IOException {
        String baseURL = "https://openlibrary.org";
        String url = String.format("%s/isbn/%s.json", baseURL, isbn);

        String jsonStr = HttpUtils.fetch(url);
        BookDTO fetchedBook = GSON.fromJson(jsonStr, BookDTO.class);

        List<AuthorDTO> fetchedAuthors = new ArrayList<>();
        for (AuthorDTO a : fetchedBook.getAuthors()) {
            String authorStr = HttpUtils.fetch(String.format("%s%s", baseURL, a.getKey()));
            AuthorDTO author = GSON.fromJson(authorStr, AuthorDTO.class);
            author.convertKey(author.getKey());
            fetchedAuthors.add(author);
        }
        fetchedBook.setAuthors(fetchedAuthors);
        return fetchedBook;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn}")
    public String postBook(@PathParam("isbn") String isbn) throws IOException {
        BookDTO fetchedBook = getBookFromISBN(isbn);
        BookDTO submittedBook = BOOK_FACADE.createBook(fetchedBook);
        return GSON.toJson(submittedBook);
    }
}