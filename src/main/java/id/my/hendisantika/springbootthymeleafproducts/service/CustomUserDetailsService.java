package id.my.hendisantika.springbootthymeleafproducts.service;

import id.my.hendisantika.springbootthymeleafproducts.entity.CustomUserDetails;
import id.my.hendisantika.springbootthymeleafproducts.entity.User;
import id.my.hendisantika.springbootthymeleafproducts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-thymeleaf-products
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/24
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
