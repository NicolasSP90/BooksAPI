package alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String languages;
    private int downloads;

    @ManyToOne
    private Author author;


    // Constructor
    public Book() { }

    public Book(BookData bookData, Author author) {
        this.title = bookData.title();
        setLanguages(bookData.languages());
        this.downloads = bookData.downloads();
        this.author = author;
    }


    // Getters and Setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() { return this.author; }
    public void setAuthor(Author author) { this.author = author; }

    public String getLanguages() { return this.languages; }
    public void setLanguages(List<String> languages) { this.languages = String.join(",", languages); }

    public int getDownloads() { return this.downloads; }
    public void setDownloads(int downloads) { this.downloads = downloads; }

    @Override
    public String toString() { return
            "Livro: %s\n".formatted(getTitle()) +
                    "Autor %s\n".formatted(getAuthor()) +
                    "Idiomas: %s\n".formatted(getLanguages()) +
                    "Downloads: %d\n".formatted(getDownloads()); }
}
