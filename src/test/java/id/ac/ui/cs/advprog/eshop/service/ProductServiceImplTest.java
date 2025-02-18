package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setProductId("f29a3d8f-bf97-4e2d-a937-bfc2bada94f3");
        product1.setProductName("Reed Bean");
        product1.setProductQuantity(9);

        product2 = new Product();
        product2.setProductId("3d973f0a-cf56-4ad0-bd9c-b5be47a24eeb");
        product2.setProductName("Eblana Bean");
        product2.setProductQuantity(10);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(product1)).thenReturn(product1);

        Product createdProduct = productService.create(product1);

        assertNotNull(createdProduct);
        assertEquals("f29a3d8f-bf97-4e2d-a937-bfc2bada94f3", createdProduct.getProductId());
        assertEquals("Reed Bean", createdProduct.getProductName());
        assertEquals(9, createdProduct.getProductQuantity());
    }

    @Test
    void testFindAllProducts() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2).iterator());
        List<Product> products = productService.findAll();
        assertEquals(2, products.size());
    }

    @Test
    void testFindProductById() {

        when(productRepository.findProductById(product1.getProductId())).thenReturn(product1);

        productService.create(product1);

        Product foundProduct = productService.findProductById(product1.getProductId());

        assertNotNull(foundProduct);
        assertEquals("f29a3d8f-bf97-4e2d-a937-bfc2bada94f3", foundProduct.getProductId());
        assertEquals("Reed Bean", foundProduct.getProductName());
    }

    @Test
    void testUpdateProduct() {
        productService.create(product1);
        product1.setProductName("Loughshinny Bean");

        when(productRepository.findProductById(product1.getProductId())).thenReturn(product1);

        productService.updateProduct(product1);

        Product updatedProduct = productService.findProductById(product1.getProductId());
        assertNotNull(updatedProduct);
        assertEquals("Loughshinny Bean", updatedProduct.getProductName());
    }

    @Test
    void testDeleteProduct() {

        doNothing().when(productRepository).deleteProduct(product1.getProductId());

        productService.deleteProduct(product1.getProductId());

        Product deletedProduct = productService.findProductById("3d973f0a-cf56-4ad0-bd9c-b5be47a24eeb");
        assertNull(deletedProduct);
    }
}
