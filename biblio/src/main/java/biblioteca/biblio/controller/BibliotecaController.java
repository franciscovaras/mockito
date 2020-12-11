package biblioteca.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biblioteca.biblio.entity.Libro;
import biblioteca.biblio.service.BibliotecaService;

@RestController
@RequestMapping(path = ("/api"))
public class BibliotecaController {

	@Autowired
	BibliotecaService bibliotecaService;
	
	
	@GetMapping(path = "respuesta/{libroId}")
	Libro getLibroById(@PathVariable Long libroId) {

	return bibliotecaService.retrieveLibro(libroId);
	}

	

	@GetMapping(path = "respuesta/all")
	List<Libro> getAll() {

		return bibliotecaService.getAll();
	}

}
