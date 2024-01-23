package br.com.nunessports.nunessports.repositories;

import br.com.nunessports.nunessports.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
