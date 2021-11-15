package dtos;

public class AuthorDTO {
    private String name;
    private String birth_date;
    private Bio bio;

    private class Bio {
        private String value;
    }
}
