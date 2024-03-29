package id.my.hendisantika.springbootthymeleafproducts.service;

import id.my.hendisantika.springbootthymeleafproducts.dto.ProductAddRequest;
import id.my.hendisantika.springbootthymeleafproducts.entity.Product;
import id.my.hendisantika.springbootthymeleafproducts.exception.DataIsEmptyException;
import id.my.hendisantika.springbootthymeleafproducts.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> products = productRepository.findAllProduct();
        if (products.isEmpty()) {
            throw new DataIsEmptyException();
        }
        return products;
    }

    @Transactional
    public void addOrUpdateProduct(ProductAddRequest productAddRequest) {
        if (productAddRequest.getIdProduct() == null) {
            Product product = new Product();
            product.setName(productAddRequest.getProductName());
            product.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
            product.setExpireDate(productAddRequest.getProductExpire());
            productRepository.save(product);
        } else {
            Product currentProduct = productRepository.findById(productAddRequest.getIdProduct()).orElseThrow(() -> new EntityNotFoundException());
            currentProduct.setName(productAddRequest.getProductName());
            currentProduct.setPrice(new BigDecimal(productAddRequest.getProductPrice()));
            currentProduct.setExpireDate(productAddRequest.getProductExpire());
            productRepository.save(currentProduct);
        }

    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
