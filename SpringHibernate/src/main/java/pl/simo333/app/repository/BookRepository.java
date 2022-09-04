package pl.simo333.app.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.simo333.app.domain.Author;
import pl.simo333.app.domain.Book;
import pl.simo333.app.domain.Category;
import pl.simo333.app.domain.Publisher;


import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitle(String title);

    @Query("select b from Book b where b.title = ?1")
    List<Book> queryByTitle(String title);

    List<Book> findAllByTitleContains(String titleLike);

    List<Book> findAllByCategory(Category category);

    @Query("select b from Book b where b.category = :category")
    List<Book> queryByCategory(@Param("category") Category category);

    List<Book> findAllByCategory_Id(long categoryId);

    List<Book> findAllByAuthorsContaining(Author author);

    List<Book> findAllByPublisher(Publisher publisher);

    List<Book> findAllByRating(double rating);

    Optional<Book> findFirstByCategoryOrderByTitle(Category category);

    @Query("select b from Book b where b.rating between ?1 and ?2")
    List<Book> queryByRatingBetween(double rangeLow, double rangeHigh);

    @Query("select b from Book b where b.publisher = ?1")
    List<Book> queryByPublisher(Publisher publisher);

    @Query("select b from Book b where b.category = ?1 order by b.title")
    Optional<Book> queryFirstByCategory(Category category);
}
