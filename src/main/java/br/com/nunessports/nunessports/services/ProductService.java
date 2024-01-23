package br.com.nunessports.nunessports.services;

import br.com.nunessports.nunessports.models.Product;
import br.com.nunessports.nunessports.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id){
        return productRepository.findById(id);
    }

    public void registerProduct(Product product){

        if (product.getCode().isEmpty()){
            throw new RuntimeException("NS_SV0001 - O código do produto não pode ser nulo");
        }

        if (productRepository.existsById(product.getCode())){
            throw new RuntimeException("NS_SV0002 - Um produto com o mesmo código já existe no banco de dados");
        }

        productRepository.save(product);

    }

    public void updateProduct(Product product){

        if (product.getCode().isBlank()){
            throw new RuntimeException("NS_UP0001 - O código do produto não pode ser nulo");
        }

        if (!productRepository.existsById(product.getCode())){
            throw new RuntimeException("NS_UP0002 - Não existe nenhum produto com esse código no banco de dados");
        }

        Optional<Product> savedProduct = getProductById(product.getCode());

        if(savedProduct.isEmpty()){
            throw new RuntimeException("NS_UP0003 - Falha ao recuperar o produto");
        }

        savedProduct.get().setName(product.getName());
        savedProduct.get().setDescription(product.getDescription());
        savedProduct.get().setPrice(product.getPrice());

        productRepository.save(savedProduct.get());

    }

    public void deleteProduct(String id){

        if (id.isBlank()){
            throw new RuntimeException("NS_UP0001 - O código do produto não pode ser nulo");
        }

        if (!productRepository.existsById(id)){
            throw new RuntimeException("NS_UP0002 - Não existe nenhum produto com esse código no banco de dados");
        }

        productRepository.deleteById(id);

    }

}
