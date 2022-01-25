package net.codejava.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UsoContactos {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		int opcion;

		do {

			System.out.println("opcion 1: añadir");
			System.out.println("opcion 2: buscar");
			System.out.println("opcion 3: modificar");
			System.out.println("opcion 4: eliminar");
			System.out.println("opcion 5: buscarSql");
			System.out.println("opcion 0: salir del programa");
			opcion = tec.nextInt();
			switch (opcion) {

			case 1:
				System.out.println("vas a añadir un nuevo usuario");
				System.out.println("Nombre:");
				String nombre = tec.next();
				System.out.println(nombre);
				System.out.println("Apellidos:");
				String apellidos = tec.next();
				System.out.println(apellidos);
				System.out.println("Teléfono:");
				String tlf = tec.next();
				System.out.println("Email:");
				String email = tec.next();

				añadir(nombre, apellidos, tlf, email);
				break;

			case 2:
				System.out.println("Vas a buscar un usuario. Especifica su id:");
				Integer id = tec.nextInt();
				buscar(id);
				break;

			case 3:
				modificar();
				break;

			case 4:
				eliminar();
				break;

			case 5:
				buscarSql();
				break;

			case 0:
				System.out.println("Adiós");
				break;

			default:
				System.out.println("Elige una opción correcta");
				break;
			}
		} while (opcion != 0);

		tec.close();
	}

	private static void añadir(String nombre, String Apellidos, String tlf, String email) {

		// Leer los datos de un nuevo registro (dar de alta), almacenándolo.)

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Agenda");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		Contacto c1 = new Contacto();

		c1.setNombre(nombre);
		c1.setApellidos(Apellidos);
		c1.setNumeroTelefono(tlf);
		c1.setEmail(email);

		entityManager.persist(c1);
		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}

	private static void buscar(Integer id) {
		// Buscar una persona de la agenda leyendo de teclado su nombre y apellidos. Se
		// visualizará el resto de los datos

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Agenda");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		Integer PK = id;

		// El metodo find pide la clase y el argumento con el cual se buscará una
		// instacia en la base de datos
		Contacto c2 = entityManager.find(Contacto.class, PK);
		entityManager.flush();

		System.out.println(c2);

		entityManager.close();
		factory.close();

	}

	private static void modificar() {

		// Modificar el teléfono o e_mail, de una persona que se pedirá por teclado
		Scanner tec = new Scanner(System.in);

		System.out.println("Vas a modificar un usuario. Especifica el id del usuario a modificar");
		Integer id = tec.nextInt();

		System.out.println("vas a modificar el usuario con id: " + id);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Agenda");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		Contacto cMod = new Contacto();
		cMod.setId(id);
		System.out.println("nuevo nombre:");
		cMod.setNombre(tec.next());

		System.out.println("nuevos Apellidos:");
		cMod.setApellidos(tec.next());

		System.out.println("nuevo email:");
		cMod.setEmail(tec.next());

		System.out.println("nuevo teléfono");
		cMod.setNumeroTelefono(tec.next());

		entityManager.merge(cMod);
		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}

	private static void eliminar() {

		// Eliminar una persona de la agenda telefónica dando su nombre y apellidos.

		Scanner tec = new Scanner(System.in);

		System.out.println("Vas a eliminar a un usuario. Especifica el id del usuario a eliminar");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Agenda");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Integer pk = tec.nextInt();

		Contacto eliminar = entityManager.getReference(Contacto.class, pk);

		entityManager.remove(eliminar);
		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}

	private static void buscarSql() {

		Scanner tec = new Scanner(System.in);

		System.out.println("Vas a buscar a un usuario por el nombre. Especifica el nombre del usuario.");

		String nombre = tec.next();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Agenda");

		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		String jpql = "SELECT c FROM Contacto c WHERE c.nombre = '" + nombre + "'";

		Query query = entityManager.createQuery(jpql);
		entityManager.getTransaction().commit();

		Contacto c1 = (Contacto) query.getSingleResult();

		System.out.println(c1);

		entityManager.close();
		factory.close();
	}

}