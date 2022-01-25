package net.codejava.hibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactos")
public class Contacto implements Serializable {
	private Integer id;
	private String Nombre;
	private String Apellidos;
	private String NumeroTelefono;
	private String Email;
	
	@Column(name="id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="Nombre")
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Column(name="Apellidos")
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	@Column(name="NumeroTelefono")
	public String getNumeroTelefono() {
		return NumeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		NumeroTelefono = numeroTelefono;
	}
	@Column(name="Email")
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", NumeroTelefono="
				+ NumeroTelefono + ", Email=" + Email + "]";
	}
	
	
	
}
