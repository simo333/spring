package pl.simo333.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.simo333.app.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);

    Optional<Author> findByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);

    @Query("select a from Author a where a.email like ?1%")
    List<Author> queryByEmailLike(String email);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> queryByPeselLike(String pesel);

}
