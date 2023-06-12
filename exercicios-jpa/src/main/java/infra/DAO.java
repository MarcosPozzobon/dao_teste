package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Produto;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			//...
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
		
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
		
	}
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	public DAO<E> incluir(E entidade){
		
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	public List<E> obterTodos(){
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtd_registros, int desloc){
		if(classe == null) {
			throw new 
			UnsupportedOperationException
			("Pra rodar essa bosta sem classe "
					+ "declarada é meio difícil, né?");
		}
		
		String jpql = "select e from" + classe.getName() + "e";
		TypedQuery<E> query = em.createNamedQuery(jpql, classe);
		query.setMaxResults(qtd_registros);
		query.setFirstResult(desloc);
		
		return query.getResultList();
		
	}
	public void fechar() {
		em.close();
	}

}
