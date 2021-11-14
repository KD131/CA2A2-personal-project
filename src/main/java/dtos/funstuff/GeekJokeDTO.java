package dtos.funstuff;

public class GeekJokeDTO {
    private String note =
            "Almost always gives a Chuck joke, which is not a geek joke, but I didn't make the API. " +
                    "It'd be way better to fetch a programming joke from https://v2.jokeapi.dev/joke/Programming?type=single&format=json.";
    private String joke;

    public GeekJokeDTO() {
    }
}
