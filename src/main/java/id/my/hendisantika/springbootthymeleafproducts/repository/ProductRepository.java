package id.my.hendisantika.springbootthymeleafproducts.repository;

import id.my.hendisantika.springbootthymeleafproducts.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:24
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p")
    List<Product> findAllProduct();
}
