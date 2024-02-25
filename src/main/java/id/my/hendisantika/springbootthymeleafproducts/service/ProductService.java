package id.my.hendisantika.springbootthymeleafproducts.service;

import id.my.hendisantika.springbootthymeleafproducts.entity.Product;
import id.my.hendisantika.springbootthymeleafproducts.exception.DataIsEmptyException;
import id.my.hendisantika.springbootthymeleafproducts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
