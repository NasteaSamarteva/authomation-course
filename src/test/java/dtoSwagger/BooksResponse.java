package dtoSwagger;

import java.util.List;

public class BooksResponse {

    private List<BookDto> books;

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
