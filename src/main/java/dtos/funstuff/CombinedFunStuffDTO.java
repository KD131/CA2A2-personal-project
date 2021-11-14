package dtos.funstuff;

public class CombinedFunStuffDTO {
    private DadJokeDTO dadJoke;
    private ChuckJokeDTO chuckJoke;
    private SingleLineJokeDTO singleLineJoke;
    private BreadJokeDTO breadJoke;
    private YoMamaJokeDTO yoMamaJoke;
    private GeekJokeDTO geekJoke;
    private CatFactDTO catFact;
    private FriendsQuoteDTO friendsQuote;

    public CombinedFunStuffDTO(DadJokeDTO dadJoke, ChuckJokeDTO chuckJoke, SingleLineJokeDTO singleLineJoke, BreadJokeDTO breadJoke, YoMamaJokeDTO yoMamaJoke, GeekJokeDTO geekJoke, CatFactDTO catFact, FriendsQuoteDTO friendsQuote) {
        this.dadJoke = dadJoke;
        this.chuckJoke = chuckJoke;
        this.singleLineJoke = singleLineJoke;
        this.breadJoke = breadJoke;
        this.yoMamaJoke = yoMamaJoke;
        this.geekJoke = geekJoke;
        this.catFact = catFact;
        this.friendsQuote = friendsQuote;
    }
}
