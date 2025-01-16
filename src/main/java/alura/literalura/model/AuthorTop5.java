package alura.literalura.model;

public class AuthorTop5 {
    private String name;
    private Long downloads;

    public AuthorTop5(String name, Long downloads) {
        this.name = name;
        this.downloads = downloads;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public Long getDownloads() { return this.downloads; }
    public void setDownloads(Long downloads) { this.downloads = downloads; }

    @Override
    public String toString() {
        return "%s - %s downloads".formatted(getName(), getDownloads());
    }
}