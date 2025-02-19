package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindProductById() {
        Product dummyProduct = new Product();
        dummyProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        dummyProduct.setProductName("Nian Bean");
        dummyProduct.setProductQuantity(5);

        productRepository.create(dummyProduct);

        Product targetProduct  = productRepository.findProductById(dummyProduct.getProductId());
        Product failedProduct = productRepository.findProductById("123e4567-e89b-12d3-a456-426614174000");
        assertEquals(dummyProduct.getProductId(), targetProduct.getProductId());
        assertNull(failedProduct);
    }

    @Test
    void testUpdateProduct() {
        Product baseProduct = new Product();
        baseProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        baseProduct.setProductName("Chongyue Bean");
        baseProduct.setProductQuantity(3);
        productRepository.create(baseProduct);

        baseProduct.setProductName("Yu Bean");
        baseProduct.setProductQuantity(12);
        productRepository.updateProduct(baseProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product updatedProduct = productIterator.next();

        assertEquals(baseProduct.getProductId(), updatedProduct.getProductId());
        assertEquals(baseProduct.getProductName(), updatedProduct.getProductName());
        assertEquals(baseProduct.getProductQuantity(), updatedProduct.getProductQuantity());

        Product nonExistingProduct = new Product();
        nonExistingProduct.setProductId("non-existing-id");
        nonExistingProduct.setProductName("Non-Existent Bean");
        nonExistingProduct.setProductQuantity(5);
        productRepository.updateProduct(nonExistingProduct);

        // Verify that the original product list remains unchanged
        Iterator<Product> unchangedIterator = productRepository.findAll();
        assertTrue(unchangedIterator.hasNext());
        Product unchangedProduct = unchangedIterator.next();
        assertNotEquals(nonExistingProduct.getProductId(), unchangedProduct.getProductId());
    }

    @Test
    void testDeleteProduct() {
        Product dummyRemovalProduct = new Product();
        dummyRemovalProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        dummyRemovalProduct.setProductName("Ling Bean");
        dummyRemovalProduct.setProductQuantity(7);
        productRepository.create(dummyRemovalProduct);

        productRepository.deleteProduct(dummyRemovalProduct.getProductId());
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
}