package dtos;

public class WikipediaArticleDTO {
    private String title;
    private String description;
    private int pageid;
    private String extract;
    private String url;
    private Thumbnail thumbnail;

    public WikipediaArticleDTO(String title, String description, int pageid, String extract, String url, String thumbnail_source, int thumbnail_width, int thumbnail_height) {
        this.title = title;
        this.description = description;
        this.pageid = pageid;
        this.extract = extract;
        this.url = url;
        this.thumbnail = new Thumbnail(thumbnail_source, thumbnail_width, thumbnail_height);
    }

    public class Thumbnail {
        private String source;
        private int width;
        private int height;

        public Thumbnail(String thumbnail_source, int width, int height) {
            this.source = thumbnail_source;
            this.width = width;
            this.height = height;
        }
    }
}
