package it.unito.springdbpostgres.config;
import it.unito.springdbpostgres.model.Product;
import it.unito.springdbpostgres.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Laptop Pro", new BigDecimal("1200.50")));
            productRepository.save(new Product("Mouse Wireless", new BigDecimal("25.99")));
            productRepository.save(new Product("Tastiera Meccanica", new BigDecimal("89.00")));
            System.out.println(">>> Sample products initialized.");
        }
    }
}