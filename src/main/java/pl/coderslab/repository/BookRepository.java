package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByAuthorOrTitle(String author, String title);
    List<Book> findBooksByBorrowedIsFalse ();


}
