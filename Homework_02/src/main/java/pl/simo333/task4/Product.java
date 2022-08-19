package pl.simo333.task4;

public class Product {
    private Long id;
    private String name;
    private Double price;

    private static Long lastId = 1L;


    public Product(String name, double price) {
        this.id = lastId;
        this.name = name;
        this.price = price;
        lastId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public Double setPrice(double price) {
        return this.price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Long getLastId() {
        return lastId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
