package interfaces;

import models.Book;
import models.Dvd;
import models.Reader;

import java.util.List;

public interface LibraryManager {

    String addBook(Book book);

    String addDvd(Dvd dvd);

    void addReader(Reader reader);

    void deleteItem(String isbn);

    List<Book> getBooks();

    List<Dvd> getDvds();

    String borrowItem(String isbn, String readerId);

    double returnItem(String isbn);

    void reserveItem(String isbn, Reader readerReserved);

}
