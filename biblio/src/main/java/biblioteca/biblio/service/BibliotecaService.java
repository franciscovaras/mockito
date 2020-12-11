package biblioteca.biblio.service;

import java.util.List;

import biblioteca.biblio.entity.Libro;

public interface BibliotecaService {

	Libro retrieveLibro(Long libroId);

	public List<Libro> getAll();

}
