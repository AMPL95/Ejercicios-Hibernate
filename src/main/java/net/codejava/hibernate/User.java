package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* Entity indica que la clase user es el nombre de la TABLA(no de la base de datos), sin embargo en nuestra base de 
    datos la tabla se llama users con s y no user, con lo cual con la etiqueta @table se indica el nombre de la 
    Tabla a la que queremos hacer referencia con esa clase.*/
@Entity
@Table(name="users")
public class User {
	private Integer id;
	private String fullname;
	private String email;
	private String password;
	
	/*
	 * Las columnas de la tabla se indican con @column y el atributo que se introducirá en cada campo se obtiene del 
	 * GETTER. La clave primaria se indica con la etiqueta @id y ademas se le puede establecer un criterio de creacion
	 * cada vez que se crea un nuevo registro, esto se hace con el valor estrategy que puede ser de 4 tipos, el que nos
	 * interesa para que sea AUTOINCREMENTAL y UNICO es el IDENTITY 
	 */
	@Column(name= "User_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="fullname")
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@Column(name="Email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
