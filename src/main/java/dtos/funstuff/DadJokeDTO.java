package dtos.funstuff;

public class DadJokeDTO {
    private String id;
    private String joke;
    /*
     * Note that the status property is missing, and we only have a default constructor.
     * Gson reflects the properties from the JSON into the identically named variables where possible automatically.
     */

    public DadJokeDTO() {
    }
}
