package alura.literalura.repository;

import alura.literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);

    List<Book> findBooksByLanguages(String language);

    @Query("SELECT b FROM Book b ORDER BY b.downloads DESC LIMIT 5")
    List<Book> getTop5DownloadedBooks();
}
