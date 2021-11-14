package dtos.funstuff;

public class SingleLineJokeDTO {
    private String category;
    private String joke;
    private Flags flags;
    private int id;

    public SingleLineJokeDTO() {
    }

    private class Flags {
        private boolean nsfw;
        private boolean religious;
        private boolean political;
        private boolean racist;
        private boolean sexist;
        private boolean explicit;
    }
}
