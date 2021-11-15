package dtos;

import entities.Author;

public class AuthorDTO {
    private String key;
    private String name;
    private String birth_date;
    private Bio bio;

    public AuthorDTO() {
    }

    public AuthorDTO(Author author) {
        this.key = author.getId();
        this.name = author.getName();
        this.birth_date = author.getBirth_date();
        this.bio = new Bio();
//        this.bio.value = author.getBio();
    }

    private class Bio {
        private String value;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getBio() {
        return bio != null
                ? bio.value
                : null;
    }

    // this could also be done in a deserializer but this is somewhat simpler
    public void convertKey(String oldKey) {
        String[] keyArray = oldKey.split("/");
        this.key = keyArray[keyArray.length - 1];
    }
}
