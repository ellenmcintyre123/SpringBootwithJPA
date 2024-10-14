package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> add(Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }

    public List<Product> get(){
        return productRepository.findAll();
    }

    public  String update(Long id, Product updatedProduct){
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id); // Ensure the updated product has the correct ID
            productRepository.save(updatedProduct);
            return "Product updated";
        } else {
            return "Product not found";
        }
    }

    public String delete(Long id){

        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "deleted product";
        }else{
            return "not found";
        }
    }

}
