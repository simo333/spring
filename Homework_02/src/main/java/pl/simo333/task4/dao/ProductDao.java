package pl.simo333.task4.dao;

import org.springframework.stereotype.Component;
import pl.simo333.task4.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Component
public class ProductDao {
    private final List<Product> products = new ArrayList<>();

    public List<Product> products() {
        return products;
    }

    public ProductDao() {
        Random rand = new Random();
        for (long i = 1L; i <= 19; i++) {
            addProduct(new Product("prod" + rand.nextInt(10), rand.nextDouble()));
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> Objects.equals(p.getId(), id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product of given id not found. For id: " + id));
    }

}
