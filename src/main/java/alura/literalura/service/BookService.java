package alura.literalura.service;

import alura.literalura.model.*;
import alura.literalura.repository.AuthorsRepository;
import alura.literalura.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void getBooks(BookRepository bookRepository, AuthorsRepository authorsRepository){
        var json = APIconnection.searchByKeyword();

        ConvertData converter = new ConvertData();
        SearchData data = converter.IgetData(json, SearchData.class);

        if (!data.results().isEmpty()){
            BookData dataBook = data.results().getFirst();
            AuthorData dataAuthor = dataBook.authors().getFirst();

            Book bookInDB = bookRepository.findByTitle(dataBook.title());

            if (bookInDB != null){
                System.out.println("Livro já se encontra no banco de dados");
                System.out.println(bookInDB);

            } else {
                Author authorInDB = authorsRepository.findByNameIgnoreCase(dataAuthor.name());

                if (authorInDB != null){
                    Book book = new Book(dataBook, authorInDB);
                    bookRepository.save(book);
                    System.out.println("Livro adicionado com sucesso");

                } else {
                    Author author = new Author(dataAuthor);
                    authorsRepository.save(author);
                    Book book = new Book(dataBook, author);
                    bookRepository.save(book);
                    System.out.println("Livro adicionado com sucesso");
                    System.out.println(book);
                    System.out.println(author);
                }
            }

        } else {
            System.out.println("Livro não consta no acervo digital.");
        }
    }

    public void getBooksShow(BookRepository bookRepository){
        bookRepository.findAll().forEach(System.out::println);
    }

    public void getAuthorsShow(AuthorsRepository authorsRepository){
        authorsRepository.findAll().forEach(System.out::println);
    }

    public void getBooksByLanguage(BookRepository bookRepository, String language){
        bookRepository.findBooksByLanguages(language).forEach(System.out::println);
    }

    public void getTop5DownloadedBooks(BookRepository bookRepository){
        bookRepository.getTop5DownloadedBooks().forEach(System.out::println);
    }

    public void getTop5DownloadedAuthors(AuthorsRepository authorsRepository){
        authorsRepository.getTop5DownloadedAuthors().forEach(a -> System.out.println("%s - %s downloads".formatted(a.getName(), a.getDownloads())));
    }
}
