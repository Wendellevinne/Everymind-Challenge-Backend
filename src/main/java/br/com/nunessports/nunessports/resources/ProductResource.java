package br.com.nunessports.nunessports.resources;

import br.com.nunessports.nunessports.models.Product;
import br.com.nunessports.nunessports.models.UpdateProductRequest;
import br.com.nunessports.nunessports.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/nunessports")
@AllArgsConstructor
public class ProductResource {

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
    @PostMapping("/registerProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerProduct(@RequestBody Product product){
        productService.registerProduct(product);
    }

    @PutMapping("updateProduct/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest newProduct){
        productService.updateProduct(id, newProduct);
    }

    @DeleteMapping("/deleteProduct/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

}
