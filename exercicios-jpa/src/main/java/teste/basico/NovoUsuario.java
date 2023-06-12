package teste.basico;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario user1 = new Usuario("Marcos", "marcosklann13@gmail.com");
		//Usuario user2 = new Usuario("Marcelo", "marcelo.pozobon2@gmail.com");
		//Usuario user3 = new Usuario("Rafael", "rafabp@gmail.com");
		
		Usuario user4 = new Usuario();
		user4.setNome("Matheus");
		user4.setId(4L);
		user4.setEmail("matheus_teste@gmail.com");
		
		Usuario user5 = new Usuario();
		user5.setNome("Vini");
		user5.setId(5L);
		user5.setEmail("vini_teste@gmail.com");
		
		 Usuario user6 = 
				new Usuario("Leonardo", "leonardo_teste@gmail.com");
		 
		 Usuario user7 = new Usuario("Djalma", "djalma_teste@gmail.com");
		
		
		ArrayList<Usuario> lista_usuarios = new ArrayList();
		
		lista_usuarios.add(user4);
		lista_usuarios.add(user5);
		lista_usuarios.add(user6);

		//user1.setId(1L);
		//user4.setId(4L);
		//user5.setId(5L);
		//user6.setId(6L);
		user7.setId(7L);
		
		
		em.getTransaction().begin();
		//em.persist(user1);
		//em.persist(user4);
		//em.persist(user5);
		//em.persist(user6);
		em.persist(user7);
		em.getTransaction().commit();
		
		
		
		em.close();
		emf.close();
		
	}
	
	
}
