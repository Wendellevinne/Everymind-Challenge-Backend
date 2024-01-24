package br.com.nunessports.nunessports.config;

import br.com.nunessports.nunessports.models.Product;
import br.com.nunessports.nunessports.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product(
                null,
                "00001",
                "Tênis Olympikus",
                "Tênis Olympikus",
                BigDecimal.valueOf(400));

        Product product2 = new Product(
                null,
                "00002",
                "Tênis Adidas",
                "Tênis Adidas",
                BigDecimal.valueOf(420));

        productRepository.saveAll(Arrays.asList(product1, product2));
    }
}
