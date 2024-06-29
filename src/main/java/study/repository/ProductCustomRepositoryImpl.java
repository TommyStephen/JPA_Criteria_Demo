package study.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import study.model.Product;


public class ProductCustomRepositoryImpl implements ProductCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Product> findByNameContainingAndPriceLessThan(String name, Double price) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
		Root<Product> product = criteriaQuery.from(Product.class);
		
		Predicate namePredicate = null;
		Predicate pricePredicate = null;
		
		    if (name != null && !name.isEmpty()) {
	            namePredicate = 
		    	criteriaBuilder.like(product.get("name"), "%" + name + "%" );
	        }
	        if (price != null) {
	        	pricePredicate = 
	            criteriaBuilder.lessThan(product.get("price"), price);
	        }
	        criteriaQuery.where(namePredicate, pricePredicate);

	        TypedQuery<Product> query = entityManager.createQuery(criteriaQuery);
	        
	        return query.getResultList();
	}

}
