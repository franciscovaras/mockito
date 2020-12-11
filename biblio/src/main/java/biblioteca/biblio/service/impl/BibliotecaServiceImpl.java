package biblioteca.biblio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblio.entity.Libro;
import biblioteca.biblio.repositories.LibroRepository;
import biblioteca.biblio.service.BibliotecaService;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {

	@Autowired
	LibroRepository libroRepository;

	public Libro retrieveLibro(Long libroId) {
		Libro libro = libroRepository.findById(libroId).get();
		return libro; 
	}

	public List<Libro> getAll() {
		List<Libro> lista = libroRepository.findAll();
		return lista;
	}

}
