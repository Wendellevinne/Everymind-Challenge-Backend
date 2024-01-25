package br.com.nunessports.nunessports.services;

import br.com.nunessports.nunessports.models.Product;
import br.com.nunessports.nunessports.models.UpdateProductRequest;
import br.com.nunessports.nunessports.repositories.ProductRepository;
import br.com.nunessports.nunessports.services.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void registerProduct(Product product){

        if (Objects.equals(product.getCode(), "") ||
            Objects.equals(product.getName(), "") ||
            Objects.equals(product.getDescription(), "") ||
            Objects.equals(product.getPrice(), null)){
            throw new RuntimeException("NS_SV0001 - Os campos não podem ser nulos");
        }

        productRepository.save(product);

    }

    public void updateProduct(Long id, UpdateProductRequest newProduct){

        if (id == null){
            throw new RuntimeException("NS_UP0001 - O código do produto não pode ser nulo");
        }

        if (!productRepository.existsById(id)){
            throw new RuntimeException("NS_UP0002 - Não existe nenhum produto com esse código no banco de dados");
        }

        Product savedProduct = getProductById(id);

        savedProduct.setCode(newProduct.getCode());
        savedProduct.setName(newProduct.getName());
        savedProduct.setDescription(newProduct.getDescription());
        savedProduct.setPrice(newProduct.getPrice());

        productRepository.save(savedProduct);

    }

    public void deleteProduct(Long id){

        if (id == null){
            throw new RuntimeException("NS_UP0001 - O código do produto não pode ser nulo");
        }

        if (!productRepository.existsById(id)){
            throw new RuntimeException("NS_UP0002 - Não existe nenhum produto com esse código no banco de dados");
        }

        productRepository.deleteById(id);

    }

}
