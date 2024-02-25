package id.my.hendisantika.springbootthymeleafproducts.service;

import id.my.hendisantika.springbootthymeleafproducts.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
