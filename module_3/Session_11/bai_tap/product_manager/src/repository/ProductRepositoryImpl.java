package repository;

import model.Product;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product(1, "Laptop", 1000, "ASus", "Japan"));
        productMap.put(2, new Product(2, "Iphone", 700, "Iphone_6", "America"));
        productMap.put(3, new Product(3, "Swatch", 300, "Swatch_beauty", "Italia"));
        productMap.put(4, new Product(4, "Book", 10, "Vitoria", "VietNam"));
        productMap.put(5, new Product(5, "Pen", 5, "Thien_Long", "VietNam"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> tempProduct = new ArrayList<>();
        List<Product> productList = new ArrayList<>(productMap.values());
        for (Product product: productList){
            if (product.getName().contains(name)){
                tempProduct.add(product);
            }
        }
        return tempProduct;
    }
}
