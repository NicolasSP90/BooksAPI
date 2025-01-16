package alura.literalura.repository;

import alura.literalura.model.Author;
import alura.literalura.model.AuthorTop5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorsRepository extends JpaRepository<Author, Long> {
    Author findByNameIgnoreCase(String title);

    @Query("SELECT new alura.literalura.model.AuthorTop5 (a.name, SUM(b.downloads)) " +
            "FROM Author a JOIN a.books b " +
            "GROUP BY a.name, b.downloads " +
            "ORDER BY b.downloads DESC " +
            "LIMIT 5")
    List<AuthorTop5> getTop5DownloadedAuthors();
}
