package ie.atu.week4.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> add(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }
    public void deleteId(Long id){
            productRepository.deleteById(id);
    }

}

