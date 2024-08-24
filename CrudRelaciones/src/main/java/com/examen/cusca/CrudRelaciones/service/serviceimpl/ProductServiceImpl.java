package com.examen.cusca.CrudRelaciones.service.serviceimpl;

import com.examen.cusca.CrudRelaciones.entities.Order;
import com.examen.cusca.CrudRelaciones.entities.Product;
import com.examen.cusca.CrudRelaciones.repository.ProductRepository;
import com.examen.cusca.CrudRelaciones.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }
    @Override
    public Product getProductById(Long id) {
        return this.productRepository.findById(id).get();
    }
    @Override
    public Product createProduct(Product product) {
        product.setProductName(product.getProductName());
        this.productRepository.save(product);
        return null;
    }
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct !=null){
            existingProduct.setProductName(product.getProductName());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
    }
    @Override
    public void deleteProduct(Long id) {
        this.productRepository.deleteById(id);
    }
}
