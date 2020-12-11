package biblioteca.biblio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.biblio.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

	Optional<Libro> findById(Long id);

}
