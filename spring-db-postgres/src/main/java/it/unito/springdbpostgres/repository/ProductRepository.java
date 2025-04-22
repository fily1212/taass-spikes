package it.unito.springdbpostgres.repository;
import it.unito.springdbpostgres.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}