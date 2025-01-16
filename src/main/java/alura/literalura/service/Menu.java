package alura.literalura.service;

public class Menu {
    public void showMenu() {
        System.out.println("""
                ===== Menu Inicial =====
                
                1- Adicionar Livro ao Banco de Dados
                2- Listar Livros Armazenados
                3- Listar Autores Armazenados
                4- Listar Livros em um Idioma
                5- Top 5 Livros mais Baixados
                6- Top 5 Autores com mais Livros Baixados
                
                0- Encerrar
                
                ========================
                """);
    }

    public void languageMenu() {
        System.out.println("""
                ===== Idiomas =====
                1- pt
                2- en
                
                0- Cancelar
                """);
    }
}
