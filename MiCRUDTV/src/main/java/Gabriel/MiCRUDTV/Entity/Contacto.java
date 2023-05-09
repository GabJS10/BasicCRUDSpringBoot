package Gabriel.MiCRUDTV.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "contactos")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false, length = 50)
	@NotBlank
	@Size(min=5, message="El nombre debe contener 5 o mas caracteres")
	private String nombre;

	@Column(name = "email", nullable = false, length = 50)
	@NotBlank
	@Email(regexp = "^(?=.{1,64}@)(?!.*\\.\\.)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@(?!.*\\.\\.)"
	        + "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "Email no valido")
	private String email;

	@Column(name = "fechaNacimiento", nullable = false)
	@NotNull(message="la fecha de nacimineto no puede ser nula")
	@Past(message="Ingrese una fecha valida")
	private LocalDate fechaNacimiento;

	@Column(name = "fechaRegistro", nullable = false)
	private LocalDateTime fechaRegistro;

	public Contacto() {
	}

	public Contacto(Long id, String nombre, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}

	public Contacto(String nombre, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegistro) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}
	
	
	
}
