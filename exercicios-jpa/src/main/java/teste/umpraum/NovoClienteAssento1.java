package teste.umpraum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	
	public static void main(String[] args) {
		
		Assento assento = new Assento("16C");
		Cliente cliente = new Cliente("Ana", assento);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.persist(cliente);
		em.persist(assento);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
