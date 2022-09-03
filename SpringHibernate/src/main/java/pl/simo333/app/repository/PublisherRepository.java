package pl.simo333.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.simo333.app.domain.Publisher;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> findByNip(String nip);

    Optional<Publisher> findByRegon(String regon);
}
