package serpis.ad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateCategoria {
	
	private static EntityManagerFactory entityManagerFactory;
	

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory( "serpis.ad.lpa.mysql" );

		insertCategorias();				
		showCategorias();
		updateCategorias();
		deleteCategorias();
		
		entityManagerFactory.close();
	}
	
	public static void showCategorias(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Categoria> result = entityManager.createQuery( "from Categoria", Categoria.class ).getResultList();
		for ( Categoria cate : result ) {
			System.out.println( "Categoria: " + cate.getNombre() + ", id: " + cate.getId());
		}
		
        entityManager.getTransaction().commit();
        entityManager.close();


	}
	
	public static void insertCategorias(){
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setNombre("NuevaCateHiber123");
		entityManager.persist(categoria);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		
	}
	
	
	public static void updateCategorias(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = entityManager.find(Categoria.class,1);
		categoria.setNombre("Actualizada");
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}

	
	public static void deleteCategorias(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = entityManager.find(Categoria.class,1);
		entityManager.remove(categoria);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		
	}
}
