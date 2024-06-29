package study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.model.Product;
import study.repository.ProductRepository;

@Service
public class ProductServiceImpl {
    
	@Autowired
    private ProductRepository productRepository;
  
    public Product saveProduct(Product product) {
    	return productRepository.save(product);
    }

	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
}
