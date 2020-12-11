package biblioteca.biblio.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PRESTAMO")
public class Prestamo {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@CreationTimestamp
	@Column(name = "FECHA_PRESTAMO", unique = false, nullable = false, length = 9, updatable = false)
	private Timestamp fechaPrestamo;

	@CreationTimestamp
	@Column(name = "FECHA_DEVOLUCION", unique = false, nullable = false, length = 9, updatable = false)
	private Timestamp fechaDevolucion;

	@Column(name = "ESTADO")
	private boolean estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIBRO_ID", nullable = false)
	@JsonIgnoreProperties({"prestamos", "hibernateLazyInitializer", "handler"})
	private Libro libro;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ESTUDIANTE_ID")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Estudiante estudiante;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Timestamp fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Timestamp getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
