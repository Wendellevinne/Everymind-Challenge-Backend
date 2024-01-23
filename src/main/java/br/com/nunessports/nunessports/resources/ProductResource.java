package br.com.nunessports.nunessports.resources;

import br.com.nunessports.nunessports.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/nunessports")
public class ProductResource {

    @GetMapping("/products")
    public ResponseEntity<Product> getAllProducts(){
        Product product = new Product(
                "00001",
                "Chuteira Adidas",
                "Chuteira Adidas",
                BigDecimal.valueOf(350.00));
        return ResponseEntity.ok().body(product);
    }

}
