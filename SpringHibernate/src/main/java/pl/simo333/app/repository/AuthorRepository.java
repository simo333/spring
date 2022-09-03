package pl.simo333.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.simo333.app.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);

    Optional<Author> findByPesel(String pesel);

    List<Author> findAllByLastName(String lastName);

}
