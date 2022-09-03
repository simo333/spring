package pl.simo333.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Category;
import pl.simo333.app.domain.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    List<Book> findAllByTitleContains(String titleLike);

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByCategory_Id(long categoryId);

    List<Book> findAllByAuthorsContaining(Author author);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByRating(double rating);

    Optional<Book> findFirstByCategoryOrderByTitle(Category category);
}
