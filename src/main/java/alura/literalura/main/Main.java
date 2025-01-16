package alura.literalura.main;

import alura.literalura.repository.AuthorsRepository;
import alura.literalura.repository.BookRepository;
import alura.literalura.service.BookService;
import alura.literalura.service.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void run(BookRepository bookRepository, AuthorsRepository authorsRepository) {
        boolean running = true;

        Menu menu = new Menu();
        BookService bookService = new BookService();

        while (running) {
            menu.showMenu();

            switch (validadeMenu(0,6)) {
                case 0:
                    running = false;
                    break;
                case 1:
                    // 1- Adicionar Livro ao Banco de Dados
                    bookService.getBooks(bookRepository, authorsRepository);
                    break;

                case 2:
                    // 2- Listar Livros Armazenados
                    bookService.getBooksShow(bookRepository);
                    break;

                case 3:
                    // 3- Listar Autores Armazenados
                    bookService.getAuthorsShow(authorsRepository);
                    break;

                case 4:
                    // 4- Listar Livros em um Idioma
                    menu.languageMenu();
                    switch (validadeMenu(0,2)) {
                        case 1:
                            bookService.getBooksByLanguage(bookRepository, "pt");
                            break;
                        case 2:
                            bookService.getBooksByLanguage(bookRepository, "en");
                            break;
                        default:
                            break;
                    }
                    break;

                case 5:
                    // 5- Top 5 Livros mais Baixados
                    bookService.getTop5DownloadedBooks(bookRepository);

                    break;

                case 6:
                    // 6- Top 5 Autores com mais Livros Baixados
                    bookService.getTop5DownloadedAuthors(authorsRepository);
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        System.out.println("Programa finalizado");
    }

    public static int validadeMenu(int minValue, int maxValue) {
        while (true) {
            Scanner input = new Scanner(System.in);

            try {
                int value = input.nextInt();
                input.nextLine();
                if (value >= minValue && value <= maxValue) {
                    return value;
                } else { throw new IllegalArgumentException("Valor fora do range das opções!"); }

            } catch (InputMismatchException e) {
                System.err.println("Informe um valor numérico!");

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }



    }
}
