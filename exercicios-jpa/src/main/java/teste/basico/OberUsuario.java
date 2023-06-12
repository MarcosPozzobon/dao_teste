package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javassist.expr.NewArray;
import modelo.basico.Usuario;

public class OberUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Usuario getUsuario = em.find(Usuario.class, 5L);
		System.out.println(getUsuario.getNome());
		
		em.close();
		emf.close();
	}
}
