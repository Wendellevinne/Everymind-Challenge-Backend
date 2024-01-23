package br.com.nunessports.nunessports.services;

import br.com.nunessports.nunessports.models.Product;
import br.com.nunessports.nunessports.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
