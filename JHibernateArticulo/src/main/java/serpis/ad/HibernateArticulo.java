package serpis.ad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateArticulo{
	
	private static EntityManagerFactory entityManagerFactory;
	

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory( "serpis.ad.lpa.mysql" );

		insertArticulos();				
		showArticulos();
		
		entityManagerFactory.close();
	}
	
	public static void showArticulos(){
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
        List<Articulo> result = entityManager.createQuery( "from Articulo", Articulo.class ).getResultList();
		for ( Articulo cate : result ) {
			System.out.println( "Articulo: " + cate.getNombre() );
		}
		
        entityManager.getTransaction().commit();
        entityManager.close();


	}
	
	public static void insertArticulos(){
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Articulo articulo = new Articulo();
		articulo.setNombre("NuevoArticuloHibernate");
		articulo.setPrecio(1234);
		entityManager.persist(articulo);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		
	}
	
	
	public static void updateCategorias(){
		
		
	}

	
	public static void deleteCategorias(){
		
		
	}
}
