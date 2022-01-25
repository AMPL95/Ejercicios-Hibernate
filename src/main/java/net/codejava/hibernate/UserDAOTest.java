package net.codejava.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDAOTest {

	public static void main(String[] args) {
		
		
		//para designar la base de datos sobre la que queremos hacer la persistencia
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
		
		EntityManager entityManager = factory.createEntityManager();
		
		
		
		/*con esto creamos un nuevo usuario, previamente se habrán hecho las configuraciones para que los atributos de 
		 * este objeto sean las columnas de una tabla en la base de datos*/
		
		entityManager.getTransaction().begin();
		User newUser = new User();
		newUser.setEmail("otromail.com");
		newUser.setFullname("angelito5");
		newUser.setPassword("contraseña");
		 
		entityManager.persist(newUser);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();
		
		
		
		/* para que todas las transacciones sean satisfactorias deben tener un begin como inicializador y un commit 
		 * como finalizador, sino no se completarán, por eso no se me ejecutaba el cambio de contraseña. El video de
		 * la pagina crea los metodos begin() y end() donde se incluyen las aperturas del Factory, entityManager y
		 * trasaction.begin - transaction.commit - y los 2 close() respectiamente 
		 */
		
		/*entityManager.getTransaction().begin();
		User existingUser = new User();
		existingUser.setId(1);
		existingUser.setEmail("bill.joy@gmail.com");
		existingUser.setFullname("Bill Joy");
		existingUser.setPassword("billionaire");
		
		
		entityManager.merge(existingUser);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		factory.close();*/
	}

}
