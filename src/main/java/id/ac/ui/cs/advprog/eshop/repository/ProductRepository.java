package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findProductById(String productId) {
        for(Product product : productData) {
            if(product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct(Product updatedProduct) {
        String updatedProductId = updatedProduct.getProductId();
        for (int i = 0; i < productData.size(); i++) {
            String currentProductId = productData.get(i).getProductId();
            if (currentProductId.equals(updatedProductId)) {
                productData.set(i, updatedProduct);
                break;
            }
        }
    }

    public void deleteProduct(String productId) {
        productData.removeIf(product -> product.getProductId().equals(productId));
    }
}
