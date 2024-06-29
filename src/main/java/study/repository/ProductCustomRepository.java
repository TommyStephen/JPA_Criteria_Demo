package study.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import study.model.Product;
@Repository
public interface ProductCustomRepository {

	List<Product> findByNameContainingAndPriceLessThan(String name, Double price);
}
