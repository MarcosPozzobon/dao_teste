package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		Produto produto1 = new Produto();
		produto1.setNome("Anafranil 25mg");
		produto1.setPreco(45.99);
		produto1.setId(1L);
		
		
		
		em.getTransaction().begin();
		em.merge(produto1);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
