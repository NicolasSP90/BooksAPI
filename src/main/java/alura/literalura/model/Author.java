package alura.literalura.model;

import jakarta.persistence.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Year birthYear;
    private Year deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();


    // Constructor
    public Author() {}

    public Author(AuthorData authorData) {
        if (authorData.name().contains(", ")){
            var nameLast = authorData.name().split(", ")[0];
            var nameFirst = authorData.name().split(", ")[1];
            this.name = "%s %s".formatted(nameFirst, nameLast);
        } else if (authorData.name().contains(",")) {
            var nameLast = authorData.name().split(",")[0];
            var nameFirst = authorData.name().split(",")[1];
            this.name = "%s %s".formatted(nameFirst, nameLast);
        } else {
            this.name = authorData.name();
        }

        this.birthYear = authorData.birthYear() != null ? Year.of(authorData.birthYear()) : null;
        this.deathYear = authorData.deathYear() != null ? Year.of(authorData.deathYear()) : null;
    }

    // Getters and Setters
    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public Year getBirthYear() { return this.birthYear; }
    public void setBirthYear(Year birthYear) { this.birthYear = birthYear; }

    public Year getDeathYear() { return this.deathYear; }
    public void setDeathYear(Year deathYear) { this.deathYear = deathYear; }

    public List<Book> getBooks() { return this.books; }
    public void setBooks(List<Book> books) { this.books = books; }


    @Override
    public String toString() { return "%s [%s - %s]".formatted(getName(), getBirthYear(), getDeathYear()); }

}
